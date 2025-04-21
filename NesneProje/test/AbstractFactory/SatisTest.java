/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package AbstractFactory;

import org.junit.Test;
import static org.junit.Assert.*;

public class SatisTest {

    @Test
    public void testSatisEkleme() {
        Satis satis = new Satis();
        String sonuc = satis.SatisEkleme(14, "Türkiye", "Firma A", "1234567890", "0123456789", "Nakit", "Karayolu", 100, 5000, 10);
        assertEquals("Satış eklendi", sonuc);
    }

    @Test
    public void testSatisBilgi() {
        Satis satis = new Satis();
        String bilgi = satis.SatisBilgi(1);
        assertNotNull(bilgi);
    }

    @Test
    public void testSatisDuzenleme() {
        Satis satis = new Satis();
        String sonuc = satis.SatisDüzenleme("firma_adi", "Firma B", 1, 0, 1);
        assertEquals("İşlem Başarılı", sonuc);
    }

    @Test
    public void testSatisSil() {
        Satis satis = new Satis();
        String sonuc = satis.SatisSil(4);
        assertEquals("Silme işlemi gerçekleşmedi", sonuc);
    }

    @Test
    public void testGelir() {
        Satis satis = new Satis();
        int gelir = satis.gelir(1);
        assertTrue(gelir >= 0);
    }

    @Test
    public void testGider() {
        Satis satis = new Satis();
        int gider = satis.gider(1);
        assertEquals(0, gider);
    }

    @Test
    public void testMaliVeriEkleme() {
        Satis satis = new Satis();
        satis.MaliVeriEkleme(1);
        
    }
}
