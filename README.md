# Java Blackjack Game

A command-line implementation of the classic casino card game Blackjack.

## Description

This Java application simulates a Blackjack game where a player competes against a dealer. The game follows standard Blackjack rules, including options to hit, stand, and double down. The game keeps track of the player's balance, allowing for multiple rounds of play until the player runs out of funds.

## Features

- Play Blackjack against a computer dealer
- Multiple decks support (configurable)
- Player actions: Hit, Stand, and Double Down
- Starting balance customization
- Automatic deck shuffling when 65% of cards have been dealt
- Blackjack detection with 3:2 payout
- User-friendly command-line interface

## Installation

1. Ensure you have Java Development Kit (JDK) installed on your system.
2. Clone this repository or download the source code.
3. Navigate to the project directory.
4. Compile the Java files:
   ```
   javac -d Blackjack/Out Blackjack/Models/*.java Blackjack/Main.java
   ```

## Usage

Run the game using the following command:

```
java -cp Blackjack/out Blackjack.Main
```

### Game Rules

- The goal is to get a hand value closer to 21 than the dealer without exceeding 21.
- Card values:
  - Number cards (2-10): Face value
  - Face cards (Jack, Queen, King): 10 points
  - Ace: 1 or 11 points (whichever benefits the hand more)
- If a player gets 21 with just two cards (an Ace and a 10-value card), they have a "Blackjack" and receive a 3:2 payout.
- The dealer must hit until they have at least 17 points.
- If the player's hand exceeds 21, they "bust" and lose the bet.
- If the dealer busts, the player wins.
- If neither busts, the higher hand value wins.

### Player Actions

1. **Hit**: Take another card
2. **Stand**: End your turn with your current hand
3. **Double Down**: Double your bet, take exactly one more card, and end your turn (only available on your first two cards)

## Class Structure

- **Game**: Main game controller that manages the flow of the game
- **Deck**: Represents a deck (or multiple decks) of playing cards
- **Card**: Represents a single playing card
- **Person**: Abstract class for both Player and Dealer
- **Player**: Represents the user with balance management
- **Dealer**: Represents the computer dealer
- **Bet**: Handles bet amounts and operations

## Configuration

You can customize the game by modifying the initial parameters when creating a `Game` object:

```java
// Default: 100 chips starting balance, with specified number of decks
Game game = new Game(numDecks);

// Custom: Specify both starting balance and number of decks
Game game = new Game(startingBalance, numDecks);
```

## Future Enhancements

Potential features for future versions:
- Split pairs functionality
- Insurance bets
- Surrender option
- Multiple player support
- Graphical user interface

## Acknowledgments

This project was created as a programming exercise to demonstrate object-oriented programming concepts in Java.
