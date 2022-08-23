package com.exam.belt.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.exam.belt.models.Rating;
import com.exam.belt.models.Tvshow;
import com.exam.belt.services.TvshowService;

@Controller
public class TvshowController {

	@Autowired
	private TvshowService tvshowService;
	
	@GetMapping("/show/new")
	public String newShow(HttpSession session, @ModelAttribute("newShow") Tvshow tvshow) {
		if(session.getAttribute("loggedInUser")== null) {
		return "dashboard.jsp";
		}
		else {
		return "new.jsp";
		}
	}
	@PostMapping("/show/create")
	public String createShow(@Valid @ModelAttribute("newShow")Tvshow tvshow, BindingResult result) {
		if(result.hasErrors()) {
			return"new.jsp";
		}
		else {
			tvshowService.create(tvshow);
			return "redirect:/dashboard";
		}
	}
	@GetMapping("/show/details/{id}")
	public String viewShow(@PathVariable Long id, Model model, HttpSession session, @ModelAttribute("newRating") Rating rating) {
		if(session.getAttribute("loggedInUser")!= null) {
		Tvshow tvshow= tvshowService.getOne(id);
		model.addAttribute("tvshow", tvshow);
		return "details.jsp";
	}
		else {
			return "redirect:/";
		}
	}
	@GetMapping("/show/edit/{id}")
	public String editBook(@PathVariable Long id, HttpSession session, @ModelAttribute("editShow") Tvshow tvshow, Model model) {
		if(session.getAttribute("loggedInUser")!= null) {
		return "dashboard.jsp";
		}
		else {
			Tvshow editShow = tvshowService.getOne(id);
			model.addAttribute("editShow", editShow);
		return "edit.jsp";
		}
	}
	@PutMapping("/show/update/{id}")
	public String updateShow(@PathVariable Long id, @Valid @ModelAttribute("editShow") Tvshow tvshow, HttpSession session) {
		if(session.getAttribute("loggedInUser")!= null) {
			return "dashboard.jsp";
		}
		else {
		tvshowService.update(tvshow);
		return "redirect:/dashboard";
		}
	}
}
