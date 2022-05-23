package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.HistoryParking;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.dao.HistoryParkingRepository;

@Service
public class HistoryParkingServiceImp implements HistoryParkingService {
	public HistoryParkingRepository historyParkingRepository;
		
	@Autowired
	public HistoryParkingServiceImp(HistoryParkingRepository historyParkingRepository) {
		this.historyParkingRepository = historyParkingRepository;
	}

	@Override
	public void saveParkingSession(HistoryParking historyParking) {
		historyParkingRepository.save(historyParking);
	}

	@Override
	public List<HistoryParking> findAll() {
		return historyParkingRepository.findAll();
	}

	@Override
	public void delete(int historyId) {
		historyParkingRepository.deleteById(historyId);
	}



}
