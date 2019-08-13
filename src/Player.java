import java.util.LinkedList;
import java.util.Set;

class Player {
    /**
     * A List Of All The Cards a Player Has.
     */
    private LinkedList<Card> list = new LinkedList<Card>();

    /**
     * Adding Cards to the Player.
     */
    public void addCard(Card card) {
        list.add(card);
    }

    /**
     * Add Set of Cards to The player.
     */
    public void addCards(Set<Card> cards) {
        list.addAll(cards);
    }

    /**
     * Get Single Card From the Cards A Player Has.
     */
    public Card removeCard() {
        return list.removeFirst();
    }

    /**
     * Count The Number Of cards left To a Player.
     */
    public int deckSize() {
        return list.size();
    }

    /**
     * Check If Player Has Cards Left or Not.
     */
    public boolean checkCards() {
        return list.size() > 0;
    }

    /**
     * @return String
     */
    @Override
    public String toString() {
        String rv = list.get(0).toString();
        for (int i=1; i<list.size(); i++) {
            rv += "," + list.get(i).toString();
        }
        return rv;
    }
}