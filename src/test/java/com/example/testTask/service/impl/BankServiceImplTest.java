package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Bank;
import com.example.testTask.rep.BankRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BankServiceImplTest extends GeneralTest<Bank> {

    @Override
    @BeforeEach
    @SuppressWarnings("unchecked")
    protected void setUp() {
        BankRepository bankRepository = Mockito.mock(BankRepository.class);
        Specifications<Bank> bankSpecifications = Mockito.mock(Specifications.class);
        BankServiceImpl bankService = Mockito.spy(new BankServiceImpl(bankRepository, bankSpecifications));

        super.repository=bankRepository;
        super.specifications=bankSpecifications;
        super.service=bankService;
    }

    @Override
    protected List<Bank> getObjects() {
        Bank bank1 = new Bank();
        bank1.setId(1L);
        bank1.setName("name1");
        bank1.setBic("bic1");

        Bank bank2 = new Bank();
        bank2.setId(2L);
        bank2.setName("name2");
        bank2.setBic("bic2");

        List<Bank> banks = new ArrayList<>();
        banks.add(bank1);
        banks.add(bank2);
        return banks;
    }

    @Override
    protected Bank getObject() {
        Bank bank = new Bank();
        bank.setId(1L);
        bank.setName("name");
        bank.setBic("bic");
        return bank;
    }

    @Override
    protected Bank updateObject(Bank object) {
        object.setName("updated"+object.getName());
        object.setBic("updated"+object.getBic());
        return object;
    }
}
