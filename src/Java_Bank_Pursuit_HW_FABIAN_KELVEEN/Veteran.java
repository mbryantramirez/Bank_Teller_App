package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

public class Veteran {
    private String veteran;

    public void setVeteran(String input){
        switch(input){
            case "1":
                veteran = "I am a US veteran.";
                break;
            case "2":
                veteran = "I am not a US veteran.";
                break;
            case "3":
                veteran = "I do not wish to answer.";
                break;
            default:
                veteran = null;
                break;
        }
    }
    public String getVeteran(){
        return veteran;
    }
}
