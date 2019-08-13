/**
 * Creating and Getting A Card.
 */
public class Card {
    private final Rank_Interface rank;
    private final Suit_Interface suit;

    /**
     * Constructor,Rank and Suit are passed in the Card.
     * @param rank 
     * @param suit   
     */
    public Card(Rank_Interface rank, Suit_Interface suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Represents the Card in the Form of String.
     * @return String.  
     */
    @Override
    public String toString() {
        return "Card" + rank.toString() + " of " + suit.toString();
    }

    /**
     * Compares The Two Cards.  
     */
    public int compareTo(Card cards) {
        return this.rank.compareTo(cards.rank);
    }
    
    /**
     * Two cards as equal only When their ranks and suits are equal.  
     * @param other
     * @return true if the cards are equal else it will return false.  
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Card)) {
            return false;
        }
        Card otherCard = (Card) other;
        return this.rank.equals(otherCard.rank) && this.suit.equals(otherCard.suit);
    }
}
