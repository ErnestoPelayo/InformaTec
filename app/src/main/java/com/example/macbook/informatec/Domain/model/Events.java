package com.example.macbook.informatec.Domain.model;

public class Events {

    private String name;
    private String ubication;
    private String date;
    private String information;

    public Events() {
    }

    public Events(String name, String description, String date, String information) {
        this.name = name;
        this.ubication = description;
        this.date = date;
        this.information = information;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String description) {
        this.ubication = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "Events{" +
                "name='" + name + '\'' +
                ", description='" + ubication + '\'' +
                ", date='" + date + '\'' +
                ", informationComplete='" + information + '\'' +
                '}';
    }
}
