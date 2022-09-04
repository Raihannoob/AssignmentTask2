import java.util.Scanner;
public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    int customerId;

    public BankAccount(int balance, String customerName, int customerId) {
        this.balance = balance;
        this.customerName = customerName;
        this.customerId = customerId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

//    public int getPreviousTransaction() {
//        return previousTransaction;
//    }

    public void setPreviousTransaction(int previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    void deposit(int amount) {
        if (amount > 0) {
            balance = balance + amount;
            previousTransaction = +amount;
            System.out.println("****Deposited Successful*****");

        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    void withdraw(int amount) {
        if (amount > 0 ) {
            balance = balance - amount;
            previousTransaction = +amount;
            System.out.println("****Withdrawn Successful***");
        } else {
            System.out.println("***Invalid Withdrawn Amount***");
        }

    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited : " + previousTransaction);
        } else if (previousTransaction < 0) {

            System.out.println("Withdraw:" + Math.abs(previousTransaction));
        } else {
            System.out.println("No Transaction occurred");
        }
    }

    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("welcome" + customerName);
        System.out.println(customerId);
        System.out.println("\n");
        System.out.println("A.Check Balance");
        System.out.println("B.Deposit");
        System.out.println("C.Withdraw");
        System.out.println("D.Previous Transaction");
        System.out.println("E.Exit");
        do {
            System.out.println("==========================================");
            System.out.println("Enter An option");
            System.out.println("==========================================");
            option = scanner.next().charAt(0);
            System.out.println("\n");
            switch (option) {
                case 'A':
                    System.out.println("-----------------------");
                    System.out.println("Balance = " + balance);
                    System.out.println("-----------------------");
                    System.out.println("\n");
                    break;
                case 'B':
                    System.out.println("-----------------------");
                    System.out.println("Enter an amount to deposit:");
                    System.out.println("-----------------------");
                    int amount1 = scanner.nextInt();
                    deposit(amount1);
                    System.out.println("\n");
                    break;
                case 'C':
                    System.out.println("-----------------------");
                    System.out.println("Enter an amount to Withdraw:");
                    System.out.println("-----------------------");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                case 'D':
                    System.out.println("-----------------------");
                    System.out.println("Previous Transaction:");
                    getPreviousTransaction();
                    System.out.println("\n");
                    break;
                case 'E':
                    System.out.println("*************************");
                    break;
                default:
                    System.out.println("Please Enter Again!!");
                    break;
            }

        } while (option != 'E');
        System.out.println("Thank You For Using Our service!");

    }
}
