/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufakturmithlabs;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Mithlabs
 */
public class DistribusiJalan extends javax.swing.JFrame {
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    private DefaultTableModel tabModeKirim;
    private DefaultTableModel tabModeTerkirim;

    

    /**
     * Creates new form NewJFrame
     */
    public DistribusiJalan() {

        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);      
//        dataTableProduk();
        dataTableKirim();
        dataTableTerkirim();
        tampil_combo_barang();
        tampil_combo_selected();
        
       
        
    }
    
    protected void bersih(){
        
    }
    
    public void tampil_combo_barang(){
        try {
        String sql = "SELECT DISTINCT `id_distribusi` FROM `distribusi` ";
        rs = stat.executeQuery(sql);                               
        while(rs.next()){
            Object[] obb = new Object[1];
            obb[0] = rs.getString(1);
            cIdDistribusi.addItem((String) obb[0]);
            
        }
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void tampil_combo_selected() {
           
    }
    
    
    protected void dataTableKirim(){
        Object[] Baris = {"ID Distribusi","Kode Produk","Nama Produk","Qty","Nama Tujuan","No HP","Alamat Tujuan","Tanggal Kirim","Status"};
        tabModeKirim = new DefaultTableModel(null,Baris);
        tabKirim.setModel(tabModeKirim);
        
        try{
            sql = "SELECT * FROM produk INNER JOIN distribusi ON produk.product_sku = distribusi.kode_barang WHERE distribusi.status = 'Plan' OR distribusi.status = 'Proses' ORDER BY distribusi.status DESC ";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_distribusi");
                String b = rs.getString("product_sku");
                String c = rs.getString("product_name");
                String d = rs.getString("qty");
                String e = rs.getString("nama_tujuan");
                String f = rs.getString("no_hp_tujuan");
                String g = rs.getString("alamat_tujuan");                
                String h = rs.getString("tanggal");
                String i = rs.getString("status");                
                String[] data = {a,b,c,d,e,f,g,h,i};
                tabModeKirim.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Load Data Barang Jadi");
        }
    }
    
    protected void dataTableTerkirim(){
        Object[] Baris = {"ID Distribusi","Kode Produk","Nama Produk","Qty","Nama Tujuan","No HP","Alamat Tujuan","Tanggal Kirim","Status","Tanggal Diterima"};
        tabModeTerkirim = new DefaultTableModel(null,Baris);
        tabTerkirim.setModel(tabModeTerkirim);
        
        try{
            sql = "SELECT * FROM produk INNER JOIN distribusi ON produk.product_sku = distribusi.kode_barang WHERE distribusi.status = 'Terkirim';";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("id_distribusi");
                String b = rs.getString("product_sku");
                String c = rs.getString("product_name");
                String d = rs.getString("qty");
                String e = rs.getString("nama_tujuan");
                String f = rs.getString("no_hp_tujuan");
                String g = rs.getString("alamat_tujuan");                
                String h = rs.getString("tanggal");
                String i = rs.getString("status");      
                String j = rs.getString("tanggal_diterima");                                
                String[] data = {a,b,c,d,e,f,g,h,i,j};
                tabModeTerkirim.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Load Data Barang Jadi");
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

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bHome = new javax.swing.JButton();
        bBack1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cIdDistribusi = new javax.swing.JComboBox<>();
        bKirim = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabKirim = new javax.swing.JTable();
        cUpdateStatus = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        bUpdate = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        tUpdateTanggal = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabTerkirim = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tIdDistribusi = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(122, 164, 130));
        jPanel3.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(122, 164, 130));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));

        jLabel2.setText("ID Distribusi");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel10.setText("Distribusi");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logomithlabs100.png"))); // NOI18N
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Cetak Surat Jalan");

        bHome.setText("Home");
        bHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHomeActionPerformed(evt);
            }
        });

        bBack1.setText("Back");
        bBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBack1ActionPerformed(evt);
            }
        });

        cIdDistribusi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item" }));
        cIdDistribusi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cIdDistribusiActionPerformed(evt);
            }
        });

        bKirim.setText("Cetak");
        bKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bKirimActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Tabel Produk Distribusi - Plan & On Proses");

        tabKirim.setModel(new javax.swing.table.DefaultTableModel(
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
        tabKirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabKirimMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabKirim);

        cUpdateStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an Item", "Plan", "Proses", "Terkirim" }));
        cUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cUpdateStatusActionPerformed(evt);
            }
        });

        jLabel3.setText("Update Status");

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        jLabel4.setText("Tanggal Diterima");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Tabel Produk Distribusi - Terkirim");

        tabTerkirim.setModel(new javax.swing.table.DefaultTableModel(
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
        tabTerkirim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabTerkirimMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabTerkirim);

        jLabel6.setText("ID Distribusi");

        tIdDistribusi.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(cIdDistribusi, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(bKirim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tUpdateTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cUpdateStatus, 0, 298, Short.MAX_VALUE)
                                .addComponent(tIdDistribusi))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(bBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 868, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cIdDistribusi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bKirim, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tIdDistribusi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tUpdateTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(bUpdate)
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(135, 135, 135)
                .addComponent(jLabel5)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabKirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabKirimMouseClicked
        // TODO add your handling code here:
        int bar = tabKirim.getSelectedRow();
        String a = tabModeKirim.getValueAt(bar,0).toString();
        String b = tabModeKirim.getValueAt(bar,8).toString();
        cIdDistribusi.setSelectedItem(a);
        cUpdateStatus.setSelectedItem(b);
        tIdDistribusi.setText(a);
        
    }//GEN-LAST:event_tabKirimMouseClicked

    private void bKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bKirimActionPerformed
        // TODO add your handling code here:
        try {
             String nama = "src/manufakturmithlabs/CetakSuratJalan.jasper";
             Connection conn = new Koneksi().connect();
             HashMap parameter = new HashMap();
             parameter.put("id",cIdDistribusi.getSelectedItem().toString());
             File report = new File(nama);
             JasperReport jasperReport = (JasperReport) JRLoader.loadObject(report.getPath());
             JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport,parameter,conn);
             JasperViewer.viewReport(jasperprint,false);
             JasperViewer.setDefaultLookAndFeelDecorated(true);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        

    }//GEN-LAST:event_bKirimActionPerformed

    private void cIdDistribusiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cIdDistribusiActionPerformed
        // TODO add your handling code here:
        tampil_combo_selected();

    }//GEN-LAST:event_cIdDistribusiActionPerformed

    private void bBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBack1ActionPerformed
        // TODO add your handling code here:
        new Distribusi().setVisible(true);
        dispose();
    }//GEN-LAST:event_bBack1ActionPerformed

    private void bHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHomeActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_bHomeActionPerformed

    private void cUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cUpdateStatusActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cUpdateStatusActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        try{  
            if (cUpdateStatus.getSelectedItem().toString() == "Proses") 
             {
                sql = "UPDATE `distribusi` SET `status`=? WHERE `id_distribusi`=?;";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1,cUpdateStatus.getSelectedItem().toString());                 
                stat.setString(2,tIdDistribusi.getText());
                stat.executeUpdate();                
                dataTableTerkirim();
                dataTableKirim();
             } else if (cUpdateStatus.getSelectedItem().toString() == "Plan") {
                sql = "UPDATE `distribusi` SET `status`=? WHERE `id_distribusi`=?;";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1,cUpdateStatus.getSelectedItem().toString());                 
                stat.setString(2,tIdDistribusi.getText());
                stat.executeUpdate();                
                dataTableTerkirim();
                dataTableKirim();  
             } else {
                sql = "UPDATE `distribusi` SET `status`=?,`tanggal_diterima`=? WHERE `id_distribusi`=?;";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1,cUpdateStatus.getSelectedItem().toString());
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                String date = sdf2.format(tUpdateTanggal.getDate());
                stat.setString(2, date);                     
                stat.setString(3,tIdDistribusi.getText());
                stat.executeUpdate();                
                dataTableTerkirim();
                dataTableKirim();

            }
             bersih();
             JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
    }//GEN-LAST:event_bUpdateActionPerformed

    private void tabTerkirimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabTerkirimMouseClicked
        // TODO add your handling code here:
        int bar = tabTerkirim.getSelectedRow();
        String a = tabModeTerkirim.getValueAt(bar,0).toString();
        String b = tabModeTerkirim.getValueAt(bar,8).toString();
        cIdDistribusi.setSelectedItem(a);
        cUpdateStatus.setSelectedItem(b);
        tIdDistribusi.setText(a);
        
    }//GEN-LAST:event_tabTerkirimMouseClicked

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
            java.util.logging.Logger.getLogger(DistribusiJalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DistribusiJalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DistribusiJalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DistribusiJalan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DistribusiJalan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBack1;
    private javax.swing.JButton bHome;
    private javax.swing.JButton bKirim;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> cIdDistribusi;
    private javax.swing.JComboBox<String> cUpdateStatus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tIdDistribusi;
    private com.toedter.calendar.JDateChooser tUpdateTanggal;
    private javax.swing.JTable tabKirim;
    private javax.swing.JTable tabTerkirim;
    // End of variables declaration//GEN-END:variables
}
