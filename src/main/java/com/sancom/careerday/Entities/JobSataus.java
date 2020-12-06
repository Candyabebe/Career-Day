package com.sancom.careerday.Entities;

public enum JobSataus {
    ACTIVE("Active"),
    INACTIVE("Inactive");
    String name;

    JobSataus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
