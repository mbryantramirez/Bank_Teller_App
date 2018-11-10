package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

public class Name {
    private String fName;
    private String mName;
    private String lName;
    private final String[] sArray = {"Jr", "Sr", "II", "III", "IV", "V", ""};
    private String suffix;


    public void setfName(String fName) {
        if (fName.equals("none")) {
            this.fName = "";
        } else {
            this.fName = fName;
        }
    }

    public void setmName(String mName) {
        if (mName.equals("none")) {
            this.mName = "";
        } else {
            this.mName = mName;
        }

    }

    public void setlName(String lName) {
        if (lName.equals("none")) {
            this.lName = "";
        } else {
            this.lName = lName;
        }
    }

    public String getfName() {
        return fName;
    }

    public String getmName() {
        return mName;
    }

    public String getlName() {
        return lName;
    }

    public void setSuffix(String suffix) {
        try {
            if (Integer.parseInt(suffix) >= 1 && Integer.parseInt(suffix) <= 6) {
                this.suffix = sArray[Integer.parseInt(suffix) - 1];
            } else {
                this.suffix = "";
            }
        }catch(NumberFormatException e){
            this.suffix = null;
        }
    }

    public String getSuffix() {
        return suffix;
    }
}
