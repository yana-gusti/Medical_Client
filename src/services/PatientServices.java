package services;

import java.util.ArrayList;

public class PatientServices {
    private static DBConnection database = new DBConnection();
 private static final ArrayList<Patient> patient = database.getAllPatient();
    
    

    private static PatientServices list = new PatientServices();

    public static PatientServices getList() {
        return list;
    }
    public static Patient findPatient(String lastName) {
         for (Patient pat : DBConnection.getAllPatient()) {
             if (lastName.equals(pat.getLast_name()) ) {
                 return pat;
             }
         }
         return null;
  }

   


}
