/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextField;
import net.sourceforge.jdatepicker.DateModel;

/**
 * Ayuda a controlar la integridad de los
 * datos del paciente
 * @author Wilson Neira Mija  
 * @version 1.5.2
 */
public class PacienteControl {
    
    /**
     * Valida que solamente se ingresen numeros hasta
     * una longitud de 8 digitos en caso del DNI y 9 digitos
     * en el caso de CARNET DE EXTRANJERIA
     * @param txtDNI JTextField
     * @param evt KeyEvent
     */
    public void ValidarDNIYCE(JTextField txtDNI,KeyEvent evt){
        int a=txtDNI.getText().length();
        if(!Character.isDigit(evt.getKeyChar()) || a>8)
            evt.consume();
    }
    
    /**
     * Valida que solamente se ingresen letras y espacios
     * @param txtNom JTextField
     * @param evt KeyEvent
     */
    public void validarNombres(JTextField txtNom,KeyEvent evt){
        char caracter=evt.getKeyChar();
        if(caracter!=' ') 
            if(!Character.isLetter(caracter))
                evt.consume();
    }
    
    /**
     * Cada letra que se va ingresando en el JTextField 
     * enviado como primer parametro se va convirtiendo a
     * mayuscula
     * @param txtNom JTextField
     * @param evt KeyEvent
     */
    public void NombreMayuscula(JTextField txtNom,KeyEvent evt){
        String Nombre=txtNom.getText();
        if(evt.getKeyCode()>=65 && evt.getKeyCode()<=90){
            txtNom.setText(Nombre.toUpperCase());
        }
    }
        
    /**
     * Verifica que la fecha de nacimiento ingresada
     * no sea mayor a la actual
     * @param modeloFecha DateModel
     * @return boolean
     */
    public boolean ValidarFechaNac(DateModel modeloFecha){
        Calendar fecha;
        int anno,mes,dia;
        fecha=new GregorianCalendar();
        anno=fecha.get(Calendar.YEAR);
        mes=fecha.get(Calendar.MONTH)+1;
        dia=fecha.get(Calendar.DAY_OF_MONTH);
        if(modeloFecha.getYear()<anno){
           return true;
        }
        else{
            if(modeloFecha.getYear()==anno)
            {
                if((modeloFecha.getMonth()+1)<mes){
                    return true;
                }
                else{
                    if((modeloFecha.getMonth()+1)==mes)
                        if(modeloFecha.getDay()<=dia)
                             return true;
                }
            }
        }
        return false;

    }
    
}
