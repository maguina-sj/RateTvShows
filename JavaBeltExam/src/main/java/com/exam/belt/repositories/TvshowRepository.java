package com.exam.belt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.exam.belt.models.Tvshow;


public interface TvshowRepository extends CrudRepository<Tvshow, Long>{
	List<Tvshow>findAll();

}
