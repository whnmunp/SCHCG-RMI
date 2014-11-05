/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.border.Border;

/**
 * Permite colocar una imagen de fondo
 * @author Wilson Neira Mija 
 * @author Carlos Nole Machaca 
 * @version 1.5.2
 */
public class ImagenMDI implements Border{
    /**
     * Subclase que describe una imagen
     */
    BufferedImage fondo;

    /**
     * Crea un objeto de la clase ImagenMDI, que coloca
     * una imagen como fondo
     */  
    public ImagenMDI() {
        try {
            URL ur1=new URL(getClass().getResource("fondo.jpg").toString());
            fondo=ImageIO.read(ur1);
        }
        catch(IOException ex) {
            
        }
    }
    
    /**
     * Dibuja la imagen de fondo
     * @param c componente
     * @param g objeto clase Graphics
     * @param x
     * @param y
     * @param width ancho
     * @param height alto
     */
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawImage(fondo,(x+(width-fondo.getWidth())/2),(y+(height-fondo.getHeight())/2),null);
    }
    
    /**
     * Obtiene la representación de las fronteras de un contenedor
     * @param c
     * @return Insets
     */
    public Insets getBorderInsets(Component c) {
        return new Insets(0, 0, 0, 0);
    }
    
    /**
     * Borde opaco
     * @return boolean
     */
    public boolean isBorderOpaque() {
        return true;
    }
    
}
