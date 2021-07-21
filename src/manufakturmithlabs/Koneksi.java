/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manufakturmithlabs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.SQLException;
/**
 *
 * @author MithLabs
 */
public class Koneksi {
    
    Connection con;
    Statement stm;
    private Connection koneksi;
    
    public void config(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/manufakturmithlabs","root","");
            stm = con.createStatement();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi Database Gagal"+e.getMessage());
        }
    }
    
    public Connection connect() {
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost/manufakturmithlabs","root","");
        } catch (SQLException ex){
            System.out.println("Gagak Koneksi "+ex);
        }
        return koneksi;
    }
}
