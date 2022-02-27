package io.github.vvijayk1999.mailorderpharmacy.controllers;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.github.vvijayk1999.mailorderpharmacy.exceptions.DrugNotFoundException;
import io.github.vvijayk1999.mailorderpharmacy.exceptions.UnauthorizedAccessException;
import io.github.vvijayk1999.mailorderpharmacy.models.dtos.PrescriptionDTO;
import io.github.vvijayk1999.mailorderpharmacy.services.CommonService;
import io.github.vvijayk1999.mailorderpharmacy.services.SubscriptionService;

@Controller
public class SubscriptionController {

	@Autowired
	private SubscriptionService service;

	@Autowired
	private CommonService commonService;

	@GetMapping("/subscriptions")
	public ModelAndView subscriptions() {

		ModelAndView model = new ModelAndView("subscriptions");

		String email = commonService.getLoggedinEmailId();
		System.out.println(service.getSubscriptions(email));
		model.addObject("subscriptions", service.getSubscriptions(email));

		return model;
	}

	@GetMapping("/subscribe")
	public String prescription(ModelMap model, @RequestParam String drugId, @RequestParam String location) {

		PrescriptionDTO prescription = new PrescriptionDTO("", 0, "", new Date(), location, drugId, "", 0, 0);

		model.addAttribute("prescription", prescription);

		return "subscribe";
	}

	@RequestMapping(value = "/subscribe", method = RequestMethod.POST)
	public String subscribe(Model model, @ModelAttribute PrescriptionDTO prescription) {

		try {
			service.subscribe(prescription);
		} catch (DrugNotFoundException e) {
			PrescriptionDTO p = new PrescriptionDTO("", 0, "", new Date(), prescription.getLocation(),
					prescription.getDrugId(), "", 0, 0);

			model.addAttribute("prescription", p);
			model.addAttribute("errorMessage", e.getLocalizedMessage());
			return "subscribe";
		}

		return "redirect:/subscriptions";
	}

	@GetMapping(value = "/unsubscribe/{sId}")
	public String unsubscribe(Model model, @PathVariable("sId") long sId) {

		try {
			service.unsubscribe(sId);
		} catch (NoSuchElementException | UnauthorizedAccessException e) {
			model.addAttribute("errorMessage", e.getLocalizedMessage());
			return "subscriptions";
		}

		return "redirect:/subscriptions";
	}

	@GetMapping("/refill/{sId}")
	public String adhocRefillForm(ModelMap model, @PathVariable("sId") long sId) {

		PrescriptionDTO prescription;
		try {
			prescription = service.getRefill(sId);
		} catch (UnauthorizedAccessException e) {
			model.addAttribute("errorMessage", e.getLocalizedMessage());
			return "refill";
		}

		model.addAttribute("prescription", prescription);
		model.addAttribute("sId", sId);

		return "refill";
	}

	@PostMapping("/refill/{sId}")
	public String adhocRefill(Model model, @ModelAttribute PrescriptionDTO prescription,
			@PathVariable("sId") long sId) {

		try {
			service.refill(sId, prescription);
		} catch (NoSuchElementException | UnauthorizedAccessException | DrugNotFoundException e) {
			model.addAttribute("errorMessage", e.getLocalizedMessage());
			return "refill";
		}

		return "redirect:/subscriptions";
	}
}
