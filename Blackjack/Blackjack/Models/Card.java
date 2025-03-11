package Blackjack.Models;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public char getSuit() {
        return suit.rep;
    }

    public int getRankValue() {
        return rank.value;
    }

    public String getRankString() {
        return rank.face;
    }

    //This wont work as is, cards need to be in a row
    public void display() {
        System.out.println("┌─────────┐");
        if (rank == Rank.TEN) {
            System.out.println("│ " + getRankString() + "      │");
        }
        else {
            System.out.println("│ " + getRankString() + "       │");
        }
        System.out.println("│         │");
        System.out.println("│    " + getSuit() + "    │");
        System.out.println("│         │");
        if (rank == Rank.TEN) {
            System.out.println("│      " + getRankString() + " │");
        }
        else {
            System.out.println("│       " + getRankString() + " │");
        }
        System.out.println("└─────────┘");
    }

    public void displayTop() {
        System.out.print(" ┌─────────┐ ");
    }

    public void displayTopFace() {
        if (getRankString().length() > 1) {
            System.out.print(" │ " + getRankString() + "      │ ");
        }
        else {
            System.out.print(" │ " + getRankString() + "       │ ");
        }
    }

    public void displayEmpty() {
        System.out.print(" │         │ ");
    }

    public void displaySuit() {
        System.out.print(" │    " + getSuit() + "    │ ");
    }
    public void displayBottomFace() {
        if (getRankString().length() > 1) {
            System.out.print(" │      " + getRankString() + " │ ");
        }
        else {
            System.out.print(" │       " + getRankString() + " │ ");
        }
    }

    public void displayBottom() {
        System.out.print(" └─────────┘ ");
    }


}
