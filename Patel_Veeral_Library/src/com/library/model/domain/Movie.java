package com.library.model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * This class is responsible for creating Addresses which are then stored with each Customer.
 * 
 * NOTE: Rearranged the class to fit the conventional order of methods/variables.
 * @author: Veeral Patel
 */
@Entity
@Table(name = "sys.movie")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Movie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//This is the title of the Movie.
	private String title;
        
        //This is the ID from database
        private Integer id;
	
	//This is the year the movie was released.
	private int releaseYear;
	
	//This is a boolean to specify if the movie is available or not.
	private int availibility;
	
	//This is the catalog Number, this is required to rent the movie.
	private String catalogNumber;
	
	//If rented, this is the date the Movie is due again at the library.
	private Date returnDate;
	
	
	/**
	* This is the constructor. For every Movie object that gets created, this method is called and requires these parameters.
	*/
	public Movie(String title, int releaseYear, String catalogNumber, int availibility) {
		super();
		this.title = title.toLowerCase();
		this.releaseYear = releaseYear;
		this.availibility = availibility;
		this.catalogNumber = catalogNumber;
                this.id = id;
		this.returnDate = null;
	}

        public Movie() {}
	/**ß
	* Validate if the instance variables are valid
	* 
	* @return boolean - true if instance variables are valid, else false
	*/
		public boolean validate () {
			
			if (releaseYear == 0.0) return false;
			if (catalogNumber == null) return false;
			if (title == null) return false;
			if (returnDate != null) return false;
		    if (availibility == 1) return false;
			return true;
		}	
	
	/**
	* Until the next comments, all these methods are getters and setters. Which mean that they get and set values for
	* objects that are within the class.
	*/
                
        @Column(name = "movieTitle", length = 45)
	public String getTitle() {
		return title.toLowerCase().trim();
	}
	public void setTitle(String title) {
		this.title = title;
	}
        
        @Id
        @Column (name = "idMovie", length = 11)
        public Integer getID(){
            return id;
        }
        
        @Column(name = "releaseYear", length = 11)
	public int getReleaseYear() {
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
        
        public void setID (int id) {
		this.id = id;
	}
        
        @Column(name = "availibility", length = 2)
	public int getAvailibility() {
		return availibility;
	}
	public void setAvailibility(int availibility) {
		this.availibility = availibility;
	}
        
        @Column(name = "catalogNumber", length = 45)
	public String getCatalogNumber() {
		return catalogNumber;
	}
	public void setCatalogNumber(String catalogNumber) {
		this.catalogNumber = catalogNumber;
	}
        
        @Column(name = "returnDate", length = 11)
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	
	/**
	* This is the equals() method. This method will check if two objects within the class are identical to each other.
	* 
	*/	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (availibility != other.availibility)
			return false;
		if (catalogNumber != other.catalogNumber)
			return false;
		if (releaseYear != other.releaseYear)
			return false;
		if (returnDate == null) {
			if (other.returnDate != null)
				return false;
		} else if (!returnDate.equals(other.returnDate))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	/**
	* This is the hashCode() method. This is mainly used for hashing collections such as a HashMap, which is not used here.
	* 
	*/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + availibility;
		result = prime * result + ((catalogNumber == null) ? 0 : catalogNumber.hashCode());
		result = prime * result + releaseYear;
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}	
	
	/**
	* This is the toString() method. This method turns an Movie object into a string that can be read at runtime if invoked.
	* 
	*/
	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseYear=" + releaseYear + ", availibility=" + availibility
				+ ", catalogNumber=" + catalogNumber + ", returnDate=" + returnDate + "]";
	}
	
	
}
