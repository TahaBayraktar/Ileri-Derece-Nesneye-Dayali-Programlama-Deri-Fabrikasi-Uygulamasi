import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import java.util.List;
import nesneproje.Personel;

public class PersonelTest {

    @Test
    public void testVerimlilik() {
        Personel yonetici1 = new Personel(1234567890, "password", "Turkey", "Ali", "Veli", "1234567890", 5000, 8);
        int verimlilik = yonetici1.Verimlilik(1234567890);
        assertEquals(33, verimlilik); 
    }


    @Test
    public void testCalisaniBul() {
        Personel yonetici1 = new Personel();
        yonetici1.İsealma(1234567890, "password", "Turkey", "Ali", "Veli", "1234567890", 5000, 8,"Personel");
        String calisanBilgi = yonetici1.CalisaniBul(1234567890);
        
        assertTrue(calisanBilgi.contains("Ali"));
        assertTrue(calisanBilgi.contains("Veli"));
    }


    @Test
    public void testMaasGuncelle() {
        Personel personel = new Personel();
        personel.MaasGuncelle(12345678901L, 5000); 
        
    }

    @Test
    public void testBilgiGuncelle() {
        Personel personel = new Personel();
        personel.BilgiGuncelle(12345678901L, 2500, "Yeni İsim", "isim", 1); 
    }

    @Test
    public void testIsealma() {
        Personel personel = new Personel();
        String sonuc = personel.İsealma(12345678901L, "Türkiye", "Yeni İsim", "12345", "Yeni Soyisim", "5555555555", 3000, 50, "Personel");
        assertEquals("İşlem Başarılı", sonuc); 
    }


    @Test
    public void testTumCalısanGoster() {
        Personel personel = new Personel();
        List<Personel> calisanListesi = personel.TumCalısanGoster();
        assertFalse(calisanListesi.isEmpty()); 
        for (Personel calisan : calisanListesi) {
            assertEquals("Personel", calisan.getMevki()); 
        }
    }

    @Test
    public void testIstenCikarma() {
        Personel yonetici1 = new Personel(1234567890, "password", "Turkey", "Ali", "Veli", "1234567890", 5000, 8);
        String cikarilan = yonetici1.İstenCıkarım(1234567890);
        assertTrue(cikarilan.contains("Ali"));
        assertTrue(cikarilan.contains("Veli"));
    }
}
