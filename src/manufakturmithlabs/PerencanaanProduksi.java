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
public class PerencanaanProduksi extends javax.swing.JFrame {
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    private DefaultTableModel tabModeProduksi;
    private DefaultTableModel tabModeBahanProduksi;

    /**
     * Creates new form PerencanaanProduksi2
     */
    public PerencanaanProduksi() {
         Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);     
        tampil_combo_bahan();
        dataTableProduksi();
        dataTableBahanProduksi();
    }
    
    protected void bersih(){
        cKodeBarang.setSelectedIndex(0);
        tNamaBarang.setText("");
        tStockUsed.setText("");
        tSatuan.setText("");
        tHarga.setText("");
        tStatusStock.setText("");
    }
    
    protected void bersih1(){
        tKodeProduksi.setText("PRO-");
        tNamaProduk.setText("");
        tSKUProduk.setText("");
        tJumlahProduk.setText("");
    }
    
    protected void dataTableProduksi(){
        Object[] Baris = {"Kode Produksi","SKU Produk","Nama Produk","Qty","Status"};
        tabModeProduksi = new DefaultTableModel(null,Baris);
        tabPerencanaanProduksi.setModel(tabModeProduksi);
        
        try{
            sql = "SELECT `kd_produksi`, `product_sku`, `product_name`, `product_qty`, `status` FROM `produksi` WHERE `status` = 'Plan';";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("kd_produksi");
                String b = rs.getString("product_sku");
                String c = rs.getString("product_name");
                String d = rs.getString("product_qty");
                String e = rs.getString("status");
                String[]data = {a,b,c,d,e};
                tabModeProduksi.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Load Data Produksi");
        }
    }
    
    protected void dataTableBahanProduksi(){
        Object[] Baris = {"Kode Barang","Stock Used","Kode Produksi","Total Biaya"};
        tabModeBahanProduksi = new DefaultTableModel(null,Baris);
        tabBahanProduksi.setModel(tabModeBahanProduksi);
        
        try{
            sql = "SELECT `kd_barang`, `stock_used`, `kd_produksi`, `total_biaya` FROM `bahan_produksi` WHERE `kd_produksi` = '"+(tKodeProduksi.getText())+"';";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("kd_barang");
                String b = rs.getString("stock_used");
                String c = rs.getString("kd_produksi");
                String d = rs.getString("total_biaya");
                String[]data = {a,b,c,d};
                tabModeBahanProduksi.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Load Bahan Produksi");
        }
    }
    
    public void tampil_combo_bahan(){
        try {
        String sql = "SELECT `kd_barang` FROM `bahan` ORDER BY 'kd_barang'";
        rs = stat.executeQuery(sql);                               
        while(rs.next()){
            Object[] obb = new Object[3];
            obb[0] = rs.getString(1);
            cKodeBarang.addItem((String) obb[0]);
        }
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void tampil_combo_selected()
    {
        try {
        String sql = "SELECT `nama_barang`, `satuan`, `harga`, `stock` FROM `bahan` WHERE `kd_barang` = '"+cKodeBarang.getSelectedItem()+"';";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] obsel = new Object[4];
            obsel[0]= rs.getString(1);
            obsel[1]= rs.getString(2);
            obsel[2]= rs.getString(3);
            obsel[3]= rs.getString(4);
                       
            tNamaBarang.setText((String) obsel[0]);
            tSatuan.setText((String) obsel[1]);
            tHarga.setText((String) obsel[2]);
            tStatusStock.setText((String) obsel[3]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cKodeBarang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        tNamaBarang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tStockUsed = new javax.swing.JTextField();
        tSatuan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bAdd = new javax.swing.JButton();
        bClear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabBahanProduksi = new javax.swing.JTable();
        bRemove = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tHarga = new javax.swing.JTextField();
        bRefresh = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        tStatusStock = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bDelete = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bSave = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tKodeProduksi = new javax.swing.JTextField();
        tNamaProduk = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tSKUProduk = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tJumlahProduk = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bClear2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabPerencanaanProduksi = new javax.swing.JTable();
        bHome = new javax.swing.JButton();
        bBack = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        bMove = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(251, 238, 193));
        jPanel3.setMaximumSize(new java.awt.Dimension(1366, 768));
        jPanel3.setPreferredSize(new java.awt.Dimension(1350, 768));

        jPanel2.setBackground(new java.awt.Color(251, 238, 193));

        jLabel7.setText("Kode Barang");

        cKodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an item" }));
        cKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cKodeBarangActionPerformed(evt);
            }
        });

        jLabel8.setText("Nama Barang");

        tNamaBarang.setEditable(false);

        jLabel9.setText("Stock Used");

        tSatuan.setEditable(false);

        jLabel10.setText("Satuan");

        bAdd.setText("Add");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        tabBahanProduksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabBahanProduksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabBahanProduksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabBahanProduksi);

        bRemove.setText("Remove");
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });

        jLabel11.setText("Harga/@");

        tHarga.setEditable(false);

        bRefresh.setText("Refresh");
        bRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRefreshActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel15.setText("Status Stock");

        tStatusStock.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(bAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bClear)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bRefresh))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tStockUsed)
                            .addComponent(tSatuan)
                            .addComponent(tHarga)
                            .addComponent(cKodeBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tStatusStock, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(998, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tStatusStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tStockUsed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tHarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bAdd)
                            .addComponent(bClear)
                            .addComponent(bRemove)
                            .addComponent(bRefresh))))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(251, 238, 193));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bUpdate.setText("Update");
        bUpdate.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                bUpdateAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        jLabel2.setText("Kode Produksi ");

        tKodeProduksi.setText("PRO-");

        jLabel3.setText("Nama Produk");

        tSKUProduk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tSKUProdukActionPerformed(evt);
            }
        });

        jLabel4.setText("SKU Produk");

        jLabel5.setText("Jumlah Produk");

        bClear2.setText("Clear");
        bClear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClear2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tKodeProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tSKUProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(tJumlahProduk)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(bClear2)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tKodeProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tSKUProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tJumlahProduk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSave)
                    .addComponent(bUpdate)
                    .addComponent(bDelete)
                    .addComponent(bClear2))
                .addGap(73, 73, 73))
        );

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel12.setText("Perencanaan Produksi");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logomithlabs100.png"))); // NOI18N
        jLabel13.setToolTipText("");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel14.setText("PRODUKSI");

        tabPerencanaanProduksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tabPerencanaanProduksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPerencanaanProduksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabPerencanaanProduksi);

        bHome.setText("Home");
        bHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHomeActionPerformed(evt);
            }
        });

        bBack.setText("Back");
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Move to Production");

        bMove.setText("Move");
        bMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bMove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(5, 5, 5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(bMove)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1305, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(bHome)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(bBack))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 880, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(bHome)
                                    .addComponent(bBack))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(388, 388, 388))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tSKUProdukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tSKUProdukActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tSKUProdukActionPerformed

    private void bHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHomeActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_bHomeActionPerformed

    private void tabPerencanaanProduksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPerencanaanProduksiMouseClicked
        // TODO add your handling code here:
        int bar = tabPerencanaanProduksi.getSelectedRow();
        String a = tabModeProduksi.getValueAt(bar,0).toString();
        String b = tabModeProduksi.getValueAt(bar,1).toString();
        String c = tabModeProduksi.getValueAt(bar,2).toString();
        String d = tabModeProduksi.getValueAt(bar,3).toString();
        String e = tabModeProduksi.getValueAt(bar,4).toString();
      
        tKodeProduksi.setText(a);
        tSKUProduk.setText(b);
        tNamaProduk.setText(c);
        tJumlahProduk.setText(d);
        dataTableBahanProduksi();
    }//GEN-LAST:event_tabPerencanaanProduksiMouseClicked

    private void bClear2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClear2ActionPerformed
        // TODO add your handling code here:
        bersih1();
    }//GEN-LAST:event_bClear2ActionPerformed

    private void tabBahanProduksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabBahanProduksiMouseClicked
        // TODO add your handling code here:
        int bar = tabBahanProduksi.getSelectedRow();
        String a = tabModeBahanProduksi.getValueAt(bar,0).toString();
        String b = tabModeBahanProduksi.getValueAt(bar,1).toString();
      
        cKodeBarang.setSelectedItem(a);
        tStockUsed.setText(b);

    }//GEN-LAST:event_tabBahanProduksiMouseClicked

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_bClearActionPerformed

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        // TODO add your handling code here:
        // Connected to tKodeProduksi
        try{
            {
                float stockUsed = Float.parseFloat(tStockUsed.getText());
                float harga = Float.parseFloat(tHarga.getText());
                float totalBiaya = stockUsed * harga;
                String sTotalBiaya = String.valueOf(totalBiaya);

                sql = "INSERT INTO `bahan_produksi`(`kd_barang`, `stock_used`, `total_biaya`, `kd_produksi`) VALUES (?,?,?,?)";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1,cKodeBarang.getSelectedItem().toString());
                stat.setString(2,tStockUsed.getText());
                stat.setString(3,sTotalBiaya);
                stat.setString(4,tKodeProduksi.getText());
                stat.executeUpdate();
                dataTableBahanProduksi();
            }
            {
                sql = "UPDATE `bahan` SET `stock`=stock-? WHERE `kd_barang`=?";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(2,cKodeBarang.getSelectedItem().toString());
                //String stockUsed = tStockUsed.getText();
                stat.setString(1,tStockUsed.getText()); 
                stat.executeUpdate();
                cKodeBarang.requestFocus();
                bersih();
            }
            JOptionPane.showMessageDialog(null, "Data Bahan Produksi Berhasil di tambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
    }//GEN-LAST:event_bAddActionPerformed

    private void cKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cKodeBarangActionPerformed
        // TODO add your handling code here:
        tampil_combo_selected();

    }//GEN-LAST:event_cKodeBarangActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        // TODO add your handling code here:
        try{
            {
                sql = "INSERT INTO `produksi`(`kd_produksi`, `product_name`, `start_date`, `product_sku`, `product_qty`, `status`, `end_date`) VALUES "
                        + "(?,?,'',?,?,'Plan','');";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1,tKodeProduksi.getText());
                stat.setString(2,tNamaProduk.getText());
                stat.setString(3,tSKUProduk.getText());
                stat.setString(4,tJumlahProduk.getText());
                stat.executeUpdate();
                dataTableBahanProduksi();
                dataTableProduksi();
                bersih();
            }
            JOptionPane.showMessageDialog(null, "Data Rencana Produksi Berhasil di tambahkan");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
        
    }//GEN-LAST:event_bSaveActionPerformed

    private void bRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRefreshActionPerformed
        // TODO add your handling code here:
        dataTableBahanProduksi();
    }//GEN-LAST:event_bRefreshActionPerformed

    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        // TODO add your handling code here:
        try{
            {
                sql = "DELETE FROM `bahan_produksi` WHERE `kd_barang` = '"+cKodeBarang.getSelectedItem().toString()+"' AND `kd_produksi` = '"+tKodeProduksi.getText()+"';";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                dataTableBahanProduksi();
            }
            {
                sql = "UPDATE `bahan` SET `stock`=stock+? WHERE `kd_barang`=?";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(2,cKodeBarang.getSelectedItem().toString());
                stat.setString(1,tStockUsed.getText()); 
                stat.executeUpdate();
                cKodeBarang.requestFocus();
                bersih();
            }
            JOptionPane.showMessageDialog(null, "Data Bahan Produksi Berhasil Dihapus (Stock dikembalikan)");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
    }//GEN-LAST:event_bRemoveActionPerformed

    private void bUpdateAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_bUpdateAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_bUpdateAncestorMoved

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        try{
            {
                sql = "UPDATE `produksi` SET `product_name`=?,`product_sku`=?,`product_qty`=? WHERE `kd_produksi`= '"+tKodeProduksi.getText()+"';";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.setString(1,tNamaProduk.getText());
                stat.setString(2,tSKUProduk.getText());
                stat.setString(3,tJumlahProduk.getText());
                stat.executeUpdate();
                dataTableBahanProduksi();
                dataTableProduksi();
                bersih();
            }
            JOptionPane.showMessageDialog(null, "Data Produksi Berhasil Diperbaharui");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
        
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        try{
            {
                sql = "DELETE FROM `produksi` WHERE `kd_produksi` ='"+tKodeProduksi.getText()+"';";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                dataTableBahanProduksi();
                dataTableProduksi();
                bersih();
                bersih1();
            }
            {
                sql = "DELETE FROM `bahan_produksi` WHERE kd_produksi ='"+tKodeProduksi.getText()+"';";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                dataTableBahanProduksi();
                dataTableProduksi();
                bersih();
                bersih1();
            }
            JOptionPane.showMessageDialog(null, "Data Rencana Produksi Berhasil Dihapus");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan"+e.getMessage());
        }
        
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMoveActionPerformed
        // TODO add your handling code here:
        try{
            {
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
                String todayDate = sdf2.format(new Date());     
                sql = "UPDATE `produksi` SET `status`='WIP', `start_date`='"+todayDate+"' WHERE `kd_produksi`= '"+tKodeProduksi.getText()+"';";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                dataTableBahanProduksi();
                dataTableProduksi();
                bersih();
            }
            JOptionPane.showMessageDialog(null, "Berhasil Masuk ke Produksi");
            int a = JOptionPane.showConfirmDialog(null,"Menuju Tampilan Produksi?");
            if (a==JOptionPane.YES_OPTION){
                new Produksi().setVisible(true);
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data Gagal Diupdate"+e.getMessage());
        }
    }//GEN-LAST:event_bMoveActionPerformed

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        // TODO add your handling code here:
        new DashProduksi().setVisible(true);
        dispose();
    }//GEN-LAST:event_bBackActionPerformed

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
            java.util.logging.Logger.getLogger(PerencanaanProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PerencanaanProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PerencanaanProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PerencanaanProduksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PerencanaanProduksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bBack;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bClear2;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bHome;
    private javax.swing.JButton bMove;
    private javax.swing.JButton bRefresh;
    private javax.swing.JButton bRemove;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> cKodeBarang;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField tHarga;
    private javax.swing.JTextField tJumlahProduk;
    private javax.swing.JTextField tKodeProduksi;
    private javax.swing.JTextField tNamaBarang;
    private javax.swing.JTextField tNamaProduk;
    private javax.swing.JTextField tSKUProduk;
    private javax.swing.JTextField tSatuan;
    private javax.swing.JTextField tStatusStock;
    private javax.swing.JTextField tStockUsed;
    private javax.swing.JTable tabBahanProduksi;
    private javax.swing.JTable tabPerencanaanProduksi;
    // End of variables declaration//GEN-END:variables
}
