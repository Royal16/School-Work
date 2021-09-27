public class Main {

    public static void main (String[] args){

        Persons person = new Persons();
        Persons person2 = new Persons();

        person.transfer("bank", person2, 100);
        person.checkBalance();
        person2.checkBalance();



    }

}
