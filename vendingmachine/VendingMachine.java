package vendingmachine;

import java.util.Scanner;

public class VendingMachine {
    //vending machine amount as class variable
    double currentBalance = 0;

    public static void main(String[] args) {
        VendingMachine v = new VendingMachine();
        v.vendingLoop();
    }

    public void vendingLoop() {
        while (true) {
            menu();
            userOption();
            System.out.println("\nVending Machine Amount = " + this.currentBalance);
        }
    }

    public void menu() {
        System.out.println("\nHi This is the menu:");
        System.out.println("Id\t Name\t\t Price\t\n" +
                "1.\t Tea\t\t 10\t\n" +
                "2.\t Coffee\t\t 20\t\n" +
                "3.\t Coke\t\t 50\t\n" +
                "4.\t Lays\t\t 20.50\t\n" +
                "5.\t Cake\t\t 100\t\n");
    }

    public void userOption() {
        System.out.println("Enter item ID: ");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        System.out.println("Enter Amount: ");
        String amount_str = sc.next();
        Double amount = Double.parseDouble(amount_str);
        dispenceItem(id, amount);
    }

    public void dispenceItem(int id, double amount) {
        if (id < 1 || id > 5) {
            System.out.println("Please enter valid id");
            menu();
        }

        if (id == 1) {
            if (amount < 10) {
                incorrectAmount(10);
            }
            currentBalance += 10;
            if (amount > 10) {
                System.out.println("Returning balance : " + (amount - 10));
            }
            System.out.println("Dispensing Tea");
        }

        if (id == 2) {
            if (amount < 20) {
                incorrectAmount(20);
            }
            currentBalance += 20;
            if (amount > 20) {
                System.out.println("Returning balance : " + (amount - 20));
            }
            System.out.println("Dispensing Coffee");
        }

        if (id == 3) {
            if (amount < 50) {
                incorrectAmount(50);
            }
            currentBalance += 50;
            if (amount > 50) {
                System.out.println("Returning balance : " + (amount - 50));
            }
                System.out.println("Dispensing Coke");
        }

        if (id == 4) {
            if (amount < 20.50) {
                incorrectAmount(20.50);
            }
            currentBalance += 20.50;
            if (amount > 20.50) {
                System.out.println("Returning balance : " + (amount - 20.50));
            }
            System.out.println("Dispensing Lays");

        }

        if (id == 5) {
            if (amount < 100) {
                incorrectAmount(100);
            }
            currentBalance += 100;
            if (amount > 100) {
                System.out.println("Returning balance : " + (amount - 100));
            }
            System.out.println("Dispensing Cake");

        }
    }

        public void incorrectAmount ( double amt){
            System.out.println("Enter greater or equal to " + amt);
            vendingLoop();
        }

    }




