package com.example.testTask.map;

import com.example.testTask.dto.GeneralDto;
import com.example.testTask.dto.PageDto;
import com.example.testTask.entity.GeneralEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GeneralMapper<T extends GeneralEntity,V extends GeneralDto> {

    public abstract V objectToDto(T object);

    public abstract T dtoToObject(V dto);

    public List<V> objectToDtoList (List<T> objectList) {
        return objectList.stream().map(this::objectToDto).collect(Collectors.toList());
    }

    public PageDto<T> pageToDto(Page<T> page) {
        PageDto<T> pageDto = new PageDto<>();
        pageDto.setContent(page.getContent());
        pageDto.setTotalPages(page.getTotalPages());
        pageDto.setNumber(page.getNumber());
        pageDto.setSize(page.getSize());
        pageDto.setTotalElements(page.getTotalElements());
        return pageDto;
    }
}
