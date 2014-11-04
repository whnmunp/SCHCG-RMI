/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Objeto CarpetaFamiliar
 * @author Wilson Neira Mija
 * @author Carlos Augusto Nole Machaca
 * @version 1.5.2
 */
public class CarpetaFamiliar {
    /**
     * Variable tipo String que contiene el Código de Carpeta
     */
    private String CarpetaFamiliar;
    /**
     * Variable tipo String que contiene la Historia Máxima
     */
    private String MaximaHistoria;
    /**
     * Variable tipo ArrayList que contien las historias clínicas
     * de la CarpetaFamiliar
     */
    private ArrayList<HistoriaClinica> Historias;

    /**
     * Inicia un objeto de la clase <code>CarpetaFamiliar</code>
     * @param CarpetaFamiliar numero de la Carpeta
     * @param Historias un ArrayList con todas las historias clinicas que contiene la carpeta
     */
    public CarpetaFamiliar(String CarpetaFamiliar, ArrayList<HistoriaClinica> Historias) {
        this.CarpetaFamiliar = CarpetaFamiliar;
        this.Historias = Historias;
    }

    /**
     * Inicia un objeto de la clase <code>CarpetaFamiliar</code>
     * @param CarpetaFamiliar <code>String</code> numero que tendra la
     * nueva carpeta Familiar a registrarse
     */
    public CarpetaFamiliar(String CarpetaFamiliar) {
        this.CarpetaFamiliar = CarpetaFamiliar;
    }

    /**
     * Inicia un objeto vacio de la clase <code>CarpetaFamiliar</code>
     */
    public CarpetaFamiliar() {
    }
    
    /**
     * Inicia un objeto de la clase <code>CarpetaFamiliar</code>
     * @param CarpetaFamiliar numero de la carpeta
     * @param MaximaHistoria  la mayor historia clinica registrada en la carpeta (la mas cercana a la "Z")
     */
    public CarpetaFamiliar(String CarpetaFamiliar, String MaximaHistoria) {
        this.CarpetaFamiliar = CarpetaFamiliar;
        this.MaximaHistoria = MaximaHistoria;
    }
    
    /**
     * Obtiene el numero de la carpeta
     * @return int 
     */
    public String getCarpetaFamiliar() {
        return CarpetaFamiliar;
    }
    
    /**
     * Modifica el numero de la carpeta
     * @param CarpetaFamiliar numero de carpeta familiar nuevo
     */
    public void setCarpetaFamiliar(String CarpetaFamiliar) {
        this.CarpetaFamiliar = CarpetaFamiliar;
    }
    
    /**
     * Obtiene la maxima historia clinica
     * @return String
     */
    public String getMaximaHistoria() {
        return MaximaHistoria;
    }

    /**
     * Modifica la maxima historia clinica
     * @param MaximaHistoria nueva maxima historia
     */
    public void setMaximaHistoria(String MaximaHistoria) {
        this.MaximaHistoria = MaximaHistoria;
    }

    /**
     * Obtiene todas las historia de una carpeta
     * @return ArrayList
     */
    public ArrayList<HistoriaClinica> getHistorias() {
        return Historias;
    }

    /**
     * modifica las historias obtenidas por
     * otras nuevas
     * @param Historias ArrayList que contiene las historias clinicas 
     */
    public void setHistorias(ArrayList<HistoriaClinica> Historias) {
        this.Historias = Historias;
    }
    
