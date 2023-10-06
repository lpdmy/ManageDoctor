package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import model.Doctor;

public interface IDoctorRepository {
    void addDoctor(HashMap<String,Doctor> doctors) throws Exception;
    void updateDoctor(HashMap<String,Doctor> doctors, Doctor doctor) throws Exception;
    void deleteDoctor(HashMap<String,Doctor> doctors,String code) throws Exception;
    public HashMap<String,Doctor> search(HashMap<String,Doctor> doctors, Predicate<Doctor> c) throws Exception;
    void printAllDoctors (HashMap<String, Doctor> doctors);
}
