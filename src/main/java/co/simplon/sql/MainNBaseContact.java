package co.simplon.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MainNBaseContact {
	private static Logger monLogger= LoggerFactory.getLogger(MainNBaseContact.class);
	static String databaseUrl = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970?user=sql8157970&password=GTyyUfvfQ6";

	public static void main(String[] args) throws Exception {
		monLogger.info(args[0]); 
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		Connection connexion = DriverManager.getConnection(databaseUrl);
		PreparedStatement requete = connexion.prepareStatement("SELECT * FROM CONTACTS WHERE CONTACT_TYPE = ?");
		requete.setString(1, args[0]);
		ResultSet resultat = requete.executeQuery();

		while (resultat.next()) {
			String email = resultat.getString(4);
			System.out.println(email);
		}
		resultat.close();
		requete.close();
		connexion.close();
	}
}
