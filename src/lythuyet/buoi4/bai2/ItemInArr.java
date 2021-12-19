/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lythuyet.buoi4.bai2;

import java.io.Serializable;

/**
 *
 * @author huyvu
 */
public class ItemInArr implements Serializable{

    private int value;
    private int index;

    public int getValue() {
        return this.value;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
