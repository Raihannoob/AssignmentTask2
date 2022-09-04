import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<BankAccount> bankAccountList = new ArrayList<>();
    public  void addAccount(BankAccount bankAccount) {
        bankAccountList.add(bankAccount);
    }
    public  void showCustomerList() {
        for (BankAccount bankAccount : bankAccountList) {
            System.out.println("ID: " + bankAccount.getCustomerId() + " " + "Name : " + bankAccount.getCustomerName() +"balance " + bankAccount.getBalance());
        }
    }
    public void transferMoney(int senderBankAcNo,int receiverBankAcNo,int amount) {
        BankAccount senderBankAccount;
        BankAccount receiverBankAccount;
        int receiverCount = 0;
        int senderCount =   0;
        for (BankAccount bankAccount : bankAccountList) {
            //for Checking Sender account
            if (bankAccount.customerId == senderBankAcNo) {
                senderCount += 0;
                //separate sender object
                senderBankAccount = bankAccount;
                //for loop for searching Receiver object
                for(BankAccount bankAccount1 : bankAccountList){
                    //for Checking Receiver account
                    if(bankAccount1.customerId == receiverBankAcNo) {
                        receiverCount += 1;
                        //checking sender account have enough money to send
                        if(amount <= senderBankAccount.balance) {
                            senderBankAccount.balance=  senderBankAccount.balance - amount;
                            bankAccount1.balance = bankAccount1.balance +amount;
                            System.out.println("Money Transfer Successful");
                        }else {
                            System.out.println("Not Enough Money for Transfer");
                        }
                    }

                }

            }
        }
        if(receiverCount == 0){
            System.out.println("Receiver Account Number is not valid");
        }
        if (senderCount == 0){
            System.out.println("Sender Account Number is not valid");
        }
    }
        void openingUserAccount(){
                int customerId = 0;
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter Your Name :");
                String customerNAme = scan.nextLine();
                System.out.println("Enter Your Email  :");
                String customerEmail = scan.nextLine();
                System.out.println("Enter Initial deposit(You must deposit more than 1000tk for open a bank account***): ");
                int initialDeposit = scan.nextInt();
                //for Initial Deposit You must deposit more than 1000tk for open a bank account***
                if (initialDeposit >1000){
                    customerId +=1;
                    BankAccount obj1 = new BankAccount(initialDeposit,customerNAme,customerId,customerEmail);
                    System.out.println("Account Register SuccessFully");
                    bankAccountList.add(obj1);
                    BankAccount obj2 = new BankAccount(2000,"Raihan",2,"raihan.tanvir961@gmail.com");
                    bankAccountList.add(obj2);
                    System.out.println("Transfer Money");
                    System.out.println("Enter Your Bank Account Number:");
                    int senderBankAcNo = scan.nextInt();
                    System.out.println("Enter Receiver Account Number: ");
                    int receiverBankAcNo = scan.nextInt();
                    System.out.println("Enter Amount:");
                    int amount = scan.nextInt();
                    System.out.println("-----------------------");
//                    transferMoney(senderBankAcNo,receiverBankAcNo,amount);
                    obj1.showMenu();


                }
                else {
                    System.out.println("Invalid Initial Amount");
                }
            }

    public static void main(String[] args) {
        Main main = new Main();
        main.openingUserAccount();
        main.showCustomerList();
    }
}


