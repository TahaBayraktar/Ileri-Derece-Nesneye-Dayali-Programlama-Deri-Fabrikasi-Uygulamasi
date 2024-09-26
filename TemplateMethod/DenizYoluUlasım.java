/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TemplateMethod;

import AbstractFactory.Satis;
import Sql.SqlVeriIslemleriSatis;
import Sql.SqlVeriIslemleriUlasım;
import java.util.List;

/**
 *
 * @author taha
 */
public class DenizYoluUlasım extends UlasımYap {

    public DenizYoluUlasım() {
    }
    
    public DenizYoluUlasım(int ulasim_id, int satis_id, String sattigimiz_ulke, String satilan_urun, String satilan_renk, String firma_iletisim, String ulasım_yolu, String teslim_edildimi, int ulasım_yolu_uzaklık,int satilan_desi, int ulasım_maliyet, int tahmini_teslimat_gunu) {
        this.ulasim_id = ulasim_id;
        this.satis_id = satis_id;
        this.sattigimiz_ulke = sattigimiz_ulke;
        this.satilan_urun = satilan_urun;
        this.satilan_renk = satilan_renk;
        this.firma_iletisim = firma_iletisim;
        this.ulasım_yolu = "Deniz";
        
        this.teslim_edildimi = teslim_edildimi;
        this.ulasım_yolu_uzaklık=ulasım_yolu_uzaklık;
        this.satilan_desi = satilan_desi;
        this.ulasım_maliyet = ulasım_maliyet;
        this.tahmini_teslimat_gunu = tahmini_teslimat_gunu;
    }
        public DenizYoluUlasım(int satis_id, String sattigimiz_ulke, String satilan_urun, String satilan_renk, String firma_iletisim, String ulasım_yolu, String teslim_edildimi, int ulasım_yolu_uzaklık,int satilan_desi, int ulasım_maliyet, int tahmini_teslimat_gunu) {
        this.satis_id = satis_id;
        this.sattigimiz_ulke = sattigimiz_ulke;
        this.satilan_urun = satilan_urun;
        this.satilan_renk = satilan_renk;
        this.firma_iletisim = firma_iletisim;
        this.ulasım_yolu = "Deniz";
        this.teslim_edildimi = teslim_edildimi;
        this.ulasım_yolu_uzaklık=ulasım_yolu_uzaklık;
        this.satilan_desi = satilan_desi;
        this.ulasım_maliyet = ulasım_maliyet;
        this.tahmini_teslimat_gunu = tahmini_teslimat_gunu;
    }
    

    
    
    
    
    
    
    
    
    
    


    

    @Override
    public int KargoMaliyet(int satis_id,int satılan_desi) {
        int maliyet=0;
        int paket_sayısı=KargoPaketle(satis_id,satılan_desi);
        maliyet=KargoyuGotur(satis_id,paket_sayısı);
        SqlVeriIslemleriSatis s=new SqlVeriIslemleriSatis();
        List<Satis> veri=s.Verileri_Listeleme();
        for(Satis c:veri){
            if(c.getSatis_id()==satis_id && c.getUlasım_yolu().toLowerCase().equals("deniz")){
                maliyet+=c.getUlasım_yolu_uzaklık()*10;
            }
        }
        return maliyet;
    }
    @Override
    public int KargoyuGotur(int satis_id,int paket) {
        int maliyet=0;
        int goturulen_arac=paket/10;
        if((paket%10)!=0){
            goturulen_arac+=1;
        }
        SqlVeriIslemleriSatis s=new SqlVeriIslemleriSatis();
        List<Satis> veri=s.Verileri_Listeleme();
        for(Satis c:veri){
            if(c.getSatis_id()==satis_id &&c.getUlasım_yolu().toLowerCase().equals("deniz")){
                if(c.getSatilan_ulke().toLowerCase().equals("turkiye")){
                    maliyet=goturulen_arac*TurkiyelimanUzaklık;
                }
                if(c.getSatilan_ulke().toLowerCase().equals("amerika")){
                    maliyet=goturulen_arac*AmerikalimanUzaklık;
                }
            }
        }
        maliyet=maliyet*5;
        return maliyet; 
    }
    @Override
    public int KargoyuYukle(int kargo_sayısı) {
        int KonteynırSayısı=0;
        KonteynırSayısı=kargo_sayısı/100;
        if((kargo_sayısı%100)!=0){
            KonteynırSayısı+=1;
        }
        return KonteynırSayısı;
        
        
    }

    @Override
    public int KargoUlasımYap(int satis_id) {
        SqlVeriIslemleriSatis s=new SqlVeriIslemleriSatis();
        List<Satis> veri=s.Verileri_Listeleme();
        for(Satis c:veri){
            if(c.getSatis_id()==satis_id && c.getUlasım_yolu().toLowerCase().equals("deniz")){
                if(c.getUlasım_yolu_uzaklık()<=200 && 0<c.getUlasım_yolu_uzaklık()){
                    return 3;
                }
                if(c.getUlasım_yolu_uzaklık()<=400&& 200<c.getUlasım_yolu_uzaklık()){
                    return 4;
                }
                if(c.getUlasım_yolu_uzaklık()<=600&& 400<c.getUlasım_yolu_uzaklık()){
                    return 5;
                }
                if(c.getUlasım_yolu_uzaklık()<=800 && 600<c.getUlasım_yolu_uzaklık()){
                    return 6;
                }
                if(c.getUlasım_yolu_uzaklık()<=1000 && 800<c.getUlasım_yolu_uzaklık()){
                    return 7;
                }
                if(c.getUlasım_yolu_uzaklık()<=1200 && 1000<c.getUlasım_yolu_uzaklık()){
                    return 8;
                }
                else{
                    return 9; 
                }
                
            }
        }
        return 0;
    
    
    }
    
    

    @Override
    public String KargoTeslimat(int satis_id,int satılan_desi) {
        SqlVeriIslemleriSatis s=new SqlVeriIslemleriSatis();
        SqlVeriIslemleriUlasım u=new SqlVeriIslemleriUlasım();
        List<Satis> veri=s.Verileri_Listeleme();
        List<UlasımYap> veri2=u.Verileri_Listeleme();
        for(Satis c:veri){
            if(c.getSatis_id()==satis_id && c.getUlasım_yolu().toLowerCase().equals("deniz")){
                int tahmini_teslimat=KargoUlasımYap(satis_id);
                int ulasım_maliyet=KargoMaliyet(satis_id,satılan_desi);
                String teslim_edildimi="hayır";
                u.VeriEkleme(new DenizYoluUlasım(c.getSatis_id(),c.getSattigimiz_ulke(),c.getSatilan_urun(),c.getSatilan_urun_renk(),
                        c.getFirma_iletisim(),c.getUlasım_yolu(),teslim_edildimi,c.getUlasım_yolu_uzaklık(),satılan_desi,ulasım_maliyet,tahmini_teslimat), 0);
                return "Kargo Teslimat İçin Yola Çıkmıştır";
            }
        }
        return "İşlem Başarısız.";
        
    }

    
}
