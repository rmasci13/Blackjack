package Blackjack;

import Blackjack.Models.*;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(100, 1);
        game.playGame();
    }


    /*
     * To Compile -------->  javac -d Blackjack/Out Blackjack/Models/*.java Blackjack/Main.java
     * To Run     -------->  java -cp Blackjack/out Blackjack.Main
     */
        
}
