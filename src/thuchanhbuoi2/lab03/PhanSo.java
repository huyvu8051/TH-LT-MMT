/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thuchanhbuoi2.lab03;

import java.io.Serializable;

public class PhanSo implements Serializable {

    private int tuso;
    private int mauso;

    //
    public PhanSo() {
        tuso = (int) (Math.random() * 100);
        do {
            mauso = (int) (Math.random() * 90 + 1);
        } while (mauso == 0);
    }

    //constructor
    public PhanSo(int tuso, int mauso) {
        this.tuso = tuso;
        if (mauso == 0) {
            mauso = 1;
        } else {
            this.mauso = mauso;
        }
    }

    //
    public String toString() {
        return tuso + "/" + mauso;
    }

    public int getMauso() {
        return mauso;
    }

    public boolean ktNguyenTo() {
        if (mauso < 1) {
            return false;
        }
        int t = (int) Math.sqrt(mauso);
        for (int i = 2; i < t; i++) {
            if (mauso % i == 0) {
                return false;
            }
        }
        return true;
    }

}
