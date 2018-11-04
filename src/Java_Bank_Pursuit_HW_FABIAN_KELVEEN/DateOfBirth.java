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

        if(Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12){
            DateOfBirth.month = month;
        }else{
            DateOfBirth.month = "";
        }

    }

    public static String getDay() {
        return day;
    }

    public static void setDay(String day) {

        if(Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31){
            DateOfBirth.day = day;
        }else{
            DateOfBirth.day = "";
        }

    }

    public static String getYear() {
        return year;
    }

    public static void setYear(String year) {
        if(Integer.parseInt(year) >= 1900 && Integer.parseInt(year) <= 2018) {
            DateOfBirth.year = year;
        }else{
            DateOfBirth.year = "";
        }
    }

}
