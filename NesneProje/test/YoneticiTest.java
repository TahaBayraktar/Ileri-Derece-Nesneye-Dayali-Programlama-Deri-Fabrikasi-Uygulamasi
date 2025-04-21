import org.junit.Before;
import org.junit.Test;
import java.util.List;
import nesneproje.Yonetici;
import static org.junit.Assert.*;

public class YoneticiTest {

    private Yonetici yonetici;

    @Before
    public void setUp() {
        yonetici = new Yonetici();
    }

    @Test
    public void testVerimlilik() {
        Yonetici yonetici1 = new Yonetici(12345777333L, "password", "Turkey", "Ali", "Veli", "1234567890", 5000, 8);
        int verimlilik = yonetici1.Verimlilik(12345777333L);
        assertEquals(33, verimlilik);
    }




   

    @Test
    public void testBilgiGuncelle() {
        Yonetici yonetici1 = new Yonetici(12345777333L, "password", "Turkey", "Ali", "Veli", "1234567890", 5000, 8);
        yonetici1.BilgiGuncelle(12345777333L, 10000, "", "mas", 1);

    }

    @Test
    public void testMaasGuncelle() {
        Yonetici yonetici1 = new Yonetici(12345777333L, "password", "Turkey", "Ali", "Veli", "1234567890", 5000, 8);
        yonetici1.MaasGuncelle(12345777333L, 10000);

    }

    @Test
    public void testIstenCikarma() {
        Yonetici yonetici1 = new Yonetici(12345777333L, "password", "Turkey", "Ali", "Veli", "1234567890", 5000, 8);
        String cikarilan = yonetici1.İstenCıkarım(12345777333L);
        assertTrue(cikarilan.contains("Ali"));
        assertTrue(cikarilan.contains("Veli"));
    }

    @Test
    public void testIseAlma() {
        Yonetici yonetici1 = new Yonetici();
        String sonuc = yonetici1.İsealma(12345777333L, "Turkey", "Ali", "1234", "Veli", "1234567891", 5500, 9, "Yönetici");
        assertEquals("İşlem Başarılı.", sonuc);
    }
}
