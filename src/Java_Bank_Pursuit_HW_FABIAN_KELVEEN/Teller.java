package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.*;

public class Teller implements BankTeller {
    private Scanner scanner = new Scanner(System.in);
    private String userName, passWord, choice;
    public static ArrayList<Customer> list = new ArrayList<>();
    public static Customer customer = new Customer();
    public static int position = 0;
    private Random random = new Random();
    public static HashMap<String, Integer> hashMap = new HashMap<>();


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
                menu();
                break;
            } else {
                System.out.println(ConsoleColors.RED
                        + "|Sorry wrong username or password.         | \n" +
                        "|Please try again.                         |"
                        + ConsoleColors.BLUE);
            }
            System.out.println("|------------------------------------------|");
        } while (userName != "Kelveen" && passWord != "Fabian");
    }

    @Override
    public void menu() {
        boolean isMenu = true;
        if (userName == null) {
            System.out.println("Username is null");
        }

        /**
         System.out.println("Please input USERNAME for verification.");
         switch(scanner.next()){
         case "Kelveen":
         userName = "Kelveen";
         //   menu();
         break;
         default:
         System.out.println("Wrong username entry. Please try again.");
         //   menu();
         break;
         }
         */


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
        int ID = random.nextInt(9999999) + 1000001;

        System.out.println("---------------");
        System.out.println("Name: " + customer.getName());
        System.out.println("DOB: " + customer.getDob());
        System.out.println("Social Security: " + customer.getSS());
        System.out.println("Sex: " + customer.getSex());
        System.out.println("Citizen: " + customer.getCitizen());
        System.out.println("Veteran: " + customer.getVeteran());
        System.out.println("New Credit Balance: " + customer.getCreditBalance());
        System.out.println("New Checking Balance: " + customer.getCheckingBalance());
        System.out.println("---------------");
        System.out.println("Correct?");

        switch (scanner.next()) {
            case "Y":
            case "y":
                list.add(customer);
                hashMap.put(customer.getName(), ID);
                customer = new Customer();
                ID = 0;
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
        do {
            if (list.isEmpty()) {
                System.out.println("There are no accounts. Please create new accounts in the menu. Thank you.");
                break;
            } else {
                System.out.println("Who's information would you like to read? Press 0 to go back to menu");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(i + 1 + ". " + list.get(i).getName());
                }
                position = scanner.nextInt();
                if (position <= 0 || position > list.size()) {
                    break;
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
                break;
            }
        } while (position != 0 && !(list.isEmpty()));
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
                switch (scanner.next()) {
                    case "y":
                    case "Y":
                    case "Yes":
                    case "yes":
                        isList = false;
                        break;
                    case "n":
                    case "N":
                    case "No":
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
