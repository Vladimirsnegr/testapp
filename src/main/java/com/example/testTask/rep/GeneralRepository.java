package com.example.testTask.rep;

import com.example.testTask.entity.GeneralEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GeneralRepository<T extends GeneralEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
    List<T> findAll(Specification specification);
}
