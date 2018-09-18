package com.healthcareltd.jfs.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.healthcareltd.jfs.jdbc.Patient;
import com.healthcareltd.jfs.jdbc.PatientDbUtil;

public class PatientDbUtil {

	private static PatientDbUtil instance;
	private DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/patient_tracker";
	
	public static PatientDbUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new PatientDbUtil();
		}
		
		return instance;
	}
	
	private PatientDbUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
		
	public List<Patient> getpatients() throws Exception {

		List<Patient> patients = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "select * from patient order by last_name";

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				// create new patient object
				Patient temppatient = new patient(id, firstName, lastName,
						email);

				// add it to the list of patients
				patients.add(temppatient);
			}
			
			return patients;		
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}

	public void addpatient(patient thepatient) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "insert into patient (first_name, last_name, email) values (?, ?, ?)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, thepatient.getFirstName());
			myStmt.setString(2, thepatient.getLastName());
			myStmt.setString(3, thepatient.getEmail());
			
			myStmt.execute();			
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public patient getpatient(int patientId) throws Exception {
	
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "select * from patient where id=?";

			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, patientId);
			
			myRs = myStmt.executeQuery();

			patient thepatient = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");

				thepatient = new patient(id, firstName, lastName,
						email);
			}
			else {
				throw new Exception("Could not find patient id: " + patientId);
			}

			return thepatient;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	public void updatepatient(patient thepatient) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "update patient "
						+ " set first_name=?, last_name=?, email=?"
						+ " where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, thepatient.getFirstName());
			myStmt.setString(2, thepatient.getLastName());
			myStmt.setString(3, thepatient.getEmail());
			myStmt.setInt(4, thepatient.getId());
			
			myStmt.execute();
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	
	public void deletepatient(int patientId) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "delete from patient where id=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setInt(1, patientId);
			
			myStmt.execute();
		}
		finally {
			close (myConn, myStmt);
		}		
	}	
	
	private Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	private void close(Connection theConn, Statement theStmt) {
		close(theConn, theStmt, null);
	}
	
	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}	
}
