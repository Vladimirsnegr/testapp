package com.example.testTask.map;

import com.example.testTask.dto.ClientDto;
import com.example.testTask.entity.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper extends GeneralMapper<Client, ClientDto> {
    @Override
    public ClientDto objectToDto(Client object) {
        ClientDto dto = new ClientDto();
        dto.setId(object.getId());
        dto.setName(object.getName());
        dto.setShortName(object.getShortName());
        dto.setAddress(object.getAddress());
        dto.setOrganizationForm(object.getOrganizationForm());
        return dto;
    }

    @Override
    public Client dtoToObject(ClientDto dto) {
        Client client = new Client();
        client.setId(dto.getId());
        client.setName(dto.getName());
        client.setShortName(dto.getShortName());
        client.setAddress(dto.getAddress());
        client.setOrganizationForm(dto.getOrganizationForm());
        return client;
    }
}
