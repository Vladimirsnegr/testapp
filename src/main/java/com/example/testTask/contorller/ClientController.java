package com.example.testTask.contorller;

import com.example.testTask.dto.ClientDto;
import com.example.testTask.entity.Client;
import com.example.testTask.map.ClientMapper;
import com.example.testTask.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController extends GeneralController<Client, ClientDto>{
    @Autowired
    public ClientController(ClientServiceImpl clientService, ClientMapper clientMapper) {
        super(clientService, clientMapper);
    }
}
