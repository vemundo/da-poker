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
        ny();
        bland();
    }

    public void ny() {
        kort.clear();
        for (Sort suit : Sort.values()) {
            for (Verdi rank : Verdi.values()) {
                kort.add(new Kort(suit, rank));
            }
        }
    }

    public void bland() {
        System.out.println("Blander kortstokk");
        Collections.shuffle(kort);
    }

    public int tellKort() {
        return kort.size();
    }

    public Kort trekkKort() {
        return kort.removeFirst();
    }

    public Hand trekkHand() throws Exception {
        return new Hand(this);
    }
}