package com.library.model.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
* This class is responsible for creating CDs.
* 
* NOTE: Rearranged the class to fit the conventional order of methods/variables.
* @author: Veeral Patel
*/
@Entity
@Table(name = "sys.cd")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class CD implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		//This is the title of the CD.
		private String title;
                
                //This is the unique ID from database
                private Integer id;
		
		//This is the artist that is responsible for the creation of the CD
		private String artist;
		
		//This is the year the CD was released.
		private int releaseYear;
		
		//This is a boolean to specify if the CD is available or not.
		private int availibility;
		
		//This is the catalog Number, this is required to rent the CD.
		private String catalogNumber;
		
		//If rented, this is the date the CD is due again at the library.
		private Date returnDate;
	
	
	/**
	* This is the constructor. For every CD object that gets created, this method is called and requires these parameters.
	*/
	public CD(String title, String artist, int releaseYear, String catalogNumber, int availibility) {
		super();
		this.title = title.toLowerCase();
		this.artist = artist;
		this.releaseYear = releaseYear;
		this.availibility = availibility;
                this.id = id;
		this.catalogNumber = catalogNumber;
		this.returnDate = null;
	}
        
        public CD() {}
	
	
	/**
	* Validate if the instance variables are valid
	* 
	* @return boolean - true if instance variables are valid, else false
	*/
		public boolean validate () {
			
			if (releaseYear == 0.0) return false;
			if (catalogNumber == null) return false;
			if (title == null) return false;
			if (artist == null) return false;
			if (returnDate != null) return false;
		    if (availibility == 1) return false;
			return true;
		}	
		
	/**
	* Until the next comments, all these methods are getters and setters. Which mean that they get and set values for
	* objects that are within the class.
	*/
                        
        @Column(name = "cdTitle", length = 45)
	public String getTitle() {
		return title.toLowerCase().trim();
	}
        
        @Id
        @Column (name = "idCD", length = 11)
        @GeneratedValue(generator="increment")
        @GenericGenerator(name="increment", strategy = "increment")
        public Integer getID(){
            return id;
        }
        
	public void setTitle(String title) {
		this.title = title;
	}
        
        @Column(name = "cdArtist", length = 45)
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
        
        @Column(name = "releaseYear", length = 11)
	public int getReleaseYear() {
		return releaseYear;
	}
        
        public void setID (int id) {
		this.id = id;
	}
	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}
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
	* Until the next comments, all these methods are getters and setters. Which mean that they get and set values for
	* objects that are within the class.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CD other = (CD) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
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
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
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
		return "CD [title=" + title + ", artist=" + artist + ", releaseYear=" + releaseYear + ", availibility="
				+ availibility + ", catalogNumber=" + catalogNumber + ", returnDate=" + returnDate + "]";
	}

	
	
	
	
}
