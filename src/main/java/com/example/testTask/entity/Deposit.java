package com.example.testTask.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "deposits")
public class Deposit extends GeneralEntity{
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Bank bank;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Client client;

    private LocalDate startDate;
    private Float percent;
    private Integer termInMonths;

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
