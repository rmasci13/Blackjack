package Blackjack.Models;

public class Player extends Person {
    private int balance;

    public Player(int balance) {
        super(true);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void updateBalance(int change) {
        this.balance = balance + change;
    }
}
