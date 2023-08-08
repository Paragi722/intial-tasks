import java.util.Scanner;
import java.util.Random;
class Bank{
    Scanner key=new Scanner(System.in);
    Random re=new Random();
    int amount=0;
    int balance=0;
    int transac=0;
    int accno;
    
    boolean exit; //by default false
    
    public static void main(String[] args){
        Bank bank=new Bank();
        bank.runmenu();
    }
    public void runmenu(){
        printheader();
        while(!exit){
            printmenu();
            int choice=getinput();
            performaction(choice);
        }
    }
    private void printheader(){
        System.out.println("**************************************");
        System.out.println("*****Welcome to the Secure Banking*****");
        System.out.println("--------------------------------------");
    }
    private void printmenu(){
        System.out.println("!!!please choose the option bellow!!!!");
        System.out.println("1) Create an account");
        System.out.println("2) Withdrawal the amount");
        System.out.println("3) Deposit the amount");
        System.out.println("4) List the  balance details");
        System.out.println("0) Exit");
    }
    private int getinput(){
        int choice=-1;
        do{
            System.out.print("Enter your option:");
           try{
            choice=Integer.parseInt(key.nextLine());
        }
        catch(NumberFormatException e){
            System.out.println("please enter the number from the given option");
        }
        if(choice<0 || choice>4){
            System.out.println("please choose again");
        } 
        }while(choice<0 || choice>4);
        return choice;
    }
    private void performaction(int choice){
        switch(choice){
        case 0: System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"); 
        System.out.println("Thank you for using our banking application");
         System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"); 
                exit=true;
                break;
        case 1:createaccount();
                break;
        case 2:System.out.println("Enter the amount for withdrawal");
            amount=key.nextInt();
            withdrawamount(amount);
                break;
        case 3:System.out.println("Enter the amount for deposition");
            amount=key.nextInt();
            depositamount(amount);
                break;
        case 4:balancedetails(); 
                break;
        default:System.out.println("Incorrect option");
                break;    
        }
    }
    private void createaccount(){
        String Firstname,Lastname,SSn;
        String acctype=null;
        double initialdeposit=0;
        boolean v=false;
       
        while(!v){
        System.out.println("Enter the account type");
        acctype=key.nextLine();
        if(acctype.equalsIgnoreCase("checking") || acctype.equalsIgnoreCase("saving")){
            v=true;
        }
        else{
        System.out.println("please choose the following account type checking or saving");
        }
        }
        System.out.println("Enter your first name");
        Firstname=key.nextLine();
        System.out.println("Enter your last name");
        Lastname=key.nextLine();
        System.out.println("Enter the security number");
        SSn=key.nextLine();
        accno=re.nextInt(100000,100050);
        System.out.println("Your account number is:"+accno);
        

        v=false;
        while(!v){
            try{
                System.out.println("please deposit the initial amount");
                initialdeposit = Double.parseDouble(key.nextLine());
            }
            catch(NumberFormatException e){
                System.out.println("Enter a amount in numbers");
            }
            if(acctype.equalsIgnoreCase("checking")){
                if(initialdeposit<100){
                    System.out.println("please deposit the intial amount 100 or more");
                }
                else{
                    balance+=initialdeposit;
                    v=true;
                }
            }
            else{
                if(initialdeposit<50){
                    System.out.println("please deposit the intial amount 50 or more");
                }
                else{
                    balance += initialdeposit;
                    v=true;
                }
            }
        }
        
    }
    
    private void withdrawamount(int amount){
        if(amount>balance){
            System.out.println("your account doesn't have that much fund");
        }
        else{
            balance -= amount;
            System.out.println("After transaction the available balance in your account is:"+balance);
            System.out.println("_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_*_");
            System.out.println("");
            System.out.println("");
            transac=-amount;
        }
    }
    private void depositamount(int amount){
        if(amount<=0){
            System.out.println("please enter the sufficient amount");
        }
        else{
            balance += amount;
            System.out.println("Total balance :"+balance);
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println(" ");
            transac=amount;
        }
    }
    private void balancedetails(){
        if(transac<0){
            System.out.println("previously withdrawn:"+Math.abs(transac));
            System.out.println("");
            System.out.println("Total Balance:"+balance);
            System.out.println("#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=#=");
            System.out.println(" ");
        }
        else if(transac>0){
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("previously deposited:"+transac);
            System.out.println("");
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("");
            System.out.println("Total Balance = "+balance);
            System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=");
            System.out.println("");
            System.out.println("");
        }
        else{
            System.out.println("!!!!No transaction has ocurred !!!!");
        }
    }
}
