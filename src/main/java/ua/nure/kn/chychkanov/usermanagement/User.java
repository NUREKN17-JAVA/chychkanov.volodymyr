package ua.nure.kn.chychkanov.usermanagement;

import java.util.Date;
import java.io.Serializable;
import java.util.Calendar;

public class User implements Serializable{
	private static final long serialVersionUID = -112812758632339479L;
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public User(Long id, String firstName, String lastName, Date dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getFullName() {
		return getLastName() + " " + getFirstName();
	}
	
	public int getAge() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
		int currentMonth = calendar.get(Calendar.MONTH);
		calendar.setTime(getDateOfBirth());
		int birthYear = calendar.get(Calendar.YEAR);
		int birthDay = calendar.get(Calendar.DAY_OF_MONTH);
		int birthMonth = calendar.get(Calendar.MONTH);
		int age = currentYear - birthYear;
		if ((currentMonth == birthMonth && currentDay < birthDay) || currentMonth <  birthMonth ) {
			return age;
		}	
		else if(currentDay == birthDay && currentMonth == birthMonth) {
			return age;
		}
		else if(currentYear < birthYear || (currentYear == birthYear && birthMonth > currentMonth) || 
				(currentYear == birthYear && birthMonth == currentMonth && birthDay > currentDay)) {
			return -age;
		}
		else {
			return age;
		}		
	 }
	 
		
}