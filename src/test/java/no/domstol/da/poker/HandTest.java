package no.domstol.da.poker;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
 
/**
 * Tester for PokerHand
 * @author vemund
 */
public class HandTest {

    Kort kløverEss = new Kort(Sort.KLØVER, Verdi.ESS);
    Kort kløverKonge = new Kort(Sort.KLØVER, Verdi.KONGE);
    Kort ruterEss = new Kort(Sort.RUTER, Verdi.ESS);
    Kort ruterKonge = new Kort(Sort.RUTER, Verdi.KONGE);
    Kort sparEss = new Kort(Sort.SPAR, Verdi.ESS);
    Kort sparTo = new Kort(Sort.SPAR, Verdi.TO);
    Kort sparTre = new Kort(Sort.SPAR, Verdi.TRE);
    Kort sparFire = new Kort(Sort.SPAR, Verdi.FIRE);
    Kort sparFem = new Kort(Sort.SPAR, Verdi.FEM);
    Kort sparSeks = new Kort(Sort.SPAR, Verdi.SEKS);
    Kort sparSju = new Kort(Sort.SPAR, Verdi.SJU);
    Kort sparKonge = new Kort(Sort.SPAR, Verdi.KONGE);
    Kort hjerterEss = new Kort(Sort.HJERTER, Verdi.ESS);
    Kort hjerterTo = new Kort(Sort.HJERTER, Verdi.TO);
    Kort hjerterTre = new Kort(Sort.HJERTER, Verdi.TRE);
    Kort hjerterFire = new Kort(Sort.HJERTER, Verdi.FIRE);
    Kort hjerterFem = new Kort(Sort.HJERTER, Verdi.FEM);
    Kort hjerterSeks = new Kort(Sort.HJERTER, Verdi.SEKS);
    Kort hjerterSju = new Kort(Sort.HJERTER, Verdi.SJU);
    Kort hjerterÅtte = new Kort(Sort.HJERTER, Verdi.ÅTTE);
    Kort hjerterKonge = new Kort(Sort.HJERTER, Verdi.KONGE);


    @Test
    public void testShortHand() {
        // Skal kaste exception, bare to unike kort på handa
        Throwable ignore = assertThrows(Exception.class, () -> new PokerHand(hjerterEss, sparEss, hjerterEss, sparEss, hjerterEss));
        System.out.println("Got exception as expected: " + ignore.getMessage());
    }

    @Test
    public void testIngenPar() throws Exception {
        PokerHand ingenPar = new PokerHand(sparEss, hjerterTo, hjerterTre, hjerterFire, hjerterFem);
        System.out.println(ingenPar);
        assertTrue(ingenPar.getKategori() == Kategori.INGEN_PAR);
    }   

    @Test
    public void testEttPar() throws Exception {
        PokerHand ettPar = new PokerHand(sparEss, hjerterEss, hjerterTo, hjerterTre, hjerterFire);
        System.out.println(ettPar);
        assertTrue(ettPar.getKategori() == Kategori.PAR);
    }    
    
    @Test
    public void testToPar() throws Exception {
        PokerHand toPar = new PokerHand(sparEss, hjerterEss, sparTo, hjerterTo, hjerterTre);
        System.out.println(toPar);
        assertTrue(toPar.getKategori() == Kategori.TO_PAR);
    }
    
    @Test
    public void testTreLike() throws Exception {
        PokerHand treLike = new PokerHand(sparEss, hjerterEss, kløverEss, hjerterTo, hjerterTre);
        System.out.println(treLike);
        assertTrue(treLike.getKategori() == Kategori.TRE_LIKE);
    }

    @Test
    public void testFireLike() throws Exception {
        PokerHand fireLike = new PokerHand(sparEss, hjerterEss, kløverEss, ruterEss, hjerterTre);
        System.out.println(fireLike);
        assertTrue(fireLike.getKategori() == Kategori.FIRE_LIKE);
    }
        
    @Test
    public void testFulltHus() throws Exception {
        PokerHand fulltHus = new PokerHand(sparEss, hjerterEss, sparTo, hjerterTo, kløverEss);
        System.out.println(fulltHus);
        assertTrue(fulltHus.getKategori() == Kategori.FULLT_HUS);
    }

