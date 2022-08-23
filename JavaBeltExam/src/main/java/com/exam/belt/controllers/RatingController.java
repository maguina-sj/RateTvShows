package com.exam.belt.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.exam.belt.models.Rating;
import com.exam.belt.services.RatingService;


@Controller
public class RatingController {
	@Autowired
	private RatingService ratingService;

	@PostMapping("/show/rating")
	public String newRating(@Valid @ModelAttribute("newRating") Rating rating, BindingResult result) {
		if(result.hasErrors()) {
			return "details.jsp";
		}
		ratingService.create(rating);
		return "redirect:/dashboard";
	}
}
