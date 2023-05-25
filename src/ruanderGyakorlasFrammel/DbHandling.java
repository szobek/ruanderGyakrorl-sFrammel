package ruanderGyakorlasFrammel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DbHandling {
	String dbName="felhasznalo_db";
	String dbUser="root";
	String dbPassword="";
	String dbPort="3306";
	String dbUrl="localhost";
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://"+dbUrl+":"+dbPort+"/"+dbName+"", dbUser, dbPassword);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from osztalyzatok");
			while (rs.next()) {
				rs.getString("nev");
				
			}
				//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
			JOptionPane.showMessageDialog(null, "sikerült kapcsolódni");
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "nem sikerült kapcsolódni");
		}
	}
}
