package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.*;

public class Teller implements BankTeller {
    private Scanner scanner = new Scanner(System.in);
    private String userName, passWord, choice;
    private ArrayList<Customer> list = new ArrayList<>();
    private Customer customer = new Customer();
    private int position = 0;
    private HashMap<String, Integer> hashMap = new HashMap<>();
    private HashSet<String> hashSet = new HashSet<>();



    public void findAccount(){
        System.out.println("Which account are you looking for?");
        choice = scanner.next();

        if(hashSet.contains(choice)){
            System.out.println("The account " + choice + " exists.");
            System.out.println("What would you like to do?");
            System.out.println("1. Read information");
            System.out.println("2. Update information");
            System.out.println("3. Delete account");

            switch(scanner.next().toLowerCase()){
                case "1":
                case "read":
                case "2":
                case "update":
                case "3":
                case "delete":

            }
        }
        else{
            System.out.println("Sorry the account you are looking for does not exist. Please try again.");
        }
    }
    public void initialCustomers() {
        Customer abrams = new Customer("John", "", "Abrams",
                "7", "10", "19", "1989",
                "555-55-5555", "m", "yes",
                "1", "500", "50000");
        Customer sally = new Customer ("Sally", "", "Myers", "4", "05", "25",
                "1990", "111-11-1111", "f", "no", "2", "50000", "60000");
        Customer harold = new Customer("Harold", "Martavious", "DeGrasse",
                "5", "06", "06", "1995", "000-00-0000", "m", "yes", "3", "400", "25000");
        Customer daisy = new Customer("Daisy", "Rose", "Pedals", "7", "04", "16", "2001", "888-88-8888",
                "f", "y", "2", "200", "8000");
        Customer street = new Customer("Street", "", "Fighter", "4", "01", "10", "1989", "222-22-2222","f",
                "no", "3", "500000", "5000");
        list.add(abrams);
        list.add(sally);
        list.add(harold);
        list.add(daisy);
        list.add(street);
    }
    @Override
    public void logo() {
        System.out.println("Logo");
    }

    @Override
    public void signIn() {
        userName = null;
        passWord = null;
        do {
            System.out.println(ConsoleColors.BLUE
                    + "|----Welcome To The Bank Teller Program----|");
            System.out.println("|           " + ConsoleColors.YELLOW + "Please Sign In:"
                    + ConsoleColors.BLUE + "                |");
            System.out.println("|Username:                                 |");
            userName = scanner.next();
            System.out.println("|PassWord:                                 |");
            passWord = scanner.next();
            System.out.println("|                                          |");


            if (userName.equals("Kelveen") && passWord.equals("Fabian")) {
                initialCustomers();
                menu();
                break;
            } else {
                System.out.println(ConsoleColors.RED
                        + "|Sorry wrong username or password.         | \n" +
                        "|Please try again.                         |"
                        + ConsoleColors.BLUE);
            }
            System.out.println("|------------------------------------------|");
        } while (!userName.equals("Kelveen") && !passWord.equals("Fabian"));
    }

