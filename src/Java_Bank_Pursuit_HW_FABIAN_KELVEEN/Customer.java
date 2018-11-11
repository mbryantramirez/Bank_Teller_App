package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.Random;
import java.util.Scanner;

public class Customer {
    private Scanner scanner = new Scanner(System.in);
    private String choice;
    private String salary;
    private double max;
    private Random random = new Random();
    private int ID = random.nextInt(9999999) + 1000001;
    private Name name = new Name();
    private DateOfBirth dob = new DateOfBirth();
    private SocialSecurity ss = new SocialSecurity();
    private Sex sex = new Sex();
    private Citizen citizen = new Citizen();
    private Veteran veteran = new Veteran();
    private BankAccount bankAccount = new BankAccount();



    Customer(){}

    Customer(String fName, String mName, String lName, String suffix,
             String month, String day, String year, String ss, String sex,
             String citizen, String veteran, String checking, String credit) {
        this.name.setfName(fName);
        this.name.setmName(mName);
        this.name.setlName(lName);
        this.name.setSuffix(suffix);
        this.dob.setMonth(month);
        this.dob.setDay(day);
        this.dob.setYear(year);
        this.ss.setSocialSecurity1(ss.substring(0, 3));
        this.ss.setSocialSecurity2(ss.substring(4, 6));
        this.ss.setSocialSecurity3(ss.substring(7, 11));
        this.sex.setSex(sex);
        this.citizen.setCitizen(citizen);
        this.veteran.setVeteran(veteran);
        this.bankAccount.setChecking(checking);
        this.bankAccount.setCredit(credit);
    }

    public int getID() {
        return ID;
    }

    public void createNewCustomer() {
        do {
            System.out.println("What is your first name? [Write none if you don't have one]");
            name.setfName(scanner.next());
        } while (name.getfName() == null);

        do {
            System.out.println("What is your middle name? [Write none if you don't have one]");
            name.setmName(scanner.next());
        } while (name.getmName() == null);

        do {
            System.out.println("What is your last name? [Write none if you don't have one]");
            name.setlName(scanner.next());
        } while (name.getlName() == null);

        do {
            System.out.println("Suffix? [1.Jr, 2.Sr, 3.II 4.III 5.IV 6.V 7.None]");
            name.setSuffix(scanner.next());
        } while (name.getSuffix() == null);

        do {
            try {
                System.out.println("What is your date of birth? [XX/XX/XXXX]");
                choice = scanner.next();
                dob.setMonth(choice.substring(0, 2));
                dob.setDay(choice.substring(3, 5));
                dob.setYear(choice.substring(6, 10));
            } catch (StringIndexOutOfBoundsException e) {
                dob.setYear("null");
            }
        } while (dob.getYear() == null || dob.getDay() == null || dob.getMonth() == null);

        do {
            System.out.println("What is your sex? [M/f]");
            sex.setSex(scanner.next());
        } while (sex.getSex() == null);


        do {
            try {
                System.out.println("What is your social security? [XXX-XX-XXXX]");
                choice = scanner.next();
                ss.setSocialSecurity1(choice.substring(0, 3));
                ss.setSocialSecurity2(choice.substring(4, 6));
                ss.setSocialSecurity3(choice.substring(7, 11));
            } catch (StringIndexOutOfBoundsException e) {
                ss.setSocialSecurity1("null");
            }
        } while (ss.getSocialSecurity1() == null || ss.getSocialSecurity2() == null || ss.getSocialSecurity3() == null);

        do {
            System.out.println("Are you a U.S. citizen?[Y/n]");
            citizen.setCitizen(scanner.next());
        } while (citizen.getCitizen() == null);

        do {
            System.out.println("Are a you a veteran? Choose below:");
            System.out.println("1. I am a US veteran.");
            System.out.println("2. I am not a US veteran.");
            System.out.println("3. I do not wish to answer.");
            veteran.setVeteran(scanner.next());
        } while (veteran.getVeteran() == null);


        do {
            System.out.println("Would you like to sign up for a credit card account? [Y/n]");
            choice = scanner.next();

            switch (choice) {
                case "y":
                case "Y":
                case "Yes":
                case "yes":
                    do {
                        System.out.println("Please input a salary, so that we can determine how much credit we can offer you.");
                        salary = scanner.next();
                        bankAccount.setCredit(salary);
                    } while (bankAccount.getCredit() <= 0);
                    break;
                case "n":
                case "N":
                case "No":
                case "no":
                    break;
                default:
                    choice = null;
                    break;
            }
        } while (choice == null);

        do {
            System.out.println("Would you like to sign up for a checking account? [Y/n]");
            choice = scanner.next();

            switch (choice.toLowerCase()) {
                case "y":
                case "yes":
                    do {
                        System.out.println("Please enter how much you would like to deposit. Minimum = $25.00");
                        choice = scanner.next();
                        if (Double.parseDouble(choice) >= 25.00) {
                            bankAccount.setChecking(choice);
                        } else {
                            bankAccount.setChecking(null);
                        }
                    } while (bankAccount.getChecking() <= 0);
                    break;
                case "n":
                case "no":
                    break;
                default:
                    choice = null;
                    break;
            }
        } while (choice == null);
    }


