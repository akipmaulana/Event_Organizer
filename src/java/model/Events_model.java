/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MF613110035
 */
public class Events_model {
    private int id_event;
    private String nama_event;
    private String deskripsi;
    private String tgl_diselesi;
    private String tgl_dimulai;
    private int jml_peserta;
    private int id_user;
    private ResultSet data;
    
    //get data by id
    public ResultSet getData(String id) 
    {
        //code here 
        return getData();
    }
    
    //insert event
    public boolean insert_Event(String nama, String tgl_dimulai, String tgl_selesai, int kouta, String deskripsi, int id_user)
    {
        boolean masuk = false;
        Database db = new Database();
        db.query("insert into event values('0','"+id_user+"','"+nama+"','"+tgl_dimulai+"','"+tgl_selesai+"','"+kouta+"','"+deskripsi+"')");
        if (db.isMasuk())
        {
            masuk = true;
        }
        else
        {
            masuk = false;
        }
        
        return masuk;
    }
    
    public boolean update_Events(String nama, String tgl_dimulai, String tgl_selesai, int kouta, String deskripsi, int id_events)
    {
        Database db = new Database();
        db.query("update event set name='"+nama+"', begin='"+tgl_dimulai+"', end='"+tgl_selesai+"' , quota="+kouta+", description='"+deskripsi+"' where event_id="+id_events+"");
        
        if (db.isMasuk())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean delete_Events(int id_event)
    {
        Database db = new Database();
        db.query("delete from event where event_id='"+id_event+"'");
        if (db.isMasuk())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public void getData(int event_id) throws SQLException{
        Database db = new Database();
        data = db.getResult("select * from event where event_id="+event_id+"");
        getData().next();
        this.id_event = Integer.parseInt(getData().getString("event_id"));
        this.id_user = Integer.parseInt(getData().getString("user_id"));
        this.nama_event = getData().getString("name");
        this.tgl_dimulai = getData().getString("begin");
        this.tgl_diselesi = getData().getString("end");
        this.deskripsi = getData().getString("description");
        this.jml_peserta = Integer.parseInt(getData().getString("quota"));
    }
    
    public void getAll(){
        Database db = new Database();
        data = db.getResult("select * from event");
    }

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public String getNama_event() {
        return nama_event;
    }

    public void setNama_event(String nama_event) {
        this.nama_event = nama_event;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getTgl_diselesi() {
        return tgl_diselesi;
    }

    public void setTgl_diselesi(String tgl_diselesi) {
        this.tgl_diselesi = tgl_diselesi;
    }

    public String getTgl_dimulai() {
        return tgl_dimulai;
    }

    public void setTgl_dimulai(String tgl_dimulai) {
        this.tgl_dimulai = tgl_dimulai;
    }

    public int getJml_peserta() {
        return jml_peserta;
    }

    public void setJml_peserta(int jml_peserta) {
        this.jml_peserta = jml_peserta;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    /**
     * @return the data
     */
    public ResultSet getData() {
        return data;
    }
    
    
    
}
