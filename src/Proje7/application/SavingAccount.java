package Proje7.application;

import java.time.LocalDate;

public class SavingAccount extends Account {

    public LocalDate savingStartTime;


    public SavingAccount(int number, int funds) {
        super(number, funds);
        savingStartTime = LocalDate.now();
    }

    @Override
    public boolean withdraw(int amountToWithdraw) {
        if (!LocalDate.now().isAfter(savingStartTime.plusYears(1))){
            System.out.println("Yatirim hesabinizdan 1 yildan once para cekemezsiniz, lutfen banka yetkilimizle temasa geciniz...");
            return false;
        } else if (funds < amountToWithdraw){
            System.out.println("Hesabinizda yeterli bakiye bulunmamaktadir...");
            return false;
        }
        this.setFunds(funds - amountToWithdraw);
        System.out.println("Lutfen paranizi aliniz, hesabinizda toplam "+funds+" euro kalmistir...");
        return true;
    }


}
