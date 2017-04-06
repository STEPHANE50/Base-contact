package domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONTACTS")
public class Contact {

	public Contact() {
		super();
	}

	public void setAge(int age) {
		this.age = age;
	}

	private Contact(long id, String fname, String lname, String empail, String contactType, int age) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.empail = empail;
		this.contactType = contactType;
		this.age = age;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private long id;
	@Column(name = "FNAME", length = 100)
	private String fname;
	@Column(name = "LNAME", length = 100)
	private String lname;
	@Column(name = "EMAIL", length = 255)
	private String empail;
	@Column(name = "CONTACT_TYPE", length = 30)
	private String contactType;
	@Column(name = "AGE", length = 100)
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmpail() {
		return empail;
	}

	public void setEmpail(String empail) {
		this.empail = empail;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public int getAge() {
		return age;
	}
}
