package ruanderGyakorlasFrammel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class DbHandling {
	private static List<Tanulo> lista;
	private static String dbName = "felhasznalo_db";
	private static String dbUser = "root";
	private static String dbPassword = "";
	private static String dbPort = "3306";
	private static String dbUrl = "localhost";


	public static void connect(List<Tanulo> lista) {
		try(Connection con = DriverManager.getConnection("jdbc:mysql://" + dbUrl + ":" + dbPort + "/" + dbName + "",
				dbUser, dbPassword)) {
			Class.forName("com.mysql.jdbc.Driver");
			;

			filList(con,lista);
			//System.out.println(lista.size());
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "nem sikerült kapcsolódni");
		}
	}

	private static void filList(Connection con,List<Tanulo> lista) {
		Statement stmt;
		try {
			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("select * from osztalyzatok");
			while (rs.next()) {
				lista.add(new Tanulo(rs.getString("nev"), rs.getInt("matek"), rs.getInt("angol"), rs.getInt("tori"), rs.getInt("ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