    public String getSex() {
        return sex.getSex();
    }

    public void editSex() {
        boolean isSex = true;

        do {
            System.out.println("Which information would you like to change?");
            System.out.println("1. Sex");
            System.out.println("2. Exit");

            switch (scanner.next()) {
                case "1":
                    System.out.println("Current Sex: " + sex.getSex());
                    do {
                        System.out.println("New Sex:[M/f]");
                        sex.setSex(scanner.next());
                    } while (sex.getSex() == null);
                    break;
                case "2":
                    System.out.println("Sex: " + getSex());
                    System.out.println("Is this information correct?[Y/n]");

                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            isSex = false;
                            break;
                        case "n":
                        case "N":
                        case "no":
                        case "No":
                            break;
                        default:
                            System.out.println("ERROR: Wrong answer. Please try again");
                            break;
                    }
                    break;
                default:
                    System.out.println("Wrong answer. Please try again");
                    break;
            }
        } while (isSex);
    }

    public String getName() {
        return name.getfName() + " " + name.getmName() + " " + name.getlName() + " " + name.getSuffix();
    }

    public void editName() {
        boolean isEditing = true;

        do {
            System.out.println("Which information would you like to change?");
            System.out.println("1. First Name");
            System.out.println("2. Middle Name");
            System.out.println("3. Last Name");
            System.out.println("4. Suffix");
            System.out.println("5. Exit");

            switch (scanner.next()) {

                case "1":
                    System.out.println("Current First Name: " + name.getfName());
                    System.out.println("New First Name: ");
                    name.setfName(scanner.next());
                    break;
                case "2":
                    System.out.println("Current Middle Name: " + name.getmName());
                    System.out.println("New Middle Name: ");
                    name.setmName(scanner.next());
                    break;
                case "3":
                    System.out.println("Current Last Name: " + name.getlName());
                    System.out.println("New Last Name: ");
                    name.setlName(scanner.next());
                    break;
                case "4":
                    System.out.println("Current Suffix: " + name.getSuffix());
                    do {
                        System.out.println("New Suffix [1.Jr, 2.Sr, 3.II 4.III 5.IV 6.V 7.None]: ");
                        name.setSuffix(scanner.next());
                    } while (name.getSuffix() == null);
                    break;
                case "5":
                    System.out.println("Name: " + getName());
                    System.out.println("Is this information correct?[Y/n]");
                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            isEditing = false;
                            break;
                        case "n":
                        case "N":
                        case "no":
                        case "No":
                            break;
                        default:
                            System.out.println("ERROR: Wrong answer. Please try again");
                            break;
                    }
                    break;
                default:
                    System.out.println("ERROR: Wrong answer. Please try again.");
                    break;
            }
        } while (isEditing);

    }

    public String getDob() {
        return dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear();
    }

    public void editDob() {
        boolean isBirth = true;

        do {
            System.out.println("Which information would you like to change?");
            System.out.println("1. Month");
            System.out.println("2. Day");
            System.out.println("3. Year");
            System.out.println("4. Exit");

            switch (scanner.next()) {
                case "1":
                    System.out.println("Current Month: " + dob.getMonth());
                    do {
                        System.out.println("New Month: [XX]");
                        dob.setMonth(scanner.next());
                    } while (dob.getMonth() == null);
                    break;
                case "2":
                    System.out.println("Current Day: " + dob.getDay());
                    do {
                        System.out.println("New Day: [XX]");
                        dob.setDay(scanner.next());
                    } while (dob.getDay() == null);
                    break;
                case "3":
                    System.out.println("Current Year: " + dob.getYear());
                    do {
                        System.out.println("New Year: [XXXX]");
                        dob.setYear(scanner.next());
                    } while (dob.getYear() == null);
                    break;
                case "4":
                    System.out.println("DOB: " + getDob());
                    System.out.println("Is this information correct?[Y/n]");
                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            isBirth = false;
                            break;
                        case "n":
                        case "N":
                        case "no":
                        case "No":
                            break;
                        default:
                            System.out.println("ERROR: Wrong answer. Please try again");
                            break;
                    }
                    break;
                default:
                    System.out.println("ERROR: Wrong answer. Please try again");
                    break;
            }
        } while (isBirth);
    }

    public String getSS() {
        return ss.getSocialSecurity1() + "-" + ss.getSocialSecurity2() + "-" + ss.getSocialSecurity3();
    }

    public void editSS() {
        boolean isSS = true;

        do {
            System.out.println("Which information would you like to change?");
            System.out.println("1. Social Security");
            System.out.println("2. Exit");

            switch (scanner.next()) {
                case "1":
                    System.out.println("Current Social Security: " + getSS());
                    do {
                        try {
                            System.out.println("New Social Security: [XXX-XX-XXXX]");
                            choice = scanner.next();
                            ss.setSocialSecurity1(choice.substring(0, 3));
                            ss.setSocialSecurity2(choice.substring(4, 6));
                            ss.setSocialSecurity3(choice.substring(7, 11));
                        } catch (StringIndexOutOfBoundsException e) {
                            ss.setSocialSecurity1("null");
                        }
                    }
                    while (ss.getSocialSecurity3() == null || ss.getSocialSecurity2() == null || ss.getSocialSecurity1() == null);
                    break;
                case "2":
                    System.out.println("Social Security: " + getSS());
                    System.out.println("Is this information correct?[Y/n]");

                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            isSS = false;
                            break;
                        case "n":
                        case "N":
                        case "no":
                        case "No":
                            break;
                        default:
                            System.out.println("Wrong answer. Please try again");
                            break;
                    }
                    break;
                default:
                    System.out.println("Wrong answer. Please try again");
                    break;
            }
        } while (isSS);


    }

    public void editCitizen() {
        boolean isCitizen = true;

        do {
            System.out.println("Which information would you like to change.");
            System.out.println("1. Citizen");
            System.out.println("2. Exit");

            switch (scanner.next()) {
                case "1":
                    System.out.println("Current Citizen: " + getCitizen());
                    do {
                        System.out.println("New Citizen[Y/n]: ");
                        citizen.setCitizen(scanner.next());
                    } while (citizen.getCitizen() == null);
                    break;
                case "2":
                    System.out.println("Citizen: " + getCitizen());
                    System.out.println("Is this information correct?[Y/n]");

                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            isCitizen = false;
                            break;
                        case "n":
                        case "N":
                        case "no":
                        case "No":
                            break;
                        default:
                            System.out.println("Wrong answer. Please try again");
                            break;
                    }
                    break;
                default:
                    System.out.println("Wrong answer. Please try again");
                    break;
            }
        } while (isCitizen);
    }

    public String getCitizen() {
        return citizen.getCitizen();
    }

    public void editVeteran() {
        boolean isVeteran = true;

        do {
            System.out.println("Which information would you like to change.");
            System.out.println("1. Veteran");
            System.out.println("2. Exit");

            switch (scanner.next()) {
                case "1":
                    System.out.println("Veteran: " + getVeteran());
                    do {
                        System.out.println("New Veteran: ");
                        System.out.println("1. I am a US veteran.");
                        System.out.println("2. I am not a US veteran.");
                        System.out.println("3. I do not wish to answer.");
                        veteran.setVeteran(scanner.next());
                    } while (veteran.getVeteran() == null);
                    break;
                case "2":
                    System.out.println("Veteran: " + getVeteran());
                    System.out.println("Is this information correct?[Y/n]");

                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            isVeteran = false;
                            break;
                        case "n":
                        case "N":
                        case "no":
                        case "No":
                            break;
                        default:
                            System.out.println("Wrong answer. Please try again");
                            break;
                    }
                    break;
                default:
                    System.out.println("Wrong answer. Please try again");
                    break;
            }
        } while (isVeteran);
    }

    public String getVeteran() {
        return veteran.getVeteran();
    }

    public double getCreditBalance() {
        return bankAccount.getCredit();
    }

    public double getCheckingBalance() {
        return bankAccount.getChecking();
    }

    public void editAccount() {
        boolean isAccount = true;

        do {
            System.out.println("Which information would you like to change?");
            System.out.println("1. Credit");
            System.out.println("2. Checking");
            System.out.println("3. Exit");

            String amount;
            switch (scanner.next()) {
                case "1":
                case "credit":
                case "Credit":
                case "CREDIT":
                    System.out.println("What would you like to do?");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Update Salary");
                    System.out.println("4. Exit");

                    switch (scanner.next()) {
                        case "1":
                        case "Deposit":
                        case "deposit":
                        case "DEPOSIT":
                            System.out.println("Current Amount: " + bankAccount.getCredit());
                            System.out.println("Max Amount: " + bankAccount.getMaxCredit());
                            do {
                                try {
                                    System.out.println("What is the amount that you would like deposit?");
                                    amount = scanner.next();
                                    bankAccount.depositCredit(amount);
                                    System.out.println("New Amount: " + bankAccount.getCredit() + "\n");
                                } catch (NumberFormatException e) {
                                    amount = null;
                                }
                            } while (amount == null);
                            break;
                        case "2":
                        case "Withdraw":
                        case "withdraw":
                        case "WITHDRAW":
                            System.out.println("Current Amount: " + bankAccount.getCredit());
                            System.out.println("Max Amount: " + bankAccount.getMaxCredit());
                            do {
                                try {
                                    if (max >= 300) {
                                        System.out.println("Reached max limit of withdrawal for the week. Please try again next week.");
                                        break;
                                    } else {
                                        System.out.println("What is the amount that you would like to withdraw?($300.00 Max Limit)");
                                        amount = scanner.next();
                                        if (Double.parseDouble(amount) <= 300) {
                                            max = max + Double.parseDouble(amount);
                                        }
                                        bankAccount.creditWithdrawal(amount);
                                        System.out.println("Withdrew: " + amount);
                                        System.out.println("New Amount: " + bankAccount.getCredit() + "\n");
                                    }
                                } catch (NumberFormatException e) {
                                    amount = null;
                                }
                            } while (amount == null);
                            break;
                        case "3":
                            System.out.println("Current Salary: " + salary);
                            salary = null;
                            do {
                                try {
                                    System.out.println("What is your new salary?");
                                    salary = scanner.next();
                                    bankAccount.setCredit(salary);
                                    System.out.println("New Max Credit: " + bankAccount.getMaxCredit() + "\n");
                                } catch (NumberFormatException e) {
                                    salary = null;
                                }
                            } while (salary == null);
                            break;
                        case "4":
                        case "Exit":
                        case "exit":
                        case "EXIT":
                            break;
                    }
                    break;
                case "2":
                case "checking":
                case "Checking":
                case "CHECKING":
                    System.out.println("What would you like to do?");
                    System.out.println("1. Deposit");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Exit");

                    switch (scanner.next()) {
                        case "1":
                        case "Deposit":
                        case "deposit":
                        case "DEPOSIT":
                            do {
                                try {
                                    System.out.println("Current amount: " + bankAccount.getChecking());
                                    System.out.println("What is the amount that you would like deposit?");
                                    amount = scanner.next();
                                    bankAccount.depositChecking(amount);
                                    System.out.println("New Amount: " + bankAccount.getChecking() + "\n");

                                } catch (NumberFormatException e) {
                                    amount = null;
                                }
                            } while (amount == null);
                            break;
                        case "2":
                        case "Withdraw":
                        case "withdraw":
                        case "WITHDRAW":
                            do {
                                try {
                                    System.out.println("Current amount: " + bankAccount.getChecking());
                                    System.out.println("What is that amount that you would like withdraw");
                                    amount = scanner.next();
                                    bankAccount.checkingWithdrawal(amount);
                                    System.out.println("New Amount: " + bankAccount.getChecking() + "\n");
                                } catch (NumberFormatException e) {
                                    amount = null;
                                }
                            } while (amount == null);
                            break;
                        case "3":
                        case "Exit":
                        case "exit":
                        case "EXIT":
                            break;
                        default:
                            System.out.println("Wrong entry. Please try again");
                            break;
                    }
                    break;
                case "3":
                case "Exit":
                case "exit":
                case "EXIT":
                    System.out.println("Credit: " + bankAccount.getCredit());
                    System.out.println("Checking: " + bankAccount.getChecking());
                    System.out.println("Is this information correct?[Y/n]");
                    switch (scanner.next()) {
                        case "y":
                        case "Y":
                        case "Yes":
                        case "yes":
                            isAccount = false;
                            break;
                        case "n":
                        case "N":
                        case "No":
                        case "no":
                            break;
                        default:
                            System.out.println("Wrong entry. Please try again");
                            break;
                    }
                    break;
                default:
                    System.out.println("Wrong entry. Please try again");
                    break;

            }
        } while (isAccount);
    }
}

