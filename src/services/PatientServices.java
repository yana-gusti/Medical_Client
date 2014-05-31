package services;

import java.util.ArrayList;

public class PatientServices {
    private static DBConnection database = new DBConnection();

    

    private static PatientServices list = new PatientServices();

    public static PatientServices getList() {
        return list;
    }

   


}
