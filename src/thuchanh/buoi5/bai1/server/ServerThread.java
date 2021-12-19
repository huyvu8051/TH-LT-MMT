/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanh.buoi5.bai1.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huyvu
 */
public class ServerThread implements Runnable {

    private Scanner in;
    private PrintWriter out;
    private Socket socket;
    private String name;

    public ServerThread(Socket socket, String string) throws IOException {
        this.socket = socket;
        this.name = string;
        this.in = new Scanner(this.socket.getInputStream());
        this.out = new PrintWriter(this.socket.getOutputStream());

        try {
            new Thread(this).start();
        } catch (Exception e) {

            System.out.println("");
        }
    }

    @Override
    public void run() {
        try {
            String chuoi = in.nextLine().trim();
            while (true) {

                chuoi = chuoi.toUpperCase();
                out.println(chuoi);

                System.out.println("ccc");
            }
        } catch (Exception e) {

        } finally {
            try {
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(ServerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
