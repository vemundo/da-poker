package no.domstol.da.poker;

/**
 *
 * @author vemund
 */
public class Poker {

    public static void main(String[] args) throws Exception {
        System.out.println("Starter poker program");
        System.out.println("bruksymboler = " + System.getProperty("bruksymboler", "TRUE"));
        System.setProperty("stdout.encoding", "UTF-8");
        System.setProperty("file.encoding", "UTF-8");
        Kortstokk kortstokk = new Kortstokk();
        System.out.println("Ny kortstokk med " + kortstokk.tellKort() + " kort.");
        PokerHand hand1 = kortstokk.trekkHand();
        System.out.println("Trakk hand: " + hand1);
        PokerHand hand2 = kortstokk.trekkHand();
        System.out.println("Trakk hand: " + hand2);
        if (hand1.erBedreEnn(hand2)) {
            System.out.println(hand1 + " er bedre enn " + hand2);
        } else if (hand1.erDårligereEnn(hand2)) {
            System.out.println(hand1 + " er dårligere enn " + hand2);
        } else if (hand1.erLikeGodSom(hand2)) {
            System.out.println(hand1 + " er like god som " + hand2);
        } else {
            System.out.println("Noe er galt ved sammenligning av hender");
        }
    }
}
