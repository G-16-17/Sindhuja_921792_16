package com.cognizant.moviecruiser;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.service.CustomerService;
import com.cognizant.moviecruiser.service.MovieService;
import com.cognizant.moviecruiser.util.DateUtil;


@SpringBootApplication
public class MoviecruiserApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(MoviecruiserApplication.class);
	private static MovieService movieService;
	private static CustomerService customerService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MoviecruiserApplication.class, args);
		movieService = context.getBean(MovieService.class);
		customerService = context.getBean(CustomerService.class);
		//to add all the movies
//		List<Movie> list = addAllMoviesToStore();
//		movieService.save(list);
//		LOGGER.info("The movies are stored in db...");
		//addMovie();
		
		//getAdminList();
		//getCustomerList();
		//modifyMovieList();
		//getaMovie();
		testCustomerService();
	}

	public static void addMovie() {
		LOGGER.info("Start");
		Movie movie1 = new Movie("Andhagaram", true, "4.8 Cr", DateUtil.convertToDate("24/11/2020"), "Horror", false);
		movieService.addMovie(movie1);
		LOGGER.debug("Movies: {}", movieService.showMovieListAdmin());
		LOGGER.info("End");
	}

	private static List<Movie> addAllMoviesToStore() {

		Movie movie;
		List<Movie> movieList = new ArrayList<>();
		
		movie = new Movie("Soorarai potru", true, "124.69 Cr", DateUtil.convertToDate("12/11/2020"), "Action", true);
		movieList.add(movie);
		movie = new Movie("Aramm", true, "25.26 Cr", DateUtil.convertToDate("23/12/2017"), "Thriller", false);
		movieList.add(movie);
		movie = new Movie("3", false, "100.24 Cr", DateUtil.convertToDate("30/03/2012"), "Romance", true);
		movieList.add(movie);
		movie = new Movie("Master", false, "162.34 Cr", DateUtil.convertToDate("13/01/2021"), "Action", true);
		movieList.add(movie);
		movie = new Movie("Vikram", true, "27.50 Cr", DateUtil.convertToDate("02/11/2022"), "Action thriller", false);
		movieList.add(movie);

		return movieList;
	}
	
	private static void getAdminList() {
		LOGGER.info("Start");
		List<Movie> movieList = movieService.showMovieListAdmin();
		LOGGER.debug("Movie list= {}", movieList);
		LOGGER.info("End");
	}

	private static void getCustomerList() {
		LOGGER.info("Start");
		List<Movie> movieList = movieService.showMovieListCustomer();
		LOGGER.debug("Movie list= {}", movieList);
		LOGGER.info("End");

	}
	
	private static void modifyMovieList() {
		
		LOGGER.info("Start");
		Movie movie = new Movie(4,"Master", true, "180.34 Cr", DateUtil.convertToDate("13/01/2021"), "Action", true);
		movieService.editMovie(movie);;
		LOGGER.info("End");

	}
	
	private static void getaMovie() {
		
		LOGGER.info("Start");
		Movie movie=movieService.getMovieById(1);
		LOGGER.debug("Movie list= {}", movie);
		LOGGER.info("End");

	}
	public static void testCustomerService() {
		LOGGER.info("Start");
		LOGGER.debug("CustomerList: {}", customerService.getAllCustomer());
//		LOGGER.debug("Customer: {}", customerService.getCustomerById(102));
//		LOGGER.debug("MovieList: {}", customerService.getCustomerById(101).getMovieList());
//		LOGGER.debug("CustomerList: {}", movieService.getMovieById(1).getCustomerList());
//		customerService.addCustomer("Agil");
		LOGGER.info("End");
	}
}
