package no.domstol.da.poker;

/**
 *
 * @author vemund
 */
public class Poker {

    public static void main(String[] args) {
        Kortstokk kortstokk = new Kortstokk();
        System.out.println("Ny kortstokk med " + kortstokk.count() + " kort.");
        System.out.println("Trakk kort: " + kortstokk.draw());
        System.out.println("Kortstokk har " + kortstokk.count() + " kort igjen.");
        
    }
}
