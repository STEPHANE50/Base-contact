package co.simplon.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbdcContactDao implements ContactsDAO {

	public List<String> RecupererEmailParContactType(String type) throws Exception {

		String databaseUrl = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970?user=sql8157970&password=GTyyUfvfQ6";

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());

		Connection connexion = DriverManager.getConnection(databaseUrl);
		PreparedStatement requete = connexion.prepareStatement("SELECT * FROM CONTACTS WHERE CONTACT_TYPE = ?");
		requete.setString(1, type);
		ResultSet resultat = requete.executeQuery();

		List<String> emails = new ArrayList<String>();
		while (resultat.next()) {
			emails.add(resultat.getString("email"));
		}
		resultat.close();
		requete.close();
		connexion.close();
		return emails;

	}

}