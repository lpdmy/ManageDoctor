package controller;

import view.Menu;
import common.Library;
import java.util.HashMap;
import model.Doctor;
import repository.DoctorRepository;
import view.Validation;

public class ManageDoctor extends Menu<String> {

    HashMap<String, Doctor> doctors = new HashMap<>();
    Library lib = new Library();
    DoctorRepository doctorRes = new DoctorRepository();
    Validation val = new Validation();
    static String[] menu = {"Add doctor",
        "Update Doctor",
        "Delete Doctor",
        "Search Doctor",
        "Exit"
    };

    public ManageDoctor() {
        super("MENU", menu);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                try {
                    doctorRes.addDoctor(doctors);
                } catch (Exception ex) {
                    System.out.println("An exception occurred: " + ex.getMessage());
                }
            }
            break;

            case 2:
                updating();
                break;
            case 3:
                String code = lib.getString("Enter code of doctor you need to delete");
                 {
                    try {
                        doctorRes.deleteDoctor(doctors, code);
                    } catch (Exception ex) {
                        System.out.println("An exception occurred: " + ex.getMessage());
                    }
                }
                break;

            case 4:
                searching();
                break;
            case 5:
                System.exit(0);
            default:
                return;
        }
    }

//Searching Menu
    private void searching() {
        String[] mSearch = {"Find by Doctor Code", "Find by Name", "Find by specilization","Back to main menu"};
        Menu m = new Menu("Doctor Searching", mSearch) {
            @Override
            public void execute(int n) {
                HashMap<String, Doctor> rs = null;
                switch (n) {
                    case 1:
                        String code = lib.getString("Enter Doctor Code");
                         {
                            try {
                                rs = doctorRes.search(doctors, c -> c.getCode().equals(code));
                            } catch (Exception ex) {
                                System.out.println("An exception occurred: " + ex.getMessage());
                            }
                        }
                        break;

                    case 2:
                        String name = lib.getString("Enter Doctor Name");
                         {
                            try {
                                rs = doctorRes.search(doctors, c -> c.getName().equalsIgnoreCase(name));
                            } catch (Exception ex) {
                                System.out.println("An exception occurred: " + ex.getMessage());
                            }
                        }
                        break;

                    case 3:
                        String specialization = lib.getString("Enter specialization: ");
                         {
                            try {
                                rs = doctorRes.search(doctors, c -> c.getSpecialization().equalsIgnoreCase(specialization));
                            } catch (Exception ex) {
                                System.out.println("An exception occurred: " + ex.getMessage());
                            }
                        }
                        break;
                    case 4:
                        return;

                }
                if (rs.isEmpty()) {
                    System.out.println("Not found data");
                } else {
                    doctorRes.printAllDoctors(rs);
                }
            }

        };
        m.run();
    }
//Update Menu
    //UPDATE 

    private void updating() {
        doctorRes.printAllDoctors(doctors);
        String code = lib.getString("Enter Doctor Code");
            String name = lib.getString("Enter new name");
            if (name == "") {
                name = doctors.get(code).getName();
            }
            String special = lib.getString("Enter Specialization");
            if (special == "") {
                special = doctors.get(code).getSpecialization();
            }
            String available = lib.getString("Enter availability");
            int avail;
            if (available == "") {
                avail = doctors.get(code).getAvailabitlity();
            } else {
            try {
                avail = val.checkInt(available);
            } catch (Exception ex) {
                System.out.println("A exception occur:" + ex.getMessage());
                avail = doctors.get(code).getAvailabitlity();
            }}
            try {
               
                doctorRes.updateDoctor(doctors, new Doctor(code, name, special, avail));
            } catch (Exception ex) {
                System.out.println("An exception occurred: " + ex.getMessage());
            } 
        
    
}}
