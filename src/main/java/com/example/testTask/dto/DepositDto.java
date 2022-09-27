package com.example.testTask.dto;

import com.example.testTask.entity.Bank;
import com.example.testTask.entity.Client;

import java.time.LocalDate;
import java.util.Date;

public class DepositDto extends GeneralDto {
    private String name;
    private Bank bank;
    private Client client;
    private LocalDate startDate;
    private Float percent;
    private Integer termInMonths;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public Integer getTermInMonths() {
        return termInMonths;
    }

    public void setTermInMonths(Integer termInMonths) {
        this.termInMonths = termInMonths;
    }
}
