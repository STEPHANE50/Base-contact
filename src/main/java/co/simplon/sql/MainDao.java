package co.simplon.sql;

import java.util.List;

public class MainDao {

	public static void main(String[] args) throws Exception {
		ContactsDAO dao = new JdbdcContactDao();
		String type = args[0];
		List<String> emails = dao.RecupererEmailParContactType(type);
		for (String email : emails) {
			System.out.println(email);
		}
	}

}
