package no.domstol.da.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author vemund
 */
public final class Kortstokk {

    private final List<Kort> kort =  new ArrayList<>();

    public Kortstokk() {
        resett();
        stokk();
    }

    public void resett() {
        kort.clear();
        for (Sort suit : Sort.values()) {
            for (Verdi rank : Verdi.values()) {
                kort.add(new Kort(suit, rank));
            }
        }
    }

    public void stokk() {
        Collections.shuffle(kort);
    }

    public int count() {
        return kort.size();
    }

    public Kort draw() {
        return kort.removeFirst();
    }
}