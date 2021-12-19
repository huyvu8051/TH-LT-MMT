/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lythuyet.buoi5.bai1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author huyvu
 */
public class Server {

    public static void main(String[] args) throws SocketException, IOException {
        //Giai đoạn 1: Server tạo Socket - gán số hiệu cổng
        try {
            DatagramSocket server = new DatagramSocket(8888);
            System.out.println("Server đang chạy!!!");
            while (true) {
                //Giai đoạn 3: trao đổi dữ liệu client và server
                //Giai đoạn 3.3: Server nhận dữ liệu, tạo packet (cần 2 tham số: 1 mảng byte, 2 là chiều mảng cần chứa)
                //Giai đoạn 3.3.1: tạo mảng byte
                byte mangn[] = new byte[256];
                //Giai đoạn 3.3.2: khai báo chiều dài mảng cần chứa
                int lenght = mangn.length;

                ByteArrayInputStream byteInputStream = new ByteArrayInputStream(mangn);

                DatagramPacket nhann = new DatagramPacket(mangn, lenght);
                server.receive(nhann);

                ObjectInputStream input = new ObjectInputStream(byteInputStream);

                Object o = input.readObject();

                //Giai đoạn 3.4: xử lý dữ liệu
                String chuoin = new String(nhann.getData(), 0, nhann.getLength()).trim();
                int n = Integer.parseInt(chuoin);
                int sofibo = fibo(n);
                //Giai đoạn 3.5: tạo packet gửi dữ liệu về cho client. (cần 4 tham số: 1 mảng, 2 chiều dài mang,3 địa chỉ máy đích (client), 4 cổng máy đích (máy client))
                //Giai đoạn 3.5.1: tạo mảng để gửi
                byte mangfibo[] = new byte[256];
                mangfibo = String.valueOf(sofibo).getBytes();
                //Giai đoạn 3.5.2: tạo chiều dài mảng byte
                int lenghtfi = mangfibo.length;
                //Giai đoạn 3.5.3: lấy địa chỉ máy đích(client)
                InetAddress ip = nhann.getAddress();
                //Giai đoạn 3.5.4: lấy cổng máy đích (client)
                int port = nhann.getPort();
                DatagramPacket guifibo = new DatagramPacket(mangfibo, lenghtfi, ip, port);
                server.send(guifibo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int fibo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibo(n - 1) + fibo(n - 2);
    }
}
