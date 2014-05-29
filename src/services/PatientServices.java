package services;

import java.util.ArrayList;

public class PatientServices {
    private static DBConnection database = new DBConnection();

    private static ArrayList<Patient> patients = database.getAllPatient();
    

    private static PatientServices list = new PatientServices();

    public static PatientServices getList() {
        return list;
    }

    public static int addPatient(Patient newPatient) {
        newPatient.setId(DBConnection.savePatient(newPatient));
        patients.add(newPatient);
        return newPatient.getId();
    }

    public static ArrayList<Patient> getAll() {
        return patients;
    }

    public static Patient findPatient(String first_name, String diagnoz) {
        for (Patient p : patients) {
            if (first_name.equals(p.getFirst_name()) && (diagnoz.equals(p.getDiagnoz()))) {
                return p;
            }
        }
        return null;
    }



}
