package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingDetails;

public interface parkingDetailsRepository extends JpaRepository<parkingDetails, Integer> {
    @Query("SELECT COUNT(entry_date) FROM parkingDetails")
    public Long countNumberOfCurrentInParkingArea();


}
