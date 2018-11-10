package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

public class DateOfBirth {
    private String month;
    private String day;
    private String year;


    DateOfBirth() {
    }

    DateOfBirth(String month, String day, String year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {

        try {
            if (Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12) {
                this.month = month;
            } else {
                this.month = "";
            }
        }catch(NumberFormatException e){
            this.month = null;
        }

    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        try {
            if (Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31) {
                this.day = day;
            } else {
                this.day = "";
            }
        }catch(NumberFormatException e){
            this.day = null;
        }

    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        try {
            if (Integer.parseInt(year) >= 1900 && Integer.parseInt(year) <= 2018) {
                this.year = year;
            } else {
                this.year = "";
            }
        }catch(NumberFormatException e){
            this.year = null;
        }
    }

}
