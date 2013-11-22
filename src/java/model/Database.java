/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author MF613110035
 */
public class Database {
    public Connection con;
    public ResultSet rs;
    public Statement sta;
    private boolean Masuk = false;  
    private int result = 0;
            
    public void setMasuk(boolean Masuk) {
        this.Masuk = Masuk;
    }

    public boolean isMasuk() {
        return Masuk;
    }
    
    
    public Database()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_event", "root", "");
            
        }
        catch (Throwable ex)
        {
            
        }
        
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
    
    
    public Connection getKoneksi()
    {
        return con;
    }
    
    public void query(String query)
    {
        try
        {
            sta = con.createStatement();
            setResult(sta.executeUpdate(query));
            sta.close();
            setMasuk(true);
        }
        catch (Exception e)
        {
            setMasuk(false);
            System.out.println(e.getMessage());
        }
        
    } 
   
    public ResultSet getResult(String query)
    {
        
        try
        {
            sta = con.createStatement();
            rs = sta.executeQuery(query);
        }
        catch (Exception ex)
        {
            
            //JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
}
