/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Permite crear Objeto tipo Parentesco
 * @author Wilson Neira Mija
 */
public class Parentesco {
    /**
     * Variable tipo String que contiene el id de parentesco
     */
    private String IdParentesco;
    /**
     * Variable tipo String que contiene la descripcion del parentesco
     */
    private String Denominacion;

    /**
     * Crea un objeto de la clase Parentesco
     * @param IdParentesco
     * @param Denominacion 
     */
    public Parentesco(String IdParentesco, String Denominacion) {
        this.IdParentesco = IdParentesco;
        this.Denominacion = Denominacion;
    }

    /**
     * Crea un objeto de la clase <code>Parentesco</code>
     * @param Denominacion <code>String</code> que contiene el 
     * parentesco con el cual se crea el objeto
     */
    public Parentesco(String Denominacion) {
        this.Denominacion = Denominacion;
    }

    /**
     * Crea un objeto vacio de la clase <code>Parentesco</code>
     */
    public Parentesco() {
    }

    /**
     * Obtiene el id del parentesco
     * @return String
     */
    public String getIdParentesco() {
        return IdParentesco;
    }

    /**
     * Modifica el id del parentesco
     * @param IdParentesco 
     */
    public void setIdParentesco(String IdParentesco) {
        this.IdParentesco = IdParentesco;
    }

    /**
     * Obtiene la denominacion del parentesco
     * @return String
     */
    public String getDenominacion() {
        return Denominacion;
    }

    /**
     * Modifica la denominacion del parentesco
     * @param Denominacion 
     */
    public void setDenominacion(String Denominacion) {
        this.Denominacion = Denominacion;
    }
    
    /**
     * Consulta todos los parentesco que existan
     * en la base de datos
     * @return devuelve un ArrayList con los parentescos
     * @throws SQLException 
     */
    public ArrayList<Parentesco> ConsultarParentesco() throws SQLException{
        String query;
        Parentesco  parentesco;
        ArrayList<Parentesco> parentescos;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        query="SELECT \"descripcion\" from \"Parentesco\" order by \"codParentesco\";";
        rs=st.executeQuery(query);
        parentescos=new ArrayList<Parentesco>();
        while(rs.next()){
            parentesco=new Parentesco(rs.getString("descripcion"));
            parentescos.add(parentesco);
        }
        return parentescos;
    }
    
    /**
     * Consulta todos los parentesco que existan en una
     * carpeta familiar
     * @param codCarpeta
     * @return ArrayList con todos los parentesco
     * @throws SQLException 
     */
    public ArrayList<Parentesco> ConsultarParentesco(String codCarpeta) throws SQLException{
        String query;
        Parentesco  parentesco;
        ArrayList<Parentesco> parentescos;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        query="select pa.\"descripcion\" from \"Paciente\" as p inner join \"Parentesco\" as pa on p.\"codParentesco\"=pa.\"codParentesco\"  where p.id in (select id from \"HistoriaClinica\" where \"codCarpeta\"='"+codCarpeta+"') and p.\"codParentesco\" in ('P','M')";
        rs=st.executeQuery(query);
        parentescos=new ArrayList<>();
        while(rs.next()){
            parentesco=new Parentesco(rs.getString("descripcion"));
            parentescos.add(parentesco);
        }
        return parentescos;
    }
}
