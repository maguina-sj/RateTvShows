package com.exam.belt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.belt.models.Rating;
import com.exam.belt.repositories.RatingRepository;

@Service
public class RatingService {
	@Autowired
	private RatingRepository ratingRepo;
	
	//add a rating
	public void create(Rating rating) {
		ratingRepo.save(rating);
	}

}
