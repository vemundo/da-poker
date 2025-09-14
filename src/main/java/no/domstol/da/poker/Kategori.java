package no.domstol.da.poker;

/**
 *
 * @author vemun
 */
public enum Kategori {
    INGEN_PAR(1),
    PAR(2),
    TO_PAR(3),
    TRE_LIKE(4),
    STRAIGHT(5),
    FLUSH(6),
    FULLT_HUS(7),
    FIRE_LIKE(8),
    STRAIGHT_FLUSH(9);

    private final int rangering;

    Kategori(int rangering) {
        this.rangering = rangering;
    }

    public int getRangering() {
        return rangering;
    }
}
