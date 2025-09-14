package no.domstol.da.poker;

/**
 *
 * @author vemund
 */
public enum Verdi {
    TO(2, "2"),
    TRE(3, "3"),
    FIRE(4, "4"),
    FEM(5, "5"),
    SEKS(6, "6"),
    SJU(7, "7"),
    ÅTTE(8, "8"),
    NI(9, "9"),
    TI(10, "10"),
    KNEKT(11, "J"),
    DAME(12, "Q"),
    KONGE(13, "K"),
    ESS(14, "A");

    private final int rangering;
    private final String symbol;

    Verdi(int rangering, String symbol) {
        this.rangering = rangering;
        this.symbol = symbol;
    }

    public int getRangering() {
        return rangering;
    }

    @Override
    public String toString() {
        return symbol;
    }

}   
