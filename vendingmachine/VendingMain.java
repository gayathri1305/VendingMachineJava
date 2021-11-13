package vendingmachine;

import java.util.Scanner;

public class VendingMain {
    public static void main(String[] args) {
        VendingMain v=new VendingMain();
        v.menu();
        v.userOption();
    }

    public void menu(){
        System.out.println("Hi This is the menu:");
        System.out.println("Id\t Name\t\t Price\t\n"+
                            "1.\t Tea\t\t 10\t\n"+
                            "2.\t Coffee\t\t 20\t\n"+
                            "3.\t Coke\t\t 50\t\n"+
                            "4.\t Lays\t\t 20.50\t\n"+
                            "5.\t Cake\t\t 100\t\n");

    }
    public void userOption(){
        System.out.println("Enter item ID: ");
        Scanner sc= new Scanner(System.in);
        int id=sc.nextInt();
        System.out.println("Enter Amount: ");
        String amount_str=sc.next();
        Double amount= Double.parseDouble(amount_str);
        double vendMachAmt=dispenceItem(id,amount);

    }

    public double dispenceItem(int id, double amount){
        double vendMachAmt=0;
        if(id<1 || id>5){
            System.out.println("Please enter valid id");
            menu();
        }

        if(id==1){
            if(amount>10){
                vendMachAmt=amount-10;
                System.out.println("Returning balance : " + (amount-10));
                System.out.println("Dispensing Tea");
            }
            else if(amount==10){
                System.out.println("Dispensing Tea");
            }
            else{
                System.out.println("please enter High amount");
            }
             
        }
        if(id==2){
            if(amount>20){
                vendMachAmt=amount-20;
                System.out.println("Returning balance : " + (amount-20));
                System.out.println("Dispensing Coffee");
            }
            else if(amount==20){
                System.out.println("Dispensing Coffee");
            }
            else{
                System.out.println("please enter High amount");
            }

        }
        if(id==3){
            if(amount>50){
                vendMachAmt=amount-50;
                System.out.println("Returning balance : " + (amount-50));
                System.out.println("Dispensing Coke");
            }
            else if(amount==50){
                System.out.println("Dispensing Coke");
            }
            else{
                System.out.println("please enter High amount");
            }

        }

        if(id==4){
            if(amount>20.50){
                vendMachAmt=amount-20.50;
                System.out.println("Returning balance : " + (amount-20.50));
                System.out.println("Dispensing Lays");
            }
            else if(amount==20.50){
                System.out.println("Dispensing Lays");
            }
            else{
                System.out.println("please enter High amount");
            }

        }

        if(id==5){
            if(amount>100){
                vendMachAmt=amount-100;
                System.out.println("Returning balance : " + (amount-100));
                System.out.println("Dispensing Cake");
            }
            else if(amount==100){
                System.out.println("Dispensing Cake");
            }
            else{
                System.out.println("please enter High amount");
            }

        }
        return vendMachAmt;

    }
}
