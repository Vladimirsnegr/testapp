package com.example.testTask.map;

import com.example.testTask.dto.OrganizationFormDto;
import com.example.testTask.entity.OrganizationForm;
import org.springframework.stereotype.Component;

@Component
public class OrganizationFormMapper extends GeneralMapper<OrganizationForm, OrganizationFormDto> {
    @Override
    public OrganizationFormDto objectToDto(OrganizationForm object) {
        OrganizationFormDto dto = new OrganizationFormDto();
        dto.setId(object.getId());
        dto.setName(object.getName());
        return dto;
    }

    @Override
    public OrganizationForm dtoToObject(OrganizationFormDto dto) {
        OrganizationForm form = new OrganizationForm();
        form.setId(dto.getId());
        form.setName(dto.getName());
        return form;
    }
}
