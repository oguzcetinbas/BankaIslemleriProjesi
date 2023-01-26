package Proje7.repository;

import Proje7.application.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {



    // Banka Islemleri Listesi tanimlaydık..."Para_Yatir", "Para_Cek", "Transfer", "Hesap_Ac"...
    private static Action action1 = new Action("Para_Yatir");
    private static Action action2 = new Action("Para_Cek");
    private static Action action3 = new Action("Transfer");
    private static Action action4 = new Action("Hesap Ac");
    private static Action action5 = new Action("Hesap Dondur");
    private static Action action6 = new Action("Cikis");
    public static List<Action> actions = new ArrayList<>(Arrays.asList(action1,action2,action3,action4,action5, action6));


    // Hesap Numaralari
    private static Account user_1_account1 = new SavingAccount(1234, 200);
    private static Account user_1_account2 = new CheckingAccount(4321, 20);
    private static Account user_2_account1 = new SavingAccount(5678, 1000);
    private static Account user_2_account2 = new CheckingAccount(8765, 100);
    private static Account user_3_account1 = new SavingAccount(9999, 5000);
    private static Account user_3_account2 = new CheckingAccount(1111, 500);



    // Banka musterileri kullanici adi listesi tanimladık..."User1", "User2", "User3"...
    private static Customer customer1 = new Customer("User1", "password1", new ArrayList<>(Arrays.asList(user_1_account1,user_1_account2)));
    private static Customer customer2 = new Customer("User2", "password2", new ArrayList<>(Arrays.asList(user_2_account1, user_2_account2)));
    private static Customer customer3 = new Customer("User3", "password3", new ArrayList<>(Arrays.asList(user_3_account1, user_3_account2)));
    public static List<Customer> customers = new ArrayList<>(Arrays.asList(customer1,customer2,customer3));



    // ------------------------------- Methods --------------------------------------------------------------
    public static Customer confirmUsernameAndPassword(String username, String password) {

        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getUserName().equals(username) && customers.get(i).getPassword().equals(password)){
                return customers.get(i);
            }
        }
        return null;
    }





}
