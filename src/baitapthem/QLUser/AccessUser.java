/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapthem.QLUser;
import java.util.Vector;
/**
 *
 * @author TienDat
 */
public class AccessUser {

    private User user[];
    //so luong user hien dang duoc luu dia chi trong danh sach
    private int n;
    private int MAXN;
    //ham khoi tao

    public AccessUser(int MAXN) {
        //Ham khoi tao nhan tham so so luong user toi da      
        this.MAXN = MAXN;
        user = new User[MAXN];
        n = 0;
    }
    //ham them user vao danh sach quan ly

    public void AddUser(User u) {
        user[n] = u;
        n++;
    }
    //ham tao user va luu dia chi user vao danh sach de quan ly 

    public void AddUser(String t, String mk, String dd, int q) {
        user[n] = new User(t, mk, dd, q);
        n++;
    }

    public Vector timKiem(String ten) {
//tao vector luu ket qua tra lai
        Vector rows = new Vector();
        for (int i = 0; i < n; i++) {
            if (user[i].laUser(ten)) {
                rows.add(user[i].hienThiRow());
            }
        }
//moi dong la mot user 
        return rows;
    }

    public Vector timKiem(int quyen) {
        Vector rows = new Vector();
        for (int i = 0; i < n; i++) {
            if (user[i].laUser(quyen)) {
                rows.add(user[i].hienThiRow());
            }
        }
        return rows;
    }

}
