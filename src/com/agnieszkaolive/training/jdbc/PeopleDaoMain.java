package com.agnieszkaolive.training.jdbc;

import static com.agnieszkaolive.training.jdbc.PeopleDao.selectFromPeople;

public class PeopleDaoMain {
    public static void main(String[] args) {
        PeopleDao peopleDao = new PeopleDao();
        People people = new People(123, "John");
        peopleDao.insertIntoPeople(people);
        //selectFromPeople();
    }
}
