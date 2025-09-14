package no.domstol.da.poker;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
 
/**
 *
 * @author vemund
 */
public class HandTest {

    Kort hjerterEss = new Kort(Sort.HJERTER, Verdi.ESS);
    Kort sparEss = new Kort(Sort.SPAR, Verdi.ESS);
    Kort kløverEss = new Kort(Sort.KLØVER, Verdi.ESS);
    Kort ruterEss = new Kort(Sort.RUTER, Verdi.ESS);
    Kort hjerterTo = new Kort(Sort.HJERTER, Verdi.TO);
    Kort sparTo = new Kort(Sort.SPAR, Verdi.TO);
    Kort hjerterTre = new Kort(Sort.HJERTER, Verdi.TRE);
    Kort hjerterFire = new Kort(Sort.HJERTER, Verdi.FIRE);
    Kort hjerterFem = new Kort(Sort.HJERTER, Verdi.FEM);
    Kort hjerterSeks = new Kort(Sort.HJERTER, Verdi.SEKS);

    @Test
    public void testShortHand() {
        // Skal kaste exception, bare to unike kort på handa
        assertThrows(Exception.class, () -> new Hand(hjerterEss, sparEss, hjerterEss, sparEss, hjerterEss));
    }

    @Test
    public void testIngenPar() throws Exception {
        Hand ingenPar = new Hand(sparEss, hjerterTo, hjerterTre, hjerterFire, hjerterFem);
        System.out.println(ingenPar);
        assertTrue(ingenPar.getKategori() == Kategori.INGEN_PAR);
    }   

    @Test
    public void testEttPar() throws Exception {
        Hand ettPar = new Hand(sparEss, hjerterEss, hjerterTo, hjerterTre, hjerterFire);
        System.out.println(ettPar);
        assertTrue(ettPar.getKategori() == Kategori.PAR);
    }    
    
    @Test
    public void testToPar() throws Exception {
        Hand toPar = new Hand(sparEss, hjerterEss, sparTo, hjerterTo, hjerterTre);
        System.out.println(toPar);
        assertTrue(toPar.getKategori() == Kategori.TO_PAR);
    }
    
    @Test
    public void testToTreLike() throws Exception {
        Hand treLike = new Hand(sparEss, hjerterEss, kløverEss, hjerterTo, hjerterTre);
        System.out.println(treLike);
        assertTrue(treLike.getKategori() == Kategori.TRE_LIKE);
    }

    @Test
    public void testFireLike() throws Exception {
        Hand fireLike = new Hand(sparEss, hjerterEss, kløverEss, ruterEss, hjerterTre);
        System.out.println(fireLike);
        assertTrue(fireLike.getKategori() == Kategori.FIRE_LIKE);
    }
        
    @Test
    public void testFulltHus() throws Exception {
        Hand fulltHus = new Hand(sparEss, hjerterEss, sparTo, hjerterTo, kløverEss);
        System.out.println(fulltHus);
        assertTrue(fulltHus.getKategori() == Kategori.FULLT_HUS);
    }

    @Test
    public void testFlush() throws Exception {
        Hand flush = new Hand(hjerterEss, hjerterTo, hjerterTre, hjerterFire, hjerterFem);
        System.out.println(flush);
        assertTrue(flush.getKategori() == Kategori.FLUSH);
    }

    @Test
    public void testStraight() throws Exception {
        Hand straight = new Hand(sparTo, hjerterTre, hjerterFire, hjerterFem, hjerterSeks);
        System.out.println(straight);
        assertTrue(straight.getKategori() == Kategori.STRAIGHT);
    }

    @Test
    public void testStraightFlush() throws Exception {
        Hand straightFlush = new Hand(hjerterTo, hjerterTre, hjerterFire, hjerterFem, hjerterSeks);
        System.out.println(straightFlush);
        assertTrue(straightFlush.getKategori() == Kategori.STRAIGHT_FLUSH);
    }

}