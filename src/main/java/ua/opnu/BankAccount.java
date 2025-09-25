package ua.opnu;

public class BankAccount {
    String Andrew;
    double balance;
    double transactionFee = 0.0; // комісія за зняття/переказ

    // покласти гроші
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // отримати баланс
    double getBalance() {
        return balance;
    }

    // зняти гроші
    boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            return true;
        }
        return false;
    }

    // переказ грошей іншому рахунку
    boolean transfer(BankAccount receiver, double amount) {
        if (amount > 0 && balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            receiver.deposit(amount);
            return true;
        }
        return false;
    }
}
