package com.example.testTask.contorller;

import com.example.testTask.dto.DepositDto;
import com.example.testTask.entity.Deposit;
import com.example.testTask.map.DepositMapper;
import com.example.testTask.service.impl.DepositServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/deposits")
public class DepositController extends GeneralController<Deposit, DepositDto> {

    @Autowired
    public DepositController(DepositServiceImpl depositService, DepositMapper depositMapper) {
        super(depositService, depositMapper);
    }
}
