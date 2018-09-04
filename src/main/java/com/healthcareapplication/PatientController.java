package com.healthcareapplication;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import com.healthcareapplication.PatientDbUtil;
import com.healthcareapplication.Patient;

@ManagedBean
@SessionScoped
public class PatientController {

	private static ArrayList<Patient> patients;
	private Logger logger = Logger.getLogger(getClass().getName());

	public PatientController() throws Exception {

//		PatientDbUtil = PatientDbUtil.getInstance();
	}

	public static void main(String[] args) {
		
	}

	public void loadPatients() {

		logger.info("Loading Patients");

		try {

			// get all Patients from database
			patients = PatientDbUtil.getPatients();

		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading Patients", exc);

			// add error message for JSF page
			addErrorMessage(exc);
		}
	}

	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
//	public String addPatient(Patient thePatient) {
//
//		logger.info("Adding Patient: " + thePatient);
//
//		try {
//
//			// add Patient to the database
//			PatientDbUtil.addPatient(thePatient);
//
//		} catch (Exception exc) {
//			// send this to server logs
//			logger.log(Level.SEVERE, "Error adding Patients", exc);
//
//			// add error message for JSF page
//			addErrorMessage(exc);
//
//			return null;
//		}
//
//		return "list-Patients?faces-redirect=true";
//	}
//
//	public String loadPatient(int PatientId) {
//
//		logger.info("loading Patient: " + PatientId);
//
//		try {
//			// get Patient from database
//			Patient thePatient = PatientDbUtil.getPatient(PatientId);
//
//			// put in the request attribute ... so we can use it on the form page
//			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
//
//			Map<String, Object> requestMap = externalContext.getRequestMap();
//			requestMap.put("Patient", thePatient);
//
//		} catch (Exception exc) {
//			// send this to server logs
//			logger.log(Level.SEVERE, "Error loading Patient id:" + PatientId, exc);
//
//			// add error message for JSF page
//			addErrorMessage(exc);
//
//			return null;
//		}
//
//		return "update-Patient-form.xhtml";
//	}
//
//	public String updatePatient(Patient thePatient) {
//
//		logger.info("updating Patient: " + thePatient);
//
//		try {
//
//			// update Patient in the database
//			PatientDbUtil.updatePatient(thePatient);
//
//		} catch (Exception exc) {
//			// send this to server logs
//			logger.log(Level.SEVERE, "Error updating Patient: " + thePatient, exc);
//
//			// add error message for JSF page
//			addErrorMessage(exc);
//
//			return null;
//		}
//
//		return "list-Patients?faces-redirect=true";
//	}
//
//	public String deletePatient(int PatientId) {
//
//		logger.info("Deleting Patient id: " + PatientId);
//
//		try {
//
//			// delete the Patient from the database
//			PatientDbUtil.deletePatient(PatientId);
//
//		} catch (Exception exc) {
//			// send this to server logs
//			logger.log(Level.SEVERE, "Error deleting Patient id: " + PatientId, exc);
//
//			// add error message for JSF page
//			addErrorMessage(exc);
//
//			return null;
//		}
//
//		return "list-Patients";
//	}
//
//
//}
