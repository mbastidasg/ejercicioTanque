/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplotanque;
import java.util.*;

/**
 *
 * @author ESTUDIANTE
 */
public class Tanque {
    private int xref;
    private int yref;
    private int angulo;
    private String[] imagenes;
    
    public Tanque(String [] imagenes, int xref, int yref, int angulo){
        this.imagenes = new String [18];
        for (int i = 0; i < 18; i++) {
            this.imagenes[i] = i + ".png";
           
        }
        this.xref = xref;
        this.yref= yref;
        this.angulo = angulo;
    }

    public int getXref() {
        return xref;
    }

    public void setXref(int xref) {
        this.xref = xref;
    }

    public int getYref() {
        return yref;
    }

    public void setYref(int yref) {
        this.yref = yref;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public String[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(String[] imagenes) {
        this.imagenes = imagenes;
    }
    
    
}
