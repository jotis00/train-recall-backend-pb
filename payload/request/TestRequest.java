package com.jo.trainrecallbackend.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TestRequest
{
    @NotBlank
    private String nameOfTest;
    @NotBlank
    private String setting;
    @NotBlank
    private String score;
    @NotBlank
    private String dateOfTest;


    public String getNameOfTest() {
        return nameOfTest;
    }

    public void setNameOfTest(String nameOfTest) {
        this.nameOfTest = nameOfTest;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getDateOfTest() {
        return dateOfTest;
    }

    public void setDateOfTest(String dateOfTest) {
        this.dateOfTest = dateOfTest;
    }
}
