public class Persons {

    Money balance = new Money();
    private double dif;

    public void withdraw(double amount){
        balance.withdraw(amount);
    }

    public void deposit(double amount){
         balance.deposit(amount);
    }
    public void checkBalance(){
        balance.checkAll();
    }

    public void buy(String payment, double price){
        if(payment == "wallet"){
            if(price <= balance.checkWallet()){
                balance.payWallet(price);
            }else if(price <= balance.checkBank()){
                dif = price - balance.checkWallet();
                balance.withdraw(dif);
                balance.payWallet(price);
            }else{
                System.out.println("Not enough balance!");
                System.out.println("------------------------------------------");
            }
        }else if(payment == "bank"){
            if(price <= balance.checkBank()){
                balance.payBank(price);
            }else if(price <= balance.checkWallet()){
                dif = price - balance.checkBank();
                balance.deposit(dif);
                balance.payBank(price);
            }else{
                System.out.println("Not enough balance!");
                System.out.println("------------------------------------------");
            }
        }
    }

    public void transfer(String account, Persons reciver, double amount){
        if(account == "bank"){
            reciver.balance.setBMoneyUp(amount);
            balance.setBMoneyDown(amount);
        }else if(account == "wallet"){
            reciver.balance.setWMoneyUp(amount);
            balance.setWMoneyDown(amount);
        }
    }
}
