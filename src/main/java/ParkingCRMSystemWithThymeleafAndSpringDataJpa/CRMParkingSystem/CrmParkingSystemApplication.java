package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingDetails;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingDetailsService;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingDetalsServiceImp;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingUsersService;

@SpringBootApplication
public class CrmParkingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrmParkingSystemApplication.class, args);

	}

}
