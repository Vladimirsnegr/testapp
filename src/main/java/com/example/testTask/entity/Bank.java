package com.example.testTask.entity;

import javax.persistence.*;

@Entity
@Table(name = "banks")
public class Bank extends GeneralEntity{
    @Column(unique=true)
    private String bic;

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
