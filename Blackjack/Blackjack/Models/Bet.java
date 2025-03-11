package Blackjack.Models;

public class Bet {
    int value;

    public Bet(int value) {
        this.value = value;
    }

    public void doubleBet()  {
        this.value = value * 2;
    }

    public int getValue() {
        return this.value;
    }

    public void display() {
        System.out.println("┌─────────┐");
        System.out.println("│         │");
        System.out.println("│" + centerValue() + "│");
        System.out.println("│         │");
        System.out.println("└─────────┘");
        System.out.println();
    }

    private String centerValue() {
        int requiredSize = 9;
        String text = String.valueOf(getValue());
        int padding = requiredSize - text.length();
        int left = padding / 2;
        int right = padding - left;
        return " ".repeat(left) + text + " ".repeat(right);
    }
}

