package com.exam.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exam.belt.models.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {
	List<Rating> findByOrderByRatingAsc();
}
