/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Akip Maulana
 */
public class Event {
    private int id_event;
    private String nama_event;
    private String deskripsi;
    private String tgl_dibuat;
    private String tgl_dimulai;
    private int quota;
    private int id_user;
    
   
    private Database db;
    private ResultSet rs;

    public Event() {
        this.db = new Database();
    }
    
    public void addEvent(int id_user, String nama_event, String start, String finish
            ,int quota, String deskripsi){
        String s = "insert into event (user_id,name,begin,end,quota,description) values"
                + "('"+id_user+"','"+nama_event+"','"+start+"','"+finish+"','"+quota+"','"+deskripsi+"')" ;
        getDb().query(s);
    }
    
    public void editEvent(){
        
    }
    
    public void viewEvent(int id_event) throws SQLException{
        String s = "select * from event where event_id="+id_event ;
        rs = getDb().getResult(s);
        getRs().next();
        this.id_event = Integer.parseInt(getRs().getString("event_id"));
        this.nama_event = getRs().getString("name");
        this.deskripsi = getRs().getString("description");
        this.tgl_dibuat = getRs().getString("begin");
        this.tgl_dimulai = getRs().getString("end");
        this.id_user = Integer.parseInt(getRs().getString("user_id"));
        this.quota = Integer.parseInt(getRs().getString("quota"));
    }
    
    public void deleteEvent(int id_event){
        String s = "delete from event where event_id="+id_event;
        getDb().query(s);
    }

    /**
     * @return the id_event
     */
    public int getId_event() {
        return id_event;
    }

    /**
     * @return the nama_event
     */
    public String getNama_event() {
        return nama_event;
    }

    /**
     * @return the deskripsi
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * @return the tgl_dibuat
     */
    public String getTgl_dibuat() {
        return tgl_dibuat;
    }

    /**
     * @return the tgl_dimulai
     */
    public String getTgl_dimulai() {
        return tgl_dimulai;
    }

    /**
     * @return the id_user
     */
    public int getId_user() {
        return id_user;
    }

    /**
     * @return the db
     */
    public Database getDb() {
        return db;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @return the quota
     */
    public int getQuota() {
        return quota;
    }
    
}
