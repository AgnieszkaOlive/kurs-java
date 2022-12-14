package com.agnieszkaolive.training.jdbc;

public class Animal {
    private int ID;
    private String name;
    private int weight;

    public Animal() {
    }

    public Animal(int ID, String name, int weight) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
