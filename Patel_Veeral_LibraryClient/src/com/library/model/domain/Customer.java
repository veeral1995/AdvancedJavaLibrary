package com.library.model.domain;

import java.util.Random;

/**
 * This class is responsible for creating Customers.
 * 
 * NOTE: Rearranged the class to fit the conventional order of methods/variables.
 * @author: Veeral Patel
 */

public class Customer {

	private String firstName;
	private String lastName;
	private String emailAddress;
	Address residentialAddress;
	private long ccNumber;
	private boolean eligibility;
	private long catalogNumber;
	private String userName;
	private int memberID;
	private String password;
	
	public Customer(String firstName, String lastName, String emailAddress, Integer ccNumber, String userName, String password, Address residentialAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.ccNumber = ccNumber;
		this.userName = userName;
		this.password = password;
		this.memberID = getRandomID();
		this.eligibility = true;
		this.residentialAddress = residentialAddress;
	}

	/**
	* Validate if the instance variables are valid
	* 
	* @return boolean - true if instance variables are valid, else false
	*/
		public boolean validate () {
			
			if (memberID == 0.0) return false;
			if (ccNumber == 0.0) return false;
			if (firstName == null) return false;
			if (lastName == null) return false;
			if (userName == null) return false;
			if (password == null) return false;
		    if (eligibility = false) return false;
			return true;
		}
		
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public long getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(Integer ccNumber) {
		this.ccNumber = ccNumber;
	}

	public boolean isEligibility() {
		return eligibility;
	}

	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
	}

	public long getCatalogNumber() {
		return catalogNumber;
	}

	public void setCatalogNumber(long catalogNumber) {
		this.catalogNumber = catalogNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (eligibility != other.eligibility)
			return false;
		if (catalogNumber != other.catalogNumber)
			return false;
		if (ccNumber != other.ccNumber)
			return false;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (memberID != other.memberID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (eligibility ? 1231 : 1237);
		result = prime * result + (int) (catalogNumber ^ (catalogNumber >>> 32));
		result = prime * result + (int) (ccNumber ^ (ccNumber >>> 32));
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + memberID;
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", emailAddress=" + emailAddress
				+ ", residentialAddress=" + residentialAddress + ", ccNumber=" + ccNumber + ", eligibility="
				+ eligibility + ", catalogNumber=" + catalogNumber + ", userName=" + userName + ", memberID=" + memberID
				+ "]";
	}

//this function is reponsible for checking if the username chosen is available, not jet finished.
	public boolean checkOtherUser(String userName) {
		
		return true;
	}

//This function is responisble for generating a random ID for new customers.
	public int getRandomID()
	{
		Random randoNum = new Random();
		int num = 100000 + randoNum.nextInt(900000);
		return num;
	}

}
