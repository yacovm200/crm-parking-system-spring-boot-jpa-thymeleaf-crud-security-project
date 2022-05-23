package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service;
import java.util.List;


import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.dao.parkingUsersRepository;

@Service
public class parkingUsersServiceImp implements parkingUsersService {
	
	private parkingUsersRepository parkingUsersRepository;
	
	public parkingUsersServiceImp() {}
	
	@Autowired
	public parkingUsersServiceImp(parkingUsersRepository parkingUsersRepository) {
		this.parkingUsersRepository = parkingUsersRepository;
	}

	@Override
	public List<parkingUsers> findAll() {
		return parkingUsersRepository.findAll();
	}

	@Override
	public parkingUsers findByID(int theId) {
		Optional<parkingUsers> result = parkingUsersRepository.findById(theId);
		parkingUsers parkingUsers = null;
		if (result.isPresent()) {
			parkingUsers = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		return parkingUsers;
	}

	@Override
	public void saveParkingUser(parkingUsers theParkingUsers) {
		parkingUsersRepository.save(theParkingUsers);
	}

	@Override
	public void deleteParkingUser(int theId) {
		parkingUsersRepository.deleteById(theId);

	}

	@Override
	public List<parkingUsers> searchByKeyword(String keyword) {
		return parkingUsersRepository.searchByKeyword(keyword);
	}


}
