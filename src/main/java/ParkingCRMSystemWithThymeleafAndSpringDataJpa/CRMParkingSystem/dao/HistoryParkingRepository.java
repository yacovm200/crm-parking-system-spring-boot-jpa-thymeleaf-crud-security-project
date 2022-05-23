package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.HistoryParking;

public interface HistoryParkingRepository extends JpaRepository<HistoryParking, Integer> {

}
