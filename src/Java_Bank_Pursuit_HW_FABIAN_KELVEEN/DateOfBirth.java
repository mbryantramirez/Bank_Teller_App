package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

public class DateOfBirth{
    private static String month;
    private static String day;
    private static String year;


    DateOfBirth(String month, String day, String year){
        DateOfBirth.month = month;
        DateOfBirth.day = day;
        DateOfBirth.year = year;

    }

    public static String getMonth() {
       return month;
    }

    public static void setMonth(String month) {
        DateOfBirth.month = month;
    }

    public static String getDay() {
        return day;
    }

    public static void setDay(String day) {
        DateOfBirth.day = day;
    }

    public static String getYear() {
        return year;
    }

    public static void setYear(String year) {
        DateOfBirth.year = year;
    }

}
