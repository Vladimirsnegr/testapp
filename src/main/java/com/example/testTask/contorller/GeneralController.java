package com.example.testTask.contorller;

import com.example.testTask.dto.GeneralDto;
import com.example.testTask.dto.PageDto;
import com.example.testTask.dto.SearchAndSort;
import com.example.testTask.entity.GeneralEntity;
import com.example.testTask.map.GeneralMapper;
import com.example.testTask.service.GeneralService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GeneralController<T extends GeneralEntity, V extends GeneralDto> {
    private final GeneralService<T> generalService;

    private final GeneralMapper<T,V> mapper;

    protected GeneralController(GeneralService<T> depositGeneralService, GeneralMapper<T,V> mapper) {
        this.generalService = depositGeneralService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<V> getObjects() {
        return mapper.objectToDtoList(generalService.getObjects());
    }

    @PostMapping
    public PageDto<T> getObjectWParam(@RequestBody SearchAndSort searchAndSort) {
        return mapper.pageToDto(generalService.getObjects(searchAndSort));
    }

    @GetMapping("/{id}")
    public V getObject(@PathVariable Long id) {
        return mapper.objectToDto(generalService.getObject(id));
    }

    @PostMapping("/save")
    public V saveObject(@RequestBody V dto) {
        T object = generalService.saveObject(mapper.dtoToObject(dto));
        generalService.refresh(object);
        return mapper.objectToDto(object);
    }

    @PostMapping("/{id}")
    public V updateObject(@PathVariable Long id, @RequestBody V dto) {
        T object = mapper.dtoToObject(dto);
        object.setId(id);
        T updatedObject = generalService.updateObject(object);
        generalService.refresh(updatedObject);
        return mapper.objectToDto(updatedObject);
    }

    @DeleteMapping("/{id}")
    public void deleteObject(@PathVariable Long id) {
        generalService.deleteObject(id);
    }
}
