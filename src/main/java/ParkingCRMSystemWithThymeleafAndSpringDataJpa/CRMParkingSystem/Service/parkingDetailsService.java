package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service;

import java.util.List;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingDetails;

public interface parkingDetailsService {

	public List<parkingDetails> findAll();
	public long countNumberOfCurrentInParkingArea();	
	public void saveParkingUser(parkingDetails details);
	public void deleteParkingEntrySession(int theId);

}
