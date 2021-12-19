/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lythuyet.buoi4.bai2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author huyvu
 */
public class Server {

    public static void main(String[] args) throws IOException, Exception {
        ServerSocket ss = new ServerSocket(8888);
        Socket s = ss.accept();
        ObjectOutputStream dout = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream din = new ObjectInputStream(s.getInputStream());

        try {
            while (true) {
                int[] req = (int[]) din.readObject();

                System.out.println("client says: " + req);

                ResponseDto resp = new ResponseDto();

                int maxValue = findMaxValue(req);

                resp.setMax(getItemsByValue(req, maxValue));

                int max2Value = getSecMaxValue(req);

                resp.setMax2(getItemsByValue(req, max2Value));

                dout.writeObject(resp);
                dout.flush();
            }

        } catch (Exception e) {

        } finally {
            din.close();
            s.close();
            ss.close();
        }
    }

    static int[] sortArray(int[] arr) {
        Arrays.sort(arr);
        Collections.reverse(Arrays.asList(arr));
        return arr;
    }

    static ItemInArr[] getItemsByValue(int arr[], int value) {
        List<ItemInArr> result = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {

                ItemInArr iar = new ItemInArr();
                iar.setIndex(i);
                iar.setValue(value);

                result.add(iar);
            }
        }

        return result.toArray(new ItemInArr[result.size()]);
    }

    static int findMaxValue(int[] arr) throws Exception {
        int maxValue = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }

        return maxValue;
    }

    static int getSecMaxValue(int arr[]) throws Exception {
        int arr_size = arr.length;
        int i, first, second;
        if (arr_size < 2) {
            throw new Exception("kich thuoc mang khong dung ");
        }
        first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr_size; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }
            if (arr[i] < first && arr[i] > second) {
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE) {
            throw new Exception("Khong ton tai phan tu lon thu 2 ");
        } else {
            return second;
        }
    }

}
