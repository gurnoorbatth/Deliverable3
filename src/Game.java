import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
/**
 * We have designed our Game According to the Actual War Game.
 * The game will continue to be played unless One of Player Looses All his cards to the other player.
 * We have Four Suits Starting from Suit 0 to Suit 3. Total 4 Suits.
 * We have Two players : Player 1 and Player 2
 * We have 13 Cards In each suit Starting from 0-12 Total Of 13 cards in each suit.
 * In each round Both players will throw a card without seeing it or Face Down. 
 * The player with the greater card rank will win the game and Take Both the cards.
 * If they got card of same rank There will be war where each player will throw three cards more each and at the end one player will win.
 * He will take all the cards.
 * The rounds Continued to be Played Until both players have cards.
 */

/**
 * All the Functionality of The game is Defined in this Class.  
 */
public class Game {
    private boolean print = false;
    private int num_of_players;

    /**
     * Default constructor.
     */
    public Game() {
    }

    public Game(boolean print) {
        this.print = print;
    }

    /**
     * @param num_Of_Suits  
     * @param num_Of_Ranks
     * @param number_Of_Players  
     */
    public void play(int num_Of_Suits, int num_Of_Ranks, int num_Of_Players) {
        GroupOfCards_Interface deck = new GroupOfCards();
        deck.create(num_Of_Suits, num_Of_Ranks);
        deck.shuffle_cards();
        
        Player[] players = divideCards(deck, num_Of_Players);

        int round = 0;
        while (checkPlayers(players)) {
            System.out.println(createRound(round++, players));
            singleRound(players);
        }
        System.out.println(createRound(round++, players));
    }

    private String createRound(int r_Number, Player[] players) {
        String r_String = "Playing Round Number " + r_Number + "\nPlayer 1[" + players[0].deckSize() + " Cards]";
        for (int i=1; i<players.length; i++) {
            r_String += "\nPlayer " + (i+1) + "[" + players[i].deckSize() + " Cards]";
        }
        return r_String;
    }

    /**
     * To check if There are Two Players.
     */
    boolean checkPlayers(Player[] players) {
        int num = 0;
        for (int i=0; i<players.length; i++) {
            if (players[i].deckSize() > 0) {
                num ++;
            }
        }
        return num > 1;
    }

    /**
     * Single Round Will be Played.
     */
    void singleRound(Player[] players) {
        
        Set<Integer> win_Players = new HashSet<Integer>();

        Set<Card> pot = new HashSet<Card>();

        while (true) {
            Card[] going_sub_round = new Card[players.length];
            for (int i=0; i<players.length; i++) {
                if (players[i].checkCards()) {
                    going_sub_round[i] = players[i].removeCard();
                } else {
                    going_sub_round[i] = null;
                }
            }

            win_Players.clear();
            Card win_Card = null;

            for (int i=0; i<going_sub_round.length; i++) {
                if (going_sub_round[i] == null) {
                    continue;
                }

                if (win_Card == null) {
                    win_Card = going_sub_round[i];
                    win_Players.add(i);
                    continue;
                }

                int compareResult = going_sub_round[i].compareTo(win_Card);
                if (compareResult > 0) {
                    win_Card = going_sub_round[i];
                    win_Players.clear();
                    win_Players.add(i);
                } else if (compareResult == 0) {
                    win_Players.add(i);
                }
            }

            if (print) {
                String cRound = "Player 1 Card :" + going_sub_round[0];
                for (int i=1; i<going_sub_round.length; i++) {
                    if (going_sub_round[i] != null) {
                        cRound += "\nPlayer " + (i+1) + " Card :" + going_sub_round[i];
                    }
                }
                System.out.println(cRound);
            }
            // Add current cards from the going round to the pot
            for (int i=0; i<going_sub_round.length; i++) {
                if (going_sub_round[i] != null) {
                    pot.add(going_sub_round[i]);
                }
            }

            if (win_Players.size() > 1) {
                // Add Face down cards to the pot
                if (print) {
                    System.out.println("********War********");
                }
                for (int i=0; i<players.length; i++) {
                    
                    if (players[i].checkCards()) {
                        pot.add(players[i].removeCard());
                    }
                }
            } else {
                break;
            }
        }

        if (win_Players.size() == 0) {  
            throw new Exception_Handling("Draw card game");
        }

        players[win_Players.iterator().next()].addCards(pot);
        System.out.println("*************************");
    }
    

    /**
     * Divides The Cards Into Two Players.
     */
    Player[] divideCards(GroupOfCards_Interface deck, int numberOfPlayers) {
        Player[] players = new Player[numberOfPlayers];
        for (int i=0; i<players.length; i++) {
            players[i] = new Player();
        }
        Card card;
        int cards_per_p = deck.num_of_Cards() / numberOfPlayers;
        int playerCounter = 0;

        for (int i=0; i<cards_per_p*numberOfPlayers; i++) {
            players[i%numberOfPlayers].addCard(deck.pick());
        }
        
        return players;
    }
}