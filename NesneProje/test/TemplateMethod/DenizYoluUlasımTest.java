/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package TemplateMethod;
import org.junit.Test;
import static org.junit.Assert.*;

public class DenizYoluUlasımTest {

    @Test
    public void testKargoMaliyet() {
        DenizYoluUlasım denizUlasim = new DenizYoluUlasım();
        int satis_id =6 ;
        int satilan_desi = 15;
        int beklenenMaliyet = 5150;
        int maliyet = denizUlasim.KargoMaliyet(satis_id, satilan_desi);
        assertEquals(beklenenMaliyet, maliyet);
    }
    
    @Test
    public void testKargoyuGotur() {
        DenizYoluUlasım denizUlasim = new DenizYoluUlasım();
        int satis_id = 6;
        int beklenenMaliyet = 300;
        int maliyet = denizUlasim.KargoyuGotur(satis_id, 20);
        assertEquals(beklenenMaliyet, maliyet);
    }
    
    @Test
    public void testKargoyuYukle() {
        DenizYoluUlasım denizUlasim = new DenizYoluUlasım();
        int beklenenKonteynerSayisi = 2;
        int yuklenenKargoSayisi = 150; 
        int konteynerSayisi = denizUlasim.KargoyuYukle(yuklenenKargoSayisi);
        assertEquals(beklenenKonteynerSayisi, konteynerSayisi);
    }
    
    @Test
    public void testKargoUlasımYap() {
        DenizYoluUlasım denizUlasim = new DenizYoluUlasım();
        int satis_id = 6;
        int beklenenTeslimatGun = 5;
        int teslimatGun = denizUlasim.KargoUlasımYap(satis_id);
        assertEquals(beklenenTeslimatGun, teslimatGun);
    }
    
    @Test
    public void testKargoTeslimat() {
        DenizYoluUlasım denizUlasim = new DenizYoluUlasım();
        int satis_id = 6;
        int satilan_desi = 15;
        String beklenenSonuc = "Kargo Teslimat İçin Yola Çıkmıştır";
        String sonuc = denizUlasim.KargoTeslimat(satis_id, satilan_desi);
        assertEquals(beklenenSonuc, sonuc);
    }
    
    @Test
    public void testKargoPaketle() {
        DenizYoluUlasım denizUlasim = new DenizYoluUlasım();
        int satis_id = 6;
        int beklenenPaketSayisi = 2;
        int paketSayisi = denizUlasim.KargoPaketle(satis_id, 15); 
        assertEquals(beklenenPaketSayisi, paketSayisi);
    }
}
