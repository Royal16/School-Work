public class Money {
    private double personMoney;
    private double walletMoney = 50;
    private double moneyBank = 450;
    private double total = walletMoney + moneyBank;

    public void checkAll(){
        System.out.println("Wallet balance: " + walletMoney);
        System.out.println("Bank balance: " + moneyBank);
        System.out.println("Total balance: " + total);
        System.out.println("------------------------------------------");
    }
    public double checkWallet(){
        return walletMoney;
    }
    public double checkBank(){
        return moneyBank;
    }

    public void withdraw(double amount){
        if(amount <= checkBank()) {
            System.out.println("Withdrawing " + amount + " from the bank");
            this.moneyBank = this.moneyBank - amount;
            System.out.println("Recieving " + amount + " from the bank");
            this.personMoney = amount;
            this.walletMoney = this.walletMoney + personMoney;
            System.out.println("Money in hands: " + personMoney);
            personMoney = 0;
            this.total = walletMoney + moneyBank;
            System.out.println("Putting the money on the wallet");
            System.out.println("Money in hands: " + personMoney);
            System.out.println("New wallet balance: " + walletMoney);
            System.out.println("------------------------------------------");
        }else{
            System.out.println("Not enough balance!");
            System.out.println("------------------------------------------");
        }
    }

    public void deposit(double amount){
        if(amount <= checkWallet()) {
            System.out.println("Removing " + amount + " from the wallet");
            this.walletMoney = this.walletMoney - amount;
            this.personMoney = amount;
            System.out.println("Money in hands: " + personMoney);
            System.out.println("Depositing " + amount + " to the bank");
            this.moneyBank = this.moneyBank + personMoney;
            this.personMoney = 0;
            this.total = walletMoney + moneyBank;
            System.out.println("Money in hands: " + personMoney);
            System.out.println("New bank balance: " + moneyBank);
            System.out.println("------------------------------------------");
        }else{
            System.out.println("Not enough balance!");
            System.out.println("------------------------------------------");
        }
    }

    public void payWallet(double price){
        this.walletMoney = this.walletMoney - price;
        this.total = walletMoney + moneyBank;
    }

    public void payBank(double price){
        this.moneyBank = this.moneyBank - price;
        this.total = walletMoney + moneyBank;
    }

    public void setBMoneyDown(double amount){
        this.moneyBank = this.moneyBank - amount;
        this.total = this.moneyBank + this.walletMoney;
    }
    public void setBMoneyUp(double amount){
        this.moneyBank = this.moneyBank + amount;
        this.total = this.moneyBank + this.walletMoney;
    }

    public void setWMoneyDown(double amount){
        this.walletMoney = this.walletMoney + amount;
        this.total = this.moneyBank + this.walletMoney;
    }

    public void setWMoneyUp(double amount){
        this.walletMoney = this.walletMoney - amount;
        this.total = this.moneyBank + this.walletMoney;
    }
}
