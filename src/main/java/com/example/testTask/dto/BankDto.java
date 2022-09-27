package com.example.testTask.dto;

public class BankDto extends GeneralDto{
    private String name;
    private String bic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }
}
