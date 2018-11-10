package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

public class Citizen {
    private String citizen;

    public void setCitizen(String input){
        switch(input){
            case "yes":
            case "y":
            case "Yes":
            case "Y":
                citizen = "Yes";
                break;
            case "no":
            case "No":
            case "n":
            case "N":
                citizen = "No";
                break;
            default:
                citizen = null;
                break;
        }
    }

    public String getCitizen(){
        return citizen;
    }

}
