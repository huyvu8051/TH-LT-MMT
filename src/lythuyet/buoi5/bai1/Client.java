/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lythuyet.buoi5.bai1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huyvu
 */
public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        //Giai đoạn 2: Client tạo Socket
        DatagramSocket client = new DatagramSocket();
        //Giai đoạn 3: trao đổi dữ liệu giữa client và server
        //Giai đoạn 3.1: khai báo số nguyên n
        Scanner sc = new Scanner(System.in);
        int n = 0;
        boolean check = false;
        while (!check) {
            try {
                System.out.println("Nhập số nguyên n: ");
                n = sc.nextInt();
                check = true;
            } catch (Exception e) {
                sc.nextLine();
            }
        }

        int arr[] = new int[]{1, 2, 3};

        List<Double> list = new ArrayList<>();
        list.add(1D);
        list.add(2D);
        list.add(3D);
        list.add(69D);

        ByteArrayOutputStream contentStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(contentStream);
        out.writeObject(list);
        //out.flush();
        //out.close();

        //Giai đoạn 3.2: client tạo packet để gửi lên server: (1 mảng byte, 2 chiều dài mảng byte, 3 địa chỉ đích, 4 cổng đích)
        //Giai đoạn 3.2.1: tạo mảng dữ liệu
        byte mangn[] = contentStream.toByteArray();
        mangn = String.valueOf(n).getBytes();
        //Giai đoạn 3.2.2: Tính chiều dài của mảng
        int lenght = mangn.length;
        //giai đoạn 3.2.3: khai báo địa chỉ máy đích (máy server)
        InetAddress ip = InetAddress.getByName("localhost");
        //Giai đoạn 3.2.4: khai báo cổng server
        int port = 8888;
        DatagramPacket guin = new DatagramPacket(mangn, lenght, ip, port);
        client.send(guin);
        //Giai đoạn 3.6: client nhận dữ liệu, khai báo packet (cần 2: 1 mảng chứa, 2 chiều dài mảng chứa)
        //Giai đoạn 3.6.1: khai báo mảng chứa dữ liệu từ server gửi về.
        byte nhanfi[] = new byte[256];
        //Giai đoạn 3.6.2: khai báo chiều dài mảng chứa dữ liệu từ server gửi về.
        int lenghtfi = nhanfi.length;
        DatagramPacket nhansofi = new DatagramPacket(nhanfi, lenghtfi);
        client.receive(nhansofi);
        //Giai đoạn 3.7: client hiển thị dữ liệu lên màn hình
        String fibonaci = new String(nhansofi.getData(), 0, nhansofi.getLength()).trim();
        System.out.println("Số fibonaci thứ " + n + " là " + fibonaci);
        //giai đoạn 3.8: đóng socket
        client.close();
    }
}
