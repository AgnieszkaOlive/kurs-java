package com.agnieszkaolive.training.collection;

import java.util.*;

public class CollectionExercices {
    public static void main(String[] args) {
        String[] names = new String[3];
        names[0] = "kasia";
        names[1] = "zosia";
        System.out.println(Arrays.asList(names));

        List<String> names1 = new ArrayList<>();
        names1.add("Krzych");
        names1.add("Wlodek");
        names1.add("Kazik");
        System.out.println(names1);

        List<String> names2 = new ArrayList<>();
        names2.add("Mila");
        names2.add("Krysia");
        names2.add("Zbyszek");
        names2.add("Walodia");
        names2.add("Jaroslaw");
        names2.add("Heniek");
        System.out.println("Nieposortowane names2 : " + names2);
        Collections.sort(names2);
        System.out.println("posortowane names2 : " + names2);

        Set<String> cars = new HashSet<>();
        cars.add("Skoda");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Audi");
        cars.add("Volvo");
        cars.add("BMW");
        System.out.println("Before removing Ford : " + cars);
        cars.remove("Ford");
        System.out.println("After removing Ford : " + cars);
        System.out.println(cars.contains("BMW"));
        System.out.println(cars.contains("Ford"));
        System.out.println(cars.size());

        Queue<String> numbers = new LinkedList<>();//czy w <> powinno sie wpisywac typ danych?
        numbers.add("one");
        numbers.add("eight");
        numbers.add("two");
        numbers.add("eleven");
        numbers.add("one");
        System.out.println("All numbers : " + numbers);
        System.out.println("The element to be removed : " + numbers.remove());
        System.out.println("Numbers without two : " + numbers);
        System.out.println("Numbers without the first number : " + numbers.remove());
        System.out.println("Numbers without two : " + numbers);
//        System.out.println("Reveresed order : " + numbers.);

        Deque<String> colors = new ArrayDeque<>();
        colors.add("green");
        colors.add("yellow");
        colors.add("red");
        colors.add("black");
        colors.add("blue");
        colors.add("black");
        System.out.println("Before " + colors);
        System.out.println(colors.peekFirst());
        System.out.println(colors.getLast());
        System.out.println("After " + colors);
        System.out.println(colors.size());

        HashMap<String, String> capitals = new HashMap<>();
        capitals.put("England", "London");
        capitals.put("Spain", "Madrid");
        capitals.put("France", "Paris");
        System.out.println(capitals);

        HashMap<String, Integer> notes = new HashMap<>();
        notes.put("Kasia", 3);
        notes.put("Jan", 5);
        notes.put("Piotr", 6);
        System.out.println(notes);
        System.out.println(notes.get("Kasia"));
    }
}
