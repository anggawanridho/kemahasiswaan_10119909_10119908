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
public class frm_nilai extends javax.swing.JFrame {
    
    //    deklarasi variable
    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    int row = 0;
    List<Mahasiswa> listMahasiswa = new ArrayList();
    List<MataKuliah> listMk = new ArrayList();

    /**
     * Creates new form frm_mahasiswa
     */
    public frm_nilai() {
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
        loadMahasiswa();
        loadMk();
    }
    
    public void loadMk () {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM t_mata_kuliah";
            ResultSet res = stt.executeQuery(SQL);
            cmb_mata_kuliah.removeAllItems();
            while (res.next()) {
                MataKuliah mk = new MataKuliah();
                mk.nama_mk = res.getString("nama_mk");
                mk.kode_mk = res.getString("kode_mk");
                listMk.add(mk);
                cmb_mata_kuliah.addItem(mk.nama_mk);
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

    public void loadMahasiswa () {
        try {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String SQL = "SELECT * FROM t_mahasiswa";
            ResultSet res = stt.executeQuery(SQL);
            cmb_nama.removeAllItems();
            while (res.next()) {
                Mahasiswa mahasiswa = new Mahasiswa();
                mahasiswa.nim = res.getString("nim");
                mahasiswa.nama = res.getString("nama");
                mahasiswa.alamat = res.getString("alamat");
                mahasiswa.tanggal_lahir = res.getDate("tanggal_lahir");
                mahasiswa.tempat_lahir = res.getString("tempat_lahir");
                listMahasiswa.add(mahasiswa);
                cmb_nama.addItem(mahasiswa.nama);
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
    
    private javax.swing.table.DefaultTableModel tableModel=getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel()
    {
        //membuat judul header
        return new javax.swing.table.DefaultTableModel
        (
            new Object[][] {},
            new String [] {"Nama", 
                            "Nama MK", 
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
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
                
        };
        
        public boolean isCellEditable(int rowIndex, int columnIndex)
        {
            return canEdit[columnIndex];
        }
        };
    }
        
    String data[]=new String[16];
    private void settableload()
    {
        String stat = "";
        try
        {
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database,user,pass);
            DriverManager.getConnection(database,
                                        user,
                                        pass);
            Statement stt=kon.createStatement();
            String SQL ="SELECT * FROM t_nilai JOIN t_mahasiswa tm on t_nilai.nim = tm.nim JOIN t_mata_kuliah tmk on tmk.kode_mk = t_nilai.kode_mk";
            ResultSet res = stt.executeQuery(SQL);
            while(res.next())
            {
                data[0] = res.getString("nama");
                data[1] = res.getString("nama_mk");
                data[2] = res.getString("kehadiran");
                data[3] = res.getString("tugas1");
                data[4] = res.getString("tugas2");
                data[5] = res.getString("tugas3");
                data[6] = res.getString("uts");
                data[7] = res.getString("uas");
                data[8] = res.getString("nilai_absen");
                data[9] = res.getString("nilai_tugas");
                data[10] = res.getString("nilai_uts");
                data[11] = res.getString("nilai_uas");
                data[12] = res.getString("nilai_akhir");
                data[13] = res.getString("indeks"); 
                data[14] = res.getString("keterangan");
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }
        catch(Exception ex)
        {
            System.err.println(ex.getMessage());
            JOptionPane.showMessageDialog(null,
                    ex.getMessage(),"Error",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void membersihkan_teks() {
        txt_kehadiran.setText("");
        txt_tugas1.setText("");
        txt_tugas2.setText("");
        txt_tugas3.setText("");
        txt_uts.setText("");
        txt_uas.setText("");
        txt_tgl_angkatan.setCalendar(null);
    }
    
    public void nonaktif_teks() {
        txt_kehadiran.setEditable(false);
        txt_tugas1.setEditable(false);
        txt_tugas2.setEditable(false);
        txt_tugas3.setEditable(false);
        txt_uts.setEditable(false);
        txt_uas.setEditable(false);
        txt_tgl_angkatan.setEnabled(false);
    }
    
    public void aktif_teks() {
        txt_kehadiran.setEditable(true);
        txt_tugas1.setEditable(true);
        txt_tugas2.setEditable(true);
        txt_tugas3.setEditable(true);
        txt_uts.setEditable(true);
        txt_uas.setEditable(true);
        txt_tgl_angkatan.setEnabled(true);
    }
    
    public void tampil_field(){
        row = tabel_mahasiswa.getSelectedRow();
        cmb_nama.setSelectedItem(tableModel.getValueAt(row, 0).toString());
        cmb_mata_kuliah.setSelectedItem(tableModel.getValueAt(row, 1).toString());
        txt_kehadiran.setText(tableModel.getValueAt(row, 2).toString());
        txt_tugas1.setText(tableModel.getValueAt(row, 3).toString());
        txt_tugas2.setText(tableModel.getValueAt(row, 4).toString());
        txt_tugas3.setText(tableModel.getValueAt(row, 5).toString());
        txt_uts.setText(tableModel.getValueAt(row, 6).toString());
        txt_uas.setText(tableModel.getValueAt(row, 7).toString());
        btn_simpan.setEnabled(false);
        btn_ubah.setEnabled(true);
        btn_hapus.setEnabled(true);
        btn_batal.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txt_cari_nim = new javax.swing.JTextField();
        txt_nim = new javax.swing.JTextField();
        txt_kehadiran = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_mahasiswa = new javax.swing.JTable();
        btn_tambah = new javax.swing.JToggleButton();
        btn_ubah = new javax.swing.JToggleButton();
        btn_hapus = new javax.swing.JToggleButton();
        btn_simpan = new javax.swing.JToggleButton();
        btn_batal = new javax.swing.JToggleButton();
        btn_keluar = new javax.swing.JToggleButton();
        cmb_nama = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_tugas1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_tugas2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_tugas3 = new javax.swing.JTextField();
        cmb_mata_kuliah = new javax.swing.JComboBox<>();
        txt_kd_mk = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_uts = new javax.swing.JTextField();
        txt_uas = new javax.swing.JTextField();
        txt_tgl_angkatan = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        btn_cari = new javax.swing.JButton();
        btn_tampil = new javax.swing.JButton();

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
        jLabel1.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Pencarian Data Mata Kuliah");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Masukkan Data");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nama");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("NIM");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Kehadiran");

        txt_cari_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cari_nimActionPerformed(evt);
            }
        });

        txt_nim.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nama Mata Kuliah");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Kode MK");

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
        jScrollPane2.setViewportView(tabel_mahasiswa);

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

        cmb_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_namaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Tugas 1");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Tugas 2");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Tugas 3");

        cmb_mata_kuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_mata_kuliahActionPerformed(evt);
            }
        });

        txt_kd_mk.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("UTS");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("UAS");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Angkatan");

        jLabel15.setText("Pertemuan");

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_tampil.setText("Tampilkan Keseluruhan Data");
        btn_tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tampilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(cmb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(84, 84, 84)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel14))
                                                .addGap(104, 104, 104)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt_tgl_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(cmb_mata_kuliah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txt_kd_mk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(56, 56, 56))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt_cari_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_tampil)
                                        .addGap(60, 60, 60))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(28, 28, 28))
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(btn_keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addGap(104, 104, 104)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_cari)
                        .addComponent(btn_tampil))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txt_cari_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel7)
                    .addComponent(cmb_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_mata_kuliah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_kd_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(txt_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel14))
                            .addComponent(txt_tgl_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_ubah)
                    .addComponent(btn_hapus)
                    .addComponent(btn_simpan)
                    .addComponent(btn_batal)
                    .addComponent(btn_keluar))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(832, 631));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        // TODO add your handling code here:
        frm_utama utama = new frm_utama();
        utama.setVisible(true);
    }                                 

    private void txt_cari_nimActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        if (txt_cari_nim.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kan gaada datanya, jadi mau cari apaan?");
            txt_cari_nim.requestFocus();
            tableModel.setRowCount(0);
            settableload();
        }
        else {
            // menghapus seluruh isi data di dalam jtable
            tableModel.setRowCount(0);
            // gunakan query untuk mencari
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
                Statement stt = kon.createStatement();
                String SQL = "SELECT * FROM t_nilai WHERE nama_mk="+
                txt_cari_nim.getText();
                ResultSet res = stt.executeQuery(SQL);
                while(res.next()) {
                    data[0] = res.getString(1);
                    data[1] = res.getString(2);
                    data[2] = res.getString(3);
                    data[3] = res.getString(4);
                    data[4] = res.getString(5);
                    tableModel.addRow(data);
                }
                res.close();
                stt.close();
                kon.close();
            }
            catch (Exception ex) {
                System.err.println(ex.getMessage());
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
                    JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
    }                                        

    private void btn_tampilActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        settableload();
    }                                          

    private void cmb_namaActionPerformed(java.awt.event.ActionEvent evt) {                                         
        txt_nim.setText(listMahasiswa.get(cmb_nama.getSelectedIndex()).nim);        // TODO add your handling code here:
    }                                        

    private void cmb_mata_kuliahActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        txt_kd_mk.setText(listMk.get(cmb_mata_kuliah.getSelectedIndex()).kode_mk);
    }                                               

    private void btn_tambahMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        membersihkan_teks();
        txt_kehadiran.requestFocus();
        btn_simpan.setEnabled(true);
        btn_ubah.setEnabled(false);
        btn_hapus.setEnabled(false);
        btn_batal.setEnabled(true);
        tabel_mahasiswa.setEnabled(false);
        aktif_teks();
    }                                       

    private void btn_ubahMouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        String nama = (String) cmb_nama.getSelectedItem();
        String nama_mk = (String) cmb_mata_kuliah.getSelectedItem();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String angkatan = String.valueOf(f.format(txt_tgl_angkatan.getDate()));

        Double absen = Double.valueOf(txt_kehadiran.getText());
        Double nilai_absen = ((absen/14)*100*5)/100;
        Double tugas = Double.valueOf(txt_tugas1.getText());
        Double tugas2 = Double.valueOf(txt_tugas2.getText());
        Double tugas3 = Double.valueOf(txt_tugas3.getText());
        Double nilai_tugas = (((tugas+tugas2+tugas3)/3)*(0.25));
        Double uts = Double.valueOf(txt_uts.getText());
        Double nilai_uts = uts*0.3;
        Double uas = Double.valueOf(txt_uas.getText());
        Double nilai_uas = uas*0.4;

        Double nilai_akhir = nilai_absen + nilai_tugas + nilai_uts + nilai_uas;
        char indeks;
        String keterangan;
        if (nilai_akhir >= 80 && nilai_akhir <=100) {
            indeks = 'A';
            keterangan = "Lulus";
        } 
        else if(nilai_akhir >= 68) {
            indeks = 'B';
            keterangan = "Lulus";
        } 
        else if(nilai_akhir >= 56) {
            indeks = 'C';
            keterangan = "Lulus";
        } 
        else if(nilai_akhir >= 45) {
            indeks = 'D';
            keterangan = "Tidak Lulus";
        } 
        else {
            indeks = 'E';
            keterangan = "Tidak Lulus";
        }
        
        if ((txt_kehadiran.getText().isEmpty()) || (txt_kd_mk.getText().isEmpty()) || (txt_tugas1.getText().isEmpty())
            || (txt_tugas2.getText().isEmpty()) || (txt_tugas3.getText().isEmpty()) || (txt_nim.getText().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Silahkan lengkapi data yang kosong");
            txt_nim.requestFocus();
        }
        else {
            try {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "UPDATE t_nilai "
                        + "SET "
                        + "nama = '" + nama + "', "
                        + "nama_mk = '" + nama_mk + "', "
                        + "absensi = '" + absen + "', "
                        + "tugas1 = '" + tugas + "', "
                        + "tugas2 = '" + tugas2 + "', "
                        + "tugas3 = '" + tugas3 + "', "
                        + "uts = '" + uts + "', "
                        + "uas = '" + uas + "', "
                        + "nilai_absen = '" + nilai_absen + "', "
                        + "nilai_tugas = '" + nilai_tugas + "', "
                        + "nilai_uts= '" + nilai_uts + "', "
                        + "nilai_uas = '" + nilai_uas + "', "
                        + "nilai_akhir = '" + nilai_akhir + "', "
                        + "indeks = '" + indeks + "', "
                        + "keterangan = '" + keterangan + "', "
                        + "angkatan = '" + angkatan + "' "
                        + "WHERE nama = '" + tableModel.getValueAt(row, 0).toString() + "'";
                
                stt.executeUpdate(sql);
                data[0] = nama;
                data[1] = nama_mk;
                data[2] = String.valueOf(absen);
                data[3] = String.valueOf(tugas);
                data[4] = String.valueOf(tugas2);
                data[5] = String.valueOf(tugas3);
                data[6] = String.valueOf(uts);
                data[7] = String.valueOf(uas);
                data[8] = String.valueOf(nilai_absen);
                data[9] = String.valueOf(nilai_tugas);
                data[10] = String.valueOf(nilai_uts);
                data[11] = String.valueOf(nilai_uas);
                data[12] = String.valueOf(nilai_akhir);
                data[13] = String.valueOf(indeks);
                data[14] = keterangan;
                tableModel.removeRow(row);
                tableModel.insertRow(row, data);               
                stt.close();
                kon.close(); 
                membersihkan_teks();
                btn_simpan.setEnabled(false);
                nonaktif_teks();
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.INFORMATION_MESSAGE);
                System.err.println(e.getMessage());
            }
            btn_ubah.setEnabled(false);
            btn_hapus.setEnabled(false);
        }
    }                                     

    private void btn_simpanMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        String nim=txt_nim.getText();
        String kode=txt_kd_mk.getText();
        String indeks="", keterangan="";
        double absensi,tugas1,tugas2,tugas3,uts,uas,nilai_absen,nilai_tugas,nilai_uts,nilai_uas,nilai_akhir;
        
        absensi = Double.valueOf(txt_kehadiran.getText());
        tugas1 = Double.valueOf(txt_tugas1.getText());
        tugas2 = Double.valueOf(txt_tugas2.getText());
        tugas3 = Double.valueOf(txt_tugas3.getText());
        uts = Double.valueOf(txt_uts.getText());
        uas = Double.valueOf(txt_uas.getText());
        nilai_absen = ((absensi/14)*100*5)/100;
        nilai_tugas = 0.25*(tugas1+tugas2+tugas3)/3;
        nilai_uts = uts*0.3;
        nilai_uas = uas*0.4;
        nilai_akhir = nilai_absen + nilai_uas + nilai_uts + nilai_tugas;
        
        if(nilai_akhir>=80 && nilai_akhir<=100){
            indeks = "A";
            keterangan = "Lulus";
        } else if(nilai_akhir>=68 && nilai_akhir<=79){
            indeks = "B";
            keterangan = "Lulus";
        } else if(nilai_akhir>=56 && nilai_akhir<=67){
            indeks = "C";
            keterangan = "Lulus";
        } else if(nilai_akhir>=45 && nilai_akhir<=55){
            indeks = "D";
            keterangan = "Tidak Lulus";
        } else if(nilai_akhir>=0 && nilai_akhir<=44){
            indeks = "E";
            keterangan = "Tidak Lulus";
        } else if(absensi <= 11){
            indeks = "E";
            keterangan = "Tidak Lulus";
        }
        
        if ((kode.isEmpty()) | (nim.isEmpty())){
            JOptionPane.showMessageDialog(null,
                "Lengkapi data yang kosong");
            txt_kehadiran.requestFocus();
        }
        else
        {
            try
            {
                Class.forName(driver);
                Connection kon = DriverManager.getConnection(database,user,pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO t_nilai(`nim`, `kode_mk`, `kehadiran`, `tugas1`, `tugas2`, `tugas3`, `uts`, `uas`, `nilai_absen`, `nilai_tugas`, `nilai_uts`, `nilai_uas`, `nilai_akhir`, `indeks`, `keterangan`)"
                        + "VALUES " 
                        +"('"+txt_nim.getText()+"',"
                        + "'"+txt_kd_mk.getText()+"',"
                        + "'"+txt_kehadiran.getText()+"',"
                        + "'"+txt_tugas1.getText()+"',"
                        + "'"+txt_tugas2.getText()+"',"
                        + "'"+txt_tugas3.getText()+"',"
                        + "'"+txt_uts.getText()+"',"
                        + "'"+txt_uas.getText()+"',"
                        + "'"+String.format("%.0f", nilai_absen)+"',"
                        + "'"+String.format("%.0f", nilai_tugas)+"',"
                        + "'"+String.format("%.0f", nilai_uts)+"',"
                        + "'"+String.format("%.0f", nilai_uas)+"',"
                        + "'"+String.format("%.0f", nilai_akhir)+"',"
                        + "'"+indeks+"',"
                        + "'"+keterangan+"');";
                stt.executeUpdate(SQL);
                data[0] = cmb_nama.getSelectedItem().toString();
                data[1] = cmb_mata_kuliah.getSelectedItem().toString();
                data[2] = txt_kehadiran.getText();
                data[3] = txt_tugas1.getText();
                data[4] = txt_tugas2.getText() ;
                data[5] = txt_tugas3.getText() ;
                data[6] = txt_uts.getText() ;
                data[7] = txt_uas.getText() ;
                data[8] = String.format("%.0f", nilai_absen) ;
                data[9] = String.format("%.0f", nilai_tugas) ;
                data[10] = String.format("%.0f", nilai_uts) ;
                data[11] = String.format("%.0f", nilai_uas) ;
                data[12] = String.format("%.0f", nilai_akhir) ;
                data[13] = indeks ;
                data[14] = keterangan;
                
                tableModel.insertRow(0, data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_simpan.setEnabled(false);
                nonaktif_teks();

            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null,
                    ex.getMessage(),"ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }                                       

    private void tabel_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {                                             
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            tampil_field();
        }
    }                                            

    private void btn_keluarMouseClicked(java.awt.event.MouseEvent evt) {                                        
        // TODO add your handling code here:
        frm_utama utama = new frm_utama();
        utama.setVisible(true);
        
        // menghilangkan form utama
        this.setVisible(false);
    }                                       

    private void btn_batalMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // TODO add your handling code here:
        membersihkan_teks();
        btn_tambah.setEnabled(true);
        btn_hapus.setEnabled(false);
        btn_ubah.setEnabled(false);
        btn_simpan.setEnabled(false);
        btn_batal.setEnabled(false);
        tabel_mahasiswa.setEnabled(true);
        aktif_teks();
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
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JToggleButton btn_batal;
    private javax.swing.JButton btn_cari;
    private javax.swing.JToggleButton btn_hapus;
    private javax.swing.JToggleButton btn_keluar;
    private javax.swing.JToggleButton btn_simpan;
    private javax.swing.JToggleButton btn_tambah;
    private javax.swing.JButton btn_tampil;
    private javax.swing.JToggleButton btn_ubah;
    private javax.swing.JComboBox<String> cmb_mata_kuliah;
    private javax.swing.JComboBox<String> cmb_nama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tabel_mahasiswa;
    private javax.swing.JTextField txt_cari_nim;
    private javax.swing.JTextField txt_kd_mk;
    private javax.swing.JTextField txt_kehadiran;
    private javax.swing.JTextField txt_nim;
    private com.toedter.calendar.JDateChooser txt_tgl_angkatan;
    private javax.swing.JTextField txt_tugas1;
    private javax.swing.JTextField txt_tugas2;
    private javax.swing.JTextField txt_tugas3;
    private javax.swing.JTextField txt_uas;
    private javax.swing.JTextField txt_uts;
    // End of variables declaration                   
}
