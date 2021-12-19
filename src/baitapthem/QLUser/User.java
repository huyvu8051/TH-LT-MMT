/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapthem.QLUser;

import java.util.Vector;

/**
 *
 * @author bobvu
 */
public class User 
{
    private String ten;
    private String matKhau;
    private String duongDan;
    private int quyen;
    public int READ = 0;
    public int WRITE = 1;
    public int FULL = 2;
    //Constructor
    public User(String ten, String matKhau, String duongDan, int quyen) {
        this.ten = ten;
        this.matKhau = matKhau;
        this.duongDan = duongDan;
        this.quyen = quyen;
    }
    //get,set
    public String getTen() {
        return ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public int getQuyen() {
        return quyen;
    }
    //
    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public void setQuyen(int quyen) {
        this.quyen = quyen;
    }
    public boolean laUser(String ten) 
    {
        return ten.equals(this.ten);
    }
    public Vector hienThiRow() {
        Vector row = new Vector();
        row.add(ten);
        row.add(this.matKhau);
        row.add(this.duongDan);
        row.add(this.quyen);
        return row;
    }
    public boolean laUser(int quyen) {
        return quyen == this.quyen;
    }

}
