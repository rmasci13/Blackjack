package Blackjack.Models;

import java.util.ArrayList;
import java.util.List;

public abstract class Person {
    protected boolean isHuman;
    protected List<Card> hand;
    protected int handValue;

    Person(boolean isHuman) {
        this.isHuman = isHuman;
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return this.hand;
    }

    public int getHandValue() {
        calculateHandValue();
        return handValue;
    }

    public void addCard(Card nextCard) {
        hand.add(nextCard);
    }

    public void resetHand() {
        hand.clear();
    }

    public void displayHand() {
        System.out.println();
        for (Card c : hand) {
            c.displayTop();
        }
        System.out.println();
        for (Card c : hand) {
            c.displayTopFace();
        }
        System.out.println();
        for (Card c : hand) {
            c.displayEmpty();
        }
        System.out.println();
        for (Card c : hand) {
            c.displaySuit();
        }
        System.out.println();
        for (Card c : hand) {
            c.displayEmpty();
        }
        System.out.println();
        for (Card c : hand) {
            c.displayBottomFace();
        }
        System.out.println();
        for (Card c : hand) {
            c.displayBottom();
        }
        System.out.println();
        System.out.println();
    }

    private void calculateHandValue() {
        int nonAce = 0;
        int aces = 0;
        //Calculate the total value of the non-Ace cards first so we can more accurately determine if any Aces present should be 11 or 1
        for (Card c : hand) {
            int current = c.getRankValue();
            if (current < 11) {
                nonAce += current;
            }
            else {
                aces++;
            }
        }
        //If there's aces present, if adding 11 would exceed 11 then only add 1, otherwise add 11
        int remaining = aces;
        for (int i = 0; i < aces; i++) {
            if (remaining == 1 && nonAce + 11 <= 21) {
                nonAce += 11;
                remaining--;
            }
            else {
                nonAce++;
                remaining--;
            }
        }
        handValue = nonAce;
    }
}
