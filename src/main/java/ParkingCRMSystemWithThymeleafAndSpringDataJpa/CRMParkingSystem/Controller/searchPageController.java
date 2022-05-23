package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingUsersService;

@Controller
public class searchPageController {

	private parkingUsersService parkingUsersService;

	public searchPageController(parkingUsersService parkingUsersService) {
		this.parkingUsersService = parkingUsersService;
	}

	@GetMapping("/search")
	public String exitParkingList(@RequestParam("keyword") String keyword, Model model) {
		List <parkingUsers> listOfUsers = parkingUsersService.searchByKeyword(keyword);
		model.addAttribute("ParkingUsers", listOfUsers);
		return "search";
	}

}
