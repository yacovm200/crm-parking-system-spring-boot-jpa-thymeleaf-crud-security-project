package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;

public interface parkingUsersRepository extends JpaRepository<parkingUsers, Integer> {
    @Query("SELECT p FROM parkingUsers p WHERE p.firstName LIKE %:keyword% OR p.lastName LIKE %:keyword% OR p.license LIKE %:keyword%")
	public List<parkingUsers> searchByKeyword(String keyword);
}
