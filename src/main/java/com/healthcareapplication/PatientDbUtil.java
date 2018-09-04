package com.healthcareapplication;

import java.sql.Connection;
import com.healthcareapplication.SQLDatabaseConnection;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.healthcareapplication.*;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class PatientDbUtil {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet resultSet;
	private static ArrayList<Patient> patients = new ArrayList<Patient>();

	public static void main(String[] args) throws SQLException {

	}

	public static void setPatientsFromDatabase() {
		try {
			connection = SQLDatabaseConnection.getConnection();
			statement = connection.createStatement();
			// Create and execute a SELECT SQL statement. just for checking if the
			// connection works or not
			String selectSql = "select * from dbo.Patient";
			resultSet = statement.executeQuery(selectSql);

			// Print results from select statement.
			ResultSetMetaData rsmd = resultSet.getMetaData();
			while (resultSet.next()) {
//				for (int x = 1; x <= rsmd.getColumnCount(); x++) {
//					System.out.print(resultSet.getString(x) + " ");
//				}
//				System.out.println("");
				int Patientid = resultSet.getInt("Patientid");
				String Title = resultSet.getString("Title");
				String Firstname = resultSet.getString("Firstname");
				String Lastname = resultSet.getString("Lastname");
				String Mobilephonenumber = resultSet.getString("Mobilephonenumber");
				String Homephonenumber = resultSet.getString("Homephonenumber");
				String Email = resultSet.getString("Email");
				String Gender = resultSet.getString("Gender");
				String Dateofbirth = resultSet.getString("Dateofbirth");
				String Streetnumber = resultSet.getString("Streetnumber");
				String Streetname = resultSet.getString("Streetname");
				String Suburb = resultSet.getString("Suburb");
				String Postcode = resultSet.getString("Postcode");
				String City = resultSet.getString("City");
				String State = resultSet.getString("State");
				String Emergencycontactname = resultSet.getString("Emergencycontactname");
				String Emergencycontactnumber = resultSet.getString("Emergencycontactnumber");
				String Emergencyrelation = resultSet.getString("Emergencyrelation");

				// create new Patient object
				Patient tempPatient = new Patient(Patientid, Title, Firstname, Lastname, Mobilephonenumber,
						Homephonenumber, Email, Gender, Dateofbirth, Streetnumber, Streetname, Suburb, Postcode, City,
						State, Emergencycontactname, Emergencycontactnumber, Emergencyrelation);
				patients.add(tempPatient);
			}
		} catch (SQLException e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}

	}

	public static ArrayList<Patient> getPatients() {
		setPatientsFromDatabase();
		for(Patient tempPatient: patients) {
			System.out.println(tempPatient);
		}
		return patients;
	}
}

