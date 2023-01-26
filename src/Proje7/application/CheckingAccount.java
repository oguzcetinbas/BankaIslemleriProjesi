package Proje7.application;

public class CheckingAccount extends Account {


    public CheckingAccount(int number, int funds) {
        super(number, funds);
    }

    @Override
    public boolean withdraw(int amountToWithdraw ) {

        if (funds < amountToWithdraw){
            System.out.println("Hesabinizda yeterli bakiye bulunmamaktadir...");
            return false;
        }
        this.setFunds(funds - amountToWithdraw);
        System.out.println("Lutfen paranizi aliniz, hesabinizda toplam "+funds+" euro kalmistir...");
        return true;
    }
}
