package no.domstol.da.poker;

/**
 * Denne enumen representerer verdiene i en standard kortstokk.
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

    private final int tall;
    private final String symbol;

    Verdi(int tall, String symbol) {
        this.tall = tall;
        this.symbol = symbol;
    }

    public int getTall() {
        return tall;
    }

    @Override
    public String toString() {
        return symbol;
    }

}   
