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
/**
 *
 * @author MithLabs
 */
public class ProsesManufaktur extends javax.swing.JFrame {
    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql,upsql,usql1,usql2,usql3,usql4,usql5,usql6,usql7,usql8;
    private DefaultTableModel tabmode;
    private DefaultTableModel tabmode2;

    /**
     * Creates new form ProsesManufaktur
     */
    public ProsesManufaktur() {
        
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        
        initComponents();
        tampil_combo_bp();
        tampil_combo_bb();
        datatable();
        bersih();
        
    }
    
    public void datatable2(){
        Object [] Baris2 ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47};
        tabmode2 = new DefaultTableModel(null,Baris2);
        
        try{
            sql = "SELECT `kdproduksi`, `tglproduksi`, `namabarangjadi`, `SKUBarang`, `jumlahbarang`, `kdbb1`, `kdbb2`, `kdbb3`, `kdbb4`, `kdbp1`, `kdbp2`, `kdbp3`, `kdbp4`, `nbbb1`, `nbbb2`, `nbbb3`, `nbbb4`, `nbbp1`, `nbbp2`, `nbbp3`, `nbbp4`, `hsbb1`, `hsbb2`, `hsbb3`, `hsbb4`, `hsbp1`, `hsbp2`, `hsbp3`, `hsbp4`, `jbbb1`, `jbbb2`, `jbbb3`, `jbbb4`, `jbbp1`, `jbbp2`, `jbbp3`, `jbbp4`, `tttlbb1`, `tttlbb2`, `tttlbb3`, `tttlbb4`, `tttlbp1`, `tttlbp2`, `tttlbp3`, `tttlbp4`, `biayaproduksi`, `hpp`, `status` FROM `proses` WHERE `status` = 'WIP'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("kdproduksi");
                String b = rs.getString("tglproduksi");
                String c = rs.getString("namabarangjadi");
                String d = rs.getString("SKUbarang");
                String e = rs.getString("jumlahbarang");
                String f = rs.getString("kdbb1");
                String g = rs.getString("kdbb2");
                String h = rs.getString("kdbb3");
                String i = rs.getString("kdbb4");
                String j = rs.getString("kdbp1");
                String k = rs.getString("kdbp2");
                String l = rs.getString("kdbp3");
                String m = rs.getString("kdbp4");
                String n = rs.getString("nbbb1");
                String o = rs.getString("nbbb2");
                String p = rs.getString("nbbb3");
                String q = rs.getString("nbbb4");
                String r = rs.getString("nbbp1");
                String s = rs.getString("nbbp2");
                String t = rs.getString("nbbp3");
                String u = rs.getString("nbbp4");
                String v = rs.getString("hsbb1");
                String w = rs.getString("hsbb2");
                String x = rs.getString("hsbb3");
                String y = rs.getString("hsbb4");
                String z = rs.getString("hsbp1");
                String aa = rs.getString("hsbp2");
                String ab = rs.getString("hsbp3");
                String ac = rs.getString("hsbp4");
                String ad = rs.getString("jbbb1");
                String ae = rs.getString("jbbb2");
                String af = rs.getString("jbbb3");
                String ag = rs.getString("jbbb4");
                String ah = rs.getString("jbbp1");
                String ai = rs.getString("jbbp2");
                String aj = rs.getString("jbbp3");
                String ak = rs.getString("jbbp4");
                String al = rs.getString("tttlbb1");
                String am = rs.getString("tttlbb2");
                String an = rs.getString("tttlbb3");
                String ao = rs.getString("tttlbb4");
                String ap = rs.getString("tttlbp1");
                String aq = rs.getString("tttlbb2");
                String ar = rs.getString("tttlbb3");
                String as = rs.getString("tttlbb4");
                String at = rs.getString("biayaproduksi");
                String au = rs.getString("hpp");
                
                String[] data = {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,aa,ab,ac,ad,ae,af,ag,ah,ai,aj,ak,al,am,an,ao,ap,aq,ar,as,at,au};
                tabmode2.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected void datatable(){
        Object[] Baris = {"Kode Produksi","Tanggal Produksi","Nama Barang","SKU Barang","Jumlah Barang"};
        tabmode = new DefaultTableModel(null,Baris);
        TabWIP.setModel(tabmode);
        
        try{
            sql = "SELECT `kdproduksi`, `tglproduksi`, `namabarangjadi`, `SKUBarang`, `jumlahbarang` FROM `proses` WHERE `status` = 'WIP'";
            rs = stat.executeQuery(sql);
            while(rs.next()){
                String a = rs.getString("kdproduksi");
                String b = rs.getString("tglproduksi");
                String c = rs.getString("namabarangjadi");
                String d = rs.getString("SKUbarang");
                String e = rs.getString("jumlahbarang");
                String[] data = {a,b,c,d,e};
                tabmode.addRow(data);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    protected void bersih(){
        tKodeProduksi.setText("PRO-");
        tTanggalProduksi.setCalendar(null);
        tNamaBarangJadi.setText("");
        tSKUBarang.setText("");
        tJumlahBarang.setText("");
        cBB1.setSelectedIndex(0);
        cBB2.setSelectedIndex(0);
        cBB3.setSelectedIndex(0);
        cBB4.setSelectedIndex(0);
        cBP1.setSelectedIndex(0);
        cBP2.setSelectedIndex(0);
        cBP3.setSelectedIndex(0);
        cBP4.setSelectedIndex(0);
        tnbBB1.setText("");
        tnbBB2.setText("");
        tnbBB3.setText("");
        tnbBB4.setText("");
        tnbBP1.setText("");
        tnbBP2.setText("");
        tnbBP3.setText("");
        tnbBP4.setText("");
        thsBB1.setText("");
        thsBB2.setText("");
        thsBB3.setText("");
        thsBB4.setText("");
        thsBP1.setText("");
        thsBP2.setText("");
        thsBP3.setText("");
        thsBP4.setText("");
        tjmlBB1.setText("");
        tjmlBB2.setText("");
        tjmlBB3.setText("");
        tjmlBB4.setText("");
        tjmlBP1.setText("");
        tjmlBP2.setText("");
        tjmlBP3.setText("");
        tjmlBP4.setText("");
        tttlBB1.setText("");
        tttlBB2.setText("");
        tttlBB3.setText("");
        tttlBB4.setText("");
        tttlBP1.setText("");
        tttlBP2.setText("");
        tttlBP3.setText("");
        tttlBP4.setText("");
        tBiayaProduksi.setText("");
        tHPP.setText("");
        tTanggalJadi.setCalendar(null);
    }
    
    public void tampil_combo_bp()
    {
        try {
        String sql = "SELECT `kdbarang` FROM `bahan` WHERE kategori = 'Bahan Penolong'";
        rs = stat.executeQuery(sql);                               
        while(rs.next()){
            Object[] obp = new Object[3];
            obp[0] = rs.getString(1);
            cBP1.addItem((String) obp[0]);
            cBP2.addItem((String) obp[0]);
            cBP3.addItem((String) obp[0]);
            cBP4.addItem((String) obp[0]);
            
        }
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void tampil_combo_bb()
    {
        try {
        String sql = "SELECT `kdbarang` FROM `bahan` WHERE kategori = 'Bahan Baku'";
        rs = stat.executeQuery(sql);                               
        while(rs.next()){
            Object[] obb = new Object[3];
            obb[0] = rs.getString(1);
            cBB1.addItem((String) obb[0]);
            cBB2.addItem((String) obb[0]);
            cBB3.addItem((String) obb[0]);
            cBB4.addItem((String) obb[0]);
            
        }
         
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void tampilCBB1()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBB1.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob = new Object[6];
            ob[0]= rs.getString(1);
            ob[1]= rs.getString(2);
                       
            tnbBB1.setText((String) ob[0]);
            thsBB1.setText((String) ob[1]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
    
    public void tampilCBB2()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBB2.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob2 = new Object[6];
            ob2[0]= rs.getString(1);
            ob2[1]= rs.getString(2);
                       
            tnbBB2.setText((String) ob2[0]);
            thsBB2.setText((String) ob2[1]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
    
    public void tampilCBB3()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBB3.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob3 = new Object[6];
            ob3[0]= rs.getString(1);
            ob3[1]= rs.getString(2);
                       
            tnbBB3.setText((String) ob3[0]);
            thsBB3.setText((String) ob3[1]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
    
    public void tampilCBB4()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBB4.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob4 = new Object[2];
            ob4[0]= rs.getString(1);
            ob4[1]= rs.getString(2);
                       
            tnbBB4.setText((String) ob4[0]);
            thsBB4.setText((String) ob4[1]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
    
    public void tampilCBP1()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBP1.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob4 = new Object[2];
            ob4[0]= rs.getString(1);
            ob4[1]= rs.getString(2);
                       
            tnbBP1.setText((String) ob4[0]);
            thsBP1.setText((String) ob4[1]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
    
    public void tampilCBP2()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBP2.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob4 = new Object[2];
            ob4[0]= rs.getString(1);
            ob4[1]= rs.getString(2);
                       
            tnbBP2.setText((String) ob4[0]);
            thsBP2.setText((String) ob4[1]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
    
    public void tampilCBP3()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBP3.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob4 = new Object[2];
            ob4[0]= rs.getString(1);
            ob4[1]= rs.getString(2);
                       
            tnbBP3.setText((String) ob4[0]);
            thsBP3.setText((String) ob4[1]);
        }
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }              
    }
    
    public void tampilCBP4()
    {
        try {
        String sql = "SELECT `namabarang`, `harga` FROM `bahan` WHERE kdbarang = '"+cBP4.getSelectedItem()+"'";  
        rs = stat.executeQuery(sql);
        
        while(rs.next()){
            Object[] ob4 = new Object[2];
            ob4[0]= rs.getString(1);
            ob4[1]= rs.getString(2);
                       
            tnbBP4.setText((String) ob4[0]);
            thsBP4.setText((String) ob4[1]);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tKodeProduksi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tNamaBarangJadi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tTanggalProduksi = new com.toedter.calendar.JDateChooser();
        tttlBB1 = new javax.swing.JTextField();
        tjmlBB1 = new javax.swing.JTextField();
        thsBB1 = new javax.swing.JTextField();
        tnbBB1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tnbBB2 = new javax.swing.JTextField();
        thsBB2 = new javax.swing.JTextField();
        tjmlBB2 = new javax.swing.JTextField();
        tttlBB2 = new javax.swing.JTextField();
        tnbBB3 = new javax.swing.JTextField();
        tttlBB3 = new javax.swing.JTextField();
        thsBB3 = new javax.swing.JTextField();
        tjmlBB3 = new javax.swing.JTextField();
        tjmlBB4 = new javax.swing.JTextField();
        tnbBB4 = new javax.swing.JTextField();
        thsBB4 = new javax.swing.JTextField();
        tttlBB4 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tBiayaProduksi = new javax.swing.JTextField();
        bSave = new javax.swing.JButton();
        bDelete = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        tJumlahBarang = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabWIP = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        bClear = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        tSKUBarang = new javax.swing.JTextField();
        cBB1 = new javax.swing.JComboBox<>();
        cBB2 = new javax.swing.JComboBox<>();
        cBB3 = new javax.swing.JComboBox<>();
        cBB4 = new javax.swing.JComboBox<>();
        cBP1 = new javax.swing.JComboBox<>();
        cBP2 = new javax.swing.JComboBox<>();
        cBP3 = new javax.swing.JComboBox<>();
        cBP4 = new javax.swing.JComboBox<>();
        tnbBP1 = new javax.swing.JTextField();
        tnbBP2 = new javax.swing.JTextField();
        tnbBP3 = new javax.swing.JTextField();
        tnbBP4 = new javax.swing.JTextField();
        thsBP1 = new javax.swing.JTextField();
        thsBP2 = new javax.swing.JTextField();
        thsBP3 = new javax.swing.JTextField();
        thsBP4 = new javax.swing.JTextField();
        tjmlBP1 = new javax.swing.JTextField();
        tjmlBP2 = new javax.swing.JTextField();
        tjmlBP3 = new javax.swing.JTextField();
        tjmlBP4 = new javax.swing.JTextField();
        tttlBP1 = new javax.swing.JTextField();
        tttlBP2 = new javax.swing.JTextField();
        tttlBP3 = new javax.swing.JTextField();
        tttlBP4 = new javax.swing.JTextField();
        tHPP = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        bCalculate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        bCompleted = new javax.swing.JButton();
        tTanggalJadi = new com.toedter.calendar.JDateChooser();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        bHomeUpper = new javax.swing.JButton();
        bHomeBottom = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel1.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Proses Manufaktur");

        jLabel2.setText("Kode Produksi");

        tKodeProduksi.setText("PRO-");

        jLabel3.setText("Tanggal Produksi");

        jLabel4.setText("Nama Barang");

        tTanggalProduksi.setDateFormatString("yyyy-MM-dd");

        tttlBB1.setEditable(false);

        tjmlBB1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBB1KeyPressed(evt);
            }
        });

        thsBB1.setEditable(false);

        tnbBB1.setEditable(false);

        jLabel5.setText("Kode Barang");

        jLabel6.setText("Nama Barang");

        jLabel7.setText("Harga Satuan");

        jLabel8.setText("Jumlah");

        jLabel9.setText("Total");

        tnbBB2.setEditable(false);

        thsBB2.setEditable(false);

        tjmlBB2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBB2KeyPressed(evt);
            }
        });

        tttlBB2.setEditable(false);

        tnbBB3.setEditable(false);

        tttlBB3.setEditable(false);

        thsBB3.setEditable(false);

        tjmlBB3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBB3KeyPressed(evt);
            }
        });

        tjmlBB4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBB4KeyPressed(evt);
            }
        });

        tnbBB4.setEditable(false);

        thsBB4.setEditable(false);

        tttlBB4.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Bahan Baku");

        jLabel11.setText("Kode Barang");

        jLabel12.setText("Nama Barang");

        jLabel13.setText("Harga Satuan");

        jLabel14.setText("Jumlah");

        jLabel15.setText("Total");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Bahan Penolong");

        jLabel17.setText("Biiaya Produksi");

        bSave.setText("Save");
        bSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSaveActionPerformed(evt);
            }
        });

        bDelete.setText("Delete");
        bDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDeleteActionPerformed(evt);
            }
        });

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        jLabel19.setText("Jumlah Barang");

        TabWIP.setModel(new javax.swing.table.DefaultTableModel(
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
        TabWIP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabWIPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabWIP);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Barang Work in Progess");

        bClear.setText("Clear");
        bClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClearActionPerformed(evt);
            }
        });

        jLabel21.setText("SKU Barang");

        cBB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBB1ActionPerformed(evt);
            }
        });

        cBB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBB2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBB2ActionPerformed(evt);
            }
        });

        cBB3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBB3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBB3ActionPerformed(evt);
            }
        });

        cBB4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBB4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBB4ActionPerformed(evt);
            }
        });

        cBP1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBP1ActionPerformed(evt);
            }
        });

        cBP2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBP2ActionPerformed(evt);
            }
        });

        cBP3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBP3ActionPerformed(evt);
            }
        });

        cBP4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select here" }));
        cBP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBP4ActionPerformed(evt);
            }
        });

        tnbBP1.setEditable(false);

        tnbBP2.setEditable(false);

        tnbBP3.setEditable(false);

        tnbBP4.setEditable(false);

        thsBP1.setEditable(false);

        thsBP2.setEditable(false);

        thsBP3.setEditable(false);

        thsBP4.setEditable(false);

        tjmlBP1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBP1KeyPressed(evt);
            }
        });

        tjmlBP2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBP2KeyPressed(evt);
            }
        });

        tjmlBP3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBP3KeyPressed(evt);
            }
        });

        tjmlBP4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tjmlBP4KeyPressed(evt);
            }
        });

        tttlBP1.setEditable(false);

        tttlBP2.setEditable(false);

        tttlBP3.setEditable(false);

        tttlBP4.setEditable(false);

        jLabel22.setText("HPP");

        bCalculate.setText("Calculate");
        bCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalculateActionPerformed(evt);
            }
        });

        bCompleted.setText("Completed - Barang jadi");
        bCompleted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCompletedActionPerformed(evt);
            }
        });

        tTanggalJadi.setDateFormatString("yyyy-MM-dd");

        jLabel18.setText("Tanggal Jadi");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Barang Jadi");

        jLabel24.setText("Pindah Status Barang ke Barang Jadi");

        bHomeUpper.setText("Home");
        bHomeUpper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHomeUpperActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(tTanggalJadi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel23)
                        .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCompleted, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(bHomeUpper))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(tTanggalJadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bCompleted)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bHomeUpper)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bHomeBottom.setText("Home");
        bHomeBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHomeBottomActionPerformed(evt);
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
                        .addComponent(bSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bClear)
                        .addGap(39, 39, 39)
                        .addComponent(bHomeBottom))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(bCalculate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel22))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tBiayaProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tHPP, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel16)
                                    .addComponent(cBB1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cBB3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cBB4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cBB2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cBP1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cBP2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cBP3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cBP4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tnbBB1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(tnbBB2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnbBB3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnbBB4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(thsBB1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(thsBB3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tjmlBB3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tttlBB3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(thsBB2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(tjmlBB2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tttlBB2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(tjmlBB1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel8))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel9)
                                                    .addComponent(tttlBB1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel13)
                                                .addGap(133, 133, 133))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(thsBB4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tjmlBB4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(jLabel15))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(tttlBB4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tnbBP2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnbBP3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tnbBP4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(thsBP3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tjmlBP3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tttlBP3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(thsBP4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tjmlBP4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tttlBP4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(thsBP2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tjmlBP2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tttlBP2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tnbBP1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thsBP1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tjmlBP1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(tttlBP1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tKodeProduksi)
                            .addComponent(tNamaBarangJadi)
                            .addComponent(tJumlahBarang)
                            .addComponent(tSKUBarang)
                            .addComponent(tTanggalProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(217, 217, 217))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tKodeProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tTanggalProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNamaBarangJadi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tSKUBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tJumlahBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19)))
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thsBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thsBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thsBB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBB3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thsBB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cBB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBB4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBP1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thsBP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thsBP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thsBP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cBP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tnbBP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thsBP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tjmlBP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tttlBP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tBiayaProduksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(bCalculate, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(tHPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDelete)
                    .addComponent(bSave)
                    .addComponent(bUpdate)
                    .addComponent(bClear)
                    .addComponent(bHomeBottom))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bHomeBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHomeBottomActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_bHomeBottomActionPerformed

    private void bHomeUpperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHomeUpperActionPerformed
        // TODO add your handling code here:
        new Dashboard().setVisible(true);
        dispose();
    }//GEN-LAST:event_bHomeUpperActionPerformed

    private void bCompletedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCompletedActionPerformed
        // TODO add your handling code here:
        try {
            sql = "UPDATE `proses` SET `status`='Jadi',`tgljadi`=? WHERE kdproduksi = ?";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
            String date = sdf2.format(tTanggalJadi.getDate());
            stat.setString(1, date);
            stat.setString(2, tKodeProduksi.getText());
            stat.execute();
            tKodeProduksi.requestFocus();
            datatable();
            bersih();
            JOptionPane.showMessageDialog(null,"Status Barang Menjadi Barang Jadi");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);

        }

    }//GEN-LAST:event_bCompletedActionPerformed

    private void bCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalculateActionPerformed
        // TODO add your handling code here:
        float ftttlbb1 = 0;
        float ftttlbb2 = 0;
        float ftttlbb3 = 0;
        float ftttlbb4 = 0;
        float ftttlbp1 = 0;
        float ftttlbp2 = 0;
        float ftttlbp3 = 0;
        float ftttlbp4 = 0;
        float jumlahbarangjadi = 0;
        float fbiayaproduksi = 0;
        float HPPbb1 = 0;
        float HPPbb2 = 0;
        float HPPbb3 = 0;
        float HPPbb4 = 0;
        float HPPbp1 = 0;
        float HPPbp2 = 0;
        float HPPbp3 = 0;
        float HPPbp4 = 0;

        if (tJumlahBarang.getText().isEmpty()){
            jumlahbarangjadi=1;
        } else {
            jumlahbarangjadi = Float.parseFloat(tJumlahBarang.getText());
        }

        if (tttlBB1.getText().isEmpty()){
            HPPbb1 = 0;
            thsBB1.setText("0");
            tjmlBB1.setText("0");
            tttlBB1.setText("0");
        } else {
            ftttlbb1 = Float.parseFloat(tttlBB1.getText());
            HPPbb1 = ftttlbb1 / jumlahbarangjadi;
        }

        if (tttlBB2.getText().isEmpty()){
            HPPbb2 = 0;
            thsBB2.setText("0");
            tjmlBB2.setText("0");
            tttlBB2.setText("0");
        } else {
            ftttlbb2 = Float.parseFloat(tttlBB2.getText());
            HPPbb2 = ftttlbb2 / jumlahbarangjadi;
        }

        if (tttlBB3.getText().isEmpty()){
            HPPbb3 =0;
            thsBB3.setText("0");
            tjmlBB3.setText("0");
            tttlBB3.setText("0");
        } else {
            ftttlbb3 = Float.parseFloat(tttlBB3.getText());
            HPPbb3 = ftttlbb3 / jumlahbarangjadi;
        }

        if (tttlBB4.getText().isEmpty()){
            HPPbb4 = 0;
            thsBB4.setText("0");
            tjmlBB4.setText("0");
            tttlBB4.setText("0");
        } else {
            ftttlbb4 = Float.parseFloat(tttlBB4.getText());
            HPPbb4 = ftttlbb4 / jumlahbarangjadi;
        }

        if (tttlBP1.getText().isEmpty()){
            HPPbp1 = 0;
            thsBP1.setText("0");
            tjmlBP1.setText("0");
            tttlBP1.setText("0");
        } else {
            ftttlbp1 = Float.parseFloat(tttlBP1.getText());
            HPPbp1 = ftttlbp1 / jumlahbarangjadi;

        }

        if (tttlBP2.getText().isEmpty()){
            HPPbp2 = 0;
            thsBP2.setText("0");
            tjmlBP2.setText("0");
            tttlBP2.setText("0");
        } else {
            ftttlbp2 = Float.parseFloat(tttlBP2.getText());
            HPPbp2 = ftttlbp2 / jumlahbarangjadi;
        }

        if (tttlBP3.getText().isEmpty()){
            HPPbp3 = 0;
            thsBP3.setText("0");
            tjmlBP3.setText("0");
            tttlBP3.setText("0");
        } else {
            ftttlbp3 = Float.parseFloat(tttlBP3.getText());
            HPPbp3 = ftttlbp3 / jumlahbarangjadi;

        }

        if (tttlBP4.getText().isEmpty()){
            ftttlbp4 = 1;
            thsBP4.setText("0");
            tjmlBP4.setText("0");
            tttlBP4.setText("0");
        } else {
            ftttlbp4 = Float.parseFloat(tttlBP4.getText());
            HPPbp4 = ftttlbp4 / jumlahbarangjadi;
        }

        if (tBiayaProduksi.getText().isEmpty()){
            fbiayaproduksi = 0;
        } else {
            fbiayaproduksi = Float.parseFloat(tBiayaProduksi.getText());
        }

        float HPP = HPPbb1+HPPbb2+HPPbb3+HPPbb4+HPPbp1+HPPbp2+HPPbp3+HPPbp4+(fbiayaproduksi/jumlahbarangjadi);
        tHPP.setText(String.valueOf(HPP));
    }//GEN-LAST:event_bCalculateActionPerformed

    private void tjmlBP4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBP4KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBP4.getText());
            float jml1 = Float.parseFloat(tjmlBP4.getText());

            float total1 = hs1 * jml1;
            tttlBP4.setText(String.valueOf(total1));
        }
    }//GEN-LAST:event_tjmlBP4KeyPressed

    private void tjmlBP3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBP3KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBP3.getText());
            float jml1 = Float.parseFloat(tjmlBP3.getText());

            float total1 = hs1 * jml1;
            tttlBP3.setText(String.valueOf(total1));
        }
    }//GEN-LAST:event_tjmlBP3KeyPressed

    private void tjmlBP2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBP2KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBP2.getText());
            float jml1 = Float.parseFloat(tjmlBP2.getText());

            float total1 = hs1 * jml1;
            tttlBP2.setText(String.valueOf(total1));
        }
    }//GEN-LAST:event_tjmlBP2KeyPressed

    private void tjmlBP1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBP1KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBP1.getText());
            float jml1 = Float.parseFloat(tjmlBP1.getText());

            float total1 = hs1 * jml1;
            tttlBP1.setText(String.valueOf(total1));
        }

    }//GEN-LAST:event_tjmlBP1KeyPressed

    private void cBP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBP4ActionPerformed
        // TODO add your handling code here:
        tampilCBP4();
    }//GEN-LAST:event_cBP4ActionPerformed

    private void cBP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBP3ActionPerformed
        // TODO add your handling code here:
        tampilCBP3();
    }//GEN-LAST:event_cBP3ActionPerformed

    private void cBP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBP2ActionPerformed
        // TODO add your handling code here:
        tampilCBP2();
    }//GEN-LAST:event_cBP2ActionPerformed

    private void cBP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBP1ActionPerformed
        // TODO add your handling code here:
        tampilCBP1();
    }//GEN-LAST:event_cBP1ActionPerformed

    private void cBB4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBB4ActionPerformed
        // TODO add your handling code here:
        tampilCBB4();
    }//GEN-LAST:event_cBB4ActionPerformed

    private void cBB3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBB3ActionPerformed
        // TODO add your handling code here:
        tampilCBB3();
    }//GEN-LAST:event_cBB3ActionPerformed

    private void cBB2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBB2ActionPerformed
        // TODO add your handling code here:
        tampilCBB2();
    }//GEN-LAST:event_cBB2ActionPerformed

    private void cBB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBB1ActionPerformed
        // TODO add your handling code here:
        tampilCBB1();
    }//GEN-LAST:event_cBB1ActionPerformed

    private void bClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClearActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_bClearActionPerformed

    private void TabWIPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabWIPMouseClicked
        // TODO add your handling code here:
        datatable2();
        int bar = TabWIP.getSelectedRow();
        String a = tabmode2.getValueAt(bar,0).toString();
        try {
            Date b = new SimpleDateFormat("yyyy-MM-dd").parse((String)tabmode2.getValueAt(bar, 1));
            tTanggalProduksi.setDate(b);
        } catch (ParseException ex) {
            Logger.getLogger(ProsesManufaktur.class.getName()).log(Level.SEVERE, null, ex);
        }
        String c = tabmode2.getValueAt(bar,2).toString();
        String d = tabmode2.getValueAt(bar,3).toString();
        String e = tabmode2.getValueAt(bar,4).toString();
        String f = tabmode2.getValueAt(bar,5).toString();
        String g = tabmode2.getValueAt(bar,6).toString();
        String h = tabmode2.getValueAt(bar,7).toString();
        String i = tabmode2.getValueAt(bar,8).toString();
        String j = tabmode2.getValueAt(bar,9).toString();
        String k = tabmode2.getValueAt(bar,10).toString();
        String l = tabmode2.getValueAt(bar,11).toString();
        String m = tabmode2.getValueAt(bar,12).toString();
        String n = tabmode2.getValueAt(bar,13).toString();
        String o = tabmode2.getValueAt(bar,14).toString();
        String p = tabmode2.getValueAt(bar,15).toString();
        String q = tabmode2.getValueAt(bar,16).toString();
        String r = tabmode2.getValueAt(bar,17).toString();
        String s = tabmode2.getValueAt(bar,18).toString();
        String t = tabmode2.getValueAt(bar,19).toString();
        String u = tabmode2.getValueAt(bar,20).toString();
        String v = tabmode2.getValueAt(bar,21).toString();
        String w = tabmode2.getValueAt(bar,22).toString();
        String x = tabmode2.getValueAt(bar,23).toString();
        String y = tabmode2.getValueAt(bar,24).toString();
        String z = tabmode2.getValueAt(bar,25).toString();
        String aa = tabmode2.getValueAt(bar,26).toString();
        String ab = tabmode2.getValueAt(bar,27).toString();
        String ac = tabmode2.getValueAt(bar,28).toString();
        String ad = tabmode2.getValueAt(bar,29).toString();
        String ae = tabmode2.getValueAt(bar,30).toString();
        String af = tabmode2.getValueAt(bar,31).toString();
        String ag = tabmode2.getValueAt(bar,32).toString();
        String ah = tabmode2.getValueAt(bar,33).toString();
        String ai = tabmode2.getValueAt(bar,34).toString();
        String aj = tabmode2.getValueAt(bar,35).toString();
        String ak = tabmode2.getValueAt(bar,36).toString();
        String al = tabmode2.getValueAt(bar,37).toString();
        String am = tabmode2.getValueAt(bar,38).toString();
        String an = tabmode2.getValueAt(bar,39).toString();
        String ao = tabmode2.getValueAt(bar,40).toString();
        String ap = tabmode2.getValueAt(bar,41).toString();
        String aq = tabmode2.getValueAt(bar,42).toString();
        String ar = tabmode2.getValueAt(bar,43).toString();
        String as = tabmode2.getValueAt(bar,44).toString();
        String at = tabmode2.getValueAt(bar,45).toString();
        String au = tabmode2.getValueAt(bar,46).toString();

        tKodeProduksi.setText(a);
        tNamaBarangJadi.setText(c);
        tSKUBarang.setText(d);
        tJumlahBarang.setText(e);
        cBB1.setSelectedItem(f);
        cBB2.setSelectedItem(g);
        cBB3.setSelectedItem(h);
        cBB4.setSelectedItem(i);
        cBP1.setSelectedItem(j);
        cBP2.setSelectedItem(k);
        cBP3.setSelectedItem(l);
        cBP4.setSelectedItem(m);
        tnbBB1.setText(n);
        tnbBB2.setText(o);
        tnbBB3.setText(p);
        tnbBB4.setText(q);
        tnbBP1.setText(r);
        tnbBP2.setText(s);
        tnbBP3.setText(t);
        tnbBP4.setText(u);
        thsBB1.setText(v);
        thsBB2.setText(w);
        thsBB3.setText(x);
        thsBB4.setText(y);
        thsBP1.setText(z);
        thsBP2.setText(aa);
        thsBP3.setText(ab);
        thsBP4.setText(ac);
        tjmlBB1.setText(ad);
        tjmlBB2.setText(ae);
        tjmlBB3.setText(af);
        tjmlBB4.setText(ag);
        tjmlBP1.setText(ah);
        tjmlBP2.setText(ai);
        tjmlBP3.setText(aj);
        tjmlBP4.setText(ak);
        tttlBB1.setText(al);
        tttlBB2.setText(am);
        tttlBB3.setText(an);
        tttlBB4.setText(ao);
        tttlBP1.setText(ap);
        tttlBP2.setText(aq);
        tttlBP3.setText(ar);
        tttlBP4.setText(as);
        tBiayaProduksi.setText(at);
        tHPP.setText(au);
        
        try{
            DefaultTableModel model = (DefaultTableModel)TabWIP.getModel();
            int index = TabWIP.getSelectedRow();
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(index,2));
            tTanggalProduksi.setDate(date);
        } catch(Exception nn){
            
        }

    }//GEN-LAST:event_TabWIPMouseClicked

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        try{

            Object[] Baris = {1,2,3,4,5,6,7,8,9,10};
            tabmode = new DefaultTableModel(null,Baris);
            upsql = "SELECT `jbbb1`, `jbbb2`, `jbbb3`, `jbbb4`, `jbbp1`, `jbbp2`, `jbbp3`, `jbbp4` FROM `proses` WHERE kdproduksi ='"+tKodeProduksi.getText()+"';";
            rs = stat.executeQuery(upsql);
            while(rs.next()){
                String a = rs.getString("jbbb1");
                String b = rs.getString("jbbb2");
                String c = rs.getString("jbbb3");
                String d = rs.getString("jbbb4");
                String e = rs.getString("jbbp1");
                String f = rs.getString("jbbp2");
                String g = rs.getString("jbbp3");
                String h = rs.getString("jbbp4");
                String[] data = {a,b,c,d,e,f,g,h};
                tabmode.addRow(data);
            }

            int bar = TabWIP.getSelectedRow();
            String a = tabmode.getValueAt(bar,0).toString(); //a -> jbbb1
            String b = tabmode.getValueAt(bar,1).toString(); //b -> jbbb2
            String c = tabmode.getValueAt(bar,2).toString(); //c -> jbbb3
            String d = tabmode.getValueAt(bar,3).toString(); //d -> jbbb4
            String e = tabmode.getValueAt(bar,4).toString(); //e -> jbbp1
            String f = tabmode.getValueAt(bar,5).toString(); //f -> jbbp2
            String g = tabmode.getValueAt(bar,6).toString(); //g -> jbbp3
            String h = tabmode.getValueAt(bar,7).toString(); //h -> jbbp4

            if ((cBB1.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB1.setText("0");
            } else {
                usql1 = "UPDATE `bahan` SET `stock`=stock+"+a+"-"+tjmlBB1.getText()+" WHERE kdbarang ='"+cBB1.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat1 = con.prepareStatement(usql1);
                stat1.executeUpdate();
            }

            if ((cBB2.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB2.setText("0");
            } else {
                usql2 = "UPDATE `bahan` SET `stock`=stock+"+b+"-"+tjmlBB2.getText()+" WHERE kdbarang ='"+cBB2.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat2 = con.prepareStatement(usql2);
                stat2.executeUpdate();
            }

            if ((cBB3.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB3.setText("0");
            } else {
                usql3 = "UPDATE `bahan` SET `stock`=stock+"+c+"-"+tjmlBB3.getText()+" WHERE kdbarang ='"+cBB3.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat3 = con.prepareStatement(usql3);
                stat3.executeUpdate();
            }

            if ((cBB4.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB4.setText("0");
            } else {
                usql4 = "UPDATE `bahan` SET `stock`=stock+"+d+"-"+tjmlBB4.getText()+" WHERE kdbarang ='"+cBB4.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat4 = con.prepareStatement(usql4);
                stat4.executeUpdate();
            }

            if ((cBP1.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP1.setText("0");
            } else {
                usql1 = "UPDATE `bahan` SET `stock`=stock+"+e+"-"+tjmlBP1.getText()+" WHERE kdbarang ='"+cBP1.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp1 = con.prepareStatement(usql1);
                statp1.executeUpdate();
            }

            if ((cBP2.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP2.setText("0");
            } else {
                usql2 = "UPDATE `bahan` SET `stock`=stock+"+f+"-"+tjmlBP2.getText()+" WHERE kdbarang ='"+cBP2.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp2 = con.prepareStatement(usql2);
                statp2.executeUpdate();
            }

            if ((cBP3.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP3.setText("0");
            } else {
                usql3 = "UPDATE `bahan` SET `stock`=stock+"+g+"-"+tjmlBP3.getText()+" WHERE kdbarang ='"+cBP3.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp3 = con.prepareStatement(usql3);
                statp3.executeUpdate();
            }

            if ((cBP4.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP4.setText("0");
            } else {
                usql4 = "UPDATE `bahan` SET `stock`=stock+"+h+"-"+tjmlBP4.getText()+" WHERE kdbarang ='"+cBP4.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp4 = con.prepareStatement(usql4);
                statp4.executeUpdate();
            }

            //get value a tKodeProduksi.setText(a);
            //tTanggalProduksi.setDateFormatString(b);
            //tNamaBarangJadi.setText(c);
            //tSKUBarang.setText(d);

            sql = "UPDATE `proses` SET `kdproduksi`=?,`tglproduksi`=?,"
            + "`namabarangjadi`=?,`SKUBarang`=?,`jumlahbarang`=?,"
            + "`kdbb1`=?,`kdbb2`=?,`kdbb3`=?,`kdbb4`=?,"
            + "`kdbp1`=?,`kdbp2`=?,`kdbp3`=?,`kdbp4`=?,"
            + "`nbbb1`=?,`nbbb2`=?,`nbbb3`=?,`nbbb4`=?,"
            + "`nbbp1`=?,`nbbp2`=?,`nbbp3`=?,`nbbp4`=?,"
            + "`hsbb1`=?,`hsbb2`=?,`hsbb3`=?,`hsbb4`=?,"
            + "`hsbp1`=?,`hsbp2`=?,`hsbp3`=?,`hsbp4`=?,"
            + "`jbbb1`=?,`jbbb2`=?,`jbbb3`=?,`jbbb4`=?,"
            + "`jbbp1`=?,`jbbp2`=?,`jbbp3`=?,`jbbp4`=?,"
            + "`tttlbb1`=?,`tttlbb2`=?,`tttlbb3`=?,`tttlbb4`=?,"
            + "`tttlbp1`=?,`tttlbp2`=?,`tttlbp3`=?,`tttlbp4`=?,"
            + "`biayaproduksi`=?,`hpp`=? WHERE kdproduksi = ?";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tKodeProduksi.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            String date = sdf.format(tTanggalProduksi.getDate());
            stat.setString(2, date);
            stat.setString(3, tNamaBarangJadi.getText());
            stat.setString(4, tSKUBarang.getText());
            stat.setString(5, tJumlahBarang.getText());
            stat.setString(6, cBB1.getSelectedItem().toString());
            stat.setString(7, cBB2.getSelectedItem().toString());
            stat.setString(8, cBB3.getSelectedItem().toString());
            stat.setString(9, cBB4.getSelectedItem().toString());
            stat.setString(10, cBP1.getSelectedItem().toString());
            stat.setString(11, cBP2.getSelectedItem().toString());
            stat.setString(12, cBP3.getSelectedItem().toString());
            stat.setString(13, cBP4.getSelectedItem().toString());
            stat.setString(14, tnbBB1.getText());
            stat.setString(15, tnbBB2.getText());
            stat.setString(16, tnbBB3.getText());
            stat.setString(17, tnbBB4.getText());
            stat.setString(18, tnbBP1.getText());
            stat.setString(19, tnbBP2.getText());
            stat.setString(20, tnbBP3.getText());
            stat.setString(21, tnbBP4.getText());
            stat.setString(22, thsBB1.getText());
            stat.setString(23, thsBB2.getText());
            stat.setString(24, thsBB3.getText());
            stat.setString(25, thsBB4.getText());
            stat.setString(26, thsBP1.getText());
            stat.setString(27, thsBP2.getText());
            stat.setString(28, thsBP3.getText());
            stat.setString(29, thsBP4.getText());
            stat.setString(30, tjmlBB1.getText());
            stat.setString(31, tjmlBB2.getText());
            stat.setString(32, tjmlBB3.getText());
            stat.setString(33, tjmlBB4.getText());
            stat.setString(34, tjmlBP1.getText());
            stat.setString(35, tjmlBP2.getText());
            stat.setString(36, tjmlBP3.getText());
            stat.setString(37, tjmlBP4.getText());
            stat.setString(38, tttlBB1.getText());
            stat.setString(39, tttlBB2.getText());
            stat.setString(40, tttlBB3.getText());
            stat.setString(41, tttlBB4.getText());
            stat.setString(42, tttlBP1.getText());
            stat.setString(43, tttlBP2.getText());
            stat.setString(44, tttlBP3.getText());
            stat.setString(45, tttlBP4.getText());
            stat.setString(46, tBiayaProduksi.getText());
            stat.setString(47, tHPP.getText());
            stat.setString(48, tKodeProduksi.getText());
            stat.execute();
            tKodeProduksi.requestFocus();
            datatable();
            bersih();
            JOptionPane.showMessageDialog(null,"Data Proses Berhasil Diubah");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDeleteActionPerformed
        // TODO add your handling code here:
        int ok = JOptionPane.showConfirmDialog(null,"Hapus Proses? Jumlah Stock \nDalam Proses Akan Dikembalikan \n-Klik 'Yes' bila Setuju-","Konfirmasi Dialog",JOptionPane.YES_NO_CANCEL_OPTION);
        if(ok==0){
            try{
                Object[] Baris = {1,2,3,4,5,6,7,8,9};
                tabmode = new DefaultTableModel(null,Baris);
                upsql = "SELECT `jbbb1`, `jbbb2`, `jbbb3`, `jbbb4`, `jbbp1`, `jbbp2`, `jbbp3`, `jbbp4` FROM `proses` WHERE kdproduksi ='"+tKodeProduksi.getText()+"';";
                rs = stat.executeQuery(upsql);
                while(rs.next()){
                    String a = rs.getString("jbbb1");
                    String b = rs.getString("jbbb2");
                    String c = rs.getString("jbbb3");
                    String d = rs.getString("jbbb4");
                    String e = rs.getString("jbbp1");
                    String f = rs.getString("jbbp2");
                    String g = rs.getString("jbbp3");
                    String h = rs.getString("jbbp4");
                    String[] data = {a,b,c,d,e,f,g,h};
                    tabmode.addRow(data);
                }

                int bar = TabWIP.getSelectedRow();
                String a = tabmode.getValueAt(bar,0).toString(); //a -> jbbb1
                String b = tabmode.getValueAt(bar,1).toString(); //b -> jbbb2
                String c = tabmode.getValueAt(bar,2).toString(); //c -> jbbb3
                String d = tabmode.getValueAt(bar,3).toString(); //d -> jbbb4
                String e = tabmode.getValueAt(bar,4).toString(); //e -> jbbp1
                String f = tabmode.getValueAt(bar,5).toString(); //f -> jbbp2
                String g = tabmode.getValueAt(bar,6).toString(); //g -> jbbp3
                String h = tabmode.getValueAt(bar,7).toString(); //h -> jbbp4

                if ((cBB1.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBB1.setText("0");
                } else {
                    usql1 = "UPDATE `bahan` SET `stock`=stock+"+a+" WHERE kdbarang ='"+cBB1.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement stat1 = con.prepareStatement(usql1);
                    stat1.executeUpdate();
                }

                if ((cBB2.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBB2.setText("0");
                } else {
                    usql2 = "UPDATE `bahan` SET `stock`=stock+"+b+" WHERE kdbarang ='"+cBB2.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement stat2 = con.prepareStatement(usql2);
                    stat2.executeUpdate();
                }

                if ((cBB3.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBB3.setText("0");
                } else {
                    usql3 = "UPDATE `bahan` SET `stock`=stock+"+c+" WHERE kdbarang ='"+cBB3.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement stat3 = con.prepareStatement(usql3);
                    stat3.executeUpdate();
                }

                if ((cBB4.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBB4.setText("0");
                } else {
                    usql4 = "UPDATE `bahan` SET `stock`=stock+"+d+" WHERE kdbarang ='"+cBB4.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement stat4 = con.prepareStatement(usql4);
                    stat4.executeUpdate();
                }

                if ((cBP1.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBP1.setText("0");
                } else {
                    usql1 = "UPDATE `bahan` SET `stock`=stock+"+e+" WHERE kdbarang ='"+cBP1.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement statp1 = con.prepareStatement(usql1);
                    statp1.executeUpdate();
                }

                if ((cBP2.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBP2.setText("0");
                } else {
                    usql2 = "UPDATE `bahan` SET `stock`=stock+"+f+" WHERE kdbarang ='"+cBP2.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement statp2 = con.prepareStatement(usql2);
                    statp2.executeUpdate();
                }

                if ((cBP3.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBP3.setText("0");
                } else {
                    usql3 = "UPDATE `bahan` SET `stock`=stock+"+g+" WHERE kdbarang ='"+cBP3.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement statp3 = con.prepareStatement(usql3);
                    statp3.executeUpdate();
                }

                if ((cBP4.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                    tjmlBP4.setText("0");
                } else {
                    usql4 = "UPDATE `bahan` SET `stock`=stock+"+h+" WHERE kdbarang ='"+cBP4.getSelectedItem().toString()+"';";
                    java.sql.PreparedStatement statp4 = con.prepareStatement(usql4);
                    statp4.executeUpdate();
                }

                sql="DELETE FROM `proses` WHERE kdproduksi = '"+tKodeProduksi.getText()+"'";
                java.sql.PreparedStatement stat = con.prepareStatement(sql);
                stat.executeUpdate();
                tKodeProduksi.requestFocus();
                datatable();
                bersih();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus");
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Data Gagal Dihapus"+e);
            }
        }
    }//GEN-LAST:event_bDeleteActionPerformed

    private void bSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSaveActionPerformed
        // TODO add your handling code here:
        try{
            sql = "INSERT INTO `proses`(`kdproduksi`, `tglproduksi`, `namabarangjadi`, `SKUBarang`, `jumlahbarang`, `kdbb1`, `kdbb2`, `kdbb3`, `kdbb4`, `kdbp1`, `kdbp2`, `kdbp3`, `kdbp4`, `nbbb1`,`nbbb2`, `nbbb3`, `nbbb4`, `nbbp1`, `nbbp2`, `nbbp3`,`nbbp4`, `hsbb1`, `hsbb2`, `hsbb3`, `hsbb4`, `hsbp1`,`hsbp2`, `hsbp3`, `hsbp4`, `jbbb1`, `jbbb2`, `jbbb3`,`jbbb4`, `jbbp1`, `jbbp2`, `jbbp3`, `jbbp4`, `tttlbb1`, `tttlbb2`, `tttlbb3`, `tttlbb4`, `tttlbp1`, `tttlbp2`, `tttlbp3`, `tttlbp4`, `biayaproduksi`, `hpp`, `status`, `tgljadi`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'WIP','2020-01-01');";
            java.sql.PreparedStatement stat = con.prepareStatement(sql);
            stat.setString(1, tKodeProduksi.getText());
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            String date = sdf.format(tTanggalProduksi.getDate());
            stat.setString(2, date);
            stat.setString(3, tNamaBarangJadi.getText());
            stat.setString(4, tSKUBarang.getText());
            stat.setString(5, tJumlahBarang.getText());
            stat.setString(6, cBB1.getSelectedItem().toString());
            stat.setString(7, cBB2.getSelectedItem().toString());
            stat.setString(8, cBB3.getSelectedItem().toString());
            stat.setString(9, cBB4.getSelectedItem().toString());
            stat.setString(10, cBP1.getSelectedItem().toString());
            stat.setString(11, cBP2.getSelectedItem().toString());
            stat.setString(12, cBP3.getSelectedItem().toString());
            stat.setString(13, cBP4.getSelectedItem().toString());
            stat.setString(14, tnbBB1.getText());
            stat.setString(15, tnbBB2.getText());
            stat.setString(16, tnbBB3.getText());
            stat.setString(17, tnbBB4.getText());
            stat.setString(18, tnbBP1.getText());
            stat.setString(19, tnbBP2.getText());
            stat.setString(20, tnbBP3.getText());
            stat.setString(21, tnbBP4.getText());
            stat.setString(22, thsBB1.getText());
            stat.setString(23, thsBB2.getText());
            stat.setString(24, thsBB3.getText());
            stat.setString(25, thsBB4.getText());
            stat.setString(26, thsBP1.getText());
            stat.setString(27, thsBP2.getText());
            stat.setString(28, thsBP3.getText());
            stat.setString(29, thsBP4.getText());
            stat.setString(30, tjmlBB1.getText());
            stat.setString(31, tjmlBB2.getText());
            stat.setString(32, tjmlBB3.getText());
            stat.setString(33, tjmlBB4.getText());
            stat.setString(34, tjmlBP1.getText());
            stat.setString(35, tjmlBP2.getText());
            stat.setString(36, tjmlBP3.getText());
            stat.setString(37, tjmlBP4.getText());
            stat.setString(38, tttlBB1.getText());
            stat.setString(39, tttlBB2.getText());
            stat.setString(40, tttlBB3.getText());
            stat.setString(41, tttlBB4.getText());
            stat.setString(42, tttlBP1.getText());
            stat.setString(43, tttlBP2.getText());
            stat.setString(44, tttlBP3.getText());
            stat.setString(45, tttlBP4.getText());
            stat.setString(46, tBiayaProduksi.getText());
            stat.setString(47, tHPP.getText());
            stat.execute();

            if ((cBB1.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB1.setText("0");
            } else {
                usql1 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBB1.getText()+" WHERE kdbarang ='"+cBB1.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat1 = con.prepareStatement(usql1);
                stat1.executeUpdate();
            }

            if ((cBB2.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB2.setText("0");
            } else {
                usql2 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBB2.getText()+" WHERE kdbarang ='"+cBB2.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat2 = con.prepareStatement(usql2);
                stat2.executeUpdate();
            }

            if ((cBB3.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB3.setText("0");
            } else {
                usql3 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBB3.getText()+" WHERE kdbarang ='"+cBB3.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat3 = con.prepareStatement(usql3);
                stat3.executeUpdate();
            }

            if ((cBB4.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBB4.setText("0");
            } else {
                usql4 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBB4.getText()+" WHERE kdbarang ='"+cBB4.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement stat4 = con.prepareStatement(usql4);
                stat4.executeUpdate();
            }

            if ((cBP1.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP1.setText("0");
            } else {
                usql1 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBP1.getText()+" WHERE kdbarang ='"+cBP1.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp1 = con.prepareStatement(usql1);
                statp1.executeUpdate();
            }

            if ((cBP2.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP2.setText("0");
            } else {
                usql2 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBP2.getText()+" WHERE kdbarang ='"+cBP2.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp2 = con.prepareStatement(usql2);
                statp2.executeUpdate();
            }

            if ((cBP3.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP3.setText("0");
            } else {
                usql3 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBP3.getText()+" WHERE kdbarang ='"+cBP3.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp3 = con.prepareStatement(usql3);
                statp3.executeUpdate();
            }

            if ((cBP4.getSelectedItem().toString()).equalsIgnoreCase("Select Here")){
                tjmlBP4.setText("0");
            } else {
                usql4 = "UPDATE `bahan` SET `stock`=stock-"+tjmlBP4.getText()+" WHERE kdbarang ='"+cBP4.getSelectedItem().toString()+"';";
                java.sql.PreparedStatement statp4 = con.prepareStatement(usql4);
                statp4.executeUpdate();
            }

            tKodeProduksi.requestFocus();
            datatable();
            bersih();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bSaveActionPerformed

    private void tjmlBB4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBB4KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBB4.getText());
            float jml1 = Float.parseFloat(tjmlBB4.getText());

            float total1 = hs1 * jml1;
            tttlBB4.setText(String.valueOf(total1));
        }
    }//GEN-LAST:event_tjmlBB4KeyPressed

    private void tjmlBB3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBB3KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBB3.getText());
            float jml1 = Float.parseFloat(tjmlBB3.getText());

            float total1 = hs1 * jml1;
            tttlBB3.setText(String.valueOf(total1));
        }
    }//GEN-LAST:event_tjmlBB3KeyPressed

    private void tjmlBB2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBB2KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBB2.getText());
            float jml1 = Float.parseFloat(tjmlBB2.getText());

            float total1 = hs1 * jml1;
            tttlBB2.setText(String.valueOf(total1));
        }
    }//GEN-LAST:event_tjmlBB2KeyPressed

    private void tjmlBB1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tjmlBB1KeyPressed
        // TODO add your handling code here:
        int kode = evt.getKeyCode();
        if (kode == evt.VK_ENTER){
            float hs1 = Float.parseFloat(thsBB1.getText());
            float jml1 = Float.parseFloat(tjmlBB1.getText());

            float total1 = hs1 * jml1;
            tttlBB1.setText(String.valueOf(total1));
        }
    }//GEN-LAST:event_tjmlBB1KeyPressed
    
    
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
            java.util.logging.Logger.getLogger(ProsesManufaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProsesManufaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProsesManufaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProsesManufaktur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ProsesManufaktur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabWIP;
    private javax.swing.JButton bCalculate;
    private javax.swing.JButton bClear;
    private javax.swing.JButton bCompleted;
    private javax.swing.JButton bDelete;
    private javax.swing.JButton bHomeBottom;
    private javax.swing.JButton bHomeUpper;
    private javax.swing.JButton bSave;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> cBB1;
    private javax.swing.JComboBox<String> cBB2;
    private javax.swing.JComboBox<String> cBB3;
    private javax.swing.JComboBox<String> cBB4;
    private javax.swing.JComboBox<String> cBP1;
    private javax.swing.JComboBox<String> cBP2;
    private javax.swing.JComboBox<String> cBP3;
    private javax.swing.JComboBox<String> cBP4;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tBiayaProduksi;
    private javax.swing.JTextField tHPP;
    private javax.swing.JTextField tJumlahBarang;
    private javax.swing.JTextField tKodeProduksi;
    private javax.swing.JTextField tNamaBarangJadi;
    private javax.swing.JTextField tSKUBarang;
    private com.toedter.calendar.JDateChooser tTanggalJadi;
    private com.toedter.calendar.JDateChooser tTanggalProduksi;
    private javax.swing.JTextField thsBB1;
    private javax.swing.JTextField thsBB2;
    private javax.swing.JTextField thsBB3;
    private javax.swing.JTextField thsBB4;
    private javax.swing.JTextField thsBP1;
    private javax.swing.JTextField thsBP2;
    private javax.swing.JTextField thsBP3;
    private javax.swing.JTextField thsBP4;
    private javax.swing.JTextField tjmlBB1;
    private javax.swing.JTextField tjmlBB2;
    private javax.swing.JTextField tjmlBB3;
    private javax.swing.JTextField tjmlBB4;
    private javax.swing.JTextField tjmlBP1;
    private javax.swing.JTextField tjmlBP2;
    private javax.swing.JTextField tjmlBP3;
    private javax.swing.JTextField tjmlBP4;
    private javax.swing.JTextField tnbBB1;
    private javax.swing.JTextField tnbBB2;
    private javax.swing.JTextField tnbBB3;
    private javax.swing.JTextField tnbBB4;
    private javax.swing.JTextField tnbBP1;
    private javax.swing.JTextField tnbBP2;
    private javax.swing.JTextField tnbBP3;
    private javax.swing.JTextField tnbBP4;
    private javax.swing.JTextField tttlBB1;
    private javax.swing.JTextField tttlBB2;
    private javax.swing.JTextField tttlBB3;
    private javax.swing.JTextField tttlBB4;
    private javax.swing.JTextField tttlBP1;
    private javax.swing.JTextField tttlBP2;
    private javax.swing.JTextField tttlBP3;
    private javax.swing.JTextField tttlBP4;
    // End of variables declaration//GEN-END:variables
}
