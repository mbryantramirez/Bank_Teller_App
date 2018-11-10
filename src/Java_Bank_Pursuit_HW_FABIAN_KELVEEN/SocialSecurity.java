package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

public class SocialSecurity{
    private String socialSecurity1;
    private String socialSecurity2;
    private String socialSecurity3;

    public String getSocialSecurity1() {
        return socialSecurity1;
    }

    public void setSocialSecurity1(String socialSecurity1) {

        try {
            if (Integer.parseInt(socialSecurity1.substring(0, 1)) >= 0 && Integer.parseInt(socialSecurity1.substring(0, 1)) <= 9
                    && Integer.parseInt(socialSecurity1.substring(1, 2)) >= 0 && Integer.parseInt(socialSecurity1.substring(1, 2)) <= 9
                     && Integer.parseInt(socialSecurity1.substring(2,3)) >= 0 && Integer.parseInt(socialSecurity1.substring(2,3)) <= 9) {
                this.socialSecurity1 = socialSecurity1;
            } else {
                this.socialSecurity1 = "";
            }
        }
        catch(NumberFormatException e){
            this.socialSecurity1 = null;
        }

    }

    public String getSocialSecurity2() {
        return socialSecurity2;
    }

    public void setSocialSecurity2(String socialSecurity2) {
        try {
            if (Integer.parseInt(socialSecurity2.substring(0, 1)) >= 0 && Integer.parseInt(socialSecurity2.substring(0, 1)) <= 9
                    && Integer.parseInt(socialSecurity2.substring(1, 2)) >= 0 && Integer.parseInt(socialSecurity2.substring(1, 2)) <= 9) {
                this.socialSecurity2 = socialSecurity2;
            } else {
                this.socialSecurity2 = "";
            }
        }
        catch(NumberFormatException e){
            this.socialSecurity2 = null;
        }
    }

    public String getSocialSecurity3() {
        return socialSecurity3;
    }

    public void setSocialSecurity3(String socialSecurity3) {
        try {
            if (Integer.parseInt(socialSecurity3.substring(0, 1)) >= 0 && Integer.parseInt(socialSecurity3.substring(0, 1)) <= 9
                    && Integer.parseInt(socialSecurity3.substring(1, 2)) >= 0 && Integer.parseInt(socialSecurity3.substring(1, 2)) <= 9
                    && Integer.parseInt(socialSecurity3.substring(2,3)) >= 0 && Integer.parseInt(socialSecurity3.substring(2,3)) <= 9
                    && Integer.parseInt(socialSecurity3.substring(3,4)) >= 0 && Integer.parseInt(socialSecurity3.substring(3,4)) <= 9) {
                this.socialSecurity3 = socialSecurity3;
            } else {
                this.socialSecurity3 = "";
            }
        }
        catch(NumberFormatException e){
            this.socialSecurity3 = null;
        }
    }
}
