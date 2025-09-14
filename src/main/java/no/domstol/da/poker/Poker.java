package no.domstol.da.poker;

/**
 *
 * @author vemund
 */
public class Poker {

    public static void main(String[] args) throws Exception {
        System.setProperty("stdout.encoding", "UTF-8");
        System.setProperty("file.encoding", "UTF-8");
        Kortstokk kortstokk = new Kortstokk();
        System.out.println("Ny kortstokk med " + kortstokk.tellKort() + " kort.");
        Hand hand1 = kortstokk.trekkHand();
        System.out.println("Trakk hand: " + hand1);
        Hand hand2 = kortstokk.trekkHand();
        System.out.println("Trakk hand: " + hand2);
        if (hand1.erBedreEnn(hand2)) {
            System.out.println("Den beste handen er " + hand1);
        } else if (hand1.erDårligereEnn(hand2)) {
            System.out.println("Den dårligste handen er " + hand1);
        } else if (hand1.erLikeGodSom(hand2)) {
            System.out.println("Begge hender er like gode");
        }
    }
}
