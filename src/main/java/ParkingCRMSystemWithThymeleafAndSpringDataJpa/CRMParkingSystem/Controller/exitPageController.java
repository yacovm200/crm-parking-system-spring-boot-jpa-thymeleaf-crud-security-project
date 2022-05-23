package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.HistoryParking;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingDetails;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.parkingUsers;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.HistoryParkingService;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingDetailsService;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.parkingUsersService;

@Controller
public class exitPageController {
	parkingUsersService parkingUsersService;
	parkingDetailsService parkingDetailsService;
	HistoryParkingService historyParkingService;
	
	//c'tors
	public exitPageController(parkingUsersService parkingUsersService,parkingDetailsService parkingDetailsService, HistoryParkingService historyParkingService ) {
		this.parkingUsersService = parkingUsersService;
		this.parkingDetailsService = parkingDetailsService;
		this.historyParkingService = historyParkingService;
	}


	@GetMapping("/exit")
	public String exitParkingList(Model model) {
		List <parkingUsers> theParkingUsers = parkingUsersService.findAll();
		model.addAttribute("ParkingUsers", theParkingUsers);
		return "exit";
	}

	@GetMapping("/exitform")
	public String exitForm(@RequestParam ("userId") int theId,
			@RequestParam ("parkingId") int parkingId,
			Model model) {
		
		parkingUsers parkingUsers = parkingUsersService.findByID(theId);
		model.addAttribute("user",parkingUsers);
		model.addAttribute("exitDateAndTime", new java.util.Date());
		//model.addAttribute("parking", parkingUsers.getParkingDetails().get(parkingId));
		int index =0;
		for(int i=1; i<parkingUsers.getParkingDetails().size(); i++) {
			if(parkingId == parkingUsers.getParkingDetails().get(i).getId()) {
				index = i;
				break;
			}
		}
		model.addAttribute("details",parkingUsers.getParkingDetails().get(index));
		model.addAttribute("number",parkingUsers.getParkingDetails().get(index).getId());
		return "exit-form"; 
	}
	
	@PostMapping("/saveDateAndTimeOfExitParking")
	public String saveNewUserFromFormAction(
			@ModelAttribute("user") parkingUsers parkingUsers,
			@ModelAttribute("details") parkingDetails parkingDetails
			,@RequestParam ("parkingId") int theId) {
		
		//save date and time on parkingDetails object
		String str = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		parkingDetails d = new parkingDetails(parkingDetails.getEntryDate(),parkingDetails.getEntryTime(),LocalDate.now(),str);
		d.setParkingUsers(parkingUsers);
		parkingDetailsService.saveParkingUser(d);		
		System.out.println("the row saved on history table on db");
		HistoryParking historyParking = new HistoryParking
				(parkingUsers.getFirstName(),
				 parkingUsers.getLastName(),
				 parkingUsers.getLicense(), 
				 parkingDetails.getEntryDate(), 
				 parkingDetails.getEntryTime(), 
				 LocalDate.now(),
				 str, 
				parkingUsers.getId());
		historyParkingService.saveParkingSession(historyParking);
		
		
		System.out.println(d.toString());
		parkingDetailsService.deleteParkingEntrySession(d.getId());
		parkingDetailsService.deleteParkingEntrySession(theId);	
		return "redirect:/exit";
	}
	
}
