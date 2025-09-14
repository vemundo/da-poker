package no.domstol.da.poker;

/**
 *
 * @author vemund
 */
public record Kort(Sort sort, Verdi verdi) implements Comparable<Kort>{

    @Override
    public String toString() {
        return verdi.toString() + sort;
    }

    @Override
    public int compareTo(Kort kort) {
        int verdiDiff = verdi.getRangering() - kort.verdi.getRangering();
        int retur = verdiDiff == 0 ? sort.ordinal() - kort.sort.ordinal() : verdiDiff;
        return retur;
    }
}
