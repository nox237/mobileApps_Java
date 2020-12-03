package com.example.simpleapp.event;

class Event {
    String name;
    String description;

    public Event(){

    }

    public Event(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
