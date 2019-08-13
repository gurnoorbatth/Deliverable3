/**
 * Rank Of Cards are Created Using This Interface.  
 */
public interface Rank_Interface {
    /**
     * Getting the Integer Value Of the Card.  
     */
    public int getValue();

    /**
     * Compare The ranks of cards.    
     */
    public int compareTo(Rank_Interface other);
}
