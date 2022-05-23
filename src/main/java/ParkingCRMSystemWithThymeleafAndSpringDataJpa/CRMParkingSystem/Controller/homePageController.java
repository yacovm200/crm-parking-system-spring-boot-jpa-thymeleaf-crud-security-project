package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingDetailsService;

@Controller
public class homePageController {
	
	public parkingDetailsService detailsService;
	
	public homePageController(parkingDetailsService detailsService) {
		this.detailsService = detailsService;
	}


	@GetMapping("/home")
	public String homePage(Model model/* , @RequestParam String username */) {
		model.addAttribute("count",detailsService.countNumberOfCurrentInParkingArea());
		return "home";
	}
	
}
