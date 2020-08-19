package com.example.work.pilot.classes;

public class NintendoSpecification {
    String color;
    String type;
    String screen;
    String memory;
    int capacity;
    int weight;
    String controller;
    String accessories;

    public String getColor() {
        return color;
    }

    public NintendoSpecification withColor(String color) {
        this.color = color;
        return this;
    }

    public String getType() {
        return type;
    }

    public NintendoSpecification withType(String type) {
        this.type = type;
        return this;
    }

    public String getScreen() {
        return screen;
    }

    public NintendoSpecification withScreen(String screen) {
        this.screen = screen;
        return this;
    }

    public String getMemory() {
        return memory;
    }

    public NintendoSpecification withMemory(String memory) {
        this.memory = memory;
        return this;
    }

    public int getCapacity() {
        return capacity;
    }

    public NintendoSpecification withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public NintendoSpecification withWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public String getController() {
        return controller;
    }

    public NintendoSpecification withController(String controller) {
        this.controller = controller;
        return this;
    }

    public String getAccessories() {
        return accessories;
    }

    public NintendoSpecification withAccessories(String accessories) {
        this.accessories = accessories;
        return this;
    }
}
