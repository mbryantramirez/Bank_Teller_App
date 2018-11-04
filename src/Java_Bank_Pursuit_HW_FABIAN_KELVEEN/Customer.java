package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.Date;
import java.util.HashMap;

public class Customer extends User {
    private static String fname;
    private static String mName;
    private static String lName;
    private static final String[] sArray = {"Jr", "Sr", "II", "III", "IV", "V", ""};
    private static String suffix;


    public static String getFname() {
        return fname;
    }

    public static void setFname(String fname) {
        Customer.fname = fname;
    }

    public static String getmName() {
        return mName;
    }

    public static void setmName(String mName) {

        if (mName.toLowerCase().equals("none")) {
            Customer.mName = "";
        } else {
            Customer.mName = mName;
        }

    }

    public static String getlName() {
        return lName;
    }

    public static void setlName(String lName) {
        Customer.lName = lName;
    }

    public static String getSuffix() {
        return suffix;
    }

    public static void setSuffix(int choice) {
        for (int i = 0; i < 7; i++) {
            if (choice == i + 1) {
                suffix = sArray[i];
            }
        }
    }

    public static void setDOB(String month, String day, String year) { //FIXME: We need to set boundaries for our function.
        DateOfBirth.setMonth(month);
        DateOfBirth.setDay(day);
        DateOfBirth.setYear(year);
    }

    public static String getDOB() {
        return DateOfBirth.getMonth() + "/" + DateOfBirth.getDay() + "/" + DateOfBirth.getYear();
    }

}

