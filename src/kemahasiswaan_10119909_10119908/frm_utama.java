/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kemahasiswaan_10119909_10119908;

/**
 *
 * @author ASUS
 */
public class frm_utama extends javax.swing.JFrame {

    /**
     * Creates new form frm_utama
     */
    public frm_utama() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_button = new javax.swing.JPanel();
        btn_data_mahasiswa = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_data_matkul = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        btn_data_nilai = new javax.swing.JToggleButton();
        jSeparator3 = new javax.swing.JSeparator();
        btn_simulasi_nilai = new javax.swing.JToggleButton();
        jSeparator4 = new javax.swing.JSeparator();
        btn_simulasi_kasus = new javax.swing.JToggleButton();
        lbl_aplikasi_kemahasiswaan = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 166, 100));
        setPreferredSize(new java.awt.Dimension(576, 400));
        setResizable(false);

        btn_data_mahasiswa.setText("Data Mahasiswa");
        btn_data_mahasiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_data_mahasiswa.setFocusable(false);
        btn_data_mahasiswa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_data_mahasiswa.setOpaque(true);
        btn_data_mahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_mahasiswaActionPerformed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_data_matkul.setText("Data Mata Kuliah");
        btn_data_matkul.setFocusable(false);
        btn_data_matkul.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_data_matkul.setOpaque(true);
        btn_data_matkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_matkulActionPerformed(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_data_nilai.setText("Data Nilai");
        btn_data_nilai.setFocusable(false);
        btn_data_nilai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_data_nilai.setOpaque(true);
        btn_data_nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_data_nilaiActionPerformed(evt);
            }
        });

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_simulasi_nilai.setText("Simulasi Nilai Akhir");
        btn_simulasi_nilai.setFocusable(false);
        btn_simulasi_nilai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_simulasi_nilai.setOpaque(true);
        btn_simulasi_nilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simulasi_nilaiActionPerformed(evt);
            }
        });

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);

        btn_simulasi_kasus.setText("Simulasi Kasus");
        btn_simulasi_kasus.setFocusable(false);
        btn_simulasi_kasus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn_simulasi_kasus.setOpaque(true);
        btn_simulasi_kasus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simulasi_kasusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_buttonLayout = new javax.swing.GroupLayout(pnl_button);
        pnl_button.setLayout(pnl_buttonLayout);
        pnl_buttonLayout.setHorizontalGroup(
            pnl_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_buttonLayout.createSequentialGroup()
                .addComponent(btn_data_mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_data_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_data_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_simulasi_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_simulasi_kasus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnl_buttonLayout.setVerticalGroup(
            pnl_buttonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(btn_data_mahasiswa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_data_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btn_data_nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jSeparator3)
            .addComponent(btn_simulasi_nilai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jSeparator4)
            .addComponent(btn_simulasi_kasus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lbl_aplikasi_kemahasiswaan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_aplikasi_kemahasiswaan.setText("Aplikasi Kemahasiswaan");

        jPanel2.setBackground(new java.awt.Color(0, 173, 255));

        jLabel1.setText("10119909/M. Anggawan Ridho Islami");

        jLabel2.setText("10119908/Aldi Nugraha");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119909_10119908/10119909.jpeg"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119909_10119908/10119908.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(186, 186, 186))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(165, 165, 165))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(66, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_aplikasi_kemahasiswaan, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(lbl_aplikasi_kemahasiswaan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(832, 631));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_simulasi_kasusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simulasi_kasusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_simulasi_kasusActionPerformed

    private void btn_data_matkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_matkulActionPerformed
        // TODO add your handling code here:
        frm_mata_kuliah mata_kuliah = new frm_mata_kuliah();
        mata_kuliah.setVisible(true);
        
        // menghilangkan form utama
        this.setVisible(false);
    }//GEN-LAST:event_btn_data_matkulActionPerformed

    private void btn_data_mahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_mahasiswaActionPerformed
        // TODO add your handling code here:
        frm_mahasiswa mhs = new frm_mahasiswa();
        mhs.setVisible(true);
        
        // menghilangkan form utama
        this.setVisible(false);
    }//GEN-LAST:event_btn_data_mahasiswaActionPerformed

    private void btn_data_nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_data_nilaiActionPerformed
        // TODO add your handling code here:
        frm_nilai nilai = new frm_nilai();
        nilai.setVisible(true);
        
        // menghilangkan form utama
        this.setVisible(false);
    }//GEN-LAST:event_btn_data_nilaiActionPerformed

    private void btn_simulasi_nilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simulasi_nilaiActionPerformed
        // TODO add your handling code here:
        frm_simulasi_nilai_akhir nilai_akhir = new frm_simulasi_nilai_akhir();
        nilai_akhir.setVisible(true);
        
        // menghilangkan form utama
        this.setVisible(false);
    }//GEN-LAST:event_btn_simulasi_nilaiActionPerformed

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
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_data_mahasiswa;
    private javax.swing.JToggleButton btn_data_matkul;
    private javax.swing.JToggleButton btn_data_nilai;
    private javax.swing.JToggleButton btn_simulasi_kasus;
    private javax.swing.JToggleButton btn_simulasi_nilai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl_aplikasi_kemahasiswaan;
    private javax.swing.JPanel pnl_button;
    // End of variables declaration//GEN-END:variables
}
