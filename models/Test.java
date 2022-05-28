package com.jo.trainrecallbackend.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.persistence.*;

@Entity
@Table( name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 20)
    private String nameOfTest;
    
    @NotBlank
    @Size(max = 20)
    private String setting;

    @NotBlank
    @Size(max = 200)
    private String score;

    @NotBlank
    @Size(max = 25)
    private String dateOfTest;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Test() {}
    public Test(String nameOfTest, String setting, String score, String dateOfTest, User user) {
        this.nameOfTest = nameOfTest;
        this.setting = setting;
        this.score = score;
        this.dateOfTest = dateOfTest;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
