package com.example.testTask.contorller;

import com.example.testTask.dto.BankDto;
import com.example.testTask.entity.Bank;
import com.example.testTask.map.BankMapper;
import com.example.testTask.service.impl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/banks")
public class BankController extends GeneralController<Bank, BankDto>{

    @Autowired
    public BankController (BankServiceImpl bankService, BankMapper bankMapper) {
        super(bankService, bankMapper);
    }
}
