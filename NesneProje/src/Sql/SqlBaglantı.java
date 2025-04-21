package Sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;
import java.io.InputStream;

public abstract class SqlBaglantı {

public Connection connect() {
    Connection c = null;
    try {
        // Config dosyasını oku
        Properties props = new Properties();
        try (InputStream input = SqlBaglantı.class.getClassLoader().getResourceAsStream("Properties/config.properties")) {
            if (input == null) {
                throw new Exception("Config dosyası bulunamadı!");
            }
            props.load(input);
        }

        // Config dosyasındaki bilgileri al
        String url = props.getProperty("db.url"); // Buradan dinamik URL alınıyor
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");
        String driver = props.getProperty("db.driver");

        // PostgreSQL sürücüsünü yükle
        Class.forName(driver);

        // Varsayılan veritabanına bağlan (örneğin: postgres)
        try (Connection defaultConnection = DriverManager.getConnection(url, user, password)) {
            System.out.println("Varsayılan veritabanına başarıyla bağlanıldı!");
            createDatabase(defaultConnection, "fabrika");
        }

      String fabrikaUrl;
if (url.endsWith("postgres")) {
    fabrikaUrl = url.substring(0, url.lastIndexOf("postgres")) + "fabrika";
} else {
    throw new Exception("Config dosyasındaki URL 'postgres' ile bitmiyor, doğru yapılandırın!");
}
c = DriverManager.getConnection(fabrikaUrl, user, password);
System.out.println("Fabrika veritabanına başarıyla bağlanıldı!");

        // Tabloları oluştur
        createTables(c);

    } catch (Exception ex) {
        System.out.println("Bağlantı hatası: " + ex.getMessage());
    }
    return c;
}

    // Veritabanını kontrol et ve oluştur
    private void createDatabase(Connection connection, String databaseName) {
        try (Statement statement = connection.createStatement()) {
            String createDatabaseSQL = "CREATE DATABASE " + databaseName;
            statement.executeUpdate(createDatabaseSQL);
            System.out.println("'" + databaseName + "' veritabanı başarıyla oluşturuldu.");
        } catch (Exception e) {
            if (e.getMessage().contains("already exists")) {
                System.out.println("'" + databaseName + "' veritabanı zaten mevcut.");
            } else {
                System.out.println("Veritabanı oluşturma hatası: " + e.getMessage());
            }
        }
    }

    // Tabloları Fabrika veritabanında oluştur
    private void createTables(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            // calisan tablosu
            String createCalisanTable = "CREATE TABLE IF NOT EXISTS calisan (" +
                                        "id SERIAL PRIMARY KEY NOT NULL, " +
                                        "tc BIGINT, " +
                                        "sifre VARCHAR, " +
                                        "ulke VARCHAR, " +
                                        "isim VARCHAR, " +
                                        "soyad VARCHAR, " +
                                        "numara VARCHAR, " +
                                        "mevki VARCHAR, " +
                                        "mas INT, " +
                                        "ortcalısmasaati INT" +
                                        ");";

            // depo tablosu
            String createDepoTable = "CREATE TABLE IF NOT EXISTS depo (" +
                                     "urun_id SERIAL PRIMARY KEY NOT NULL, " +
                                     "urun_adi VARCHAR, " +
                                     "renk VARCHAR, " +
                                     "birim_maliyet INT, " +
                                     "satis_fiyat INT, " +
                                     "birim_kar INT, " +
                                     "stok_miktari INT" +
                                     ");";

            // satis tablosu
            String createSatisTable = "CREATE TABLE IF NOT EXISTS satis (" +
                                      "satis_id SERIAL PRIMARY KEY NOT NULL, " +
                                      "uretim_id INT, " +
                                      "satilan_ulke INT, " +
                                      "sattigimiz_ulke VARCHAR, " +
                                      "firma_adi VARCHAR, " +
                                      "firma_vergi_no VARCHAR, " +
                                      "firma_iletisim VARCHAR, " +
                                      "satilan_urun VARCHAR, " +
                                      "satilan_urun_renk VARCHAR, " +
                                      "odeme_turu VARCHAR, " +
                                      "ulasım_yolu VARCHAR, " +
                                      "ulasım_yolu_uzaklık VARCHAR, " +
                                      "satis_fiyati INT, " +
                                      "satilan_desi INT" +
                                      ");";

            // ulasım tablosu
            String createUlasimTable = "CREATE TABLE IF NOT EXISTS ulasım (" +
                                       "ulasım_id SERIAL PRIMARY KEY NOT NULL, " +
                                       "satis_id INT, " +
                                       "sattigimiz_ulke VARCHAR, " +
                                       "satilan_urun VARCHAR, " +
                                       "satilan_renk VARCHAR, " +
                                       "firma_iletisim VARCHAR, " +
                                       "ulasım_yolu VARCHAR, " +
                                       "teslim_edildimi VARCHAR, " +
                                       "ulasım_yolu_uzaklık INT, " +
                                       "satilan_desi INT, " +
                                       "ulasım_maliyet INT, " +
                                       "tahmini_teslimat_gunu INT" +
                                       ");";

            // uretim tablosu
            String createUretimTable = "CREATE TABLE IF NOT EXISTS uretim (" +
                                       "uretim_id SERIAL PRIMARY KEY NOT NULL, " +
                                       "urun_id INT, " +
                                       "uretilen_ulke VARCHAR, " +
                                       "urun_adı VARCHAR, " +
                                       "urun_renk VARCHAR, " +
                                       "uretilen_miktar INT, " +
                                       "maliyet INT" +
                                       ");";

            // SQL komutlarını çalıştır
            statement.execute(createCalisanTable);
            System.out.println("'calisan' tablosu başarıyla oluşturuldu veya zaten mevcut.");

            statement.execute(createDepoTable);
            System.out.println("'depo' tablosu başarıyla oluşturuldu veya zaten mevcut.");

            statement.execute(createSatisTable);
            System.out.println("'satis' tablosu başarıyla oluşturuldu veya zaten mevcut.");

            statement.execute(createUlasimTable);
            System.out.println("'ulasım' tablosu başarıyla oluşturuldu veya zaten mevcut.");

            statement.execute(createUretimTable);
            System.out.println("'uretim' tablosu başarıyla oluşturuldu veya zaten mevcut.");

        } catch (Exception e) {
            System.out.println("Tablo oluşturma hatası: " + e.getMessage());
        }
    }
}