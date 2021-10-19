package com.company;
import java.util.*;

public class ATMMachine {

    private double totalBal = 100;

    Scanner sc = new Scanner(System.in);

    public int userAccount(){

        System.out.print("Enter your account number: ");

        int account = sc.nextInt();
        return account;
    }

    public int enterPin(){

        System.out.print("Enter your PIN: ");

        int pin = sc.nextInt();
        return pin;
    }

    public void startAtm(){

        userAccount();
        enterPin();
        drawMainMenu();
    }

    public void drawMainMenu(){

        int selection;

        System.out.println("\n ATM Main Menu: ");
        System.out.println("1. View your account balance");
        System.out.println("2. Withdraw money");
        System.out.println("3. Add cash");
        System.out.println("4. Terminate transaction");
        System.out.print("Choice: ");

        selection = sc.nextInt();

        switch(selection){

            case 1: viewAccountInfo();
            break;

            case 2: withdraw();
            break;

            case 3: addMoney();
            break;

            case 4: System.out.println("Thank You for using the ATM!! Goodbye");
            break;
        }
    }

    public void viewAccountInfo(){

        System.out.println("Account Information: ");
        System.out.println("\t Total Balance: " + "Rs." + totalBal);

        drawMainMenu();
    }

    public void deposit(int depAmount){

        System.out.println("\n Please insert your money now....");

        totalBal = totalBal + depAmount;
    }

    public void checkNSF(int withdrawAmount){

        if(totalBal - withdrawAmount < 0) {

            System.out.println("\n ERROR!!! Insufficient amount in your account.");
        }

        else {

            totalBal = totalBal - withdrawAmount;

            System.out.println("\n Please take your money now.....");
        }
    }

    public void addMoney(){

        int addMoney;

        System.out.println("Deposit Cash: ");
        System.out.println("1. Rs.100");
        System.out.println("2. Rs.200");
        System.out.println("3. Rs.500");
        System.out.println("4. Rs.2000");
        System.out.println("5. Return to Main Menu");
        System.out.print("Choice: ");

        addMoney = sc.nextInt();

        switch (addMoney){

            case 1: deposit(100);
            drawMainMenu();
            break;

            case 2: deposit(200);
            drawMainMenu();
            break;

            case 3: deposit(500);
            drawMainMenu();
            break;

            case 4: deposit(2000);
            drawMainMenu();
            break;

            case 5: drawMainMenu();
            break;
        }
    }

    public void withdraw(){

        int withdrawSelection;

        System.out.println("Withdraw Cash: ");
        System.out.println("1. Rs.100");
        System.out.println("2. Rs.200");
        System.out.println("3. Rs.500");
        System.out.println("4. Rs.2000");
        System.out.println("5. Return to Main Menu");
        System.out.print("Choice: ");

        withdrawSelection = sc.nextInt();

        switch (withdrawSelection) {

            case 1: checkNSF(100);
            drawMainMenu();
            break;

            case 2: checkNSF(200);
            drawMainMenu();
            break;

            case 3: checkNSF(500);
            drawMainMenu();
            break;

            case 4: checkNSF(2000);
            drawMainMenu();
            break;

            case 5: drawMainMenu();
            break;
        }
    }

    public static void main(String[] args) {

        ATMMachine atm = new ATMMachine();
        atm.startAtm();// write your code here
    }
}
