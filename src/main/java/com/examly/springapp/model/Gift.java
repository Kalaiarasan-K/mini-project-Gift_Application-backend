package com.examly.springapp.model;

import jakarta.persistence.*;

@Entity
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String giftCategories;
    private String experience;
    private String specialization;
    private String phoneNumber;

    public Gift() {
    }

    public Gift(String name, String giftCategories, String experience, String specialization, String phoneNumber) {
        this.name = name;
        this.giftCategories = giftCategories;
        this.experience = experience;
        this.specialization = specialization;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGiftCategories() {
        return giftCategories;
    }

    public void setGiftCategories(String giftCategories) {
        this.giftCategories = giftCategories;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
