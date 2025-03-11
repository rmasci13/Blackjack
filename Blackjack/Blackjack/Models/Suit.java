package Blackjack.Models;

public enum Suit {
    DIAMONDS('\u2666'),
    HEARTS('♥'),
    SPADES('♠'),
    CLUBS('♣');

    final char rep;

    Suit(char rep) {
        this.rep = rep;
    }
}
