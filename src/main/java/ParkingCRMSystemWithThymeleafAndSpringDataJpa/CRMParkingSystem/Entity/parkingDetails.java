package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
@Table(name ="details")
public class parkingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "entry_date")
	private LocalDate entryDate;

	@Column(name = "entry_time")
	private String entryTime;

	@Column(name = "exit_date")
	private LocalDate exitDate;

	@Column(name = "exit_time")
	private String exitTime;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private parkingUsers parkingUsers;

	public parkingDetails() {}

	public parkingDetails(LocalDate entryDate, String entryTime, LocalDate exitDate, String exitTime) {
		this.entryDate = entryDate;
		this.entryTime = entryTime;
		this.exitDate = exitDate;
		this.exitTime = exitTime;
	}
	
	//test
//	public parkingDetails(LocalDate entryDate, LocalDateTime entryTime, LocalDate exitDate, LocalDateTime exitTime, int user_id ) {
//		this.entryDate = entryDate;
//		this.entryTime = entryTime;
//		this.exitDate = exitDate;
//		this.exitTime = exitTime;
//		this.parkingUsers.setId(user_id);
//	}
	//setter gettrs and tostring...

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public parkingUsers getParkingUsers() {
		return parkingUsers;
	}

	public void setParkingUsers(parkingUsers parkingUsers) {
		this.parkingUsers = parkingUsers;
	}

	@Override
	public String toString() {
		return "parkingDetails [id=" + id + ", entryDate=" + entryDate + ", entryTime=" + entryTime + ", exitDate="
				+ exitDate + ", exitTime=" + exitTime + ", parkingUsers=" + parkingUsers + "]";
	}


	



	
	
}
