package ruanderGyakorlasFrammel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;

public class DbHandling {
	private List<Tanulo> lista ;
	private String dbName="felhasznalo_db";
	private String dbUser="root";
	private String dbPassword="";
	private String dbPort="3306";
	private String dbUrl="localhost";
	
	public DbHandling(List<Tanulo> lista) {
		this.lista=lista;
	}
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://"+dbUrl+":"+dbPort+"/"+dbName+"", dbUser, dbPassword);
			
			//JOptionPane.showMessageDialog(null, "sikerült kapcsolódni");
			filList(con, lista);
			System.out.println(lista.size());
		} catch (Exception e) {
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "nem sikerült kapcsolódni");
		}
	}
	
	private void filList(Connection con, List<Tanulo> lista) {
		Statement stmt;
		try {
			stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from osztalyzatok");
		while (rs.next()) {
			
			lista.add(new Tanulo(rs.getString("nev"),rs.getInt("matek"),rs.getInt("angol"),rs.getInt("tori")));
		}
			//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
		con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
