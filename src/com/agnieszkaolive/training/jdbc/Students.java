package com.agnieszkaolive.training.jdbc;

public class Students {
    private int id;
    private String name;
    private String lastName;
    private int note;

    public Students() {
    }

    public Students(int id, String name, String lastName, int note) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.note = note;
    }

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", note=" + note +
                '}';
    }
}
