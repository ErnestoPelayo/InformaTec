package com.example.macbook.informatec.Models;

public class Events {

    private String name;
    private String ubication;
    private String date;
    private String informationComplete;

    public Events() {
    }

    public Events(String name, String description, String date, String informationComplete) {
        this.name = name;
        this.ubication = description;
        this.date = date;
        this.informationComplete = informationComplete;
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

    public String getInformationComplete() {
        return informationComplete;
    }

    public void setInformationComplete(String informationComplete) {
        this.informationComplete = informationComplete;
    }

    @Override
    public String toString() {
        return "Events{" +
                "name='" + name + '\'' +
                ", description='" + ubication + '\'' +
                ", date='" + date + '\'' +
                ", informationComplete='" + informationComplete + '\'' +
                '}';
    }
}
