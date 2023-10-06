package dataAcess;

import common.Library;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.function.Predicate;
import model.Doctor;

public class DoctorDao {

    Library lib = new Library();
    private static DoctorDao instance = null;

    public static DoctorDao Instance() {
        if (instance == null) {
            synchronized (DoctorDao.class) {
                if (instance == null) {
                    instance = new DoctorDao();
                }
            }
        }
        return instance;
    }

    public void createDoctor(HashMap<String, Doctor> doctors) throws Exception {
        while (true) {
            String code = lib.getString("Enter Doctor Code");
            String name = lib.getString("Enter Doctor Name");
            String specialization = lib.getString("Enter doctor specialization");
            int availability = lib.getInt("Enter avaibility", 0, 10000);
            if (doctors.containsKey(code)) {
                throw new Exception("Doctor code is duplicated");
            }
            doctors.put(code, new Doctor(code, name, specialization, availability));
            System.err.println("Create Success");
            if (!lib.getYN("Do you want to continue (Y/N)")) {
                return;
            }
        }
    }

    public HashMap search(HashMap<String,Doctor> doctors, Predicate c) {
        HashMap rs = new HashMap<>();
        Set keySet = doctors.keySet();
        for (Object o : keySet) {
            Doctor d = doctors.get(o);
            if (c.test(d)) {
                rs.put(d.getCode(), d);
            }
        }
        return rs;
    }


    public void printListNameDoctor(HashMap<String, Doctor> doctors) {
        System.out.println("Code\tName\tSpecialization\tAvailability");
        Set keySet = doctors.keySet();
        for (Object o : keySet) {
            System.out.println(doctors.get(o));
        }
    }
}
