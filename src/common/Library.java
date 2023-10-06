package common;

import java.time.temporal.Temporal;
import java.util.Scanner;

public class Library {

    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }

    public String getString(String mes) {
        System.out.print(mes + ": ");
        return sc.nextLine();
    }

    public String getCourseName(String mes) {
        String temp;
        while (true) {
            System.out.print(mes + ": ");
            try {
                String input = sc.nextLine();
                temp = input.trim().toLowerCase();
                if (temp.equalsIgnoreCase("Java") || temp.equalsIgnoreCase("C") || temp.equalsIgnoreCase("C++")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid courseName (Java/C/C++)");
            }
        }
        return temp;
    }

    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

    public float getFloat(String promt) {
        float a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Float.parseFloat(s);
                if (a > 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number greater than zero: ");
            }
        }
        return a;
    }
    
        public boolean getYN(String promt) {
        boolean a;
        while (true) {
            System.out.print(promt + ": ");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("Y")) return true;
            if (s.equalsIgnoreCase("N")) return false;
            System.out.println("Please enter Y or N ");
        }
    }

    public String getPhone(String promt) {
        String temp = null;
        while (true) {
            System.out.print(promt + ": ");
            temp = sc.nextLine().trim();
            if (temp == null || temp.length() != 10 || !temp.startsWith("0")) {
                temp = null;
            } else {
            for (int i = 2; i < temp.length(); i++) {
                if (((temp.charAt(i)) > '9') || ((temp.charAt(i)) < '0')) {
                    temp = null;
                }
            } }
            if (temp != null) {
                break;
            }          
            System.out.println("Please enter a apporiate phone number (0......): ");

        }
        return temp;
    }
    

}
