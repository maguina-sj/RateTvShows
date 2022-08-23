package com.exam.belt.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.belt.models.Tvshow;
import com.exam.belt.repositories.TvshowRepository;

@Service
public class TvshowService {
	@Autowired
	private TvshowRepository tvshowRepo;
	
	//list all shows
		public List<Tvshow> all() {
			return tvshowRepo.findAll();
		}
		//new show
		public Tvshow create(Tvshow tvshow) {
			return tvshowRepo.save(tvshow);
		}
		//delete a shows
		public void delete(Long id) {
			tvshowRepo.deleteById(id);
		}
		//get one show
		public Tvshow getOne(Long id) {
			return tvshowRepo.findById(id).orElse(null);
		}
		//update show
		public Tvshow update(Tvshow tvshow) {
			return tvshowRepo.save(tvshow);
		}
}
