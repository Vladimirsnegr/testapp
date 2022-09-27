package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.dto.SearchAndSort;
import com.example.testTask.entity.GeneralEntity;
import com.example.testTask.rep.GeneralRepository;
import com.example.testTask.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GeneralServiceImpl<T extends GeneralEntity>  implements GeneralService<T> {
    private final GeneralRepository<T> repository;
    private final Specifications<T> specifications;

    @Autowired
    private EntityManager em;
    protected GeneralServiceImpl(GeneralRepository<T> repository, Specifications<T> specifications) {
        this.specifications = specifications;
        this.repository = repository;
    }

    @Override
    public List<T> getObjects() {
        return repository.findAll();
    }

    @Override
    public Page<T> getObjects(SearchAndSort searchAndSort) {
        return repository.findAll(specifications.containsTextInAttributes(searchAndSort),
                PageRequest.of(searchAndSort.getPagination().getPage(), searchAndSort.getPagination().getSize()));
    }

    @Override
    public T getObject(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Объект не найден");
        }

        return repository.getById(id);
    }

    @Override
    public T saveObject(T object) {
        validate(object);

        T savedObject = repository.saveAndFlush(object);
        return savedObject;
    }

    @Override
    public T updateObject(T object) {
        if (object.getId()==null) {
            throw new RuntimeException("Данные не заполнены");
        }

        if (!repository.existsById(object.getId())) {
            throw new RuntimeException("Объект не найден");
        }

        validate(object);

        T savedObject = repository.saveAndFlush(object);
        return savedObject;
    }

    @Override
    public boolean deleteObject(Long id) {
        if(!repository.existsById(id)){
            throw new RuntimeException("Объект не найден");
        }

        repository.deleteById(id);
        return true;
    }

    @Override
    @Transactional
    // Надо зарефрешить, чтобы данные, возвращаемые в контроллеры после апдейта\сохранения были полными
    public void refresh(T object) {
        if(!repository.existsById(object.getId())){
            throw new RuntimeException("Объект не найден");
        }

        em.refresh(object);
    }

    protected void validate(T object) {
    }
}
