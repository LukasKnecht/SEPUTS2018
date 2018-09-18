package com.healthcareltd.jfs.jdbc;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Patient {

	private int Patientid;
	private String Title;
	private String Firstname;
	private String Lastname;
	private String Mobilephonenumber;
	private String Homephonenumber;
	private String Email;
	private String Gender; 
	private String Dateofbirth; 
	private String Streetnumber;
	private String Streetname;
	private String Suburb;
	private String Postcode;
	private String City;
	private String State;
	private String Emergencycontactname;
	private String Emergencycontactnumber;
	private String Emergencyrelation;
	
	public Patient() {
	}
	
	public Patient(int Patientid, String Title, String Firstname, String Lastname, String Mobilephonenumber, String Homephonenumber, String Email, String Gender, String Dateofbirth, String Streetnumber, String Streetname, String Suburb, String Postcode, String City, String State, String Emergencycontactname, String Emergencycontactnumber, String Emergencyrelation) {
		this.Patientid=Patientid;
		this.Title=Title;
		this.Firstname=Firstname;
		this.Lastname=Lastname;
		this.Mobilephonenumber=Mobilephonenumber;
		this.Homephonenumber=Homephonenumber;
		this.Email=Email;
		this.Gender=Gender; 
		this.Dateofbirth=Dateofbirth; 
		this.Streetnumber=Streetnumber;
		this.Streetname=Streetname;
		this.Suburb=Suburb;
		this.Postcode=Postcode;
		this.City=City;
		this.State=State;
		this.Emergencycontactname=Emergencycontactname;
		this.Emergencycontactnumber=Emergencycontactnumber;
		this.Emergencyrelation=Emergencyrelation;
	}

	public int getPatientid() {
		return Patientid;
	}

	public void setPatientid(int patientid) {
		Patientid = patientid;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getMobilephonenumber() {
		return Mobilephonenumber;
	}

	public void setMobilephonenumber(String mobilephonenumber) {
		Mobilephonenumber = mobilephonenumber;
	}

	public String getHomephonenumber() {
		return Homephonenumber;
	}

	public void setHomephonenumber(String homephonenumber) {
		Homephonenumber = homephonenumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getDateofbirth() {
		return Dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		Dateofbirth = dateofbirth;
	}

	public String getStreetnumber() {
		return Streetnumber;
	}

	public void setStreetnumber(String streetnumber) {
		Streetnumber = streetnumber;
	}

	public String getStreetname() {
		return Streetname;
	}

	public void setStreetname(String streetname) {
		Streetname = streetname;
	}

	public String getSuburb() {
		return Suburb;
	}

	public void setSuburb(String suburb) {
		Suburb = suburb;
	}

	public String getPostcode() {
		return Postcode;
	}

	public void setPostcode(String postcode) {
		Postcode = postcode;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getEmergencycontactname() {
		return Emergencycontactname;
	}

	public void setEmergencycontactname(String emergencycontactname) {
		Emergencycontactname = emergencycontactname;
	}

	public String getEmergencycontactnumber() {
		return Emergencycontactnumber;
	}

	public void setEmergencycontactnumber(String emergencycontactnumber) {
		Emergencycontactnumber = emergencycontactnumber;
	}

	public String getEmergencyrelation() {
		return Emergencyrelation;
	}

	public void setEmergencyrelation(String emergencyrelation) {
		Emergencyrelation = emergencyrelation;
	}
	
	
}

