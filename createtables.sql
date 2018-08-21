
CREATE TABLE Patient
	(

	Patientid varchar(10) NOT NULL,
	Title varchar(10),
	Firstname varchar(50),
	Lastname varchar(50),
	Mobilephonenumber varchar(15),
	Homephonenumber varchar(15),
	Email varchar(50),
	Gender varchar(30),
	Dateofbirth date, 
	Streetnumber varchar(10),
	Streetname varchar(255),
	Suburb varchar(50),
	Postcode varchar(4),
	City varchar(50),
	State varchar(5),
	Emergencycontactname varchar(50),
	Emergencycontactnumber varchar(50),
	Emergencyrelation varchar(50),
	patientnotedate date, 
	patientnotedescription LONGTEXT,
	CONSTRAINT PK_Patient PRIMARY KEY (Patientid) 



	);

CREATE TABLE Login 
(
	Userid varchar(10) NOT NULL,
	Username varchar(10),
	Password varchar(50),
	Usertype varchar(10),
	CONSTRAINT PK_Login PRIMARY KEY (Userid)	
);
   

CREATE TABLE Appointment 

(
 Patientid varchar(10) REFERENCES Patient (Patientid),
 Userid varchar(10) REFERENCES Login (Userid),
 Appintmenttitle varchar(50),
 Appointmentstartday date,
 Appointmentstarttime time, 
 Appointmentendtime time, 
 Appointmentnotes LONGTEXT,
 CONSTRAINT PK_Appointment PRIMARY KEY (Patientid,Userid)
);   

INSERT INTO Patient VALUES ('0000000001' ,'Mr','Mawgee','Okura','0412562270','96435646','Mawgee@gmail.com','Male','1997-10-31','27/8-12 ','Hornsey Rd','Homebush West','2140','Sydney','NSW','Sophie Okura' ,'0413722039','Mother','2018-8-20','Chest Infection');

INSERT INTO Login VALUES ('LG00000001','DR123','SEP123','Doctor');

INSERT INTO Appointment VALUES ('0000000001','LG00000001','Checkup','2018-8-8','14:30:00','15:00:00','Simple Checkup patient had no issues')
