package com.example.testTask.service;

import com.example.testTask.dto.SearchAndSort;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GeneralService<T> {
    List<T> getObjects();

    Page<T> getObjects(SearchAndSort searchAndSort);

    T getObject(Long id);

    T saveObject(T object);

    T updateObject(T object);

    boolean deleteObject(Long id);

    void refresh(T object);
}
