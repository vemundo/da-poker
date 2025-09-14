package no.domstol.da.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author vemund
 */
public final class Hand implements Comparable<Hand>{

    public static final int ANTALL_KORT = 5;

    private final SortedSet<Kort> kortHand = new TreeSet<>();
    private Map<Verdi, Long> mapVerdiTilAntall;
    private final Map<Integer, List<Verdi>> mapAntallTilVerdier = new HashMap<>();;

    private final Kategori kategori;

    public Hand(Kortstokk stokk) throws Exception {
        for (int i=0 ; i<ANTALL_KORT ; i++) {
            kortHand.add(stokk.trekkKort());
        }
        kategori = evaluerHand();
    }

    /**
     * For testing
     */
    Hand(Kort kort1, Kort kort2, Kort kort3, Kort kort4, Kort kort5) throws Exception {
        kortHand.add(kort1);
        kortHand.add(kort2);
        kortHand.add(kort3);
        kortHand.add(kort4);
        kortHand.add(kort5);
        kategori = evaluerHand();
    }

    private Kategori evaluerHand() throws Exception {
        if (kortHand.size() != ANTALL_KORT) {
            throw new Exception("Feil antall kort for en pokerhand. Har " 
            + kortHand.size() + " kort men forventet " + ANTALL_KORT);
        }
        boolean flush = isFlush();
        boolean straight = isStraight();
        mapVerdiTilAntall = kortHand.stream().collect(Collectors.groupingBy(Kort::verdi,Collectors.counting()));
        for (Map.Entry<Verdi, Long> entry : mapVerdiTilAntall.entrySet()) {
            mapAntallTilVerdier.computeIfAbsent(entry.getValue().intValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        if(straight && flush) {
            return Kategori.STRAIGHT_FLUSH;
        }
        if (mapVerdiTilAntall.containsValue(4L)) {
            return Kategori.FIRE_LIKE;
        }
        if(mapVerdiTilAntall.containsValue(3L) && mapVerdiTilAntall.containsValue(2L)) {
            return Kategori.FULLT_HUS;
        }
        if(mapVerdiTilAntall.containsValue(3L)) {
            return Kategori.TRE_LIKE;
        }
        if(flush) {
            return Kategori.FLUSH;
        }
        if(straight) {
            return Kategori.STRAIGHT;
        }
        int antallPar = mapAntallTilVerdier.get(2) == null? 0 : mapAntallTilVerdier.get(2).size();
        if (antallPar == 2) {
            return Kategori.TO_PAR;
        }
        if (antallPar == 1) {
            return Kategori.PAR;
        }
        return Kategori.INGEN_PAR;
    }

    private boolean isFlush() {
        return kortHand.stream().map(k -> k.sort()).distinct().count() == 1;
    }

    private boolean isStraight() {
        Kort forrige = null;
        for (Kort kort : kortHand) {
            if (forrige != null && kort.verdi().getRangering() - forrige.verdi().getRangering() != 1) {
                return false;
            }
            forrige = kort;
        }
        return true;
    }

    @Override
    public int compareTo(Hand o) {
        if (!this.kategori.equals(o.kategori)) {
            return this.kategori.getRangering() - o.kategori.getRangering();
        }
        return switch(kategori) {
            case STRAIGHT_FLUSH -> {
                // Sammenlign høyeste kort
                yield this.kortHand.getFirst().verdi().compareTo(o.kortHand.getFirst().verdi());
            }
            case FIRE_LIKE -> {
                // Sammenlign verdi på de fire like. Kan ikke få samme verdi så lenge det trekkes fra samme kortstokk
                yield this.mapAntallTilVerdier.get(4).getFirst().compareTo(o.mapAntallTilVerdier.get(4).getFirst());
            }
            case FULLT_HUS, TRE_LIKE -> {
                // Sammenlign verdi på de tre like. Kan ikke få samme verdi så lenge det trekkes fra samme kortstokk
                yield this.mapAntallTilVerdier.get(3).getFirst().compareTo(o.mapAntallTilVerdier.get(3).getFirst());
            }
            case FLUSH, INGEN_PAR -> {
                // Sammenlign høyeste enkeltkort
                yield compareSingle(o);
            }
            case STRAIGHT -> {
                // Sammenlign høyeste kort
                yield this.kortHand.getFirst().verdi().compareTo(o.kortHand.getFirst().verdi());
            }
            case TO_PAR -> {
                List<Verdi> verdier = this.mapAntallTilVerdier.get(2);
                Collections.sort(verdier);
                List<Verdi> andreVerdier = o.mapAntallTilVerdier.get(2);
                Collections.sort(andreVerdier);
                // Først sammenlign det høyeste paret for begge hender
                if (!verdier.getFirst().equals(andreVerdier.getFirst())) {
                    yield verdier.getFirst().compareTo(andreVerdier.getFirst());
                }
                // Så sammenlign det laveste paret for begge hender
                if (!verdier.getLast().equals(andreVerdier.getLast())) {
                    yield verdier.getFirst().compareTo(andreVerdier.getFirst());
                }
                // Så sammenlign de gjenværende single i rekkefølge
                yield compareSingle(o);
            }
            case PAR -> {
                // Først sammenlign paret for begge hender
                if (!mapAntallTilVerdier.get(2).equals(o.mapAntallTilVerdier.get(2))) {
                    yield mapAntallTilVerdier.get(2).getFirst().compareTo(o.mapAntallTilVerdier.get(2).getFirst());
                }
                // Så sammenlign de gjenværende single i rekkefølge
                yield compareSingle(o);
            }
        };
    }

    private int compareSingle(Hand o) {
        List<Verdi> single = mapAntallTilVerdier.get(1);
        List<Verdi> andreSingle = o.mapAntallTilVerdier.get(1);
        for (int i=0 ; i<single.size() ; i++) {
            if (!single.get(i).equals(andreSingle.get(i))) {
                return single.get(i).compareTo(andreSingle.get(i));
            }
        }
        // Alle single er like for begge hender
        return 0;
    }

    @Override
    public String toString() {
        return kategori + ": " + kortHand;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public boolean erLikeGodSom(Hand o) {
        return compareTo(o) == 0;
    }

    public boolean erBedreEnn(Hand o) {
        return compareTo(o) > 0;
    }

    public boolean erDårligereEnn(Hand o) {
        return compareTo(o) < 0;
    }
}
