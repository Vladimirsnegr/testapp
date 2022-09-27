package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Deposit;
import com.example.testTask.rep.DepositRepository;

public class DepositServiceImpl extends GeneralServiceImpl<Deposit> {

    public DepositServiceImpl (DepositRepository depositGeneralRepository, Specifications<Deposit> depositSpecifications) {
        super(depositGeneralRepository, depositSpecifications);
    }

    @Override
    protected void validate(Deposit object) {
        if (object.getName()==null||object.getClient()==null||object.getBank()==null||object.getPercent()==null||object.getStartDate()==null||object.getTermInMonths()==null) {
            throw new RuntimeException("Данные не заполнены");
        }

        if (object.getPercent()<0f) {
            throw new RuntimeException("Процент вклада не может быть отрицательным");
        }

        if (object.getTermInMonths()<1) {
            throw new RuntimeException("Минимальный срок вклада составляет 1 месяц");
        }
    }
}
