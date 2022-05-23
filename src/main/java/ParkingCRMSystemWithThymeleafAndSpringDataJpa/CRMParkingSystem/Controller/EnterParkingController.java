package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingDetails;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingDetailsService;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingUsersService;

@Controller
public class EnterParkingController {
	parkingUsersService parkingUsersService;
	parkingDetailsService parkingDetailsService;

	//c'tors
	public EnterParkingController(parkingUsersService parkingUsersService,parkingDetailsService parkingDetailsService) {
		this.parkingUsersService = parkingUsersService;
		this.parkingDetailsService = parkingDetailsService;
	}

	/*Use cases:
	 * we want to pass to thymyleaf,
	 * only the users that arent parking right now.
	 * 
	 * so if we had user that already parking, 
	 * we wont to show him on the table of enter car,
	 * 
	 * to do that we create another list,
	 * if the user not hold data on his field(nested object) parkingDetails,
	 * we can understand that he dont need to be show in our table,
	 * because he is already parking.
	 * it this case we dont add this user to our temp list.
	 * 
	 */
	@GetMapping("/parkingList")
	public String parkingList(Model model) {

		List <parkingUsers> theParkingUsers = parkingUsersService.findAll();
		List<parkingUsers> tempList = new ArrayList<parkingUsers>();

		for(int i=0; i<theParkingUsers.size();i++) {
			if(theParkingUsers.get(i).getParkingDetails().isEmpty()) {
				tempList.add(theParkingUsers.get(i));
			}
		}		
		model.addAttribute("ParkingUsers", tempList);
		return "enter-car";
	}

	@GetMapping("/showFormForAdd")
	public String showFormToUser(Model model) {
		parkingUsers parkingUsers = new parkingUsers();
		model.addAttribute("user",parkingUsers);
		return "user-form";
	}


	@GetMapping("/showFormForUpdate") 
	public String updateUserForm(@RequestParam("userId") int theId ,
			Model model) { 
		parkingUsers parkingUsers = parkingUsersService.findByID(theId); 
		model.addAttribute("user",parkingUsers);
		return "user-form"; 
	}


	@PostMapping("/save")
	public String saveNewUserFromFormAction(@ModelAttribute("user") parkingUsers parkingUsers) {
		parkingUsersService.saveParkingUser(parkingUsers);
		return "redirect:/parkingList";
	}

	@GetMapping("/delete") 
	public String deleteUser(@RequestParam("userId") int theId){
		parkingUsersService.deleteParkingUser(theId);
		return "redirect:/parkingList"; 
	}

	@GetMapping("/enterToParking") 
	public String enterCarToParinkForm(@RequestParam("userId") int theId ,Model model ) { 
		parkingUsers parkingUsers = parkingUsersService.findByID(theId); 
		if(!parkingUsers.getParkingDetails().isEmpty()) {					
			//here i want to send alert to the screen and then redirect to parkingList.
			return "redirect:/parkingList"; 
		}
		model.addAttribute("user",parkingUsers);
		model.addAttribute("time", new java.util.Date());
		return "user-parking"; 
	}

	@PostMapping("/parking")
	public String saveCarParking(@ModelAttribute("user") parkingUsers parkingUsers) {		
		String str = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		parkingDetails d = new parkingDetails(LocalDate.now(), str, null, null);
		d.setParkingUsers(parkingUsers);
		parkingDetailsService.saveParkingUser(d);
		return "redirect:/parkingList"; 
	}
}
