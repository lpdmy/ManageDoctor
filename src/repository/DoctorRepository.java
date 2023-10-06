package repository;

import dataAcess.DoctorDao;
import java.util.HashMap;
import java.util.function.Predicate;
import model.Doctor;

public class DoctorRepository implements IDoctorRepository {

    @Override
    public void addDoctor(HashMap<String, Doctor> doctors) throws Exception {
        DoctorDao.Instance().createDoctor(doctors);
    }

    @Override
    public void updateDoctor(HashMap<String, Doctor> doctors, Doctor doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("Data doesn't exit");
        }
        if (!doctors.containsKey(doctor.getCode())) {
            throw new Exception("Data code doesn't exit");
        }
        doctors.put(doctor.getCode(), doctor);
        System.err.println("Update successful..");

    }

    @Override
    public void deleteDoctor(HashMap<String, Doctor> doctors, String code) throws Exception {
         if (!doctors.containsKey(code)) {
            throw new Exception("Data code doesn't exit");
        }
          doctors.remove(code); 
          System.err.println("Delete Successfully..");
    }
  
    @Override
    public HashMap<String, Doctor> search(HashMap<String, Doctor> doctors, Predicate<Doctor> c) throws Exception {
        if (doctors == null) {
            throw new Exception("Database doesn't exit");
        }
        return DoctorDao.Instance().search(doctors, c);
    }

    @Override
    public void printAllDoctors(HashMap<String, Doctor> doctors) {
        DoctorDao.Instance().printListNameDoctor(doctors);
    }

}
