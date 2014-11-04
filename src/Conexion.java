/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Permite obtener la conexión a la Base de Datos
 * @author Wilson Neira Mija 
 * @version 1.5.2
 */
public class Conexion {
    /**
     * Objeto connection
     */
    private Connection conn;
   
    /**
     * Crea un objeto de la clase Conexion
     */
    public Conexion(){
        try{

             String cc="jdbc:postgresql://localhost:5432/BDSCHCG";
             Class.forName("org.postgresql.Driver");
             conn=DriverManager.getConnection(cc,"postgres","12345");
         }
         catch(ClassNotFoundException e){
             javax.swing.JOptionPane.showMessageDialog(null,"Error Carga Driver");
         }     
         catch(SQLException e){
             javax.swing.JOptionPane.showMessageDialog(null,"Error al crear sentencia");
         }     
    }
       
    /**
     * Obtiene la conexion a la base de datos
     * @return Connection
     */
    public Connection getConnection() {
         return conn;
    }   

    /**
     * Termina la conexion con la base de datos
     */
     public void desconectar() {
         conn = null;
     }
}
