package com.example.lostfoundapp;




public class ItemModel {
    int id;
    String name, phone, description, date, location, type;

    public ItemModel(int id, String name, String phone, String description, String date, String location, String type) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.date = date;
        this.location = location;
        this.type = type;
    }

    public ItemModel(String name, String phone, String description, String date, String location, String type) {
        this.name = name;
        this.phone = phone;
        this.description = description;
        this.date = date;
        this.location = location;
        this.type = type;
    }
}