    @Override
    public void menu() {
        boolean isMenu = true;

        do {
            System.out.println("|------------------------------------------|");
            System.out.println("|----Welcome To The Bank Teller Program----|");
            System.out.println("| Hello " + ConsoleColors.YELLOW + userName
                    + ConsoleColors.BLUE + "!                           |");
            System.out.println("|                                          |");
            System.out.println("| Please " + ConsoleColors.YELLOW
                    + "SELECT" + ConsoleColors.BLUE
                    + " one of the options below   |");
            System.out.println("|                                          |");
            System.out.println(ConsoleColors.YELLOW
                    + "|------------------MENU--------------------|");
            System.out.println("|1.Create new customer                     |");
            System.out.println("|2.Read customer information               |");
            System.out.println("|3.Update customer information             |");
            System.out.println("|4.Delete account                          |");
            System.out.println("|5.List Accounts                           |");
            System.out.println("|6.Sign out                                |");
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
                case "5":
                    list();
                    break;
                case "6":
                    isMenu = false;
                    list.clear();
                    signIn();
                    break;
                default:
                    System.out.println("Wrong answer. Please try again.");
                    break;
            }
        } while (isMenu);
    }


    private void create() {
        customer.createNewCustomer();

        System.out.println("---------------");
        System.out.println("Name: " + customer.getName());
        System.out.println("DOB: " + customer.getDob());
        System.out.println("Social Security: " + customer.getSS());
        System.out.println("Sex: " + customer.getSex());
        System.out.println("Citizen: " + customer.getCitizen());
        System.out.println("Veteran: " + customer.getVeteran());
        System.out.println("New Credit Balance: " + customer.getCreditBalance());
        System.out.println("New Checking Balance: " + customer.getCheckingBalance());
        System.out.println("Bank ID: " + customer.getID());
        System.out.println("---------------");
        System.out.println("Correct?");

        switch (scanner.next()) {
            case "Y":
            case "y":
                list.add(customer);
                hashMap.put(customer.getName(), customer.getID());
                customer = new Customer();
                break;
            case "n":
            case "N":
                create();
                break;
            default:
                System.out.println("Wrong answer. Try again");
                create();
                break;
        }
    }


    private void read() {

        if (list.isEmpty()) {
            System.out.println("There are no accounts. Please create new accounts in the menu. Thank you.");
        } else {
            System.out.println("Who's information would you like to read? Press 0 to go back to menu");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + 1 + ". " + list.get(i).getName());
                System.out.println("BankAccount#: " + list.get(i).getID());
                System.out.println();
            }
            position = scanner.nextInt();
            if (position <= 0 || position > list.size()) {
                System.out.println("Going back to main menu.");
            } else {
                int arrayIndex = position - 1;
                customer = list.get(arrayIndex);

                System.out.println("Name: " + customer.getName());
                System.out.println("DOB: " + customer.getDob());
                System.out.println("Social Security: " + customer.getSS());
                System.out.println("Sex: " + customer.getSex());
                System.out.println("Citizen: " + customer.getCitizen());
                System.out.println("Veteran: " + customer.getVeteran());
                System.out.println("Credit Balance: " + customer.getCreditBalance());
                System.out.println("Checking Balance: " + customer.getCheckingBalance());

                System.out.println("\nGo Back To Menu?[Y/n]");
                switch (scanner.next()) {
                    case "y":
                    case "Y":
                    case "Yes":
                    case "yes":
                        customer = new Customer();
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

    private void update() {
        do {
            if (list.isEmpty()) {
                System.out.println("There are no accounts. Please create new accounts in the menu. Thank you.");
                break;
            } else {
                System.out.println("Who's information would you like update? Press 0 to go back to menu");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + ". " + list.get(i).getName());
                }
                position = scanner.nextInt();

                if (position == 0) {
                    break;
                } else {
                    int arrayIndex = position - 1;
                    Customer customer = list.get(arrayIndex);//Local reference

                    System.out.println("What would you like to change?");
                    System.out.println("1. Name");
                    System.out.println("2. Date of Birth");
                    System.out.println("3. Social Security");
                    System.out.println("4. Sex");
                    System.out.println("5. Citizen");
                    System.out.println("6. Veteran");
                    System.out.println("7. Account");
                    System.out.println("8. Exit");

                    switch (scanner.next()) {
                        case "1":
                            customer.editName();
                            break;
                        case "2":
                            customer.editDob();
                            break;
                        case "3":
                            customer.editSS();
                            break;
                        case "4":
                            customer.editSex();
                            break;
                        case "5":
                            customer.editCitizen();
                            break;
                        case "6":
                            customer.editVeteran();
                            break;
                        case "7":
                            customer.editAccount();
                            break;
                        case "8":
                            break;
                        default:
                            System.out.println("Wrong answer. BACK TO MAIN MENU");
                            break;
                    }

                }
            }
        } while (position != 0 && !(list.isEmpty()));
    }

    private void list() {
        String uName;
        String pWord;
        boolean isList = true;

        do {
            if (hashMap.isEmpty()) {
                System.out.println("There are no accounts. Please create new accounts in the menu. Thank you.");
                break;
            } else {
                int attempts = 3;

                while (attempts > 0) {
                    System.out.println("Attempts left: " + attempts);
                    System.out.println("USERNAME VERIFICATION: ");
                    uName = scanner.next();
                    System.out.println("PASSWORD VERIFICATION: ");
                    pWord = scanner.next();

                    if (uName.equals(userName) && pWord.equals(passWord)) {
                        System.out.println("Here's a list of all the users on file along with their bank account numbers\n");

                        for (String a : hashMap.keySet()) {
                            System.out.println("Name: " + a);
                            System.out.println("Bank Account #: " + hashMap.get(a));
                            System.out.println();
                        }
                        break;
                    } else {
                        attempts--;
                        System.out.println("Wrong entry please try again. Attempts left: " + attempts);
                    }
                }
                System.out.println("\nGo Back To Menu?[Y/n]");
                switch (scanner.next().toLowerCase()) {
                    case "y":
                    case "yes":
                        isList = false;
                        break;
                    case "n":
                    case "no":
                        list();
                        break;
                }
            }
        } while (isList);

    }

    private void delete() {

        do {
            if (list.isEmpty()) {
                System.out.println("There are no accounts. Please create new accounts in the menu. Thank you.");
                break;
            } else {
                System.out.println("Who's information would you like to delete? Press 0 to go back to menu");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + ". " + list.get(i).getName());
                }
                position = scanner.nextInt();
                if (position == 0) {
                    break;
                } else {
                    int arrayIndex = position - 1;
                    list.remove(arrayIndex);
                    System.out.println("Customer accounts left: ");
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(i + 1 + ". " + list.get(i).getName());
                    }
                    System.out.println("\nGo Back To Menu?[Y/n]");
                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            break;
                        case "n":
                        case "N":
                        case "No":
                        case "no":
                            delete();
                            break;
                    }
                }
            }
        } while (position != 0 && !(list.isEmpty()));
    }
}
