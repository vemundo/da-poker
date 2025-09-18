package no.domstol.da.poker;

/**
 * Denne enumen representerer de fire fargene i en standard kortstokk.
 * @author vemund
 */
public enum Sort {
    HJERTER("\u2665"),
    SPAR("\u2660"),
    KLØVER("\u2663"),
    RUTER("\u2666");

    private final String symbol;
    private final boolean brukSymboler = Boolean.parseBoolean(System.getProperty("bruksymboler", "TRUE"));

    Sort(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return brukSymboler ? symbol : "-" + name();
    }
}
