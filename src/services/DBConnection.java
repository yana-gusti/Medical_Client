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
		String SQL = "SELECT * FROM user_table";

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
        public static ArrayList<Patient> getAllPatient() {

		ArrayList<Patient> array = new ArrayList<Patient>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT * FROM patienttable";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				Patient patient = new Patient(null, null, rs.getString("first_name"),rs.getString("last_name"), null, null, null,null, null, null, null, null, null, null
                                ,null,null,null,null,null,null,null);
				patient.setId(rs.getInt("id"));
				array.add(patient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return array;
	}
        public static ArrayList<String> getAllUserName() {

		ArrayList<String> array = new ArrayList<String>();
		Statement stmt = null;
		ResultSet rs = null;
		String SQL = "SELECT user_name FROM graphic";

		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(SQL);
			while (rs.next()) {
				
				array.add(rs.getString("user_name"));
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
		String insertSQL = "INSERT INTO user_table (user_table.first_name, user_table.last_name, user_table.birthday, user_table.e_mail,  user_table.pass) VALUES('"
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
        
        public static int saveGraphic(Graphic graphic) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id =0;
		String insertSQL = "INSERT INTO graphic (graphic.user_name, graphic.moday, graphic.tuesday, graphic.wednesday," +
                "graphic.thursday, graphic.friday) VALUES('"
				+ SignInPage.user.getE_mail()
				+ "', '"
				+ graphic.getMon()
				+ "', '"
				+ graphic.getTue()
				+ "', '"
				+ graphic.getWed()
				+ "', '"
                                + graphic.getThu()
				+ "', '"
				+ graphic.getFri() + "')";

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
		String SQL = "SELECT * FROM user_table WHERE e_mail = '"
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

	
	

	
	public static boolean deletePatient(Patient patient) {
		PreparedStatement stmt = null;

		try {

			String insertSQL = "DELETE FROM patienttable WHERE last_name = '"
					+ patient.getLast_name() + "';";
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
        public boolean deleteUser(Users user) {
		PreparedStatement stmt = null;

		try {

			String insertSQL = "DELETE FROM patienttable WHERE first_name = '"
					+ user.getFirst_name() + "';";
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	public static boolean UpdateGraphic(String mon, String tue, String wed, String thu, String fri) {
		PreparedStatement stmt = null;

		try {

			String insertSQL = "UPDATE graphic SET graphic.moday = '"+mon+"', graphic.tuesday='"+tue+"',"
                                + " graphic.wednesday='"+wed+"'," +
                                    "graphic.thursday='"+thu+"',"
                                + " graphic.friday='"+fri+"' WHERE graphic.user_name like"
                                + " '"+SignInPage.user.getE_mail()+"';";
			stmt = connection.prepareStatement(insertSQL,
					Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
//        public static boolean SearchPatient(String lastName) {
//		PreparedStatement stmt = null;
//
//		try {
//
//			String insertSQL = "SELECT e_mail from user_table where last_name like '"+lastName+"'";
//			stmt = connection.prepareStatement(insertSQL,
//					Statement.RETURN_GENERATED_KEYS);
//                        String email=stmt.execute(lastName)
//			stmt.executeUpdate();
//			return true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
//
//	}
        public static int savePatient(Patient patient) {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int id =0;
		String insertSQL = "INSERT INTO patienttable (patienttable.user_name, patienttable.first_name, patienttable.last_name, patienttable.birthday, "
                        + "patienttable.address, patienttable.`work`, patienttable.diagnoz,"
                        + " patienttable.temperature, patienttable.diagnoz_admission, patienttable.diagnoz_call, "
                        + "patienttable.diagnoz_dispansery, patienttable.diagnoz_hospital, patienttable.diagnoz_infections,"
                        + " patienttable.date_from, patienttable.date_to, patienttable.date_diagnoz, "
                        + "patienttable.date_SES, patienttable.vactination, patienttable.vactin_refused, patienttable.date_to_refused ) "
                        + "VALUES ('"+SignInPage.user.getE_mail()+"',"+patient.getFirst_name()+", "+patient.getLast_name()+", "+patient.getBirthday()+", "
                        + ""+patient.getAddress()+", "+patient.getWork()+","
                        + " "+patient.getDiagnoz()+", "+patient.getTemp()+", "+patient.getDiagnoz_admission()+", "+patient.getDiagnoz_call()+","
                        + " "+patient.getDiagnoz_dispansery()+", "+patient.getDiagnoz_hospital()+", "
                        + ""+patient.getDiagnoz_infections()+", "+patient.getDate_from()+", "+patient.getDate_to()+","
                        + " "+patient.getDate_diagnoz()+", "+patient.getDate_SES()+", "
                        + ""+patient.getVactination()+", "+patient.getVactin_refused()+","+patient.getDate_to_refused()+");";

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

    @Override
    public boolean delete(Users object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	


}
