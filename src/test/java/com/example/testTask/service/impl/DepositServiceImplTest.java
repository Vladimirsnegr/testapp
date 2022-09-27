package com.example.testTask.service.impl;

import com.example.testTask.Specification.Specifications;
import com.example.testTask.entity.Bank;
import com.example.testTask.entity.Client;
import com.example.testTask.entity.Deposit;
import com.example.testTask.entity.OrganizationForm;
import com.example.testTask.rep.DepositRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DepositServiceImplTest extends GeneralTest<Deposit> {

    @Override
    @BeforeEach
    @SuppressWarnings("unchecked")
    protected void setUp() {
        DepositRepository depositRepository = Mockito.mock(DepositRepository.class);
        Specifications<Deposit> depositSpecifications = Mockito.mock(Specifications.class);
        DepositServiceImpl depositService = Mockito.spy(new DepositServiceImpl(depositRepository, depositSpecifications));

        super.repository = depositRepository;
        super.specifications = depositSpecifications;
        super.service = depositService;
    }

    @Override
    protected List<Deposit> getObjects() {
        Deposit deposit1 = new Deposit();
        deposit1.setId(1L);
        deposit1.setName("name1");
        deposit1.setPercent(11f);
        deposit1.setTermInMonths(11);
        deposit1.setStartDate(LocalDate.of(2022,1,1));

        Bank bank1 = new Bank();
        bank1.setId(1L);
        bank1.setName("name1");
        bank1.setBic("bic1");
        deposit1.setBank(bank1);

        Client client1 = new Client();
        client1.setId(1L);
        client1.setName("name1");
        client1.setShortName("shortName1");
        client1.setAddress("address1");

        OrganizationForm form1 = new OrganizationForm();
        form1.setId(1L);
        form1.setName("name1");
        client1.setOrganizationForm(form1);
        deposit1.setClient(client1);

        Deposit deposit2 = new Deposit();
        deposit2.setId(2L);
        deposit2.setName("name2");
        deposit2.setPercent(22f);
        deposit2.setTermInMonths(22);
        deposit1.setStartDate(LocalDate.of(2022,2,2));

        Bank bank2 = new Bank();
        bank2.setId(2L);
        bank2.setName("name2");
        bank2.setBic("bic2");
        deposit2.setBank(bank2);

        Client client2 = new Client();
        client2.setId(2L);
        client2.setName("name2");
        client2.setShortName("shortName2");
        client2.setAddress("address2");

        OrganizationForm form2 = new OrganizationForm();
        form2.setId(2L);
        form2.setName("name2");
        client2.setOrganizationForm(form2);
        deposit2.setClient(client2);

        List<Deposit> deposits = new ArrayList<>();
        deposits.add(deposit1);
        deposits.add(deposit2);
        return deposits;
    }

    @Override
    protected Deposit getObject() {
        Deposit deposit = new Deposit();
        deposit.setId(1L);
        deposit.setName("name");
        deposit.setPercent(11f);
        deposit.setTermInMonths(11);
        deposit.setStartDate(LocalDate.of(2022,1,1));

        Bank bank = new Bank();
        bank.setId(1L);
        bank.setName("name");
        bank.setBic("bic");
        deposit.setBank(bank);

        Client client = new Client();
        client.setId(1L);
        client.setName("name");
        client.setShortName("shortName");
        client.setAddress("address");

        OrganizationForm form = new OrganizationForm();
        form.setId(1L);
        form.setName("name");
        client.setOrganizationForm(form);
        deposit.setClient(client);
        return deposit;
    }

    @Override
    protected Deposit updateObject(Deposit object) {
        object.setName("updated"+object.getName());
        object.setTermInMonths(1+ object.getTermInMonths());
        object.setPercent(1f+object.getPercent());
        LocalDate date = object.getStartDate();
        date = date.plusYears(1);
        date = date.plusMonths(1);
        date = date.plusDays(1);
        object.setStartDate(date);

        Bank bank = new Bank();
        bank.setId(2L);
        bank.setName("name2");
        bank.setBic("bic2");
        object.setBank(bank);

        Client client = new Client();
        client.setId(2L);
        client.setName("name2");
        client.setShortName("shortName2");
        client.setAddress("address2");

        OrganizationForm form = new OrganizationForm();
        form.setId(2L);
        form.setName("name2");
        client.setOrganizationForm(form);
        object.setClient(client);
        return object;
    }
}
