
class Suit implements Suit_Interface {

    private final String suitname;

    /**
     * Constructor.
     *
     * @param name.
     */
    Suit(String name) {
        this.suitname = name;
    }

    /**
     * Getter to return the name of suit.
     */
    @Override
    public String getName() {
        return suitname;
    }

    /**
     * @return Convert suit to the String and returns it.
     */
    @Override
    public String toString() {
        return suitname;
    }

    /**
     * Tests equality of this suit with another object.
     *
     * @param obj
     */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Suit_Interface)) {
            return false;
        }
        Suit_Interface otherSuit = (Suit_Interface) obj;
        return suitname.equals(otherSuit.getName());
    }

}
