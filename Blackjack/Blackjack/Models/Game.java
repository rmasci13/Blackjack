package Blackjack.Models;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Scanner in = new Scanner(System.in);
    private Dealer dealer;
    private Player user;
    private int startingBalance;
    private int numDecks;
    private int dealtCards;
    private Deck deck;
    private Bet currentBet;

    //-------------------------------------------------------------------------Constructors------------------------------------------------------------------- 
    public Game(int numDecks) {
        this.startingBalance = 100;
        this.numDecks = numDecks;
        this.deck = new Deck(numDecks);
        this.user = new Player(100);
        this.dealer = new Dealer();
        this.dealtCards = 0;
    }

    public Game(int startingBalance, int numDecks) {
        this.startingBalance = startingBalance;
        this.numDecks = numDecks;
        this.deck = new Deck(numDecks);
        this.user = new Player(startingBalance);
        this.dealer = new Dealer();
        this.dealtCards = 0;
    }

//-----------------------------------------------------------------------Public Operational Methods-------------------------------------------------------

//-------Getters & Setters--------
    public Deck getDeck() {
        return deck;
    }

    public Person getPlayer() {
        return this.user;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public void setBet(Bet bet) {
        this.currentBet = bet;
    }

//----------Game Methods----------
    public void playGame() {
        while (true) {
            // If player balance is empty, end loop
            if (user.getBalance() <= 0) {
                System.out.println("Better luck next time");
                break;
            }
            // Shuffle if used over 3/4 of the deck
            if (dealtCards > (deck.getDeck().size() * 3) / 4) {
                System.out.println("The deck has been shuffled");
                resetDeck();
                dealtCards = 0;
            }
            playRound();
        }
    }

//-------------------------------------------------------------------Private Methods--------------------------------------------------    
    private void resetDeck() {
        this.deck = new Deck(numDecks);
    }

    private void dealCard(Person person) {
        Card topCard = deck.getDeck().pop();
        person.addCard(topCard);
        dealtCards++;
    }

    private void playRound() {
        System.out.println("Your balance: " + user.getBalance());
        int betValue = getInitialBet();
        user.updateBalance(-betValue);
        Bet bet = new Bet(betValue);
        setBet(bet);
        dealInitialHands();
        if (user.getHandValue() == 21) {
            handleBlackjack();
        } 
        else {
            moveLoop();
            dealerMoves();
            determineWinner();
        }
        resetHands();
    }

    private int getInitialBet() {
        while (true) {
            System.out.print("Enter initial bet value: ");
            try {
                int input = in.nextInt();
                in.nextLine();
                if (input > user.getBalance()) {
                    System.out.println("Invalid input. Bet exceeds balance.");
                } 
                else {
                    return input;
                } 
            } 
            catch (InputMismatchException e) {
                System.out.println("Please enter an integer value to bet");
                System.out.println();
                in.nextLine();
            }
        }
    }

    private void displayHiddenGame() {
        dealer.displayHiddenHand();
        currentBet.display();
        user.displayHand();
        System.out.println("You have " + user.getHandValue());
    }

    private void displayFullGame() {
        dealer.displayHand();
        currentBet.display();
        user.displayHand();
    }

    private void dealInitialHands() {
        dealCard(user);
        dealCard(dealer);
        dealCard(user);
        dealCard(dealer);
        displayHiddenGame();
    }

    private void moveLoop() {
        boolean keepGoing = true;
        while (keepGoing) {
            int choice = getUserMove();
            switch (choice) {
                case 1:
                    dealCard(user);
                    if (user.getHandValue() > 21) {
                        keepGoing = false;
                        break;
                    }
                    displayHiddenGame();
                    break;
                case 2:
                    keepGoing = false;
                    break;
                case 3:
                    user.updateBalance(-currentBet.getValue());
                    currentBet.doubleBet();
                    dealCard(user);
                    keepGoing = false;
                    break;
                default:
                    break;
            }
        }
    }

    private int getUserMove() {
        int input;
        while (true) {
            List<Card> hand = user.getHand();
            System.out.println("Choose your move from the following: ");
            System.out.println("1. Hit");
            System.out.println("2. Stand");
            if (validDouble(hand)) {
                System.out.println("3. Double");
            }
            try {
                input = in.nextInt();
                in.nextLine();
                if (input < 1 || input > 3 || (!validDouble(hand) && input == 3)) {
                    System.out.println("Invalid input. Please choose from presented choices");
                } 
                else {
                    return input;
                }
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please choose from presented choices");
                in.nextLine();
            }
        }
    }

    private boolean validDouble(List<Card> hand) {
        return currentBet.getValue() < user.getBalance() * 2 && hand.size() == 2;
    }
    
    private boolean validSplit(List<Card> hand) {
        return currentBet.getValue() < user.getBalance() * 2 && hand.size() == 2 && hand.get(0).getRankValue() == hand.get(1).getRankValue();
    }
   
    private boolean userWinCheck() {
        return user.getHandValue() <= 21 && user.getHandValue() > dealer.getHandValue();
    }

    private void dealerMoves() {
        while (dealer.getHandValue() < 17) {
            dealCard(dealer);
        }
        displayFullGame();
    }

    private void handleBlackjack() {
        if (dealer.getHandValue() != 21) {
            System.out.println("Blackjack! Congratulations you won " + (currentBet.getValue() + (currentBet.getValue() * 3) / 2) + " chips!");
            user.updateBalance(currentBet.getValue() + (currentBet.getValue() * 3) / 2);
        } 
        else {
            System.out.println("Sorry you pushed. Unlucky!");
            user.updateBalance(currentBet.getValue());
        }
    }

    private void determineWinner() {
        if (dealer.getHandValue() > 21 || userWinCheck()) {
            System.out.println("Congratulations! You won " + currentBet.getValue() * 2 + " chips!");
            user.updateBalance(currentBet.getValue() * 2);
        } 
        else if (user.getHandValue() == dealer.getHandValue()) {
            System.out.println("Tie! Here's your " + currentBet.getValue() + " chips back!");
            user.updateBalance(currentBet.getValue());
        } 
        else {
            if (user.getHandValue() > 21) {
                System.out.println("You busted! Better luck next game!");
            } 
            else {
                System.out.println("Dealer wins with a " + dealer.getHandValue() + " against your " + user.getHandValue());
            }
        }
    }

    private void resetHands() {
        user.resetHand();
        dealer.resetHand();
    }
}
