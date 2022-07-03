package com.example.apis.entity;

public class Message {
    private int id;
    private String Frase;
    private String Refran;
    public int id() {
        return id;
    }

    public String Frase() {
        return Frase;
    }
    public String getRefran() {
        return Refran;
    }
    @Override
    public String toString() {
        return "Frase: " + Frase ;
    }
    public String toString1() {
        return "Refran: " + Refran;
    }
}


