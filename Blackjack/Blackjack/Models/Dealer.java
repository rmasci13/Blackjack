package Blackjack.Models;

public class Dealer extends Person {
    public Dealer() {
        super(false);
    }

    @Override
    public void displayHand() {
        System.out.println("Dealer's hand is: ");
        super.displayHand();
    }

    public void displayHiddenHand() {
        System.out.println("Dealer's hand is: ");
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).displayTop();
        }
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            if (i == 0) {
                hand.get(i).displayEmpty();
            }
            else {
                hand.get(i).displayTopFace();
            }
        }
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).displayEmpty();
        }
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            if (i == 0) {
                hand.get(i).displayEmpty();
            }
            else {
                hand.get(i).displaySuit();
            }
        }
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).displayEmpty();
        }
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            if (i == 0) {
                hand.get(i).displayEmpty();
            }
            else {
                hand.get(i).displayBottomFace();
            }
        }
        System.out.println();
        for (int i = 0; i < hand.size(); i++) {
            hand.get(i).displayBottom();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
