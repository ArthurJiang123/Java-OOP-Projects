package app;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int defaultPasswordLength;

    private String email;
    private String alternateEmail;
    private int mailboxCapacity;

    private String institutionSuffix = "company.com";



    //TODO: constructor: receive firstname & lastName
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();

        this.defaultPasswordLength = 8;
        this.password = randomPassword(this.defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + institutionSuffix;
        this.showInfo();
        System.out.println("Welcome");

    }
    //TODO: ask for department from the user
    private String setDepartment(){
        System.out.println("Enter the department\n1 for Sales\n2 for Development \n3 for Accounting \n0 for none");
        Scanner in = new Scanner(System.in);

        int department = in.nextInt();
        switch(department){
            case 1:
                return "sales";
            case 2:
                return "dev";
            case 3:
                return "acct";
            default:
                return "";
        }
    }

    //TODO: generate random password
    private String randomPassword(int length){
        String passwords = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890!@#$%^&*()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random()*passwords.length());
            password[i] = passwords.charAt(rand);
        }
        return new String(password);
    }

    //TODO: set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //TODO: set alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //TODO: change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }
    public String getAlternateEmail(){
        return alternateEmail;
    }
    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
