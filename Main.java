import java.util.Scanner;
import java.util.ArrayList;
class BankAccount{
    private double balance;
    private String name;
    private int account ;
    private String password;
    public void input(Scanner scanner, int newAccno){
        account = newAccno;
        System.out.print("Enter your username: ");
        name = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();
        System.out.print("Enter your balance: ");
        balance = scanner.nextDouble();
    }
    public int getAccount(){
        return account;
    }
    public boolean login(Scanner scanner){
        System.out.print("Enter your password: ");
        String pass = scanner.nextLine();
        if(pass.equals(password)){
            return true;
        }
        else{
            System.out.println("Incorrect password..!!");
            return false;
        }
    }
    public void display(){
        System.out.println("Your name is: " + name);
        System.out.println("Your account no. is: " + account);
        System.out.println("Your current balance is: " + balance);
    }
    public void deposit(Scanner scanner){
        System.out.print("Enter the amount you want to deposit: ");
        double amount = scanner.nextDouble();
        if(amount > 0){
            balance += amount;
            System.out.println("Amount deposited successfully...");
        }
        else{
            System.out.println("Invalid deposit amount....!!");
        }
    }
    public void withdraw(Scanner scanner){
        System.out.print("Enter the amount you want to withdraw: ");
        double withdraw = scanner.nextDouble();
        if(withdraw <= 0){
            System.out.println("Invalid withdrawal amount....");
        }
        else if(withdraw > balance){
            System.out.println("You have insufficient balance..");
        }
        else{
            balance -= withdraw;
            System.out.println("Your balance left after withdrawing money is: " + balance);
        }
    }
}
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();
        int choice = 0;
        System.out.println("Welcome to the BANKING SYSTEM.....");
        while(true) {
            System.out.println(" ");
            System.out.println("======== MENU ========");
            System.out.println("1: To create account..");
            System.out.println("2: To show details...");
            System.out.println("3: To deposit money..");
            System.out.println("4: To withdraw money...");
            System.out.println("5: To delete account...");
            System.out.println("6: To exit");
            System.out.println(" ");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    System.out.print("Enter your Account Number: ");
                    int newAccno = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    for(BankAccount a : accounts){
                        if(a.getAccount() == newAccno){
                            found = true;
                            break;
                        }
                    }
                    if(found){
                        System.out.println("Account Number already exists");
                    }
                    else{
                        BankAccount acc = new BankAccount();
                        acc.input(scanner, newAccno);
                        accounts.add(acc);
                    }
                    break;
                case 2:
                    if(accounts.isEmpty()){
                        System.out.println("No accounts created yet..!!");
                    }
                    else{
                        for(BankAccount bankAccount : accounts) {
                            bankAccount.display();
                            System.out.println("---------------");
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter your Account Number: ");
                    int accno = scanner.nextInt();
                    scanner.nextLine();
                    boolean found2 = false;
                    for(BankAccount a : accounts){
                        if(a.getAccount() == accno){
                            found2 = true;
                            if(a.login(scanner)){
                                a.deposit(scanner);
                            }
                            break;
                        }
                    }
                    if(!found2){
                        System.out.println("Enter a valid Account Number..!!");
                    }
                    break;
                case 4:
                    System.out.print("Enter your Account Number: ");
                    int accno1 = scanner.nextInt();
                    scanner.nextLine();
                    boolean found1 = false;
                    for(BankAccount a : accounts){
                        if(a.getAccount() == accno1){
                            found1 = true;
                            if(a.login(scanner)){
                                a.withdraw(scanner);
                            }
                            break;
                        }
                    }
                    if(!found1){
                        System.out.println("Enter a valid Account Number..!!");
                    }
                    break;
                case 5:
                    System.out.print("Enter your Account Number: ");
                    int accno2 = scanner.nextInt();
                    scanner.nextLine();
                    boolean found3 = false;
                    for(BankAccount acc : accounts){
                        if(acc.getAccount() == accno2){
                            found3 = true;
                            if(acc.login(scanner)){
                                accounts.remove(acc);
                                System.out.println("Account deletion successful..!!");
                            }
                            break;
                        }
                    }
                    if(!found3){
                        System.out.println("Enter a valid Account Number..!!");
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using our BANKING SYSTEM..");
                    break;
                default:
                    System.out.println("Enter a valid choice...!!");
            }
            if(choice == 6){
                break;
            }
            System.out.print("Would you like to continue(Y/N): ");
            char ch = scanner.next().charAt(0);
            scanner.nextLine();
            if(ch == 'Y' || ch == 'y'){
                continue;
            }
            else{
                System.out.println("Program Finished....!!");
                break;
            }
        }
        scanner.close();
    }
}