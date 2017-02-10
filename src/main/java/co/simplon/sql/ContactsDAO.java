package co.simplon.sql;

import java.util.List;

public interface ContactsDAO  {
	public List<String> RecupererEmailParContactType(String type)throws Exception ;

}
