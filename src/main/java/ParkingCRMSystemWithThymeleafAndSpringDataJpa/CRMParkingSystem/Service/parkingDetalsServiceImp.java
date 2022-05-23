package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingDetails;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.dao.parkingDetailsRepository;

@Service
public class parkingDetalsServiceImp implements parkingDetailsService {
	private parkingDetailsRepository detailsRepository;

	public parkingDetalsServiceImp() {}

	@Autowired
	public parkingDetalsServiceImp(parkingDetailsRepository detailsRepository) {
		this.detailsRepository = detailsRepository;
	}

	@Override
	public List<parkingDetails> findAll() {
		return detailsRepository.findAll();
	}

	@Override
	public long countNumberOfCurrentInParkingArea() {
		return detailsRepository.countNumberOfCurrentInParkingArea();
	}

	@Override
	public void saveParkingUser(parkingDetails details) {
	detailsRepository.save(details);	
		
	}

	@Override
	public void deleteParkingEntrySession(int theId) {
		detailsRepository.deleteById(theId);
		
	}



}
