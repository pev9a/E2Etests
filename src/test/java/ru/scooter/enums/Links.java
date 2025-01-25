package ru.scooter.enums;

public enum Links {
    ORDER("order");

    private final String link;

    Links(String link) {
        this.link = link;
    }

    public String getLink() {
        return link;
    }
}


