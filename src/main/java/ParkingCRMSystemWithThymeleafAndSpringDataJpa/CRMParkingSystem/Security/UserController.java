package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller


public class UserController {

	@RequestMapping("/login")
	public String showMyLoginPage() {
		return "login";
	}
	
	//add request mapping for /access-denied
	@RequestMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
}