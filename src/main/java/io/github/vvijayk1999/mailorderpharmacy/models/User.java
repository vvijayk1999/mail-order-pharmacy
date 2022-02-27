package io.github.vvijayk1999.mailorderpharmacy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid Email ID")
	private String emailId;

	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid Phone Number")
	private String phoneNumber;

	@Size(min = 8, message = "Password must be of length atleast 8 characters")
	private String password;

	@Size(min = 3, max = 15, message = "First name must be between 3 and 15 characters")
	private String firstName;

	@Size(min = 3, max = 15, message = "Last name must be between 3 and 15 characters")
	private String lastName;

	public User() {

	}

	public User(String emailId, String phoneNumber, String password, String firstName, String lastName) {
		super();
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", phoneNumber=" + phoneNumber + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
