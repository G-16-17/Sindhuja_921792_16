package com.cognizant.moviecruiser.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Table
@Entity
public class Movie {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@Column
	private boolean active;
	@Column(name = "box_office")
	private String boxOffice;
	@Column(name = "date_of_launch")
	private Date dateOfLaunch;
	@Column
	private String genre;
	@Column(name = "has_teaser")
	private boolean hasTeaser;

	@ManyToMany(mappedBy = "movieList", fetch = FetchType.EAGER)
	private Set<Customer> customerList;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, boolean active, String boxOffice, Date dateOfLaunch, String genre, boolean hasTeaser) {
		super();
		this.title = title;
		this.active = active;
		this.boxOffice = boxOffice;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	
	public Movie(int id, String title, boolean active, String boxOffice, Date dateOfLaunch, String genre,
			boolean hasTeaser) {
		super();
		this.id = id;
		this.title = title;
		this.active = active;
		this.boxOffice = boxOffice;
		this.dateOfLaunch = dateOfLaunch;
		this.genre = genre;
		this.hasTeaser = hasTeaser;
	}

	public Set<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(Set<Customer> customerList) {
		this.customerList = customerList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getBoxOffice() {
		return boxOffice;
	}

	public void setBoxOffice(String boxOffice) {
		this.boxOffice = boxOffice;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isHasTeaser() {
		return hasTeaser;
	}

	public void setHasTeaser(boolean hasTeaser) {
		this.hasTeaser = hasTeaser;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-20s%-10s%-20s%-10s%-15s%-10s", id, title, active, boxOffice, dateOfLaunch, genre,
				hasTeaser);
	}

}
