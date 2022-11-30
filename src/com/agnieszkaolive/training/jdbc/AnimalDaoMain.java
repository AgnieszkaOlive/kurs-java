package com.agnieszkaolive.training.jdbc;

public class AnimalDaoMain {
    public static void main(String[] args) {
       // AnimalDao.createAnimals();

        Animal animal = new Animal(1, "elephant", 400);
        AnimalDao animalDao = new AnimalDao();
        AnimalDao.insertIntoAnimals(animal);

        Animal animal1 = new Animal(2, "crocodile", 60);
        AnimalDao animalDao1 = new AnimalDao();
        AnimalDao.insertIntoAnimals(animal1);

        Animal animal2 = new Animal(3, "snake", 2);
        AnimalDao animalDao2 = new AnimalDao();
        AnimalDao.insertIntoAnimals(animal2);


    }
}
