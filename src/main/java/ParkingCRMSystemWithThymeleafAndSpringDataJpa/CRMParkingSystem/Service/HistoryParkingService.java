package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service;

import java.util.List;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.HistoryParking;

public interface HistoryParkingService {

public List<HistoryParking>findAll();
public void saveParkingSession(HistoryParking historyParking);
public void delete(int historyId);

}
