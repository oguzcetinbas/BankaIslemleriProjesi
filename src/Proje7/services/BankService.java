package Proje7.services;


import Proje7.application.Customer;

public interface BankService {
    void addFunds(Customer currentUser);

    void withdrawMoney(Customer currentUser);

    void createAccount(Customer currentUser);

    void freezeAccount(Customer currentUser);

    // Bu Interface de govdesiz methodlar tanimlandı
    // Bu methodlarin govdesi bu interface i implement eden sinifta tanimlandı

}