    @Test
    public void testFlush() throws Exception {
        PokerHand flush = new PokerHand(hjerterEss, hjerterTo, hjerterTre, hjerterFire, hjerterFem);
        System.out.println(flush);
        assertTrue(flush.getKategori() == Kategori.FLUSH);
    }

    @Test
    public void testStraight() throws Exception {
        PokerHand straight = new PokerHand(sparTo, hjerterTre, hjerterFire, hjerterFem, hjerterSeks);
        System.out.println(straight);
        assertTrue(straight.getKategori() == Kategori.STRAIGHT);
    }

    @Test
    public void testStraightFlush() throws Exception {
        PokerHand straightFlush = new PokerHand(hjerterTo, hjerterTre, hjerterFire, hjerterFem, hjerterSeks);
        System.out.println(straightFlush);
        assertTrue(straightFlush.getKategori() == Kategori.STRAIGHT_FLUSH);
    }

    @Test
    public void testSammenligningMellomKategorier() throws Exception {
        PokerHand ingenPar = new PokerHand(sparEss, hjerterTo, hjerterTre, hjerterFire, hjerterFem);
        PokerHand ettPar = new PokerHand(sparEss, hjerterEss, hjerterTo, hjerterTre, hjerterFire);
        PokerHand toPar = new PokerHand(sparEss, hjerterEss, sparTo, hjerterTo, hjerterTre);
        PokerHand treLike = new PokerHand(sparEss, hjerterEss, kløverEss, hjerterTo, hjerterTre);
        PokerHand flush = new PokerHand(hjerterEss, hjerterTo, hjerterTre, hjerterFire, hjerterFem);
        PokerHand straight = new PokerHand(sparTo, hjerterTre, hjerterFire, hjerterFem, hjerterSeks);
        PokerHand fulltHus = new PokerHand(sparEss, hjerterEss, sparTo, hjerterTo, kløverEss);
        PokerHand fireLike = new PokerHand(sparEss, hjerterEss, kløverEss, ruterEss, hjerterTre);
        PokerHand straightFlush = new PokerHand(hjerterTo, hjerterTre, hjerterFire, hjerterFem, hjerterSeks);

        assertTrue(ingenPar.erDårligereEnn(ettPar));
        assertTrue(ettPar.erDårligereEnn(toPar));
        assertTrue(toPar.erDårligereEnn(treLike));
        assertTrue(treLike.erDårligereEnn(straight));
        assertTrue(straight.erDårligereEnn(flush));
        assertTrue(flush.erDårligereEnn(fulltHus));
        assertTrue(fulltHus.erDårligereEnn(fireLike));
        assertTrue(fireLike.erDårligereEnn(straightFlush));
    }

    @Test 
    public void testIngenParSammenligning() throws Exception {
        PokerHand ingenPar = new PokerHand(hjerterÅtte, hjerterSeks, hjerterFem, hjerterFire, sparTre);
        assertTrue(ingenPar.erLikeGodSom(new PokerHand(hjerterÅtte, hjerterSeks, hjerterFem, sparFire, sparTre)));
        assertTrue(ingenPar.erBedreEnn(new PokerHand(hjerterSju, hjerterSeks, hjerterFem, hjerterFire, sparTo)));
        assertTrue(ingenPar.erBedreEnn(new PokerHand(hjerterÅtte, hjerterFem, hjerterFire, sparTre, sparTo)));
        assertTrue(ingenPar.erBedreEnn(new PokerHand(hjerterÅtte, hjerterSeks, hjerterFire, sparTre, sparTo)));
        assertTrue(ingenPar.erBedreEnn(new PokerHand(hjerterÅtte, hjerterSeks, hjerterFem, sparTre, sparTo)));
        assertTrue(ingenPar.erBedreEnn(new PokerHand(hjerterÅtte, hjerterSeks, hjerterFem, hjerterFire, sparTo)));
    }

