package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Bank;
import com.example.testTask.rep.BankRepository;

public class BankServiceImpl extends GeneralServiceImpl<Bank> {
    public BankServiceImpl(BankRepository bankRepository, Specifications<Bank> bankSpecifications) {
        super(bankRepository, bankSpecifications);
    }

    @Override
    protected void validate(Bank object) {
        if (object.getName()==null||object.getBic()==null) {
            throw new RuntimeException("Данные не заполнены");
        }
    }
}
