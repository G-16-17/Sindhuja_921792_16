package com.cognizant.moviecruiser.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.repository.MovieRepository;

@Service
public class MovieService {
	@Autowired
	private MovieRepository repository;

	public void addMovie(Movie movie) {
		repository.save(movie);
	}

	public List<Movie> showMovieListAdmin() {
		return repository.findAll();
	}
	//String genre

	public List<Movie> showMovieListCustomer() {
		return repository.findByActiveTrueAndDateOfLaunchBefore(new Date());
	}

	public Movie getMovieById(int id) {
		return repository.findById(id).get();
	}

	public void editMovie(Movie movie) {
		repository.save(movie);
	}

	public void save(List<Movie> movies) {
		repository.saveAll(movies);
	}
}
