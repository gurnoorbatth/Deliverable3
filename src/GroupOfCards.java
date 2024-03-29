import java.util.ArrayList;
import java.util.Collections;

/**
 * A deck of cards suitable for the game of war.  
 */
public class GroupOfCards implements GroupOfCards_Interface {
  private ArrayList<Card> cards = null;

  /**
   * Initialize a deck of cards with numberOfSuits suits, numberOfRanks ranks.
   * @param numberOfSuits The number of suits with which to initialize this deck.
   * @param numberOfRanks The number of ranks with which to initialize this deck.
   */
  public void create( int numberOfSuits, int numberOfRanks ) {
    this.cards = new ArrayList<Card>();

    for (int i=0; i<numberOfSuits; i++) {
      Suit_Interface suit = new Suit("Suit" + i);
      for (int j=0; j<numberOfRanks; j++) {
        Rank_Interface rank = new Rank(j);
        cards.add(new Card(rank, suit));
      }
    }
  }

  /**
   * Shuffle the initialized deck of cards.  
   */
  public void shuffle_cards() {
    if (cards == null) {
      throw new RuntimeException("create() must be called first");
    }
    Collections.shuffle(this.cards);
  }

  /**
   * Since the given interface definition did not define the semantics of the deal() method, and
   * there is no way to determine the number of cards in the deck (nor whether the deck has cards)
   * we will return null if the deck is out of cards.  
   */
  public Card pick() {
    if (this.cards == null) {
      throw new RuntimeException("create() must be called first");
    }
    if (cards.size() == 0) {
      return null;
    }
    return cards.remove(0);
  }

  /**
   * Returns the number of cards in this deck.
   * @return The number of cards in this deck.
   */
  public int num_of_Cards() {
    return cards.size();
  }
}
