package Proje7.services;


import Proje7.application.Account;
import Proje7.application.Customer;

import Proje7.repository.Database;

import java.util.Scanner;

public class CustomerServiceImpl extends AbstractService implements CustomerService{
    @Override
    public Customer login() {
        Scanner scan = new Scanner(System.in);


        Customer currentUser;
        Account chosenAccount;



        while (true){
            System.out.println("Please enter your username: ");
            String username = scan.nextLine();
            System.out.println("Please enter your password: ");
            String password = scan.nextLine();

            currentUser = Database.confirmUsernameAndPassword(username, password);
            if ( currentUser != null ){
                System.out.println("Basarili bir sekilde giris yaptiniz");
                break;
            }
            System.out.println("Sistemde kayitli boyle bir kullanici bulunamadi.. Tekrar deneyin");
        }


        return currentUser;
    }


}
