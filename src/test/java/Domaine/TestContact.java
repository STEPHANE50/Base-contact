package Domaine;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import domaine.Contact;

public class TestContact {

	@Test
	public void lecturePremierContact() {
		Contact contact = null;

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Base-Contact");
		contact = emf.createEntityManager().find(Contact.class, 1L);
		assertEquals(1, contact.getId());
		assertEquals("Smith", contact.getLname());
		assertEquals("dsmith@icloud.com", contact.getEmpail());
		assertEquals("friend", contact.getContactType());
		assertEquals(46, contact.getAge());
	}

}
