package com.sancom.careerday.Entities;

public enum EducationLevel {
    POST_GRADUATE("Post Graduate"),
    GRADUATE("Graduate"),
    HIGH_SCHOOL("High School"),
    DIPLOMA("Diploma"),
    HIGHER_DIPLOMA("Higher Diploma"),
    POST_GRADUATE_DIPLOMA("Post Graduate Diploma");

    String name;

    EducationLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
