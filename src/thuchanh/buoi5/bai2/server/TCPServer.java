/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanh.buoi5.bai2.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author huyvu
 */
public class TCPServer {
    static final int PORT = 1234;
    private ServerSocket server;
    
    public TCPServer(){
        try {
            server = new ServerSocket(PORT);
        } catch (Exception e) {
        }
    
    }
    
    
    public void action(){
        Socket socket;
        int i = 0;
        System.out.println("Server listening...");
        
        try {
            while ((socket = server.accept()) != null) {                
                new ServerThread(socket, "client#" + i);
                System.out.printf("Thread for client#%d generating...", i++);
            }
        } catch (Exception e) {
        }
    }
    public static void main(String[] args) {
        new TCPServer().action();
    }

    
}
