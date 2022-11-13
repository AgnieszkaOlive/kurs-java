package com.agnieszkaolive.training.carsjdbc;

public class Cars {
    private String brand;
    private int speed;
    private int age;

    public Cars() {
    }

    public Cars(String brand, int speed, int age) {
        this.brand = brand;
        this.speed = speed;
        this.age = age;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "brand='" + brand + '\'' +
                ", speed=" + speed +
                ", age=" + age +
                '}';
    }
}
