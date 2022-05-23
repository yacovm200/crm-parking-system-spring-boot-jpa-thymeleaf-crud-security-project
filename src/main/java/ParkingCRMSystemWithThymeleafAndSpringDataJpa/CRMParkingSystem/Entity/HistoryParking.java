package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="history")
public class HistoryParking {

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
	@Column(name = "entry_date")
	private LocalDate entryDate;
	@Column(name = "entry_time")
	private String entryTime;
	@Column(name = "exit_date")
	private LocalDate exitDate;
	@Column(name = "exit_time")
	private String exitTime;
	@Column(name="user_id")
	private int userId;
	
	public HistoryParking() {}

	
	
	public HistoryParking(String firstName, String lastName, String license, LocalDate entryDate, String entryTime,
			LocalDate exitDate, String exitTime, int userId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.license = license;
		this.entryDate = entryDate;
		this.entryTime = entryTime;
		this.exitDate = exitDate;
		this.exitTime = exitTime;
		this.userId = userId;
	}

	
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

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		this.entryDate = entryDate;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}

	public LocalDate getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDate exitDate) {
		this.exitDate = exitDate;
	}

	public String getExitTime() {
		return exitTime;
	}

	public void setExitTime(String exitTime) {
		this.exitTime = exitTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "HistoryParking [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", license="
				+ license + ", entryDate=" + entryDate + ", entryTime=" + entryTime + ", exitDate=" + exitDate
				+ ", exitTime=" + exitTime + ", userId=" + userId + "]";
	}
	
	
	
}
