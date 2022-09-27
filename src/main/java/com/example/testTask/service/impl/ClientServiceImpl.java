package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Client;
import com.example.testTask.rep.ClientRepository;


public class ClientServiceImpl extends GeneralServiceImpl<Client> {
    public ClientServiceImpl(ClientRepository clientRepository, Specifications<Client> clientSpecifications) {
        super(clientRepository, clientSpecifications);
    }

    @Override
    protected void validate(Client object) {
        if (object.getName()==null||object.getShortName()==null||object.getAddress()==null||object.getOrganizationForm()==null) {
            throw new RuntimeException("Данные не заполнены");
        }
    }
}
