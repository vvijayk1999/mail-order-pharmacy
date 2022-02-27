package io.github.vvijayk1999.mailorderpharmacy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import io.github.vvijayk1999.mailorderpharmacy.services.DrugService;

@Controller
public class DrugController {

	@Autowired
	DrugService service;

	@RequestMapping("/drugs")
	public ModelAndView drugs() {
		ModelAndView model = new ModelAndView("drugs");
		model.addObject("drugLocations", service.getAllDrugsNested());
		return model;
	}

	@RequestMapping("/drugs/search")
	public String drugSearch() {
		return "drug-search";
	}

	@RequestMapping(value = "/drugs/search", method = RequestMethod.GET, params = "drugid")
	public ModelAndView drugSearchById(@RequestParam String drugid) {
		ModelAndView model = new ModelAndView("drug-search");
		model.addObject("drugLocations", service.getDrugsByIdNested(drugid));
		return model;
	}

	@RequestMapping(value = "/drugs/search", method = RequestMethod.GET, params = "drugname")
	public ModelAndView drugSearchByName(@RequestParam String drugname) {
		ModelAndView model = new ModelAndView("drug-search");
		model.addObject("drugLocations", service.getDrugsByNameNested(drugname));
		return model;
	}

}