//	public List<Patient> getPatients() throws Exception {
//
//		List<Patient> Patients = new ArrayList<>();
//
//		Connection myConn = null;
//		Statement myStmt = null;
//		ResultSet myRs = null;
//
//		try {
//			myConn = getConnection();
//
//			String sql = "select * from Patient order by last_name";
//
//			myStmt = myConn.createStatement();
//
//			myRs = myStmt.executeQuery(sql);
//
//			// process result set
//			while (myRs.next()) {
//
//				// retrieve data from result set row
//				int Patientid = myRs.getInt("Patientid");
//				String Title = myRs.getString("Title");
//				String Firstname = myRs.getString("Firstname");
//				String Lastname = myRs.getString("Lastname");
//				String Mobilephonenumber = myRs.getString("Mobilephonenumber");
//				String Homephonenumber = myRs.getString("Homephonenumber");
//				String Email = myRs.getString("Email");
//				String Gender = myRs.getString("Gender");
//				String Dateofbirth = myRs.getString("Dateofbirth");
//				String Streetnumber = myRs.getString("Streetnumber");
//				String Streetname = myRs.getString("Streetname");
//				String Suburb = myRs.getString("Suburb");
//				String Postcode = myRs.getString("Postcode");
//				String City = myRs.getString("City");
//				String State = myRs.getString("State");
//				String Emergencycontactname = myRs.getString("Emergencycontactname");
//				String Emergencycontactnumber = myRs.getString("Emergencycontactnumber");
//				String Emergencyrelation = myRs.getString("Emergencyrelation");
//
//				// create new Patient object
//				Patient tempPatient = new Patient(Patientid, Title, Firstname, Lastname, Mobilephonenumber,
//						Homephonenumber, Email, Gender, Dateofbirth, Streetnumber, Streetname, Suburb, Postcode, City,
//						State, Emergencycontactname, Emergencycontactnumber, Emergencyrelation);
//
//				// add it to the list of Patients
//				Patients.add(tempPatient);
//			}
//
//			return Patients;
//		} finally {
//			close(myConn, myStmt, myRs);
//		}
//	}
//
//	public void addPatient(Patient thePatient) throws Exception {
//
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//
//		try {
//			myConn = getConnection();
//
//			String sql = "insert into Patient (first_name, last_name, email) values (?, ?, ?)";
//
//			myStmt = myConn.prepareStatement(sql);
//
//			// set params
//			myStmt.setString(1, thePatient.getFirstName());
//			myStmt.setString(2, thePatient.getLastName());
//			myStmt.setString(3, thePatient.getEmail());
//
//			myStmt.execute();
//		} finally {
//			close(myConn, myStmt);
//		}
//
//	}
//
//	public Patient getPatient(int PatientId) throws Exception {
//
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		ResultSet myRs = null;
//
//		try {
//			myConn = getConnection();
//
//			String sql = "select * from Patient where id=?";
//
//			myStmt = myConn.prepareStatement(sql);
//
//			// set params
//			myStmt.setInt(1, PatientId);
//
//			myRs = myStmt.executeQuery();
//
//			Patient thePatient = null;
//
//			// retrieve data from result set row
//			if (myRs.next()) {
//				int id = myRs.getInt("id");
//				String firstName = myRs.getString("first_name");
//				String lastName = myRs.getString("last_name");
//				String email = myRs.getString("email");
//
//				thePatient = new Patient(id, firstName, lastName, email);
//			} else {
//				throw new Exception("Could not find Patient id: " + PatientId);
//			}
//
//			return thePatient;
//		} finally {
//			close(myConn, myStmt, myRs);
//		}
//	}
//
//	public void updatePatient(Patient thePatient) throws Exception {
//
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//
//		try {
//			myConn = getConnection();
//
//			String sql = "update Patient " + " set first_name=?, last_name=?, email=?" + " where id=?";
//
//			myStmt = myConn.prepareStatement(sql);
//
//			// set params
//			myStmt.setString(1, thePatient.getFirstName());
//			myStmt.setString(2, thePatient.getLastName());
//			myStmt.setString(3, thePatient.getEmail());
//			myStmt.setInt(4, thePatient.getId());
//
//			myStmt.execute();
//		} finally {
//			close(myConn, myStmt);
//		}
//
//	}
//
//	public void deletePatient(int PatientId) throws Exception {
//
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//
//		try {
//			myConn = getConnection();
//
//			String sql = "delete from Patient where id=?";
//
//			myStmt = myConn.prepareStatement(sql);
//
//			// set params
//			myStmt.setInt(1, PatientId);
//
//			myStmt.execute();
//		} finally {
//			close(myConn, myStmt);
//		}
//	}
//
//	private Connection getConnection() throws Exception {
//
//		Connection theConn = dataSource.getConnection();
//
//		return theConn;
//	}
//
//	private void close(Connection theConn, Statement theStmt) {
//		close(theConn, theStmt, null);
//	}
//
//	private void close(Connection theConn, Statement theStmt, ResultSet theRs) {
//
//		try {
//			if (theRs != null) {
//				theRs.close();
//			}
//
//			if (theStmt != null) {
//				theStmt.close();
//			}
//
//			if (theConn != null) {
//				theConn.close();
//			}
//
//		} catch (Exception exc) {
//			exc.printStackTrace();
//		}
//	}
//}
