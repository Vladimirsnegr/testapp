package com.example.testTask.map;

import com.example.testTask.dto.BankDto;
import com.example.testTask.entity.Bank;
import org.springframework.stereotype.Component;

@Component
public class BankMapper extends GeneralMapper<Bank, BankDto> {
    @Override
    public BankDto objectToDto(Bank object) {
        BankDto dto = new BankDto();
        dto.setId(object.getId());
        dto.setName(object.getName());
        dto.setBic(object.getBic());
        return dto;
    }

    @Override
    public Bank dtoToObject(BankDto dto) {
        Bank bank = new Bank();
        bank.setId(dto.getId());
        bank.setName(dto.getName());
        bank.setBic(dto.getBic());
        return bank;
    }
}
