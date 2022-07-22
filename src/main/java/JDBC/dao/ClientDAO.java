package JDBC.dao;

import java.sql.*;

public class ClientDAO {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //регистрация драйвера, дефолтная загрузка класса

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

// инициализируем переменные
        try {
            String URL = "jdbc:mysql://192.168.236.120:3306/users"; //адрес локальной базы
            String USER = "root";
            String PASS = "root";
//подключаемся к базе
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    метод получения клиента по айди  //ResultSet
    public static ResultSet getClient(String id, Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM сlient WHERE id = " + id);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        return rs;
    }

    //    метод получения списка клиентов по фамилии/имени //ResultSet
    public static ResultSet getClientListByName(String lastName,  Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT * FROM сlient WHERE firstName = " + lastName);
        ResultSet rs = preparedStatement.executeQuery();
        preparedStatement.close();
        return rs;
    }

    //        метод изменения клиентских данных(фамилия, имя, возраст) //возвращать кол во апдейтнутых записей  (executeUpdate)
    public static int updateClientsNameById(String Id, String lastName, String firstName, int age, Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        Integer executedQueryCount = statement
                .executeUpdate("UPDATE сlient set lastName='" + lastName + "', firstName ='" + firstName +"', age ='"+ age +"' WHERE id='" + Id + "'");
        statement.close();
        return executedQueryCount;
    }


}
