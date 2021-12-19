/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baitapthem.QLUser;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author bobvu
 */
public class MyConnection {

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/quanlydsnguoidung", "root", "");
//here sonoo is database name, root is username and password  
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString(), "err", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }
}
