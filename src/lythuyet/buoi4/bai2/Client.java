/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lythuyet.buoi4.bai2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author huyvu
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 8888);
        ObjectOutputStream dout = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream din = new ObjectInputStream(s.getInputStream());
        try {

            dout.writeObject(new int[]{1, 2, 3, 4});

            dout.flush();
            ResponseDto res = (ResponseDto) din.readObject();
            System.out.println("Server says: max" + res.getMax());
            System.out.println("Server says: max2" + res.getMax2());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dout.close();
            s.close();
        }
    }

    static int[] nhapMang(BufferedReader br) throws IOException {
        System.out.println("1. nhap mang");
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("\narr[" + i + "] = ");
            arr[i] = Integer.parseInt(br.readLine());
        }

        return arr;

    }

}
