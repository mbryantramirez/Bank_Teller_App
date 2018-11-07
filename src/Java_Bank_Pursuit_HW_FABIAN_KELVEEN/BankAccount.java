package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.Scanner;

public class BankAccount {
    private int checking;
    private int credit;
    private Scanner scanner = new Scanner(System.in);

    public int getChecking() {
        return checking;
    }

    public void setChecking(int checking) {
        this.checking = checking;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void withDrawal() {
        int amount;

        System.out.println("What is the amount that you would like to withdraw?");
        amount = scanner.nextInt();
        if (credit != 0 && checking != 0 && amount <= credit && amount <= checking) {
            System.out.println("Which account would you like to withdraw from: 1. Checking or 2. Credit?");
            switch (scanner.next()) {
                case "1":
                case "checking":
                case "Checking":
                    checking = checking - amount;
                    break;
                case "2":
                case "credit":
                case "Credit":
                    if (amount <= 300) {
                        credit = credit - amount;
                        break;
                    } else {
                        System.out.println("Max limit of withdrawal for credit cards are $300. Please try again.");
                        withDrawal();
                        break;
                    }
                default:
                    System.out.println("Wrong answer. Please try again.");
                    break;

            }
        } else {
            System.out.println("Not enough funds. Please try again.");
            withDrawal();
        }

    }

    public void deposit() {
        int amount;

        System.out.println("What is the amount that you would like deposit?");
        amount = scanner.nextInt();
        System.out.println("Which account would you like to add to: 1. Checking or 2. Credit?");
        switch (scanner.next()) {
            case "1":
            case "checking":
            case "Checking":
                checking = checking + amount;
                break;
            case "2":
            case "credit":
            case "Credit":
                if (amount < credit && credit != 3000) {
                    credit = credit + amount;
                } else {
                    System.out.println("Credit card paid off.");
                    break;
                }
            default:
                System.out.println("Wrong answer. Please try again.");
                deposit();
                break;

        }
    }
}
