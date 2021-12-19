/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanh.buoi3p2.bai3;

import thuchanh.buoi3p2.bai2.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.zip.GZIPInputStream;

/**
 *
 * @author huyvu
 */
public class BatTayZing {

    public static void main(String[] args) {
        String s = "https://zingnews.vn";
        String thisLine;
        try {
            URL u = new URL(s);
            try {

                // get encoding
//                URLConnection urlc = u.openConnection();
//                String encoding = urlc.getContentEncoding();
//                if (encoding == null) {
//                    encoding = "UTF-8";
//                } 
                InputStream dis = new DataInputStream(u.openStream());
                GZIPInputStream gz = new GZIPInputStream(dis);
                InputStreamReader reader = new InputStreamReader(gz);
                BufferedReader br = new BufferedReader(reader);
                while ((thisLine = br.readLine()) != null) {

                    System.out.println(thisLine);

                }
            } catch (Exception e) {
                System.err.println(e);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