    @Test
    public void testEttParSammenligning() throws Exception {
        PokerHand ettPar = new PokerHand(sparEss, hjerterEss, hjerterFem, hjerterFire, hjerterTre);
        assertTrue(ettPar.erLikeGodSom(new PokerHand(sparEss, hjerterEss, hjerterFem, hjerterFire, sparTre)));
        assertTrue(ettPar.erBedreEnn(new PokerHand(sparEss, sparFire, hjerterFire, hjerterTre, sparTo)));
        assertTrue(ettPar.erBedreEnn(new PokerHand(sparEss, hjerterEss, hjerterFire, sparTre, sparTo)));
        assertTrue(ettPar.erBedreEnn(new PokerHand(sparEss, hjerterEss, hjerterFem, sparTre, sparTo)));
        assertTrue(ettPar.erBedreEnn(new PokerHand(sparEss, hjerterEss, hjerterFem, sparFire, sparTo)));
    }

    @Test
    public void testToParSammenligning() throws Exception {
        PokerHand toPar = new PokerHand(sparEss, hjerterEss, sparTre, hjerterTre, hjerterFire);
        assertTrue(toPar.erLikeGodSom(new PokerHand(sparEss, hjerterEss, sparTre, hjerterTre, sparFire)));
        assertTrue(toPar.erBedreEnn(new PokerHand(sparKonge, hjerterKonge, sparTre, hjerterTre, sparFire)));
        assertTrue(toPar.erBedreEnn(new PokerHand(sparEss, hjerterEss, sparTo, hjerterTo, sparFire)));
        assertTrue(toPar.erBedreEnn(new PokerHand(sparEss, hjerterEss, sparTre, hjerterTre, sparTo)));
    }
    
    @Test
    public void testTreLikeSammenligning() throws Exception {
        PokerHand treLike = new PokerHand(sparEss, hjerterEss, kløverEss, hjerterFire, hjerterTre);
        // Kan ikke få to sett tre like med samme verdi så lenge det trekkes fra samme kortstokk
        assertTrue(treLike.erBedreEnn(new PokerHand(sparKonge, hjerterKonge, kløverKonge, hjerterFire, sparTre)));
    }

    @Test
    public void testFireLikeSammenligning() throws Exception {
        PokerHand fireLike = new PokerHand(sparEss, hjerterEss, kløverEss, ruterEss, hjerterTre);
        // Kan ikke få to sett fire like med samme verdi så lenge det trekkes fra samme kortstokk
        assertTrue(fireLike.erBedreEnn(new PokerHand(sparKonge, hjerterKonge, kløverKonge, ruterKonge, sparTre)));
    }
        
    @Test
    public void testFulltHusSammenligning() throws Exception {
        PokerHand fulltHus = new PokerHand(sparEss, hjerterEss, kløverEss, sparTre, hjerterTre);
        // Kan ikke få to sett fulle hus med samme verdi så lenge det trekkes fra samme kortstokk
        assertTrue(fulltHus.erBedreEnn(new PokerHand(sparKonge, hjerterKonge, ruterKonge, sparTre, hjerterTre)));
    }

    @Test
    public void testFlushSammenligning() throws Exception {
        PokerHand flush = new PokerHand(hjerterEss, hjerterTo, hjerterTre, hjerterFire, hjerterFem);
        assertTrue(flush.erLikeGodSom(new PokerHand(sparEss, sparTo, sparTre, sparFire, sparFem)));
        assertTrue(flush.erBedreEnn(new PokerHand(sparKonge, sparTo, sparTre, sparFire, sparFem)));
    }

    @Test
    public void testStraightSammenligning() throws Exception {
        PokerHand straight = new PokerHand(sparTre, hjerterFire, hjerterFem, hjerterSeks, hjerterSju);
        assertTrue(straight.erLikeGodSom(new PokerHand(sparTre, sparFire, hjerterFem, hjerterSeks, hjerterSju)));
        assertTrue(straight.erBedreEnn(new PokerHand(sparTo, sparTre, hjerterFire, hjerterFem, hjerterSeks)));
    }

    @Test
    public void testStraightFlushSammenligning() throws Exception {
        PokerHand straightFlush = new PokerHand(hjerterTre, hjerterFire, hjerterFem, hjerterSeks, hjerterSju);
        assertTrue(straightFlush.erLikeGodSom(new PokerHand(sparTre, sparFire, sparFem, sparSeks, sparSju)));
        assertTrue(straightFlush.erBedreEnn(new PokerHand(sparTo, sparTre, sparFire, sparFem, sparSeks)));
    }
}