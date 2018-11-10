package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

public class Sex{
    private String sex;

    public void setSex(String input){
        switch(input){
            case "male":
            case "m":
            case "Male":
            case "M":
                sex = "Male";
                break;
            case "f":
            case "F":
            case "female":
            case "Female":
                sex = "Female";
                break;
            default:
                sex = null;
                break;
        }
    }

    public String getSex(){
        return sex;
    }
}
