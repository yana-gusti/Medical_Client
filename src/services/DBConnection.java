/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import Pages.SignInPage;
import java.sql.*;
import java.util.ArrayList;


public class DBConnection implements Interface<Users> {

	private final String connectionUrl = "jdbc:mysql://localhost/medical_client?user=root&password=yana246897531";

	private static Connection connection;

	public DBConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(connectionUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Users> getAll() {

		ArrayList<Users> array = new ArrayList<Users>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM usertable";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Users tmpUser = new Users(null, rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("birthday"), rs.getString("e_mail"), rs.getString("pass"));
				tmpUser.setId(rs.getInt("id"));
				array.add(tmpUser);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return array;
	}

	public static int save(Users user) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id =0;
		String insertSQL = "INSERT INTO usertable (usertable.first_name, usertable.last_name, usertable.birthday, usertable.e_mail,  usertable.pass) VALUES('"
				+ user.getFirst_name()
				+ "', '"
				+ user.getLast_name()
				+ "', '"
				+ user.getBirthday()
				+ "', '"
				+ user.getE_mail()
				+ "', '"
				+ user.getPass() + "')";

		try {
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if (rs != null && rs.next()) {
				id = rs.getInt(id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}
        public static int savePatient(Patient patient) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id =0;
		String insertSQL = "INSERT INTO addmissiontable (addmissiontable.first_name, addmissiontable.last_name, addmissiontable.birthday, addmissiontable.address,  addmissiontable.work, addmissiontable.diagnoz) VALUES('"
				+ patient.getFirst_name()
				+ "', '"
				+ patient.getLast_name()
				+ "', '"
				+ patient.getBirthday()
				+ "', '"
				+ patient.getAddress()
				+ "', '"
				+ patient.getWork()
                                + "', '"
                                + patient.getDiagnoz() + "')";
		try {
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();

			if (rs != null && rs.next()) {
				id = rs.getInt(id);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}


	public static ArrayList<Users> getUser(Users user) {

		ArrayList<Users> arrayUsers = new ArrayList<Users>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM usertable WHERE e_mail = '"
				+ user.getE_mail() + "'";
		System.out.println(SQL);
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				user = new Users(null, rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("birthday"), rs.getString("e_mail"),
						 rs.getString("pass"));
				user.setId(rs.getInt("id"));
				arrayUsers.add(user);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayUsers;

	}

	
	

	

	public boolean delete(Users user) {
		PreparedStatement stmt = null;

		try {

			String insertSQL = "DELETE FROM usertable WHERE e_mail = '"
					+ user.getE_mail() + "';";
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	public static ArrayList<Patient> getAllPatient() {

		ArrayList<Patient> array = new ArrayList<Patient>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM addmissiontable";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Patient tmpPatient = new Patient(null, rs.getString("first_name"),
						rs.getString("last_name"), 
						rs.getString("birthday"), rs.getString("address"), rs.getString("work"), rs.getString("diagnoz"));
				tmpPatient.setId(rs.getInt("id"));
				array.add(tmpPatient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return array;
	}
	


}
