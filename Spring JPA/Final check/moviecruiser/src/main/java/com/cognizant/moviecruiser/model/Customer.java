package com.cognizant.moviecruiser.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int id;
	@Column(name = "cust_name")
	private String name;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "favorite", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "movie_id"))
	private Set<Movie> movieList;

	public Customer() {
	}

	public Customer(String userName) {
		super();
		this.name = userName;
	}

	public Customer(int id, String userName) {
		super();
		this.id = id;
		this.name = userName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(Set<Movie> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-15s", id, name);
	}

}
