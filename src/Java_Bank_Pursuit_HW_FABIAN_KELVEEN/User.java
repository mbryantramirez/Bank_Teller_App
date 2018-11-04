package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.io.Console;
import java.util.Scanner;

public class User implements BankTeller {
    Scanner scanner = new Scanner(System.in);
    String userName, passWord, choice, month, day, year;


    @Override
    public void logo() {
        System.out.println("Logo");
    }

    @Override
    public void signIn() {
        while (userName != "Kelveen" && passWord != "Fabian") {
            System.out.println(ConsoleColors.BLUE
                    + "|----Welcome To The Bank Teller Program----|");
            System.out.println("|           " + ConsoleColors.YELLOW + "Please Sign In:"
                    + ConsoleColors.BLUE + "                |");
            System.out.println("|Username:                                 |");
            userName = scanner.nextLine();
            System.out.println("|PassWord:                                 |");
            passWord = scanner.nextLine();
            System.out.println("|                                          |");


            if (userName.equals("Kelveen") && passWord.equals("Fabian")) {
                menu();
                break;
            } else {
                System.out.println(ConsoleColors.RED
                        + "|Sorry wrong username or password.         | \n" +
                        "|Please try again.                         |"
                        + ConsoleColors.BLUE);
            }
            System.out.println("|------------------------------------------|");
        }
        ConsoleColors.resetColor();


    }

    @Override
    public void menu() {
        System.out.println("|------------------------------------------|");
        System.out.println("|----Welcome To The Bank Teller Program----|");
        System.out.println("| Hello " + ConsoleColors.YELLOW + userName
                + ConsoleColors.BLUE + "!                           |");
        System.out.println("|                                          |");
        System.out.println("| Please " + ConsoleColors.YELLOW
                + "SELECT" + ConsoleColors.BLUE
                + " of the options below       |");
        System.out.println("|                                          |");
        System.out.println(ConsoleColors.YELLOW
                + "|------------------MENU--------------------|");
        System.out.println("|1.Create new customer                     |");
        System.out.println("|2.Read customer information               |");
        System.out.println("|3.Update customer information             |");
        System.out.println("|4.Delete account                          |");
        System.out.println("|------------------------------------------|"
                + ConsoleColors.BLUE);
        choice = scanner.next();

        switch (choice) {
            case "1":
                create();
                break;
            case "2":
                read();
                break;
            case "3":
                update();
                break;
            case "4":
                delete();
                break;
            default:
                System.out.println("Wrong answer. Please try again.");
                menu();
        }


    }


    public void create() {
        System.out.println("What is your first name? ");
        choice = scanner.next();
        Customer.setFname(choice);
        System.out.println("What is your middle name? [input 'none' if there's no middle name]");
        choice = scanner.next();
        Customer.setmName(choice);
        System.out.println("What is your last name?");
        choice = scanner.next();
        Customer.setlName(choice);
        System.out.println("Suffix? [1.Jr, 2.Sr, 3.II, 4.III, 5.IV, 6.V, 7.None]");
        choice = scanner.next();
        Customer.setSuffix(Integer.parseInt(choice));
        System.out.println("Date of birth? [MM/DD/YYYY]");
        choice = scanner.next();
        Customer.setDOB(choice.substring(0,2), choice.substring(3,5), choice.substring(6));
        showCreate();

    }

    public void showCreate() {
        System.out.println("|-------------------------------|");
        System.out.println("|Name:                           ");
        System.out.println("|" + Customer.getFname() + " " + Customer.getmName() + " " + Customer.getlName() + " " + Customer.getSuffix());
        System.out.println("|Date of Birth: " + Customer.getDOB());
        System.out.println("|-------------------------------|");


    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }

}
