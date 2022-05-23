package ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Entity.HistoryParking;
import ParkingCRMSystemWithThymeleafAndSpringDataJpa.CRMParkingSystem.Service.HistoryParkingService;

@Controller
public class historyPageController {
	public HistoryParkingService historyParkingService;
	
	public historyPageController(HistoryParkingService historyParkingService) {
		this.historyParkingService = historyParkingService;
	}

	@GetMapping("/history")
	public String exitParkingList(Model model) {
		List <HistoryParking> theHistory = historyParkingService.findAll();
		model.addAttribute("history", theHistory);
		//model.addAttribute("localDateTime", LocalDateTime.now());
		return "history";
	}
	
	@GetMapping("/historyDelete")
	public String removeRowFromHistory(@RequestParam("historyId")int historyId) {
		historyParkingService.delete(historyId);
		System.out.println(historyId);
		return "redirect:/history";
	}
	
}
