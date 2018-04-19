package emailApp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity =500;
    private  int defaultPasswordLength= 8;
    private String alternateEmail;
    private  String email;
    private String companySuffix = "art.com";

    //constroctor to ricive the first and last name
    public Email(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        System.out.println("   Departement: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is : "  + this.password);

        //Combine element to generate email
        email = firstName.toLowerCase() + "."+lastName.toLowerCase() + "@" + department+ "." + companySuffix;
        System.out.println("Your email is: " + email);
    }
    //Ask for the department
    //call a method asking for department = return the department

    private String setDepartment(){
        System.out.println("  \n New Employer: " + firstName + ".    DEPARTEMENT CODE\n1 for Sale \n2 for Developement\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice= in.nextInt();
        if (depChoice == 1) {return  "Sales";}
        else if (depChoice == 2) {return  "dev";}
        else if (depChoice == 3 ) {return  "acct";}
        else {return "";}
    }
    //call a method that returns a random password
    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0;  i<length; i++){
            int rand = (int)(Math.random()* passwordSet.length());
            password[i] = passwordSet.charAt(rand);

        }
        return  new String(password);
    }
    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }
    public String showInfo(){
        return  "DISPLAY NAME: " + firstName +  " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY : " + mailboxCapacity + " mb";
    }
}
