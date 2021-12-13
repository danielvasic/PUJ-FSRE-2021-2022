import model.Database;
import model.Uvoznik;

import java.sql.*;

public class Program {
    public static void main (String [] args){
        Uvoznik u = new Uvoznik(
                "Uvoznik 1",
                "Adresa b.b.",
                "+38763123456"
        );
        u.save();
        u.setNaziv("Uvoznik 1");
        u.update();
        /*
        try {

            Connection konekcija = Database.connection;

            System.out.println("Uspješno smo se spojili na bazu...");
            String upit = "SELECT * FROM uvoznik";
            Statement iskaz = Database.connection.createStatement();
            ResultSet rs = iskaz.executeQuery(upit);
            while (rs.next()){
                System.out.println(
                        String.valueOf(rs.getInt("id"))
                        + " " + rs.getString("naziv")
                        + " " + rs.getString("adresa")
                        + " " + rs.getString("broj_telefona")
                );
            }

            String pobrisiUpit = "DELETE FROM uvoznik WHERE id = ?";
            PreparedStatement pobrisiIskaz = konekcija.prepareStatement(pobrisiUpit);
            pobrisiIskaz.setInt(1, 1);
            pobrisiIskaz.execute();

            String urediUpit = "UPDATE uvoznik SET broj_telefona = ? WHERE id = ?";
            PreparedStatement urediIskaz = konekcija.prepareStatement(urediUpit);
            urediIskaz.setString(1, "+38763123456");
            urediIskaz.setInt(2, 5);
            urediIskaz.executeUpdate();


            Connection konekcija = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/restoran",
                    "root", ""
            );

            String upit = "INSERT INTO uvoznik (naziv, adresa, broj_telefona)";
            upit += "VALUES (?, ?, ?)";
            PreparedStatement iskaz = konekcija.prepareStatement(upit);
            iskaz.setString(1, "Pero");
            iskaz.setString(2, "Matice hrvatske b.b.");
            iskaz.setString(3, "+38763123456");
            iskaz.execute();
            System.out.println("Uspješno smo se dodali uvoznika u bazu...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
             */
    }
}
