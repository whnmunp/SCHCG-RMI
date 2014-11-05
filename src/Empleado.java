/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Permite crear objetos tipo Empleado
 * @author Wilson Neira Mija 
 * @version 1.5.2
 */
public class Empleado {
    /**
     * Variable tipo String que contiene el nombre del empleado
     */
    String Nombre;
    /**
     * Variable tipo String que contiene los apellidos del empleado
     */
    String Apellidos;
    /**
     * Variable tipo String que contiene el código del empleado
     */
    String CodEmpleado;    
    /**
     * Variable tipo String que contiene el código de usuario del empleado
     */
    String CodUsuario;    

   /**
    * Crea un objeto de la clase Empleado, obtiene sus
    * datos segun el codigo del empleado
    * @param CodEmpleado identificador del empleado
    * @throws SQLException 
    */
    public Empleado(String CodEmpleado) throws SQLException {
        Conexion con;
        Connection conn;
        String Query;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        this.CodEmpleado = CodEmpleado;
        Query="Select \"Nombres\",\"ApePat\",\"ApeMat\" from \"Empleados\" where idempleados='"+CodEmpleado+"'";
        st=conn.createStatement();
        rs=st.executeQuery(Query);
        while(rs.next()){
            this.Nombre = rs.getString("Nombres");
            this.Apellidos = rs.getString("ApePat")+" "+rs.getString("ApeMat");
            //this.Area =new Area(rs.getString("CodArea"));
        }
        con.desconectar();
    }

    /**
     * Crea un objeto de la clase Empleado con todos sus
     * datos
     * @param Nombre nombre del empleado
     * @param Apellidos apellidos del empleado
     * @param CodUsuario identificador del empleado
     */
    public Empleado(String Nombre, String Apellidos, String CodUsuario) {
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.CodUsuario = CodUsuario;
    }
    
    /**
     * Crea un objeto de la clase Empleado vacio
     */
    public Empleado(){
        
    }

    /**
     * Obtiene el codigo del empleado
     * @return identificador del empleado
     */
    public String getCodEmpleado() {
        return CodEmpleado;
    }

    /**
     * Modifica el codigo del empleado
     * @param CodEmpleado identificador del empleado
     */
    public void setCodEmpleado(String CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }
    
    /**
     * Obtiene el mobre del empleado
     * @return String
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Actualiza el nombre del empleado
     * @param Nombre nombre del empleado
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Obtiene los apellidos del empleado
     * @return String
     */
    public String getApellidos() {
        return Apellidos;
    }

    /**
     * Modifica los apellidos del empleado
     * @param Apellidos apellidos del empleado
     */
    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    /**
     * Obtiene el nombre del usuario
     * @return String
     */
    public String getCodUsuario() {
        return CodUsuario;
    }

    /**
     * Modifica el nombre del usuario
     * @param CodUsuario 
     */
    public void setCodUsuario(String CodUsuario) {
        this.CodUsuario = CodUsuario;
    }
    
}
