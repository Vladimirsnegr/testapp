package com.example.testTask.map;

import com.example.testTask.dto.DepositDto;
import com.example.testTask.entity.Deposit;
import org.springframework.stereotype.Component;

@Component
public class DepositMapper extends GeneralMapper<Deposit, DepositDto> {

    @Override
    public DepositDto objectToDto(Deposit object) {
        DepositDto dto = new DepositDto();
        dto.setId(object.getId());
        dto.setName(object.getName());
        dto.setClient(object.getClient());
        dto.setBank(object.getBank());
        dto.setPercent(object.getPercent());
        dto.setStartDate(object.getStartDate());
        dto.setTermInMonths(object.getTermInMonths());
        return dto;
    }

    @Override
    public Deposit dtoToObject(DepositDto dto) {
        Deposit deposit = new Deposit();
        deposit.setId(dto.getId());
        deposit.setName(dto.getName());
        deposit.setClient(dto.getClient());
        deposit.setBank(dto.getBank());
        deposit.setPercent(dto.getPercent());
        deposit.setStartDate(dto.getStartDate());
        deposit.setTermInMonths(dto.getTermInMonths());
        return deposit;
    }
}
