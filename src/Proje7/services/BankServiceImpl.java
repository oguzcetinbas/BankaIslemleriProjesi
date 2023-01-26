package Proje7.services;


import Proje7.application.Account;
import Proje7.application.Customer;

public class BankServiceImpl extends AbstractService implements BankService{
    @Override
    public void addFunds(Customer currentUser) {
        Account chosenAccount;
        while (true){
            System.out.println("Lutfen para yatirmak istediginiz hesap numarasini giriniz...: ");
            for (Account account : currentUser.getAccounts()) {
                System.out.println(account.getNumber());
            }
            String chosen = scan.next();
            chosenAccount = currentUser.confirmAccountNumber(chosen);
            if (chosenAccount == null) {
                System.out.println("Hatali hesap numarasi girdiniz...");
                continue;
            } else if (!chosenAccount.isActive) {
                continue;
            }
            break;
        }
        System.out.println("Lutfen yatirilacak para miktarini giriniz...: ");
        int amountToAdd = scan.nextInt();
        chosenAccount.addFunds(amountToAdd);
    }

    @Override
    public void withdrawMoney(Customer currentUser) {
        while (true){
            System.out.println("Lutfen para cekmek istediginiz hesap numarasini giriniz...: ");
            for (Account account : currentUser.getAccounts()) {
                System.out.println(account.getNumber());
            }
            String chosen = scan.next();
            Account chosenAccount = currentUser.confirmAccountNumber(chosen);
            if (chosenAccount == null) {
                System.out.println("Hatali hesap numarasi girdiniz...");
                continue;
            } else if (!chosenAccount.isActive) {
                continue;
            }
            System.out.println("Lutfen cekmek istediginiz para miktarini giriniz...: ");
            int amountToWithdraw = scan.nextInt();
            if (chosenAccount.withdraw(amountToWithdraw)) break;
        }

    }

    @Override
    public void createAccount(Customer currentUser) {
        System.out.println("Yeni hesap acma islemini onayliyor musunuz?.. Y / N");
        String secim = scan.next();
        if (secim.equalsIgnoreCase("y")){
            System.out.println("Hesap turunuzu seciniz, Yatirim hesabi icin - 1, Vadesiz Hesap icin - 2 yi tuslayin ");
            int hesapTuru = scan.nextInt();
            System.out.println("Hesabiniz basari ile olusturulmustur... Hesap No :"+ currentUser.createAccount(hesapTuru));

        }
        System.out.println("Gecerli bir secim yapmadiniz...");
    }

    @Override
    public void freezeAccount(Customer currentUser) {
        System.out.println("Lutfen dondurmak istediginiz hesap numarasini giriniz...: ");
        for (Account account : currentUser.getAccounts()) {
            System.out.println(account.getNumber());
        }
        String chosen = scan.next();
        Account chosenAccount = currentUser.confirmAccountNumber(chosen);
        if (chosenAccount == null) {
            System.out.println("Hatali hesap numarasi girdiniz...");

        } else if (!chosenAccount.isActive) {
            System.out.println("Bu hesap zaten dondurulmustur...");

        }
        chosenAccount.freeze();
    }


}
