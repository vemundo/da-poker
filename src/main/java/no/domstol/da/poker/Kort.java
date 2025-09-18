package no.domstol.da.poker;

/**
 * Denne klassen representerer et enkelt kort i en standard kortstokk. 
 * Kortet består av en farge (sort) og en verdi og kan sammenlignes med andre kort.
 * @author vemund
 */
public record Kort(Sort sort, Verdi verdi) implements Comparable<Kort>{

    @Override
    public String toString() {
        return verdi.toString() + sort;
    }

    @Override
    public int compareTo(Kort kort) {
        int verdiDiff = verdi.getTall() - kort.verdi.getTall();
        int retur = verdiDiff == 0 ? sort.ordinal() - kort.sort.ordinal() : verdiDiff;
        return retur;
    }
}
