package no.domstol.da.poker;

/**
 *
 * @author vemund
 */
public enum Sort {
    HJERTER("\u2665"),
    SPAR("\u2660"),
    KLØVER("\u2663"),
    RUTER("\u2666");

    private final String symbol;

    Sort(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
