package Proje7;


import Proje7.application.Customer;
import Proje7.repository.Database;
import Proje7.services.BankService;
import Proje7.services.BankServiceImpl;
import Proje7.services.CustomerService;
import Proje7.services.CustomerServiceImpl;


import java.util.Scanner;

public class Proje_07 {
    private static final BankService bankService = new BankServiceImpl();
    private static final CustomerService customerService = new CustomerServiceImpl();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Customer currentUser = customerService.login();
        while (true){
            System.out.println("Yapmak istediginiz islemi seciniz...");
            for (int i = 0; i < Database.actions.size(); i++) {
                System.out.println(Database.actions.get(i).getDescription()+ " - " + (i+1));
            }
            int userChoice = scan.nextInt();
            switch (userChoice){
                case 1: { bankService.addFunds(currentUser); break; }
                case 2: { bankService.withdrawMoney(currentUser); break; }
                case 3: { System.out.println("Bu islemi su an gerceklestiremiyoruz..."); break; }
                case 4: { bankService.createAccount(currentUser); break; }
                case 5: { bankService.freezeAccount(currentUser); break; }
                case 6: System.exit(1);
                default:{ System.out.println("Gecerli bir secim yapmadiniz...");}
            }
        }
    }

}
