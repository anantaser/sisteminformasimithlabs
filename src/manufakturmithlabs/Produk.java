/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufakturmithlabs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Mithlabs
 */
public class Produk extends javax.swing.JFrame {
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    String sql2;
    private DefaultTableModel tabModeBarangJadi;
    private DefaultTableModel tabModeBarangJadiNon;

    /**
     * Creates new form NewJFrame
     */
    public Produk() {

        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);      
        dataTableBarangJadi();
        dataTableBarangJadiNon();
       
       
        
    }
    
    protected void bersih(){
        tNamaProduk.setText("");
        tSKUProduk.setText("");
        tJumlahProduk.setText("");
        tBiayaBahanBaku.setText("");
        tBiayaProduksi.setText("");
        tCOGM.setText("");
        tMargin.setText("");
        tCOGS.setText("");

    }
    
    protected void dataTableBarangJadi(){
        Object[] Baris = {"SKU","Nama Barang","Qty","Biaya","COGM","COGS","Material Cost","Margin","Gudang"};
        tabModeBarangJadi = new DefaultTableModel(null,Baris);
        TabBarangJadi.setModel(tabModeBarangJadi);
        
        try{
            sql = "SELECT `product_sku`, `product_name`, `product_qty`, `product_cost`, `cogm`, `material_cost`, `cogs`,`margin`,`gudang` FROM `produk` WHERE `gudang`='Bogor'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("product_sku");
                String b = rs.getString("product_name");
                String c = rs.getString("product_qty");
                String d = rs.getString("product_cost");
                String e = rs.getString("cogm");
                String f = rs.getString("cogs");                
                String g = rs.getString("material_cost");
                String h = rs.getString("margin");
                String i = rs.getString("gudang");
                String[] data = {a,b,c,d,e,f,g,h,i};
                tabModeBarangJadi.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Load Data Barang Jadi");
        }
    }
    
    protected void dataTableBarangJadiNon(){
        Object[] Baris = {"SKU","Nama Barang","Qty","Biaya","COGM","COGS","Material Cost","Margin","Gudang"};
        tabModeBarangJadiNon = new DefaultTableModel(null,Baris);
        TabBarangJadiNon.setModel(tabModeBarangJadiNon);
        
        try{
            sql = "SELECT `product_sku`, `product_name`, `product_qty`, `product_cost`, `cogm`, `cogs`,`material_cost`,`margin`,`gudang` FROM `produk` WHERE NOT `gudang`='Bogor'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("product_sku");
                String b = rs.getString("product_name");
                String c = rs.getString("product_qty");
                String d = rs.getString("product_cost");
                String e = rs.getString("cogm");
                String f = rs.getString("cogs");
                String g = rs.getString("material_cost");
                String h = rs.getString("margin");
                String i = rs.getString("gudang");
                String[] data = {a,b,c,d,e,f,g,h,i};
                tabModeBarangJadiNon.addRow(data);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TabBarangJadi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bHome = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tBiayaBahanBaku = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tBiayaProduksi = new javax.swing.JTextField();
        bCalculateCOGM = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        tCOGM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tMargin = new javax.swing.JTextField();
        bCalculateCOGS = new javax.swing.JButton();
        tCOGS = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNamaProduk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tJumlahProduk = new javax.swing.JTextField();
        tSKUProduk = new javax.swing.JTextField();
        bUpdate = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabBarangJadiNon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(151, 202, 239));
        jPanel3.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel3.setPreferredSize(new java.awt.Dimension(1366, 768));
        jPanel3.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(151, 202, 239));
        jPanel1.setMaximumSize(new java.awt.Dimension(1366, 768));

        TabBarangJadi.setModel(new javax.swing.table.DefaultTableModel(
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
        TabBarangJadi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabBarangJadiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabBarangJadi);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Tabel Produk - Gudang Bogor");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel10.setText("PRODUK");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logomithlabs100.png"))); // NOI18N
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Data Produk");

        bHome.setText("Home");
        bHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHomeActionPerformed(evt);
            }
        });

        jLabel4.setText("Biaya Bahan Baku ");

        tBiayaBahanBaku.setEditable(false);
        tBiayaBahanBaku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBiayaBahanBakuActionPerformed(evt);
            }
        });

        jLabel5.setText("Biaya Produksi");

        tBiayaProduksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tBiayaProduksiActionPerformed(evt);
            }
        });

        bCalculateCOGM.setText("Calculate COGM");
        bCalculateCOGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalculateCOGMActionPerformed(evt);
            }
        });

        jLabel7.setText("COGM");

        tCOGM.setEditable(false);
        tCOGM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCOGMActionPerformed(evt);
            }
        });

        jLabel6.setText("Margin (%)");

        tMargin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tMarginActionPerformed(evt);
            }
        });

        bCalculateCOGS.setText("Calculate COGS");
        bCalculateCOGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalculateCOGSActionPerformed(evt);
            }
        });

        tCOGS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCOGSActionPerformed(evt);
            }
        });

        jLabel3.setText("Nama Produk");

        jLabel8.setText("SKU Produk");

        jLabel9.setText("Jumlah Produk");

        tSKUProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSKUProdukActionPerformed(evt);
            }
        });

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tMargin, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bCalculateCOGM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tBiayaProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tBiayaBahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bCalculateCOGS, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(tCOGS))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tCOGM, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tNamaProduk)
                            .addComponent(tSKUProduk)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tJumlahProduk))
                    .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tSKUProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tJumlahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tBiayaBahanBaku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tBiayaProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCalculateCOGM)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tCOGM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tMargin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCalculateCOGS)
                    .addComponent(tCOGS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bUpdate)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Tabel Produk - Gudang Lain");

        TabBarangJadiNon.setModel(new javax.swing.table.DefaultTableModel(
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
        TabBarangJadiNon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabBarangJadiNonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TabBarangJadiNon);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bHome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 245, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void TabBarangJadiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarangJadiMouseClicked
        // TODO add your handling code here:
        //"SKU","Nama Barang","Qty","Biaya","COGM","COGS","Material Cost","Margin","Gudang"
        int bar = TabBarangJadi.getSelectedRow();
        String a = tabModeBarangJadi.getValueAt(bar,0).toString();
        String b = tabModeBarangJadi.getValueAt(bar,1).toString();
        String c = tabModeBarangJadi.getValueAt(bar,2).toString();
        String d = tabModeBarangJadi.getValueAt(bar,3).toString();
        String e = tabModeBarangJadi.getValueAt(bar,4).toString();
        String f = tabModeBarangJadi.getValueAt(bar,5).toString();
        String g = tabModeBarangJadi.getValueAt(bar,6).toString();
        String h = tabModeBarangJadi.getValueAt(bar,7).toString();
        String i = tabModeBarangJadi.getValueAt(bar,7).toString();
        
        tSKUProduk.setText(a);
        tNamaProduk.setText(b);
        tJumlahProduk.setText(c);
        tBiayaProduksi.setText(d);
        tCOGM.setText(e);
        tCOGS.setText(f);
        tBiayaBahanBaku.setText(g);
        tMargin.setText(h); 
    }//GEN-LAST:event_TabBarangJadiMouseClicked

    private void bHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHomeActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_bHomeActionPerformed

    private void tBiayaBahanBakuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBiayaBahanBakuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tBiayaBahanBakuActionPerformed

    private void tBiayaProduksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tBiayaProduksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tBiayaProduksiActionPerformed

    private void bCalculateCOGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalculateCOGMActionPerformed
        // TODO add your handling code here:
        try{
            float biayaBahanBaku = Float.parseFloat(tBiayaBahanBaku.getText());
            float biayaProduksi = Float.parseFloat(tBiayaProduksi.getText());
            float cogm = biayaBahanBaku + biayaProduksi;
            String sCOGM = String.format("%.00f",cogm);;
            tCOGM.setText(sCOGM);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
    }//GEN-LAST:event_bCalculateCOGMActionPerformed

    private void tCOGMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCOGMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCOGMActionPerformed

    private void tMarginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tMarginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tMarginActionPerformed

    private void bCalculateCOGSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalculateCOGSActionPerformed
        // TODO add your handling code here:
        try{
            float fCOGM = Float.parseFloat(tCOGM.getText());
            float fMargin = Float.parseFloat(tMargin.getText());
            float cogs = fCOGM + (fCOGM*(fMargin/100)) ;
            String sCOGS = String.format("%.00f",cogs);;
            tCOGS.setText(sCOGS);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
    }//GEN-LAST:event_bCalculateCOGSActionPerformed

    private void tCOGSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCOGSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCOGSActionPerformed

    private void tSKUProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSKUProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSKUProdukActionPerformed

    private void TabBarangJadiNonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabBarangJadiNonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabBarangJadiNonMouseClicked

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
         try{
             
             {
                sql = "UPDATE `produk` SET `product_name`=?,`product_qty`=?,`product_cost`=?,`cogm`=?,`cogs`=?,`margin`=? WHERE `product_sku` = '"+tSKUProduk.getText()+"' AND `product_qty`= '"+tJumlahProduk.getText()+"' ;";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);  
                stat.setString(1,tNamaProduk.getText());
                stat.setString(2,tJumlahProduk.getText());
                stat.setString(3,tBiayaProduksi.getText());
                stat.setString(4,tCOGM.getText());
                stat.setString(5,tCOGS.getText());
                stat.setString(6,tMargin.getText());         
                stat.executeUpdate();
                bersih();
                dataTableBarangJadi();
             }                      
             JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
    }//GEN-LAST:event_bUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new Produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabBarangJadi;
    private javax.swing.JTable TabBarangJadiNon;
    private javax.swing.JButton bCalculateCOGM;
    private javax.swing.JButton bCalculateCOGS;
    private javax.swing.JButton bHome;
    private javax.swing.JButton bUpdate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tBiayaBahanBaku;
    private javax.swing.JTextField tBiayaProduksi;
    private javax.swing.JTextField tCOGM;
    private javax.swing.JTextField tCOGS;
    private javax.swing.JTextField tJumlahProduk;
    private javax.swing.JTextField tMargin;
    private javax.swing.JTextField tNamaProduk;
    private javax.swing.JTextField tSKUProduk;
    // End of variables declaration//GEN-END:variables
}
