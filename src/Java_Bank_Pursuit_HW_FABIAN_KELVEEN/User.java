package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User implements BankTeller {
    private Scanner scanner = new Scanner(System.in);
    private String userName, passWord, choice;
    private int choice1;
    public static ArrayList<Customer> list = new ArrayList<>();
    public static Customer customer = new Customer();
    public static int position = 0;


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
        customer.createNewCustomer();

        System.out.println("---------------");
        System.out.println("Name: " + customer.getName());
        System.out.println("DOB: " + customer.getDob());
        System.out.println("Social Security: " + customer.getSS());
        System.out.println("---------------");
        System.out.println("Correct?");

        switch (scanner.next()) {
            case "Y":
            case "y":
                list.add(customer);
                customer = new Customer();
                menu();
                break;
            case "n":
            case "N":
                create();
                break;
            default:
                System.out.println("Wrong answer. Try again");
                create();
        }
    }


    public void read() {
        if (list.isEmpty()) {
            System.out.println("There are no accounts. Please create some accounts in the menu.");
            menu();
        } else {
            System.out.println("Who's information would you like to read? Press 0 to go back to menu");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i).getName());
            }
            position = scanner.nextInt();
            if (position == 0) {
                menu();
            } else {
                if (!(list.isEmpty()) && position <= list.size()) {
                    System.out.println("Name: " + list.get(position - 1).getName());
                    System.out.println("DOB: " + list.get(position - 1).getDob());
                    System.out.println("Social Security: " + list.get(position - 1).getSS());
                } else {
                    System.out.println("List is either empty or there was a wrong entry. Please try again.");
                    menu();
                }

                System.out.println("Go Back To Menu?[Y/n]");
                switch (scanner.next()) {
                    case "y":
                    case "Y":
                    case "Yes":
                    case "yes":
                        menu();
                        break;
                    case "n":
                    case "N":
                    case "No":
                    case "no":
                        read();
                        break;
                }
            }
        }

    }

    public void update() {
        if (list.isEmpty()) {
            System.out.println("There are no accounts. Please create some accounts in the menu.");
            menu();
        } else {
            System.out.println("Who's information would you like update? Press 0 to go back to menu");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i).getName());
            }
            position = scanner.nextInt();

            if (position == 0) {
                menu();
            } else {

                System.out.println("What would you like to change?");
                System.out.println("1. Name");
                System.out.println("2. Date of Birth");
                System.out.println("3. Social Security");
                System.out.println("4. Exit");

                switch (scanner.next()) {
                    case "1":
                        list.get(position - 1).editName();
                        break;
                    case "2":
                        list.get(position - 1).editDob();
                        break;
                    case "3":
                        list.get(position - 1).editSS();
                        break;
                    case "4":
                        menu();
                        break;
                    default:
                        System.out.println("Wrong answer. BACK TO MAIN MENU");
                        menu();
                        break;
                }

            }
        }
    }

    public void delete() {
        if (list.isEmpty()) {
            System.out.println("There are no accounts. Please create some accounts in the menu.");
            menu();
        } else {
            System.out.println("Who's information would you like to delete? Press 0 to go back to menu");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i).getName());
            }
            position = scanner.nextInt();
            if (position == 0) {
                menu();
            } else {
                list.remove(position - 1);
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + ". " + list.get(i).getName());
                }
                menu();
            }
        }
    }

}
