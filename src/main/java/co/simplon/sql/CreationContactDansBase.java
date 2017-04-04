package co.simplon.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CreationContactDansBase {
	private static Logger monLogger = LoggerFactory.getLogger(MainNBaseContact.class);
	static String databaseUrl = "jdbc:mysql://sql8.freemysqlhosting.net:3306/sql8157970?user=sql8157970&password=GTyyUfvfQ6";
	static String requeteContacts = "INSERT into CONTACTS(FNAME,LNAME,EMAIL,CONTACT_TYPE,AGE) VALUES (?,?,?,?,?)";

	public static void main(String[] args) throws Exception {

		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		Connection connexion = DriverManager.getConnection(databaseUrl);
		ajoutContact(connexion);
	}

	private static void ajoutContact(Connection connexion) throws SQLException {
		PreparedStatement stmtAjoutContact =  connexion.prepareStatement(requeteContacts);
		stmtAjoutContact.setString(1, "Stephane");
		stmtAjoutContact.setString(2, "Levasseur");
		stmtAjoutContact.setString(3, "sl@email.fr");
		stmtAjoutContact.setString(4, "Friend");
		stmtAjoutContact.setInt(5, 58);
		//String marequete =(requeteContacts);
		Integer updateRowCount = stmtAjoutContact.executeUpdate();
		System.out.println("Table modifié: OK ");
		monLogger.info(updateRowCount.toString());
		stmtAjoutContact.close();
		connexion.close();
	}

}