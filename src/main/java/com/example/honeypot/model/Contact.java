package com.example.honeypot.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Contact {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("name")
    private String name;
    @JsonProperty("name_addition")
    private String nameAddition;
    @JsonProperty("salutation")
    private String salutation;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;

    public Contact(){}

    public Contact(Integer id, String type, String gender, String name, String nameAddition, String salutation, String phone, String email) {
        this.id = id;
        this.type = type;
        this.gender = gender;
        this.name = name;
        this.nameAddition = nameAddition;
        this.salutation = salutation;
        this.phone = phone;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAddition() {
        return nameAddition;
    }

    public void setNameAddition(String nameAddition) {
        this.nameAddition = nameAddition;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
                ", nameAddition='" + nameAddition + '\'' +
                ", salutation='" + salutation + '\'' +
                ", phone='" + phone + '\'' +
                ", eMail='" + email + '\'' +
                '}';
    }
}
