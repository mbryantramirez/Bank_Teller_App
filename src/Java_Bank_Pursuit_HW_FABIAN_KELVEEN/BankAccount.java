package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankAccount {
    private double checking;
    private double credit;
    private double maxCredit;
    private Scanner scanner = new Scanner(System.in);

    public double getMaxCredit() {
        return maxCredit;
    }

    public double getChecking() {
        return checking;
    }

    public void setChecking(double checking) {
        this.checking = checking;
    }


    public double getCredit() {
        return credit;
    }

    public void setCredit(String salary) {
            if (Double.parseDouble(salary) <= 18000 && Double.parseDouble(salary) >= 0) {
                maxCredit = 1000.0;
            } else if (Double.parseDouble(salary) <= 25000) {
                maxCredit = 1500.0;
            } else if (Double.parseDouble(salary) <= 40000) {
                maxCredit = 3000.0;
            } else if (Double.parseDouble(salary) <= 50000) {
                maxCredit = 4000.0;
            } else if (Double.parseDouble(salary) >= 55000) {
                maxCredit = 5000.0;
            } else {
                System.out.println("Sorry you do not qualify");
                maxCredit = 0;
            }
            credit = maxCredit;
    }


    public void creditWithdrawal(String amount){
        if(Double.parseDouble(amount) > 300){
            System.out.println("Withdrawal amount is greater than max amount: $300.00. Please try again.");
        }else{
            credit = credit - Double.parseDouble(amount);
        }
    }
    public void checkingWithdrawal(String amount){
        if((checking >= 0 && Double.parseDouble(amount) <= checking)){
            checking = checking - Double.parseDouble(amount);
        }else{
            System.out.println("Withdrawal amount too high or there is no balance in your account.");
        }
    }

    public void depositCredit(String amount) {
        if(Integer.parseInt(amount) >= 0){
            if ((Double.parseDouble(amount) + credit) <= maxCredit && (Double.parseDouble(amount) + credit) >= 1) {
                credit = credit + Integer.parseInt(amount);
            } else if((Double.parseDouble(amount) + credit) > maxCredit) {
                System.out.println("Credit card paid off.");
            }else{
                System.out.println("Wrong entry. Please try again.");
            }
        }else {
            System.out.println("Wrong entry. Please try again");
        }
    }
    public void depositChecking(String amount){
        if(Double.parseDouble(amount) >= 0){
            if((Double.parseDouble(amount) + checking) > 0){
                checking = Double.parseDouble(amount) + checking;
            }
            else{
                System.out.println("No funds added");
            }
        }
    }
}
