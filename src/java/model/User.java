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
public class User {
    private String username;
    private String password;
    private String id_user;
    private String jenis_kelamin;
    private String nomer_hp;
    private String email;
    private int kehadiran;//var untuk desc user apakah hadir atau tidak atau maybe dll

    private Database db;
    private ResultSet rs;     
    
    private Event event;
    
    public User() {
        db = new Database();
        event = new Event();
    }
    
    public void insertDataUser(String username, String password, String jenis_kelamin
            , String nomor_hp, String email, int kehadiran){
        String s = "insert into user (username,password,jenis_kelamin,nomer_hp,email,kehadiran) "
                + "values ('"+username+"','"+password+"','"+jenis_kelamin+"','"+nomor_hp+"'"
                + ",'"+email+"',"+kehadiran+")";
        getDb().query(s);
    }
    
    public void deleteDataUser(String id_user){
        getDb().query("delete from user where id_user='"+id_user+"'");
    }
    
    public void updateDataUser(String id_user, String password
            , String jenis_kelamin, String nomor_hp, String email, int kehadiran){
        String s = "update user set password='"+password+"'"
                + ", jenis_kelamin='"+jenis_kelamin+"', nomer_hp='"+nomor_hp+"'"
                + ", email='"+email+"', kehadiran="+kehadiran+" where id_user="+id_user+"";
        getDb().query(s);
    }
    
    public void viewDataUser(int id) throws Exception{
        rs = getDb().getResult("select * from user where id_user="+id+"");
        getRs().next();
        this.username = getRs().getString("username");
        this.password = getRs().getString("password");
        this.id_user = getRs().getString("id_user");
        this.jenis_kelamin = getRs().getString("jenis_kelamin");
        this.nomer_hp = getRs().getString("nomer_hp");
        this.email = getRs().getString("email");
        this.kehadiran = Integer.parseInt(getRs().getString("kehadiran"));
    }
    
    public void viewAll(){
        rs = getDb().getResult("select * from user");
    }
    
    /*
     * method ini untuk validasi login, true jika user, false jika bukan
     */
    public boolean validasi(String username, String password) throws SQLException{
        String query = "select * from user where username='"+username+"' and password='"+password+"'";
        rs = getDb().getResult(query);
        System.out.println(query);
        if (getRs().next()){
            return true;
        } else {
            return false;
        }
    }
    
    public void addFriend(){
        
    }
    
    public void removeFriend(){
        
    }
    
    public void inviteUser(){
        
    }
    
    public boolean isJoin(){
        return false;
    }
    
    public void createTestimonie(){}
    
    public void deleteTestimonie(){}
    
    public void updateTestimonie(){}
    
    public void viewTestimonie(String id){}

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the id_user
     */
    public String getId_user() {
        return id_user;
    }

    /**
     * @return the jenis_kelamin
     */
    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    /**
     * @return the nomer_hp
     */
    public String getNomer_hp() {
        return nomer_hp;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the kehadiran
     */
    public int getKehadiran() {
        return kehadiran;
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
     * @return the event
     */
    public Event getEvent() {
        return event;
    }
}
