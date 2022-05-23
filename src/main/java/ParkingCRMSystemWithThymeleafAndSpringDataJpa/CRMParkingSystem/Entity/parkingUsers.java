package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="users")
public class parkingUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "license")	
	private String license;	
	
	@OneToMany(mappedBy = "parkingUsers", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<parkingDetails> parkingDetails = new ArrayList<parkingDetails>();

	
	public parkingUsers() {
	}

	public parkingUsers(String firstName, String lastName, String license) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
	}
	
	//setter gettrs and tostring...
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public List<parkingDetails> getParkingDetails() {
		return parkingDetails;
	}

	public void setParkingDetails(List<parkingDetails> parkingDetails) {
		this.parkingDetails = parkingDetails;
	}

	
	@Override
	public String toString() {
		return "parkingUsers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", license=" + license
				+ ", parkingDetails=" + parkingDetails + "]";
	}


	
}