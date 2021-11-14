package vendingmachine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class VendingMachine {
    //vending machine amount as class variable
    double currentBalance = 0;
    LinkedList<String> list= new LinkedList<>();

    public static void main(String[] args) {
        VendingMachine v = new VendingMachine();
        v.vendingLoop();
    }

    public void vendingLoop() {
        while (true) {
            menu();
            userOption();
            viewVendingAmount();
            viewTransactionHistory();
            //System.out.println("\nVending Machine Amount = " + this.currentBalance);
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

        //check enter valid amount
        if (id < 1 || id > 5) {
            System.out.println("Please enter the correct id");
            vendingLoop();
        }

        System.out.println("Enter Amount: ");
        String amount_str = sc.next();
        Double amount = Double.parseDouble(amount_str);
        setItem(id, amount);
    }

    public void setItem(int id, double amount) {
        String item=null;
        double item_amount=0;

        // set the amount and item according to id
        if (id == 1) {
            item = "Tea";
            item_amount=10;
        }
        if (id == 2) {
            item = "Coffee";
            item_amount=20;
        }
        if (id == 3) {
            item = "Coke";
            item_amount=50;
        }
        if (id == 4) {
            item = "Lays";
            item_amount=20.50;
        }
        if (id == 5) {
            item = "Cake";
            item_amount=100;
        }
        dispenceItem(id,amount,item,item_amount);
    }

    public void dispenceItem(int id, double amount,String item,double item_amount){

            if (amount < item_amount) {
                incorrectAmount(item_amount);
            }
            currentBalance += item_amount;
            double balance=amount - item_amount;
            if (amount > item_amount) {
                System.out.println("Returning balance : " + balance);
            }
            System.out.println("Dispensing "+ item);
            // get timestamp
            DateFormat df =new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date =new Date();
            String currentDateTime=df.format(date);
            transactionHistory(id,amount,item,item_amount,balance,currentDateTime);
        }

        public void incorrectAmount ( double amt){
            System.out.println("Enter greater or equal to " + amt);
            vendingLoop();
        }

        public void viewVendingAmount(){
            System.out.println("\nPlease give the choice for viewing vending machine amount:(Y/N) ");
            Scanner sc= new Scanner(System.in);
            String choice=sc.next();
            char c=choice.charAt(0);
            if(c=='Y'|| c=='y'){
                System.out.println("\nVending Machine Amount = " + this.currentBalance);
            }
            else if(c=='N'|| c=='n'){

            }
            else{
                System.out.println("Entered choice is incorrect.");
            }
        }
        public void viewTransactionHistory(){
            System.out.println("\nPlease give the choice for viewing Transaction History:(Y/N) ");
            Scanner sc= new Scanner(System.in);
            String choice=sc.next();
            char c=choice.charAt(0);
            if(c=='Y'|| c=='y'){
                System.out.println("\nThe Transaction History is:");
                for(String trans:list){
                    System.out.println(trans);
                }

            }
            else if(c=='N'|| c=='n'){

            }
            else{
                System.out.println("Entered choice is incorrect.");
            }
        }

        public void transactionHistory(int id, double amount,String item,double item_amount,double balance,String date){

            StringBuilder sb=new StringBuilder();
            sb.append("Transaction time: "+ date +"; \t"+
                        "Item Id: " + id +"; \t"+
                        "Item: "+ item +"; \t"+
                        "Amount enter by user: " + amount +"; \t"+
                        "Balance returned to user: "+ balance +"; \t"+
                        "Amount in vending machine: "+ currentBalance);

            list.add(sb.toString());

        }

    }




