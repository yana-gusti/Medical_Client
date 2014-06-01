package services;

import java.util.ArrayList;

public class UserServices {
    private static DBConnection database = new DBConnection();

    private static ArrayList<Users> users = database.getAll();
    

    private static UserServices list = new UserServices();

    public static UserServices getList() {
        return list;
    }

    public static int addUser(Users newUser) {
        newUser.setId(DBConnection.save(newUser));
        users.add(newUser);
        return newUser.getId();
    }
      public static int addPatient(Patient newPatient) {
        newPatient.setId(DBConnection.savePatient(newPatient));
        return newPatient.getId();
    }
         public static int addGraphic(Graphic newGraphic) {
        newGraphic.setId(DBConnection.saveGraphic(newGraphic));
        return newGraphic.getId();
    }

    public static ArrayList<Users> getAll() {
        return users;
    }

    public static Users findUser(String e_mail, String password) {
        for (Users u : users) {
            if (e_mail.equals(u.getE_mail()) && (password.equals(u.getPass()))) {
                return u;
            }
        }
        return null;
    }
    public static String findGraphic(String e_mail) {
        for (Users u : users) {
            if (e_mail.equals(u.getE_mail()) ) {
                return e_mail;
            }
        }
        return null;
    }



}
