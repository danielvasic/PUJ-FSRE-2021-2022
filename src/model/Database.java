package model;

public class Database {
    public static java.sql.Connection connection;
    static {
        Connection c = new Connection(
                "fsre2",
                "fsre2021",
                "212.39.115.102",
                "restoran"
        );
        c.connect();
        Database.connection = c.getConnection();
    }
}
