package Java_Bank_Pursuit_HW_FABIAN_KELVEEN;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Customer extends User {
    Scanner scanner = new Scanner(System.in);
    String choice;
    Name name = new Name();
    DateOfBirth dob = new DateOfBirth();
    SocialSecurity ss = new SocialSecurity();

    public void createNewCustomer() {
        System.out.println("What is your first name? [Write none if you don't have one]");
        name.setfName(scanner.next());
        System.out.println("What is your middle name? [Write none if you don't have one]");
        name.setmName(scanner.next());
        System.out.println("What is your last name? [Write none if you don't have one]");
        name.setlName(scanner.next());
        System.out.println("Suffix? [1.Jr, 2.Sr, 3.II 4.III 5.IV 6.V 7.None]");
        name.setSuffix(scanner.nextInt());
        System.out.println("What is your date of birth? [XX/XX/XXXX]");
        choice = scanner.next();
        dob.setMonth(choice.substring(0, 2));
        dob.setDay(choice.substring(3, 5));
        dob.setYear(choice.substring(6, 10));
        System.out.println("What is your social security? [XXX-XX-XXXX]");
        choice = scanner.next();
        ss.setSocialSecurity1(choice.substring(0, 3));
        ss.setSocialSecurity2(choice.substring(4, 6));
        ss.setSocialSecurity3(choice.substring(7, 11));
    }

    public String getName() {
        return name.getfName() + " " + name.getmName() + " " + name.getlName() + " " + name.getSuffix();
    }

    public void editName() {
        System.out.println("Which information within your name would you like to change?");
        System.out.println("1. First Name");
        System.out.println("2. Middle Name");
        System.out.println("3. Last Name");
        System.out.println("4. Suffix");
        System.out.println("5. Exit");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Current First Name: " + name.getfName());
                System.out.println("New First Name: ");
                name.setfName(scanner.next());
                editName();
                break;
            case 2:
                System.out.println("Current Middle Name: " + name.getmName());
                System.out.println("New Middle Name: ");
                name.setmName(scanner.next());
                editName();
                break;
            case 3:
                System.out.println("Current Last Name: " + name.getlName());
                System.out.println("New Last Name: ");
                name.setlName(scanner.next());
                editName();
                break;
            case 4:
                System.out.println("Current Suffix: " + name.getSuffix());
                System.out.println("New Suffix [1.Jr, 2.Sr, 3.II 4.III 5.IV 6.V 7.None]: ");
                name.setSuffix(scanner.nextInt());
                editName();
                break;
            case 5:
                System.out.println("Name: " + getName());
                System.out.println("Is this information correct?[Y/n]");
                switch (scanner.next()) {
                    case "y":
                    case "Y":
                    case "Yes":
                    case "yes":
                        User.list.add(User.position - 1, User.customer);
                        User.list.remove(User.position - 1);
                        update();
                        break;
                    case "n":
                    case "N":
                    case "no":
                    case "No":
                        editName();
                        break;
                    default:
                        System.out.println("ERROR: Wrong answer. Please try again");
                        editName();
                        break;
                }
                break;
            default:
                System.out.println("ERROR: Wrong answer. Please try again.");
                editName();
                break;
        }
    }

    public String getDob() {
        return dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear();
    }

    public void editDob() {
        System.out.println("Which information within your date of birth would you like to change?");
        System.out.println("1. Month");
        System.out.println("2. Day");
        System.out.println("3. Year");
        System.out.println("4. Exit");

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("Current Month: " + dob.getMonth());
                System.out.println("New Month: ");
                dob.setMonth(scanner.next());
                editDob();
                break;
            case 2:
                System.out.println("Current Day: " + dob.getDay());
                System.out.println("New Day: ");
                dob.setDay(scanner.next());
                editDob();
                break;
            case 3:
                System.out.println("Current Year: " + dob.getYear());
                System.out.println("New Year: ");
                dob.setYear(scanner.next());
            case 4:
                System.out.println("DOB: " + getDob());
                System.out.println("Is this information correct?[Y/n]");

                switch (scanner.next()) {
                    case "y":
                    case "Y":
                    case "Yes":
                    case "yes":
                        User.list.add(User.position - 1, User.customer);
                        User.list.remove(User.position - 1);
                        update();
                        break;
                    case "n":
                    case "N":
                    case "no":
                    case "No":
                        editDob();
                        break;
                }
        }

    }

    public String getSS() {
        return ss.getSocialSecurity1() + "-" + ss.getSocialSecurity2() + "-" + ss.getSocialSecurity3();
    }//FIXME: Create editSS() method

    public void editSS() {
        System.out.println("Current Social Security: " + getSS());
        System.out.println("New Social Security: [XXX-XX-XXXX]");
        choice = scanner.next();
        ss.setSocialSecurity1(choice.substring(0, 3));
        ss.setSocialSecurity2(choice.substring(4, 6));
        ss.setSocialSecurity3(choice.substring(7, 11));

        System.out.println("SS: " + getSS());
        System.out.println("Is this information correct?[Y/n]");

        switch (scanner.next()) {
            case "y":
            case "Y":
            case "Yes":
            case "yes":
                User.list.add(User.position - 1, User.customer);
                User.list.remove(User.position - 1);
                update();
                break;
            case "n":
            case "N":
            case "no":
            case "No":
                editSS();
                break;
        }
    }


}

