package com.library.model.domain;

/**
 * This class is responsible for creating Addresses which are then stored with each Customer.
 * 
 * NOTE: Rearranged the class to fit the conventional order of methods/variables.
 * @author: Veeral Patel
 */

public class Address {
	
	//the street string will store the street name
	private String street;
	
	//the city string will store the city name
	private String city;
	
	//the state string will store the state name, It can either be "Minnesota" or "MN"
	private String state;
	
	//the country string will store the name of the country, it can either be "United States of America" or "USA"
	private String country;
	
	//the zipCode integer will store an integer that is the zip code of the address
	private int zipCode;
	
	//the addressValid boolean value, checks if the address is in Mounds View, otherwise will throw an exception
	private boolean addressValid;
	
	
/**
* This method is the constructor. This method needs to be passed a street, city, state, country, and zip code to make
* an Address.
*/	
	public Address(String street, String city, String state, String country, int zipCode) {
		super();
		this.street = street;
		
		if (city == "Mounds View" || city == "mounds view") 
			{
				this.city = city;
				addressValid = true;
			}
		else
			{
				addressValid = false;
				throw new IllegalArgumentException("Address not in Mounds View, your city was: " + city);		
			}
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}

/**
* Validate if the instance variables are valid
* 
* @return boolean - true if instance variables are valid, else false
*/
	public boolean validate () 
	{
		if (zipCode == 0.0) return false;
		if (street == null) return false;
		if (city == null) return false;
		if (state == null) return false;
	    if (addressValid = false) return false;
		return true;
	}	
	
/**
* Until the next comments, all these methods are getters and setters. Which mean that they get and set values for
* objects that are within the class.
*/
	public boolean getAddressValid() {
		return addressValid;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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
		Address other = (Address) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zipCode != other.zipCode)
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
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + zipCode;
		return result;
	}
	
/**
* This is the toString() method. This method turns an Address object into a string that can be read at runtime if invoked.
* 
*/	
	@Override
	public String toString() {
		return "[" + street + ", " + city + ", " + state + ", " + country
				+ ", " + zipCode + "]";
	}
	
	
}
