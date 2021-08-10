/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kemahasiswaan_10119909_10119908;

import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class frm_simulasi_nilai_akhir extends javax.swing.JFrame {
    
    //    deklarasi variable
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    List<MataKuliah> listMk = new ArrayList();

    /**
     * Creates new form frm_mahasiswa
     */
    public frm_simulasi_nilai_akhir() {
        initComponents();
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        
        tabel_mahasiswa.setModel(tableModel);
        settableload();
        loadMk();
    }
    
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()
    {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel
        (
            new Object[][] {},
            new String [] {"Nama M.K", 
                            "Persentase Absen", 
                            "Persentase Tugas",
                            "Persentase UTS",
                            "Persentase UAS",
                            "Absensi", 
                            "Tgs1", 
                            "Tgs2", 
                            "Tgs3", 
                            "UTS", 
                            "UAS", 
                            "Nilai Absensi", 
                            "Nilai Tugas", 
                            "Nilai UTS", 
                            "Nilai UAS", 
                            "Nilai Akhir", 
                            "Indeks", 
                            "Keterangan"}
         )
         //disable perubahan pada grid
        {
        boolean[] canEdit = new boolean []
        {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,false, false, false,
                
        };
        
        public boolean isCellEditable(int rowIndex, int columnIndex){
            return canEdit[columnIndex];
        }
        };
    }
    
    String data[]=new String[18];
    private void settableload(){
        String stat = "";
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            DriverManager.getConnection(database,
                                        user,
                                        pass);
            Statement stt=kon.createStatement();
            String SQL ="SELECT * FROM t_nilai_akhir";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next()){
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                data[6] = res.getString(7);
                data[7] = res.getString(8);
                data[8] = res.getString(9);
                data[9] = res.getString(10);
                data[10] = res.getString(11);
                data[11] = res.getString(12);
                data[12] = res.getString(13);
                data[13] = res.getString(14);
                data[14] = res.getString(15);
                data[15] = res.getString(16);
                data[16] = res.getString(17);
                data[17] = res.getString(18);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex){
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),"Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void membersihkan_teks() {
        txt_persentase_absen.setText("");
        txt_persentase_tugas.setText("");
        txt_persentase_uts.setText("");
        txt_persentase_uas.setText("");
        txt_absensi.setText("");
        txt_tugas1.setText("");
        txt_tugas2.setText("");
        txt_tugas3.setText("");
        txt_uts.setText("");
        txt_uas.setText("");
    }
    
    public void nonaktif_teks(){
        txt_persentase_absen.setEnabled(false);
        txt_persentase_tugas.setEnabled(false);
        txt_persentase_uts.setEnabled(false);
        txt_persentase_uas.setEnabled(false);
        txt_kode_mk.setEnabled(false);
        txt_absensi.setEnabled(false);
        txt_tugas1.setEnabled(false);
        txt_tugas2.setEnabled(false);
        txt_tugas3.setEnabled(false);
        txt_uts.setEnabled(false);
        txt_uas.setEnabled(false);        
    }
    
    public void aktif_teks() {
        txt_persentase_absen.setEnabled(true);
        txt_persentase_tugas.setEnabled(true);
        txt_persentase_uts.setEnabled(true);
        txt_persentase_uas.setEnabled(true);
        txt_kode_mk.setEnabled(true);
        txt_kode_mk.setEnabled(true);
        txt_absensi.setEnabled(true);
        txt_tugas1.setEnabled(true);
        txt_tugas2.setEnabled(true);
        txt_tugas3.setEnabled(true);
        txt_uts.setEnabled(true);
        txt_uas.setEnabled(true);
    }
    
    int row = 0;
    public void tampil_field()
    {
        row = tabel_mahasiswa.getSelectedRow();
        cmb_nama_mk.setSelectedItem(tableModel.getValueAt(row, 0).toString());
        txt_persentase_absen.setText(tableModel.getValueAt(row, 1).toString());
        txt_persentase_tugas.setText(tableModel.getValueAt(row, 2).toString());
        txt_persentase_uts.setText(tableModel.getValueAt(row, 3).toString());
        txt_persentase_uas.setText(tableModel.getValueAt(row, 4).toString());
        txt_absensi.setText(tableModel.getValueAt(row, 5).toString());
        txt_tugas1.setText(tableModel.getValueAt(row, 6).toString());
        txt_tugas2.setText(tableModel.getValueAt(row, 7).toString());
        txt_tugas3.setText(tableModel.getValueAt(row, 8).toString());
        txt_uts.setText(tableModel.getValueAt(row, 9).toString());
        txt_uas.setText(tableModel.getValueAt(row, 10).toString());
        btn_simpan.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_batal.setEnabled(false);
    }
    
    public void loadMk () {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM t_mata_kuliah";
            ResultSet res = stt.executeQuery(SQL);
            cmb_nama_mk.removeAllItems();
            while (res.next()) {
                MataKuliah mk = new MataKuliah();
                mk.nama_mk = res.getString("nama_mk");
                mk.kode_mk = res.getString("kode_mk");
                listMk.add(mk);
                cmb_nama_mk.addItem(mk.nama_mk);
            }
            res.close();
            stt.close();
            kon.close();
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
            JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txt_cari_nama = new javax.swing.JTextField();
        scrollpane = new javax.swing.JScrollPane();
        tabel_mahasiswa = new javax.swing.JTable();
        btn_tambah = new javax.swing.JToggleButton();
        btn_ubah = new javax.swing.JToggleButton();
        btn_hapus = new javax.swing.JToggleButton();
        btn_simpan = new javax.swing.JToggleButton();
        btn_batal = new javax.swing.JToggleButton();
        btn_keluar = new javax.swing.JToggleButton();
        txt_kode_mk = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_persentase_absen = new javax.swing.JTextField();
        txt_persentase_tugas = new javax.swing.JTextField();
        txt_persentase_uts = new javax.swing.JTextField();
        txt_persentase_uas = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmb_nama_mk = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_absensi = new javax.swing.JTextField();
        txt_tugas1 = new javax.swing.JTextField();
        txt_tugas2 = new javax.swing.JTextField();
        txt_tugas3 = new javax.swing.JTextField();
        txt_uts = new javax.swing.JTextField();
        txt_uas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Form Mahasiswa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("FORM SIMULASI NILAI AKHIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Pencarian Data Mahasiswa");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Masukkan Nama");

        txt_cari_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cari_namaActionPerformed(evt);
            }
        });

        tabel_mahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_mahasiswaMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(tabel_mahasiswa);

        btn_tambah.setText("Tambah");
        btn_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_tambahMouseClicked(evt);
            }
        });

        btn_ubah.setText("Ubah");
        btn_ubah.setEnabled(false);
        btn_ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_ubahMouseClicked(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.setEnabled(false);
        btn_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_hapusMouseClicked(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_simpanMouseClicked(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_batalMouseClicked(evt);
            }
        });

        btn_keluar.setText("Keluar");
        btn_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_keluarMouseClicked(evt);
            }
        });

        txt_kode_mk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        txt_kode_mk.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Persentase Absen");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Persentase Tugas");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Persentase UTS");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Persentase UAS");

        txt_persentase_absen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_persentase_tugas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_persentase_uts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_persentase_uas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("%");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("%");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("%");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("%");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nama Mata Kuliah");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Kode Mata Kuliah");

        cmb_nama_mk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmb_nama_mkMouseClicked(evt);
            }
        });
        cmb_nama_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_nama_mkActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tugas 2");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tugas 3");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("UTS");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("UAS");

        txt_absensi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_tugas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_tugas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_tugas3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_uts.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        txt_uas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Kehadiran");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tugas 1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btn_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_ubah, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(58, 58, 58)
                                .addComponent(txt_cari_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(484, 484, 484))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1)
                                .addComponent(jSeparator2)
                                .addComponent(scrollpane))
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel14)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cmb_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_persentase_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_persentase_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_persentase_absen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_persentase_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel18)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel17))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_uts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_uas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_absensi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(111, 111, 111)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_cari_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmb_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_kode_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_persentase_absen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txt_persentase_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txt_persentase_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txt_persentase_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(29, 29, 29)
                        .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_tambah)
                            .addComponent(btn_ubah)
                            .addComponent(btn_hapus)
                            .addComponent(btn_simpan)
                            .addComponent(btn_batal)
                            .addComponent(btn_keluar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_absensi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(832, 631));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        frm_utama utama = new frm_utama();
        utama.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void txt_cari_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cari_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cari_namaActionPerformed

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambahMouseClicked
        // TODO add your handling code here:
        membersihkan_teks();
        txt_persentase_absen.requestFocus();
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_batal.setEnabled(true);
        tabel_mahasiswa.setEnabled(false);
        aktif_teks();
    }//GEN-LAST:event_btn_tambahMouseClicked

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_ubahMouseClicked
        // TODO add your handling code here:
        String kode=txt_kode_mk.getText();
        String keterangan = "", indeks = "";
        double presentase_absen,presentase_tugas,presentase_uts,presentase_uas,absensi,tugas1,tugas2,tugas3,uts,uas,nilai_absen,nilai_tugas,nilai_uts,nilai_uas,nilai_akhir;
        
        presentase_absen = Double.valueOf(txt_persentase_absen.getText())/100;
        presentase_tugas = Double.valueOf(txt_persentase_tugas.getText())/100;
        presentase_uts = Double.valueOf(txt_persentase_uts.getText())/100;
        presentase_uas = Double.valueOf(txt_persentase_uas.getText())/100;
        absensi = Double.valueOf(txt_absensi.getText());
        tugas1 = Double.valueOf(txt_tugas1.getText());
        tugas2 = Double.valueOf(txt_tugas2.getText());
        tugas3 = Double.valueOf(txt_tugas3.getText());
        uts = Double.valueOf(txt_uts.getText());
        uas = Double.valueOf(txt_uas.getText());
        nilai_absen = presentase_absen*((absensi/14)*100);
        nilai_tugas = presentase_tugas*(tugas1+tugas2+tugas3)/3;
        nilai_uts = uts*presentase_tugas;
        nilai_uas = uas*presentase_uas;
        nilai_akhir = nilai_absen + nilai_uas + nilai_uts + nilai_tugas;
        
        if(nilai_akhir>=80 && nilai_akhir<=100){
            indeks = "A";
            keterangan = "Lulus";
        } 
        else if(nilai_akhir>=68 && nilai_akhir<=79){
            indeks = "B";
            keterangan = "Lulus";
        } 
        else if(nilai_akhir>=56 && nilai_akhir<=67){
            indeks = "C";
            keterangan = "Lulus";
        } 
        else if(nilai_akhir>=45 && nilai_akhir<=55){
            indeks = "D";
            keterangan = "Tidak Lulus";
        } 
        else if(nilai_akhir>=0 && nilai_akhir<=44){
            indeks = "E";
            keterangan = "Tidak Lulus";
        } 
        else if(absensi <= 11){
            indeks = "E";
            keterangan = "Tidak Lulus";
        }
        
        if ((kode.isEmpty())){
            JOptionPane.showMessageDialog(null,
                "Data tidak boleh kosong, silahkan dilengkapi");
            txt_kode_mk.requestFocus();
        }
        else{
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "UPDATE t_nilai_akhir SET "
                        + "`persentase_absen` = '"+txt_persentase_absen.getText()+"' ," 
                        + "`persentase_tugas` = '"+txt_persentase_tugas.getText()+"' ," 
                        + "`persentase_uts` = '"+txt_persentase_uts.getText()+"' ," 
                        + "`persentase_uas` = '"+txt_persentase_uas.getText()+"' ," 
                        + "`absensi` = '"+absensi+"' ," 
                        + "`tugas1` = '"+tugas1+"' ,"
                        + "`tugas2` = '"+tugas2+"' ,"
                        + "`tugas3` = '"+tugas3+"' ,"
                        + "`uts` = '"+uts+"' ,"
                        + "`uas` = '"+uas+"' "
                        + "WHERE "
                        + "`nama_mk` = '"+tableModel.getValueAt(row, 0).toString()+"';";
                stt.executeUpdate(SQL);
                data[0] = cmb_nama_mk.getSelectedItem().toString();
                data[1] = txt_persentase_absen.getText();
                data[2] = txt_persentase_tugas.getText();
                data[3] = txt_persentase_uts.getText();
                data[4] = txt_persentase_uas.getText();
                data[5] = txt_absensi.getText();
                data[6] = txt_tugas1.getText();
                data[7] = txt_tugas2.getText() ;
                data[8] = txt_tugas3.getText() ;
                data[9] = txt_uts.getText() ;
                data[10] = txt_uas.getText() ;
                data[11] = String.format("%.0f", nilai_absen) ;
                data[12] = String.format("%.0f", nilai_tugas) ;
                data[13] = String.format("%.0f", nilai_uts) ;
                data[14] = String.format("%.0f", nilai_uas) ;
                data[15] = String.format("%.0f", nilai_akhir) ;
                tableModel.removeRow(row);
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan.setEnabled(false);
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,
                    ex.getMessage(),"ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_ubahMouseClicked

    private void btn_hapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapusMouseClicked
        // TODO add your handling code here:
        double presentase_absen,presentase_tugas,presentase_uts,presentase_uas,absensi,tugas1,tugas2,tugas3,uts,uas,nilai_absensi,nilai_tugas,nilai_uts,nilai_uas,nilai_akhir;
        
        presentase_absen = Double.valueOf(txt_persentase_absen.getText())/100;
        presentase_tugas = Double.valueOf(txt_persentase_tugas.getText())/100;
        presentase_uts = Double.valueOf(txt_persentase_uts.getText())/100;
        presentase_uas = Double.valueOf(txt_persentase_uas.getText())/100;
        absensi = Double.valueOf(txt_absensi.getText());
        tugas1 = Double.valueOf(txt_tugas1.getText());
        tugas2 = Double.valueOf(txt_tugas2.getText());
        tugas3 = Double.valueOf(txt_tugas3.getText());
        uts = Double.valueOf(txt_uts.getText());
        uas = Double.valueOf(txt_uas.getText());
        nilai_absensi = presentase_absen*((absensi/14)*100);
        nilai_tugas = presentase_tugas*(tugas1+tugas2+tugas3)/3;
        nilai_uts = uts*presentase_tugas;
        nilai_uas = uas*presentase_uas;
        nilai_akhir = nilai_absensi + nilai_uas + nilai_uts + nilai_tugas;

        
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            Statement stt = kon.createStatement();
            String SQL = "DELETE FROM t_nilai_akhir WHERE nama_mk='"+tableModel.getValueAt(row,0).toString()+"';";

            stt.executeUpdate(SQL);
                data[0] = cmb_nama_mk.getSelectedItem().toString();
                data[1] = txt_persentase_absen.getText();
                data[2] = txt_persentase_tugas.getText();
                data[3] = txt_persentase_uts.getText();
                data[4] = txt_persentase_uas.getText();
                data[5] = txt_absensi.getText();
                data[6] = txt_tugas1.getText();
                data[7] = txt_tugas2.getText() ;
                data[8] = txt_tugas3.getText() ;
                data[9] = txt_uts.getText() ;
                data[10] = txt_uas.getText() ;
                data[11] = String.format("%.0f", nilai_absensi) ;
                data[12] = String.format("%.0f", nilai_tugas) ;
                data[13] = String.format("%.0f", nilai_uts) ;
                data[14] = String.format("%.0f", nilai_uas) ;
                data[15] = String.format("%.0f", nilai_akhir) ;
            tableModel.removeRow(row);
            stt.close();
            kon.close();
            membersihkan_teks();
            aktif_teks();
        }
        catch (Exception ex)
        {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_hapusMouseClicked

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_simpanMouseClicked
        // TODO add your handling code here:
        String kode=txt_kode_mk.getText();
        String keterangan = "", indeks = "";
        double presentase_absen,presentase_tugas,presentase_uts,presentase_uas,absensi,tugas1,tugas2,tugas3,uts,uas,nilai_absensi,nilai_tugas,nilai_uts,nilai_uas,nilai_akhir;
        
        presentase_absen = Double.valueOf(txt_persentase_absen.getText())/100;
        presentase_tugas = Double.valueOf(txt_persentase_tugas.getText())/100;
        presentase_uts = Double.valueOf(txt_persentase_uts.getText())/100;
        presentase_uas = Double.valueOf(txt_persentase_uas.getText())/100;
        absensi = Double.valueOf(txt_absensi.getText());
        tugas1 = Double.valueOf(txt_tugas1.getText());
        tugas2 = Double.valueOf(txt_tugas2.getText());
        tugas3 = Double.valueOf(txt_tugas3.getText());
        uts = Double.valueOf(txt_uts.getText());
        uas = Double.valueOf(txt_uas.getText());
        nilai_absensi = presentase_absen*((absensi/14)*100);
        nilai_tugas = presentase_tugas*(tugas1+tugas2+tugas3)/3;
        nilai_uts = uts*presentase_tugas;
        nilai_uas = uas*presentase_uas;
        nilai_akhir = nilai_absensi + nilai_uas + nilai_uts + nilai_tugas;
        
        if(nilai_akhir>=80 && nilai_akhir<=100){
            indeks = "A";
            keterangan = "Lulus";
        } 
        else if(nilai_akhir>=68 && nilai_akhir<=79){
            indeks = "B";
            keterangan = "Lulus";
        } 
        else if(nilai_akhir>=56 && nilai_akhir<=67){
            indeks = "C";
            keterangan = "Lulus";
        } 
        else if(nilai_akhir>=45 && nilai_akhir<=55){
            indeks = "D";
            keterangan = "Tidak Lulus";
        } 
        else if(nilai_akhir>=0 && nilai_akhir<=44){
            indeks = "E";
            keterangan = "Tidak Lulus";
        } 
        else if(absensi <= 11){
            indeks = "E";
            keterangan = "Tidak Lulus";
        }
        
        if (kode.isEmpty()){
            JOptionPane.showMessageDialog(null,
                "Data tidak boleh kosong, silahkan dilengkapi");
            txt_kode_mk.requestFocus();
        }
        else{
            try{
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO t_nilai_akhir(`nama_mk`, `persentase_absen`, `persentase_tugas`, `persentase_uts`, `persentase_uas`, `absensi`, `tugas1`, `tugas2`, `tugas3`, `uts`, `uas`, `nilai_absensi`, `nilai_tugas`, `nilai_uts`, `nilai_uas`, `nilai_akhir`, `index`, `ket`)"
                        + "VALUES " 
                        +"('"+cmb_nama_mk.getSelectedItem().toString()+"',"
                        + "'"+txt_persentase_absen.getText()+"',"
                        + "'"+txt_persentase_tugas.getText()+"',"
                        + "'"+txt_persentase_uts.getText()+"',"
                        + "'"+txt_persentase_uas.getText()+"',"
                        + "'"+txt_absensi.getText()+"',"
                        + "'"+txt_tugas1.getText()+"',"
                        + "'"+txt_tugas2.getText()+"',"
                        + "'"+txt_tugas3.getText()+"',"
                        + "'"+txt_uts.getText()+"',"
                        + "'"+txt_uas.getText()+"',"
                        + "'"+String.format("%.0f", nilai_absensi)+"',"
                        + "'"+String.format("%.0f", nilai_tugas)+"',"
                        + "'"+String.format("%.0f", nilai_uts)+"',"
                        + "'"+String.format("%.0f", nilai_uas)+"',"
                        + "'"+String.format("%.0f", nilai_akhir)+"');";
                stt.executeUpdate(SQL);
                data[0] = cmb_nama_mk.getSelectedItem().toString();
                data[1] = txt_persentase_absen.getText();
                data[2] = txt_persentase_tugas.getText();
                data[3] = txt_persentase_uts.getText();
                data[4] = txt_persentase_uas.getText();
                data[5] = txt_absensi.getText();
                data[6] = txt_tugas1.getText();
                data[7] = txt_tugas2.getText();
                data[8] = txt_tugas3.getText();
                data[9] = txt_uts.getText();
                data[10] = txt_uas.getText();
                data[11] = String.format("%.0f", nilai_absensi);
                data[12] = String.format("%.0f", nilai_tugas);
                data[13] = String.format("%.0f", nilai_uts);
                data[14] = String.format("%.0f", nilai_uas);
                data[15] = String.format("%.0f", nilai_akhir);
                data[16] = keterangan;
                
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan.setEnabled(false);
            }
            catch (Exception ex){
                JOptionPane.showMessageDialog(null,
                    ex.getMessage(),"ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_simpanMouseClicked

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batalMouseClicked
        // TODO add your handling code here:
        membersihkan_teks();
        btn_tambah.setEnabled(true);
        btn_hapus.setEnabled(false);
        btn_ubah.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        tabel_mahasiswa.setEnabled(true);
        aktif_teks();
    }//GEN-LAST:event_btn_batalMouseClicked

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseClicked
        // TODO add your handling code here:
        frm_utama utama = new frm_utama();
        utama.setVisible(true);
        
        // menghilangkan form utama
        this.setVisible(false);
    }//GEN-LAST:event_btn_keluarMouseClicked

    private void cmb_nama_mkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmb_nama_mkMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cmb_nama_mkMouseClicked

    private void tabel_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_mahasiswaMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            tampil_field();
        }
    }//GEN-LAST:event_tabel_mahasiswaMouseClicked

    private void cmb_nama_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_nama_mkActionPerformed
        // TODO add your handling code here:
        txt_kode_mk.setText(listMk.get(cmb_nama_mk.getSelectedIndex()).kode_mk);
    }//GEN-LAST:event_cmb_nama_mkActionPerformed

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
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_simulasi_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_simulasi_nilai_akhir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_batal;
    private javax.swing.JToggleButton btn_hapus;
    private javax.swing.JToggleButton btn_keluar;
    private javax.swing.JToggleButton btn_simpan;
    private javax.swing.JToggleButton btn_tambah;
    private javax.swing.JToggleButton btn_ubah;
    private javax.swing.JComboBox<String> cmb_nama_mk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JTable tabel_mahasiswa;
    private javax.swing.JTextField txt_absensi;
    private javax.swing.JTextField txt_cari_nama;
    private javax.swing.JTextField txt_kode_mk;
    private javax.swing.JTextField txt_persentase_absen;
    private javax.swing.JTextField txt_persentase_tugas;
    private javax.swing.JTextField txt_persentase_uas;
    private javax.swing.JTextField txt_persentase_uts;
    private javax.swing.JTextField txt_tugas1;
    private javax.swing.JTextField txt_tugas2;
    private javax.swing.JTextField txt_tugas3;
    private javax.swing.JTextField txt_uas;
    private javax.swing.JTextField txt_uts;
    // End of variables declaration//GEN-END:variables
}
