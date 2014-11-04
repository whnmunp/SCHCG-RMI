

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Permite crear objetos tipo HistoriaClínica
 * @author Wilson Neira Mija 
 * @author Carlos Nole Machaca 
 * @version 1.5.2
 */
public class HistoriaClinica{
    /**
     * Variable tipo String que contiene Código de Historia nueva
     */
    private String Hc;
    /**
     * Variable tipo String que contiene Código de Historia antigua
     */
    private String HCold;
    /**
     * Variable tipo String que contiene Código de Carpeta Familiar
     */
    private String Cf;
    /**
     * Variable tipo Paciente que es para saber quie es el 
     * dueño de la Historia Clínica
     */
    private Paciente Duenno;
    /**
     * Variable tipo integer que contiene el id del Paciente
     */
    private int cod;

    /**
     * Crea un objeto de la clase HistoriaClinica
     * completo con todos sus datos
     * @param Hc
     * @param Cf
     * @param Duenno 
     */
    public HistoriaClinica(String Hc, String Cf, Paciente Duenno) {
        this.Hc = Hc;
        this.Cf = Cf;
        this.Duenno = Duenno;
    }

    /**
     * Crea un objeto vacio de la clase HistoriaClinica
     */
    public HistoriaClinica() {
    }

    /**
     * Crea un objeto historia clinica solamente con
     * su codigo
     * @param Hc 
     */
    public HistoriaClinica(String Hc) {
        this.Hc = Hc;
    }

    /**
     * Crea un objeto historia clinica con su codigo y los
     * datos de su dueño
     * @param Hc
     * @param Duenno 
     */
    public HistoriaClinica(String Hc, Paciente Duenno) {
        this.Hc = Hc;
        this.Duenno = Duenno;
    }

    /**
     * Crea una objeto de la clase Historia Clinica con su 
     * codigo y la carpeta a la que pertenece
     * @param Hc
     * @param Cf 
     */
    public HistoriaClinica(String Hc, String Cf) {
        this.Hc = Hc;
        this.Cf = Cf;
    }

    /**
     * Crea un objeto de la clase <code>HistoriaClinica</code>
     * @param Hc <code>String</code> contiene el codigo de la historia clinica
     * @param Hcant <code>String</code> contine el codigo de la antigua historia clinica
     * @param Cf <code>String</code> contiene el numero de la carpeta a la cual pertenece la historia
     */
    public HistoriaClinica(String Hc, String Hcant, String Cf) {
        this.Hc = Hc;
        this.HCold = Hcant;
        this.Cf = Cf;
    }
    
    
    /**
     * Obtiene el codigo de la historia clinica
     * @return String
     */
    public String getHc() {
        return Hc;
    }

    /**
     * Modifica el codigo de la historia clinica
     * @param Hc 
     */
    public void setHc(String Hc) {
        this.Hc = Hc;
    }

    /**
     * Obtiene el numero de la carpeta familiar a 
     * la que pertenece la historia clinica
     * @return String
     */
    public String getCf() {
        return Cf;
    }

    /**
     * Modifica el numero de la carpeta familiar
     * @param Cf 
     */
    public void setCf(String Cf) {
        this.Cf = Cf;
    }

    /**
     * Obtiene la historia clinica antigua
     * @return String
     */
    public String getHCold() {
        return HCold;
    }

    /**
     * Modifica la historia clinica antigua
     * @param Hcant 
     */
    public void setHCold(String Hcant) {
        this.HCold = Hcant;
    }

    /**
     * Obtiene los datos del paciente dueño de la historia
     * clinica
     * @return Paciente 
     */
    public Paciente getDuenno() {
        return Duenno;
    }

    /**
     * Modifica la historia clinica
     * @param Duenno 
     */
    public void setDuenno(Paciente Duenno) {
        this.Duenno = Duenno;
    }
    
    /**
     * Obtiene el id del paciente
     * @param conn Conexion
     * @return id
     * @throws SQLException 
     */
    public int obtener_id(Connection conn)throws SQLException{
        int aux = 0;
        ResultSet rs = null;
        Statement s = null;

        s = conn.createStatement();
        rs = s.executeQuery("SELECT obtenerid();");
        while (rs.next())
            aux = rs.getInt(1);                                    
        return aux;
    }
    
    /**
     * Registra la historia Clinica perteneciente a un
     * paciente
     * @param conn conexion establecida con la base de datos
     * @throws SQLException 
     */
    public void registrarHistoria(Connection conn) throws SQLException{
        cod = obtener_id(conn);
        System.out.println("id: "+cod);
        //FUNCTION "registrarHistoriaClinica"(codcarp integer, di character, 
        //codhis character varying)
        /** Para obtener los resultados de las consultas SQL de la base de datos */
        ResultSet resultSet = null;
        /** Para enviar comandos SQL a la base de datos */
        Statement statement = null;

        statement = conn.createStatement();
        resultSet = statement.executeQuery("SELECT registrarHistoriaClinica('"+getCf()+"',"
                + "'"+cod+"','"+getHc()+"','"+getHCold()+"')");
        while (resultSet.next()){
            resultSet.getString(1);
        }
    } 
    
    /**
     * Actualiza algunos datos de la Historia Clinica, sin cambiar 
     * el codigo de la Historia Clinica
     * @param conn
     * @throws SQLException 
     */
    public void modificarHistoria(Connection conn) throws SQLException
    {
        ResultSet resultSet = null;
        Statement statement = null;
        statement = conn.createStatement();
        resultSet = statement.executeQuery("SELECT actualizarhistoriatranslado('"+getHc()+"','"+getCf()+"')");
        while (resultSet.next()){
            resultSet.getString(1);
        }

    }
    
    /**
     * Obtiene la letra de la historia mas cercana
     * a la letra Z
     * @param codCarpeta
     * @return la letra de la mayor historia
     * @throws SQLException 
     */
    public char maxHistoria(String codCarpeta) throws SQLException{
        String query,codHistoria = null;
        char Sgteletra='C';
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        //query="select max(\"codHistoria\" )from \"HistoriaClinica\" where \"codCarpeta\"='"+codCarpeta+"'";
        //query="select \"HistoriaMax\" from \"CarpetaFamiliar\" where \"codCarpeta\"='"+codCarpeta+"'";
        query="select max(\"codHistoria\") from \"HistoriaClinica\" where \"codHistoria\" like '"+codCarpeta+"-%'";
        rs=st.executeQuery(query);
        while(rs.next()){
            if(rs.getString(1)!=null){
                codHistoria=rs.getString(1).trim();
                Sgteletra=(char) (codHistoria.charAt(codHistoria.length()-1)+1);
            }   
        } 
        
        return Sgteletra;
    }
    
    /**
     * Obtiene la cantidad de historia clinica que se
     * han registrado en la base de datos
     * @return int
     * @throws SQLException 
     */
     public int CantidadHistorias() throws SQLException{
        int cantidad = 0;
        String query;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        query="select count(idhistoria) from \"HistoriaClinica\"";
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
     * Eliminar la Historia Clínica
     * @param conn Conexion
     * @param ref Referencia de la Historia Clínica a eliminar
     * @throws SQLException 
     */
    public void eliminarHistoriaClinica(Connection conn,int ref) throws SQLException{
        CallableStatement sp = conn.prepareCall("{ call eliminarhistoriaclinica(?)}");
        sp.setInt(1,ref);
        sp.execute();    
    }     
}
