package com.agnieszkaolive.training.jdbc;

import java.sql.*;

import static com.agnieszkaolive.training.jdbc.PeopleDao.selectFromPeople;

public class JdbcMainCopy {
    private static final String SELECT_TEST_SQL = "SELECT * FROM TEST ORDER BY ID;";
    private static final String SELECT_HOMEWORK_SQL = "SELECT * FROM HOMEWORK ORDER BY ID;";

    private static final String SELECT_EXERCISE_SQL = "SELECT * FROM EXERCISE ORDER BY ID;";
    // private static final String SELECT_PEOPLE_SQL = "SELECT * FROM PEOPLE ORDER BY ID;";

    private static final String INSERT_PEOPLE_SQL = "INSERT INTO PEOPLE ( ID , FIRST_NAME , LAST_NAME , GENDER , AGE )\n" +
            " VALUES(?, ?, 'Kowal', 'male', 23);";

    private static final String INSERT_PEOPLE_SQL2 = "INSERT INTO PEOPLE ( ID , FIRST_NAME , LAST_NAME , GENDER , AGE )\n" +
            " VALUES(?, ?, ?, ?, ?);";

    public static void main(String[] args) {
        //     SELECT_TEST_SQL = "";
//        homeworkDB();
//        testDB();
        //       exerciseBD();
//        peopleTable(100, "Krystyna");
//        peopleTable(3, "Czeslaw");
//        peopleTable(new People(22, "Mateusz"));
//        People agaPeople = new People(21, "Boguslaw");
//        peopleTable(agaPeople);
//        People jacekPeople = new People(24, "Grzegorz");
//        peopleTable2(jacekPeople);
//        peopleTable2(5, "Joanna", "Suchan", "female", 41);
//        peopleTable2(6, "Michal", "Czernin", "male", 13);
//        selectFromPeople();
    }

    //  public static void peopleTable2(int id, String firstName, String lastName, String gender, int age) {
    public static void peopleTable2(People people) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PEOPLE_SQL2);
            preparedStatement.setInt(1, people.getId());
            preparedStatement.setString(2, people.getFirstName());
            preparedStatement.setString(3, people.getSecondName());
            preparedStatement.setString(4, people.getGender());
            preparedStatement.setInt(5, people.getAge());
            // boolean execute = preparedStatement.execute();
            int execute = preparedStatement.executeUpdate();
            System.out.println("Execute on table people " + execute);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //public static void peopleTable(int id, String firstName) {
    public static void peopleTable(People people) {
        try {

            //   private static final String INSERT_PEOPLE_SQL = "INSERT INTO PEOPLE ( ID , FIRST_NAME , LAST_NAME , GENDER , AGE )\n" +
            //         " VALUES(?, ?, 'Kowal', 'male', 23);";
            // TODO: 11/2/2022 sparametryzowac pozostale wartosci zapytania sql insert - uzywajac znakow zapytania/
            //  ewentualnie utworzyc klase people zeby uniknac wielu parametrow
            //stworzyc nowa wlasna tabele i za pomoca JDBC wstawic wartosci z kodu Java


            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PEOPLE_SQL);
            preparedStatement.setInt(1, people.getId());
            preparedStatement.setString(2, people.getFirstName());
            boolean execute = preparedStatement.execute();
            System.out.println("Execute on people table " + execute);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // TODO: 10/26/2022 analogicznie do metody testDB() stworzyc polaczenie z baza danych a nastepnie pobrac dane
    // utworzyc nowa wlasna tabele, wzorujac sie na
    // //CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));
    // utworzyc nowy select do pobierania danych wzorujac sie na
    // "SELECT * FROM TEST ORDER BY ID;"

    public static void exerciseBD() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_EXERCISE_SQL);
            System.out.println("ResultSet " + resultSet + '\n');

            while (resultSet.next()) {
                System.out.println("Wiersz/rekord");
                int id = resultSet.getInt("ID");
                System.out.println("wartosc kolumny ID" + id);
                String name = resultSet.getString("NAME");
                System.out.println("wartosc kolumny name " + name);
            }
            ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void homeworkDB() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            System.out.println("Polaczenie z baza danych tabela homework: " + connection);
            System.out.println("wykonamy zapytanie SQL " + SELECT_HOMEWORK_SQL);

            Statement statement = connection.createStatement();
            System.out.println("Statement " + statement);

            ResultSet resultSet = statement.executeQuery(SELECT_HOMEWORK_SQL);
            System.out.println("ResultSet " + resultSet + '\n');

            while (resultSet.next()) {
                System.out.println("Wiersz/rekord");
                int id = resultSet.getInt("ID");
                System.out.println("Wartosc kolumny ID " + id);

                String name = resultSet.getString("NAME");
                System.out.println("Wartosc kolumny NAME " + name + '\n');
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testDB() {
        //kroki ktore nalezy wykonac aby wejsc w interakcje z baza danych za pomoca JDBC:
        //1. driver manager
        //2. connection
        //3. statement/prepared statement
        //4. result set
        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            System.out.println("polaczenie z baza danych : " + connection);
            System.out.println("wykonamy zapytanie SQL " + SELECT_TEST_SQL);

            Statement statement = connection.createStatement();
            System.out.println("Statement " + statement);

            ResultSet resultSet = statement.executeQuery(SELECT_TEST_SQL);
            System.out.println("ResultSet " + resultSet);

            while (resultSet.next()) {
                //CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));
                System.out.println("wiersz/rekord");
                int id = resultSet.getInt("ID");
                System.out.println("Wartosc kolumny ID " + id);

                String name = resultSet.getString("NAME");
                System.out.println("Wartosc kolumny NAME " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void selectFromPeople() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(SELECT_PEOPLE_SQL);
//            System.out.println("Resultset " + resultSet);
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("ID");
//                System.out.println("ID " + id);
//
//                String firstName = resultSet.getString("FIRST_NAME");
//                System.out.println("First name " + firstName);
//
//                String lastName = resultSet.getString("LAST_NAME");
//                System.out.println("Last name " + lastName);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (connection != null) {
//                    connection.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
// TODO: 10/19/2022  poczytac o JDBC

//CREATE TABLE PEOPLE(
//ID INT PRIMARY KEY,
//FIRST_NAME VARCHAR(255),
//LAST_NAME VARCHAR(255),
//GENDER VARCHAR(25),
//AGE INT
//);

//    boolean execute = preparedStatement.execute(); - nie pamietam skad sie to bralo i co to znaczy czemu boolean

// wyjatek :
// org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException: Unique index or primary key violation: "PRIMARY KEY ON PUBLIC.PEOPLE(ID) ( /* key:0 */ 100, 'Krystyna', 'Kowal', 'male', 23)"; SQL statement:
//INSERT INTO PEOPLE ( ID , FIRST_NAME , LAST_NAME , GENDER , AGE )
