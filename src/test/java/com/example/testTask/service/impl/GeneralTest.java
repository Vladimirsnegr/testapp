package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.dto.SearchAndSort;
import com.example.testTask.entity.GeneralEntity;
import com.example.testTask.rep.GeneralRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class GeneralTest<T extends GeneralEntity> {

    GeneralRepository<T> repository;

    Specifications<T> specifications;

    GeneralServiceImpl<T> service;

    @BeforeEach
    protected abstract void setUp();

    @Test
    void getObjectsTest() {
        List<T> objects = getObjects();

        when(repository.findAll()).thenReturn(objects);

        List<T> result = service.getObjects();
        Assertions.assertNotNull(result);
        Assertions.assertEquals(objects,result);
    }

    @Test
    void getObjectsWParamTest() {
        List<T> objects = getObjects();
        SearchAndSort searchAndSort = new SearchAndSort();
        Page<T> page = new PageImpl<>(objects);

        when(repository.findAll(specifications.containsTextInAttributes(searchAndSort),
                                PageRequest.of(searchAndSort.getPagination().getPage(),searchAndSort.getPagination().getSize()))).thenReturn(page);

        Page<T> result = service.getObjects(searchAndSort);

        Assertions.assertNotNull(result.getContent());
        Assertions.assertEquals(objects,result.getContent());
    }

    @Test
    void getObjectTest() {
        T object = getObject();

        when(repository.existsById(anyLong())).thenReturn(true);
        when(repository.getById(anyLong())).thenReturn(object);

        T result = service.getObject(object.getId());

        Assertions.assertNotNull(result);
        Assertions.assertEquals(object,result);
    }

    @Test
    void saveObjectTest() {
        T object = getObject();

        when(repository.saveAndFlush(object)).thenReturn(object);

        T result = service.saveObject(object);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(object,result);
    }

    @Test
    void updateObjectTest() {
        T object = getObject();
        when(repository.saveAndFlush(object)).thenReturn(object);
        T result = service.saveObject(object);

        object = updateObject(object);
        when(repository.existsById(object.getId())).thenReturn(true);
        when(repository.saveAndFlush(object)).thenReturn(object);

        T updatedObject = service.updateObject(object);

        Assertions.assertNotNull(updatedObject);
        Assertions.assertEquals(object,updatedObject);
    }

    @Test
    void deleteObjectTest () {
        T object = getObject();
        when(repository.existsById(object.getId())).thenReturn(true);
        service.deleteObject(object.getId());
    }

    protected abstract List<T> getObjects();
    protected abstract T getObject();

    protected abstract T updateObject(T object);
}
