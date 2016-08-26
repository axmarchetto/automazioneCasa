/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfxmenucasa;

/**
 *
 * @author a.marchetto
 */
public class Contatore {

    private double count;
    private double passo;

    public Contatore(double count, double passo) {
        this.count = count;
        this.passo = passo;
    }

    public double getCount() {
        return count;
    }

    public void incrementa() {
        count += passo;
    }
    
    public void decrementa() {
        count -= passo;
    }

}
