package Proje7.application;

public abstract class Account implements Freezable {

    protected int number;
    protected int funds;
    public boolean isActive;


    // ------------------------------- Constructor ----------------------------------------------------

    public Account(int number, int funds) {
        this.number = number;
        this.funds = funds;
        this.isActive = true;
    }

    // ------------------------------- Methods --------------------------------------------------------------

    public abstract boolean withdraw(int amountToWithdraw );

    public void addFunds(int amountToAdd){
        this.funds += amountToAdd;
    }

    @Override
    public void freeze() {
        this.isActive = false;
    }

    // ------------------------------- Getters and Setters ----------------------------------------------------

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        // Encapsulation ile field lerimi koruma altina aliyorum...
        this.funds = funds;
    }
}
