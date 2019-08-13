class Rank implements Rank_Interface {
    private final int rank_num;

    /**
     * Constructor.
     * @param rank
     */
    Rank(int rank) {
        this.rank_num = rank;
    }

    /**
     * @return Integer Value Rank of card.
     */
    @Override
    public int getValue() {
        return rank_num;
    }


    /**
     * @return String.
     */
    @Override
    public String toString() {
        return "" + rank_num;
    }

    /**
     * Tests equality with another object.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Rank_Interface)) {
            return false;
        }
        Rank_Interface otherRank = (Rank_Interface) other;
        return rank_num == otherRank.getValue();
    }
    
    /**
     * Compare the ranks of the cards.
     */
    @Override
    public int compareTo(Rank_Interface other_card) {
        if (rank_num == other_card.getValue()) {
            return 0;
        }
        if (rank_num < other_card.getValue()) {
            return -1;
        }
        return 1;
    }
}