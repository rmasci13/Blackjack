package Blackjack.Models;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private int numDecks;
    private Stack<Card> deck;

    Deck(int numDecks) {
        this.numDecks = numDecks;
        this.deck = new Stack<>();
        populateDeck();
    }

    //Public function to populate deck with sets of 52 cards and then shuffle them
    public void populateDeck() {
        deck.clear(); //Clear deck first to ensure empty
        for (int i = 0; i < numDecks; i++) { //One loop adds 52 unique cards, looping number of times user wants decks in the game
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
        shuffleDeck();
    }

    public void displayCards() {
        for (Card c : deck) {
            c.display();
        }
    }

    public Stack<Card> getDeck() {
        return deck;
    }

    private void shuffleDeck() {
        Collections.shuffle(deck);
    }
}
