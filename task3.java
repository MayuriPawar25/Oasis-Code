
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

 class ATM
{
    private double balance;
    private double deposit_Amount;
    private double withdraw_Amount;

    
    public ATM(){

    }

    
public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return deposit_Amount;
    }

    public void setDepositAmount(double deposit_Amount) {
        this.deposit_Amount = deposit_Amount;
    }

    public double getWithdrawAmount() {
        return withdraw_Amount;
    }

    public void setWithdrawAmount(double withdraw_Amount) {
        this.withdraw_Amount = withdraw_Amount;
    }
}

 interface AtmOperationInterf 
 {
    public void viewBalance();
    public void withdraw_Amount(double withdraw_Amount);
    public void deposit_Amount(double deposit_Amount );
    public  void viewMiniStatement();
}


 class AtmOperationImpl implements AtmOperationInterf{
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();
    @Override
    public void viewBalance() {
        System.out.println("Available Balance is : "+atm.getBalance());

    }

    @Override
    public void withdraw_Amount(double withdraw_Amount) {
        if(withdraw_Amount%500==0) {
            if (withdraw_Amount <= atm.getBalance()) {
                ministmt.put(withdraw_Amount, " Amount Withdrawn");
                System.out.println("Collect the Cash " + withdraw_Amount);
                atm.setBalance(atm.getBalance() - withdraw_Amount);
                viewBalance();
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multipul of 500 !!");
        }

    }

    @Override
    public void deposit_Amount(double deposit_Amount) 
    {
        ministmt.put(deposit_Amount," Amount Deposited !!");
        System.out.println(deposit_Amount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+deposit_Amount);
        viewBalance();

    }

    @Override
    public void viewMiniStatement() 
    {
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }

    }
}

public class task3 
{
    public static void main(String[] args) {
        AtmOperationInterf op=new AtmOperationImpl();
        int atmnumber=987654;
        int atmpin=321123;

        Scanner in=new Scanner(System.in);
        System.out.println("Welcome to the ATM Interface System");
        System.out.print("Enter your Atm Number : ");
        int atmNumber=in.nextInt();
        System.out.print("Enter Pin: ");
        int pin=in.nextInt();

        if((atmnumber==atmNumber)&&(atmpin==pin))
        {
            while(true){
                System.out.println("1.View Available Balance\n2.View Withdraw Amount\n3.View Deposit Amount\n4.View Ministatement\n5.Exit");
                System.out.println("Enter your Choice : ");
                int ch=in.nextInt();
                if(ch==1){
                    op.viewBalance();

                }
                else if(ch==2){
                    System.out.println("Enter amount to withdraw ");
                    double withdrawAmount=in.nextDouble();
                    op.withdraw_Amount(withdrawAmount);

                }
                else if(ch==3){
                    System.out.println("Enter amount to Deposit :");
                    double depositAmount=in.nextDouble();
                    op.deposit_Amount(depositAmount);


                }
                else if(ch==4){
                    op.viewMiniStatement();

                }
                else if(ch==5){
                    System.out.println("Collect your ATM Card\n Thank you for using!!");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Please enter valid choice!!");
                }
            }
        }
        else{
            System.out.println("Incorrect Atm number or pin!!");
            System.exit(0);
        }


    }
}