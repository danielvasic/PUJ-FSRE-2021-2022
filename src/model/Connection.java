package model;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private String username;
    private String password;
    private String hostname;
    private String schema;
    private java.sql.Connection connection;


    public Connection(String username, String password, String hostname, String schema) {
        this.username = username;
        this.password = password;
        this.hostname = hostname;
        this.schema = schema;
    }

    public void connect () {
        String connectionString = "jdbc:mysql://"+this.hostname+":3306/"+this.schema;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(
                    connectionString, username, password
            );
        } catch (ClassNotFoundException e) {
            System.out.println("Klasa za spajanje na bazu podataka nije pronađena, možda bi bilo dobro da prezmete JDBC driver i dodte prema uputama.");
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println("Nisam se uspio spojiti na bazu podataka, provjerite korisničke podatke.");
            System.out.println(e.getMessage());
        }
    }

    public java.sql.Connection getConnection() {
        return connection;
    }
}
