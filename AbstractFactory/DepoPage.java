/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package AbstractFactory;

import AbstractFactory.Depo;
import Sql.SqlVeriIslemleriDepo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yusagca
 */
public class DepoPage extends javax.swing.JFrame {

    /**
     * Creates new form DepoPage
     */
    Depo u = new Depo();

    public DepoPage() {
        initComponents();
        SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
        List<Depo> depoVeri = d.Verileri_Listeleme();
        DefaultTableModel dfTable = (DefaultTableModel) depoTabloY.getModel();
        DefaultTableModel dfTableB = (DefaultTableModel) depoBitenTablo.getModel();
        List<Depo> depoBiten = u.DepoKontrol();
        for (Depo c : depoVeri) {
            Object[] obj = {c.urun_id, Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1), Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1), c.birim_maliyet, c.satis_fiyat, c.birim_kar, c.stok_miktari};
            if(c.stok_miktari!=0){
            dfTable.addRow(obj);}
        }
        
        for (Depo c : depoBiten) {
            Object[] obj = {c.urun_id, Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1), Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1), c.birim_maliyet, c.satis_fiyat, c.birim_kar, c.stok_miktari};
            dfTableB.addRow(obj);
        }
        
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        depoTabloY = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        depoBitenTablo = new javax.swing.JTable();
        birim_maliyet = new javax.swing.JTextField();
        satis_fiyati = new javax.swing.JTextField();
        stok_miktari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        urun_renk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        silBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        urun_adi = new javax.swing.JComboBox<>();
        bul_id = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        depoTabloY.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        depoTabloY.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "urun_id", "urun_adi", "renk", "birim_maliyet", "satis_fiyat", "birim_kar", "stok_miktari"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        depoTabloY.setGridColor(new java.awt.Color(0, 0, 0));
        depoTabloY.setOpaque(false);
        depoTabloY.setShowGrid(true);
        depoTabloY.setSurrendersFocusOnKeystroke(true);
        jScrollPane3.setViewportView(depoTabloY);

        depoBitenTablo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        depoBitenTablo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "urun_id", "urun_adi", "renk", "birim_maliyet", "satis_fiyati", "birim_kar", "stok_miktarı"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        depoBitenTablo.setGridColor(new java.awt.Color(0, 0, 0));
        depoBitenTablo.setOpaque(false);
        depoBitenTablo.setShowGrid(true);
        depoBitenTablo.setSurrendersFocusOnKeystroke(true);
        jScrollPane4.setViewportView(depoBitenTablo);

        birim_maliyet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                birim_maliyetActionPerformed(evt);
            }
        });

        satis_fiyati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satis_fiyatiActionPerformed(evt);
            }
        });

        stok_miktari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stok_miktariActionPerformed(evt);
            }
        });

        jLabel1.setText("Birim Maliyet");

        jLabel2.setText("Satış Fiyatı");

        jLabel3.setText("Stok Miktarı");

        urun_renk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urun_renkActionPerformed(evt);
            }
        });

        jLabel4.setText("Renk");

        jLabel5.setText("Ürün Adı");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        jLabel7.setText("DEPO MENÜSÜ");

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        jButton1.setText("Kaydet");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        silBtn.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        silBtn.setText("Sil");
        silBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                silBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel8.setText("DEPO TABLOSU");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 3, 13)); // NOI18N
        jLabel9.setText("STOĞU BİTENLER");

        urun_adi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suet", "Suni" }));
        urun_adi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urun_adiActionPerformed(evt);
            }
        });

        bul_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bul_idActionPerformed(evt);
            }
        });

        jButton2.setText("Ara");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Ürün ID ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(satis_fiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(urun_renk, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(birim_maliyet, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(urun_adi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(stok_miktari, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bul_id)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(silBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                        .addComponent(jScrollPane4))
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urun_adi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(urun_renk, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(birim_maliyet, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(satis_fiyati, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stok_miktari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(11, 11, 11)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(silBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(bul_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void satis_fiyatiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satis_fiyatiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_satis_fiyatiActionPerformed

    private void stok_miktariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stok_miktariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stok_miktariActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            if (depoTabloY.getSelectedRow() > -1) {
                tableChanged();

            } else {

                DefaultTableModel model = (DefaultTableModel) depoTabloY.getModel();
                DefaultTableModel modelD = (DefaultTableModel) depoBitenTablo.getModel();
                model.setRowCount(0);
                modelD.setRowCount(0);
                if (urun_renk.getText().trim().isEmpty() == false) {
                   String a= u.StokEkleme(urun_adi.getSelectedItem().toString().toLowerCase(), urun_renk.getText().toLowerCase(), Integer.parseInt(birim_maliyet.getText()), Integer.parseInt(satis_fiyati.getText()), Integer.parseInt(stok_miktari.getText()));
                   JOptionPane.showMessageDialog(null, a, "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                }
                tabloGuncelle();
                urun_renk.setText("");
                birim_maliyet.setText("");
                satis_fiyati.setText("");
                stok_miktari.setText("");
                
                

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Boş alan bırakılamaz", "Uyarı", JOptionPane.WARNING_MESSAGE);

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void silBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_silBtnActionPerformed
        if (depoTabloY.getSelectedRow() > -1) {
            int uretim_id = (int) depoTabloY.getValueAt(depoTabloY.getSelectedRow(), 0);
            u.StokSil(uretim_id);
            DefaultTableModel model = (DefaultTableModel) depoTabloY.getModel();
            model.setRowCount(0);
            tabloGuncelle();
            JOptionPane.showMessageDialog(null, "Silme İşlemi Başarılı", "Başarılı", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_silBtnActionPerformed

    private void urun_renkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urun_renkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urun_renkActionPerformed

    private void birim_maliyetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_birim_maliyetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_birim_maliyetActionPerformed

    private void urun_adiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urun_adiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_urun_adiActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String cevap = u.StokDurum(Integer.parseInt(bul_id.getText()));
        if(!bul_id.getText().equals("0")){
            System.out.println(bul_id.getText().getClass());
            JOptionPane.showMessageDialog(null, cevap, "", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Aranan ID bulunamadı ", "Başarısız", JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bul_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bul_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bul_idActionPerformed
    private void tabloGuncelle() {
        SqlVeriIslemleriDepo d = new SqlVeriIslemleriDepo();
        List<Depo> depoVeri = d.Verileri_Listeleme();
        DefaultTableModel dfTableD = (DefaultTableModel) depoTabloY.getModel();
        DefaultTableModel dfTableB = (DefaultTableModel) depoBitenTablo.getModel();
        List<Depo> depoBiten = u.DepoKontrol();
        dfTableD.setRowCount(0);
        dfTableB.setRowCount(0);
        for (Depo c : depoVeri) {
            Object[] obj = {c.urun_id, Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1), Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1), c.birim_maliyet, c.satis_fiyat, c.birim_kar, c.stok_miktari};
            if(c.stok_miktari!=0){
            dfTableD.addRow(obj);}
        }
         for (Depo c : depoBiten) {
            Object[] obj = {c.urun_id, Character.toUpperCase(c.urun_adi.charAt(0)) + c.urun_adi.substring(1), Character.toUpperCase(c.renk.charAt(0)) + c.renk.substring(1), c.birim_maliyet, c.satis_fiyat, c.birim_kar, c.stok_miktari};
            dfTableB.addRow(obj);
        }

    }

    public void tableChanged() {

        int row = depoTabloY.getSelectedRow(); // Seçilen satırın indeksi
        int column = depoTabloY.getSelectedColumn(); // Seçilen sütunun indeksi
        String cName = depoTabloY.getColumnName(column);
        Object data = depoTabloY.getValueAt(row, column); // Seçilen hücrenin değeri

        int urun_id = (int) depoTabloY.getValueAt(depoTabloY.getSelectedRow(), 0);
        System.out.println(urun_id);

        System.out.println(cName);
        if (column == 1 || column == 2) {
            String a = u.StokGüncelleme(cName, data.toString(), urun_id, 0, 0);
            JOptionPane.showMessageDialog(null, a, "Uyarı", JOptionPane.WARNING_MESSAGE);
        } else if (column == 0 || column == 5) {
            String a = u.StokGüncelleme(cName, "", urun_id, (Integer) data, 0);

            JOptionPane.showMessageDialog(null, a, "Uyarı", JOptionPane.WARNING_MESSAGE);
        } else if (column == 3 || column == 4 || column == 6) {
            String a = u.StokGüncelleme(cName, "", urun_id, (Integer) data, 0);
            JOptionPane.showMessageDialog(null, a, "", JOptionPane.INFORMATION_MESSAGE);
        }

        System.out.println(data + ":" + cName + ":" + column);
        DefaultTableModel model = (DefaultTableModel) depoTabloY.getModel();
        model.setRowCount(0);
        tabloGuncelle();

        // Burada istediğiniz işlemleri yapabilirsiniz
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DepoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DepoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DepoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DepoPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DepoPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField birim_maliyet;
    private javax.swing.JTextField bul_id;
    public javax.swing.JTable depoBitenTablo;
    public javax.swing.JTable depoTabloY;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField satis_fiyati;
    private javax.swing.JButton silBtn;
    private javax.swing.JTextField stok_miktari;
    private javax.swing.JComboBox<String> urun_adi;
    private javax.swing.JTextField urun_renk;
    // End of variables declaration//GEN-END:variables
}
