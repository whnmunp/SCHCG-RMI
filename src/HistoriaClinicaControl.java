/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 * Ayuda a mantener la integridad de los
 * datos de la historia Clinica
 * @author Wilson Neira Mija  
 * @version 1.5.2
 */
public class HistoriaClinicaControl {
     
    /**
     * Verifica que solamente se ingresen letras y numeros
     * @param txtHC JTextField
     * @param evt KeyEvent
     */
    public void ValidarHistoriaClinica(JTextField txtHC,KeyEvent evt){
        if(!Character.isLetterOrDigit(evt.getKeyChar()))
            evt.consume();
    }
    
    /**
     * Convierte a mayusculas las letras que se ingresen 
     * en el campo de la historia
     * @param txtHC JTextField
     * @param evt KeyEvent
     */
    public void HistoriaClinicaMayuscula(JTextField txtHC,KeyEvent evt){
        if(Character.isLetter(evt.getKeyChar()))
            {
                String nuevo=txtHC.getText();
                nuevo=nuevo.toUpperCase();
                txtHC.setText(nuevo);
            }
    }
    
    /**
     * Verifica gracia a una expresion regular si 
     * el formato de la historia es el correcto
     * @param HCNueva historia clinica nueva asignada
     * @param codCarpeta numero de la carpeta
     * @return boolean
     */
    public boolean ValidarHCNUEVA(String HCNueva,String codCarpeta){
        Pattern pat = Pattern.compile(codCarpeta+"-[A-Z]");
        Matcher mat = pat.matcher(HCNueva);
         if (mat.matches()) {
             return true;
         } else {
             return false;
        }
    }
}
