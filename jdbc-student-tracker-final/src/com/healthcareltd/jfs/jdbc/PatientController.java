package com.healthcareltd.jfs.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.luv2code.jsf.jdbc.patient;
import com.luv2code.jsf.jdbc.patientDbUtil;

public class PatientController {

	private List<patient> patients;
	private patientDbUtil patientDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	public PatientController() throws Exception {
		patients = new ArrayList<>();
		
		patientDbUtil = patientDbUtil.getInstance();
	}
	
	public List<patient> getpatients() {
		return patients;
	}

	public void loadpatients() {

		logger.info("Loading patients");
		
		patients.clear();

		try {
			
			// get all patients from database
			patients = patientDbUtil.getpatients();
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading patients", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
		}
	}
		
	public String addpatient(patient thepatient) {

		logger.info("Adding patient: " + thepatient);

		try {
			
			// add patient to the database
			patientDbUtil.addpatient(thepatient);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error adding patients", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "list-patients?faces-redirect=true";
	}

	public String loadpatient(int patientId) {
		
		logger.info("loading patient: " + patientId);
		
		try {
			// get patient from database
			patient thepatient = patientDbUtil.getpatient(patientId);
			
			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("patient", thepatient);	
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading patient id:" + patientId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "update-patient-form.xhtml";
	}	
	
	public String updatepatient(patient thepatient) {

		logger.info("updating patient: " + thepatient);
		
		try {
			
			// update patient in the database
			patientDbUtil.updatepatient(thepatient);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error updating patient: " + thepatient, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "list-patients?faces-redirect=true";		
	}
	
	public String deletepatient(int patientId) {

		logger.info("Deleting patient id: " + patientId);
		
		try {

			// delete the patient from the database
			patientDbUtil.deletepatient(patientId);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error deleting patient id: " + patientId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		
		return "list-patients";	
	}	
	
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
}