    /**
     * Consulta a la base de datos por el contenido
     * de un determinado numero de carpeta
     * @param CodCarpeta numero de la carpeta familiar
     * @return un objeto de la clase <code>CarpetaFamiliar</code>
     * @throws SQLException 
     */
    public CarpetaFamiliar ConsultarCarpetaFamiliar(String CodCarpeta) throws SQLException{
        Paciente paciente = null;
        ArrayList<HistoriaClinica> historiasClinicas;
        HistoriaClinica historiaClinica;
        CarpetaFamiliar carpetafamiliar;
        Parentesco parentesco;
        String query;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        query="SELECT  p.id,p.dni,p.\"ApPaterno\", p.\"ApMaterno\", p.\"Nombres\",p.\"FechNac\",p.\"sexo\",p.\"direccion\",p.\"codCarpeta\",pr.\"descripcion\",hc.\"codHistoria\" FROM  \"Paciente\" as p \n" +
"inner join \"HistoriaClinica\" as hc on hc.id=p.id inner join \"Parentesco\" as pr on pr.\"codParentesco\"=p.\"codParentesco\" where hc.\"codCarpeta\"='"+CodCarpeta+"'";
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        rs=st.executeQuery(query);
        historiasClinicas=new ArrayList<HistoriaClinica>();
        while(rs.next()){
            parentesco=new Parentesco(rs.getString("descripcion"));
            if(rs.getString("codCarpeta")!=null)
            {   
                if(!rs.getString("codCarpeta").equals(" "))
                    paciente=new Paciente(rs.getString("dni"),rs.getString("Nombres"),rs.getString("ApMaterno"),rs.getString("ApPaterno"),rs.getString("FechNac"),rs.getString("direccion"),rs.getString("sexo"),true,rs.getInt("id"),parentesco);
                else
                    paciente=new Paciente(rs.getString("dni"),rs.getString("Nombres"),rs.getString("ApMaterno"),rs.getString("ApPaterno"),rs.getString("FechNac"),rs.getString("direccion"),rs.getString("sexo"),false,rs.getInt("id"),parentesco); 
            }
            else
               paciente=new Paciente(rs.getString("dni"),rs.getString("Nombres"),rs.getString("ApMaterno"),rs.getString("ApPaterno"),rs.getString("FechNac"),rs.getString("direccion"),rs.getString("sexo"),false,rs.getInt("id"),parentesco); 
            historiaClinica=new HistoriaClinica(rs.getString("codHistoria"), paciente);
            historiasClinicas.add(historiaClinica);
        }
        carpetafamiliar=new CarpetaFamiliar(CodCarpeta, historiasClinicas);
        return carpetafamiliar;
    }
	
    /**
     * Registra en la Base de datos el numero de la
     * carpeta familiar
     * @param conn coneccion establecida con la base de datos
     * @throws SQLException ocurrio algun problema
     */
    public void registrarCarpeta(Connection conn) throws SQLException{
        //FUNCTION "registrarCarpetaFamiliar"(codcarp integer)
        
        CallableStatement spObtCod = conn.prepareCall("{ call registrarcarpetafamiliar(?)}");
        spObtCod.setString(1,getCarpetaFamiliar());
        spObtCod.execute();
    }
     
    /**
     * Obtengo la cantidad de carpetas que tengo
     * en la base de datos
     * @return int cantidad de carpetas
     * @throws SQLException 
     */
    public int CantidadCarpetas() throws SQLException{
        int cantidad = 0;
        String query;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        query="select count(\"codCarpeta\") from \"CarpetaFamiliar\"";
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        rs=st.executeQuery(query);
        while(rs.next()){
            cantidad=rs.getInt(1);
        }
        return cantidad;
    }
   
    /**
     * Obtiene el mayor numero de carpeta que este registrado
     * en la base de datos
     * @return int mayor numero de carpeta
     * @throws SQLException 
     */
    public int MayorCarpeta() throws SQLException{
        int cantidad=0;
        int i=1;
        String query;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        //query="select max(\"codCarpeta\") from \"CarpetaFamiliar\"";
        query="select \"codCarpeta\" from \"CarpetaFamiliar\"";
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        rs=st.executeQuery(query);
        while(rs.next()){
            if(i==1)
                cantidad=rs.getInt(1);
            else{
                if(cantidad<rs.getInt(1))
                     cantidad=rs.getInt(1);
            }
            i++;
        }
        return cantidad;
    }
    
    /**
     * Actuliza el número de Carpeta Familiar
     * @param conn Conexion con la base de datos
     * @param codnew Código nuevo de la Carpeta Familiar
     * @throws SQLException Error SQL
     */
    public void actualizarNroCarpeta(Connection conn,String codnew) throws SQLException{
        CallableStatement sp = conn.prepareCall("{ call actualizarnrocarpeta(?,?)}");
        sp.setString(1,codnew);
        sp.setString(2,getCarpetaFamiliar());
        sp.execute();
    }
    
    /**
     * Elimina la Carpeta Familiar
     * @param conn Conexion con la base de datos
     * @throws SQLException 
     */
    public void eliminarCarpeta(Connection conn) throws SQLException{        
        CallableStatement spObtCod = conn.prepareCall("{ call eliminarcarpeta(?)}");
        spObtCod.setString(1,getCarpetaFamiliar());
        spObtCod.execute();
    }
}

