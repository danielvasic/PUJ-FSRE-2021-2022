package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Uvoznik {
    private Integer id;
    private String naziv;
    private String adresa;
    private String brojTelefona;

    public Uvoznik(String naziv, String adresa, String brojTelefona) {
        this.naziv = naziv;
        this.adresa = adresa;
        this.brojTelefona = brojTelefona;
    }

    public Integer getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public void save (){
        String query = "INSERT INTO uvoznik VALUES (null, ?, ?, ?)";
        try {
            PreparedStatement statement = Database.connection.prepareStatement(query, java.sql.Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, this.naziv);
            statement.setString(2, this.adresa);
            statement.setString(3, this.brojTelefona);
            statement.execute();
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            this.id = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("Nisam izvršio upit: " + query + ", nešto nije uredu s bazom.");
            System.out.println(e.getMessage());
        }
    }

    public void update (){
        String query = "UPDATE uvoznik SET naziv=?, adresa=?, broj_telefona=? WHERE id=?";
        try {
            PreparedStatement statement = Database.connection.prepareStatement(query);
            statement.setString(1, this.naziv);
            statement.setString(2, this.adresa);
            statement.setString(3, this.brojTelefona);
            statement.setInt(4, this.id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Nisam izvršio upit: " + query + ", nešto nije uredu s bazom.");
            System.out.println(e.getMessage());
        }
    }

    public void delete (){
        String query = "DELETE FROM uvoznik WHERE id=?";
        try {
            PreparedStatement statement = Database.connection.prepareStatement(query);
            statement.setInt(1, this.id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Nisam izvršio upit: " + query + ", nešto nije uredu s bazom.");
            System.out.println(e.getMessage());
        }
    }
}
