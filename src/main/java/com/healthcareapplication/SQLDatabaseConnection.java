package com.healthcareapplication;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class SQLDatabaseConnection {
	public static Connection connection;
	
	public static void main() {
		System.out.println("Testing Connection");
	}
	
	public static Connection getConnection() throws SQLException {
		
		System.out.println("Testing Connection");
        String connectionUrl =
                "jdbc:sqlserver:healthcaresoftwareutssql.database.windows.net:1433;"
                        + "database=healthcaresoftwaredatabase;"
                        + "user=dbadmin@healthcaresoftwareutssql;"
                        + "password=+BM}~\"\"\"5~h$Bt_w3x@7;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "hostNameInCertificate=*.database.windows.net;"
                        + "loginTimeout=30;";
 
        try {
        	Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Connection sucessful");
            return connection;
        }
        catch (SQLException e) {
        	System.out.println("Connection failed");
            e.printStackTrace();
            throw e;
        }
        
    }

}
