package com.agnieszkaolive.training.collection;

import java.util.*;

public class CollectionMain {
    public static void main(String[] args) {
        String[] names = new String[2];
        names[0] = "Krzysztof";
        names[1] = "Kasia";
        System.out.println("Imiona : " + Arrays.asList(names));
        try {
            System.out.println(names[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < names.length; i++) {
            System.out.println("element tablicy : " + names[i]);
        }

        List<String> animals = new ArrayList<>();
        animals.add("kot");
        animals.add("kot");
        System.out.println("Zwierzeta : " + animals);
        for (String animal : animals) {
            System.out.println("elementy kolekcji : " + animal);
        }

        Set<String> accounts = new HashSet<>();
        accounts.add("12345");
        accounts.add("12345");
        System.out.println("Konta : " + accounts);


    }
}

// TODO: 4/20/2022 zaprezentowac dzialanie kolejki Queue
// przecwiczyc operacje na kolekcjach na przyklad List Set uzywajac metod stawiajacych /usuwajacych/ liczacych elementy kolekcji