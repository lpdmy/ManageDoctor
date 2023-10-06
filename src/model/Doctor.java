package model;

public class Doctor {
    private String code;
    private String name;
    private String specialization;
    private int availabitlity;

    public Doctor() {
    }

    public Doctor(String code, String name, String specialization, int availabitlity) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availabitlity = availabitlity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailabitlity() {
        return availabitlity;
    }

    public void setAvailabitlity(int availabitlity) {
        this.availabitlity = availabitlity;
    }

    @Override
    public String toString() {
        return code + "\t|\t" + name + "\t|\t" + specialization + "\t|\t" + availabitlity;
    }
    


}
