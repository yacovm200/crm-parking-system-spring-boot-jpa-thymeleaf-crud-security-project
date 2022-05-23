package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service;

import java.util.List;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;

public interface parkingUsersService {

	public List<parkingUsers> findAll();
	
	public parkingUsers findByID(int theId);
	
	public void saveParkingUser(parkingUsers theParkingUsers);
	
	public void deleteParkingUser(int theId);

	public List<parkingUsers> searchByKeyword(String keyword);	

}
