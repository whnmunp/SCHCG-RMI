/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTextField;

/**
 * Ayuda a controlar la integridad de los datos de la 
 * @author Wilson Neira Mija 
 * @version 1.5.2
 */
public class CarpetaFamiliarControl {
     
    /**
     * Valida que solamente se ingresen numeros
     * en el campo perteneciente a la carpeta familiar
     * @param txtHC JTextField
     * @param evt KeyEvent
     */
    public void ValidarCarpetaFamiliar(JTextField txtHC,KeyEvent evt){
        if(!Character.isDigit(evt.getKeyChar()))
            evt.consume();
    }
        
    /**
     * Consulta en la base de datos si existe el numero de
     * carpeta que se pretende registrar
     * @param conn conexion establecida con la base de datos
     * @param codCarpeta numero de carpeta
     * @return false si no existe el numero de carpeta y true en caso contrario
     * @throws SQLException 
     */
    public boolean ExisteCodigo(Connection conn,String codCarpeta) throws SQLException{
        boolean resultado=false;
        ResultSet resultSet = null;
        /** Para enviar comandos SQL a la base de datos */
        Statement statement = null;
        String query;
        statement = conn.createStatement();
        query="select count(\"codCarpeta\") from \"CarpetaFamiliar\" where \"codCarpeta\"='"+codCarpeta+"'";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            if(resultSet.getInt(1)>=1)
                resultado=true;
        }
        return resultado;
    }
}
