/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotanque;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 * Jpanel dado que voy a pintar en el Canvas
 * ActionListener: Para poder ejecutar el escenario cada ciertos milisegundos
 */
public class Tablero extends JPanel implements ActionListener, MouseListener{
    private Timer timer ;
    private Tanque tanque;
    public Tablero(){
        //Lanza un evento de tipo ActionListener cada 25 Milisegundo
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.timer = new Timer(25, this);
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        this.timer.start(); //Inicio con el escenario
        this.tanque.setXref(50);
        this.tanque.setYref(50);
        addMouseListener (this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
         Point mp = e.getPoint();
        Rectangle cuadrado = (new Rectangle (this.xref, this.yref, 20, 20));
        if (cuadrado.contains(mp)){
            System.out.println("click sobre el rectangulo");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
     }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    //Inner class Que captura los eventos del teclado
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
               System.out.println("solte tecla");
           } else if (key == KeyEvent.VK_UP){
               xref +=20;
           }
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if ( key == KeyEvent.VK_LEFT){
                System.out.println("izquierda");
                xref -=1;
            }else if (key == KeyEvent.VK_RIGHT){
                System.out.println("derecha");
                xref+=1;
            } else if (key == KeyEvent.VK_UP){
                System.out.println("arriba");
                yref -=20;
            } else if (key == KeyEvent.VK_DOWN){
                System.out.println("abajo");
                yref +=1;
            }
            
           
        }
    }
   
    //Metodo donde se pintan los objetos 
     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       Image imgTanque = loadImage (tanque.getImagenes()[tanque.getAngulo()]);
       g.drawImage(imgTanque, tanque.getXref(), tanque.getYref(), this);
            g.drawRect(xref, yref, 20, 20);
            Rectangle rect = new Rectangle (xref, 150, 20, 20);
            g.drawOval(20, 80, 20, 20);
            Rectangle oval = new Rectangle (xref, 150, 20, 20);
       
       if (rect.intersects(oval)){
           g.drawString("game over", 50, 50);
       }
    }

    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Repaint");
        repaint();
    }
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
