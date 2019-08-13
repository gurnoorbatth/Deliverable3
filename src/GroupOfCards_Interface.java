/**
 * Interface for a GroupOfCards means Deck.
 */
public interface GroupOfCards_Interface {
  /* Create the Deck*/
  public void create(int numberOfSuits, int numberOfRanks);

  /* Shuffle the Cards */
  public void shuffle_cards();

  /* Count the Number Of Car */
  public int num_of_Cards();
  
  /* Pick A Card From The Deck */
  public Card pick();
}
