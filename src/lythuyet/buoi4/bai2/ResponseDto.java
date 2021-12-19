/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lythuyet.buoi4.bai2;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author huyvu
 */
public class ResponseDto implements Serializable {

    private ItemInArr[] max;
    private ItemInArr[] max2;

   

    public ItemInArr[] getMax() {
        return this.max;

    }

    public ItemInArr[] getMax2() {
        return this.max2;
    }

    public void setMax(ItemInArr[] max) {
        this.max = max;
    }

    public void setMax2(ItemInArr[] max2) {
        this.max2 = max2;
    }

    

}
