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

/**
 * Permite crear objetos tipo Paciente
 * @author Wilson Neira Mija 
 * @author Carlos Nole Machaca 
 * @version 1.5.2
 */
public class Paciente {
    /**
     * Variable tipo String que contiene el Documento de Identidad del Paciente
     */
    private String DNI;
    /**
     * Variable tipo String que contiene el Nombre del Paciente
     */
    private String Nombre;
    /**
     * Variable tipo String que contiene el Apellido Materno del Paciente
     */
    private String AptMat;
    /**
     * Variable tipo String que contiene el Apellido Paterno del Paciente
     */
    private String ApPat;
    /**
     * Variable tipo String que contiene la Fecha Nacimiento del Paciente
     */
    private String Fecha;
    /**
     * Variable tipo String que contiene el Sexo del Paciente
     */
    private String Sexo;
    /**
     * Variable tipo String que contiene la Direccion del Paciente
     */
    private String direccion;
    /**
     * Variable tipo boolean que permite saber si el paciente es Jefe de
     * Carpeta Familiar
     */
    private boolean jefeFamilia;
    /**
     * Permite saber el parentesco del Paciente
     */
    private Parentesco pa;
    /**
     * Permite saber la Historia Clínica del Paciente
     */
    private HistoriaClinica hc;
    /**
     * Permite saber la Carpeta Familiar del Paciente
     */
    private CarpetaFamiliar cf;
    /**
     * Variable tipo integer que contiene el id del Paciente
     */
    private int Referencia;

    /**
     * Crea un obejto de la clase <code>Paciente</code>
     * @param DNI <code>String</code> contiene el DNI y/o CARNET DE EXTRANJERIA del paciente
     * @param Nombre <code>String</code> contiene los NOMBRES del paciente
     * @param AptMat <code>String</code> contiene el APELLIDO MATERNO del paciente
     * @param ApPat  <code>String</code> contiene el APELLIDO PATERNO del paciente
     * @param Fecha <code>String</code> contiene la FECHA DE NACIMIENTO del paciente
     * @param Sexo <code>String</code> contiene el SEXO del paciente
     * @param direccion <code>String</code> contiene la DIRECCION DOMICILIARIA del paciente
     * @param jefeFamilia <code>Boolean</code> nos indicara si es jefe de familia o no
     * @param pa    <code>Parentesco</code> objeto que contendra el parentesco
     * @param cf <code>CarpetaFamiliar</code> objeto que contendra el numero de carpeta
     * @param hc <code>HistoriaClinica</code> objeto que contendra el numero de historia
     */
    public Paciente(String DNI, String Nombre, String AptMat, String ApPat, String Fecha, String Sexo,String direccion,boolean jefeFamilia, Parentesco pa,CarpetaFamiliar cf,HistoriaClinica hc) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.AptMat = AptMat;
        this.ApPat = ApPat;
        this.Fecha = Fecha;
        this.Sexo = Sexo;
        this.direccion=direccion;
        this.jefeFamilia=jefeFamilia;
        this.pa = pa;
        this.hc=hc;
        this.cf=cf;
    }

    /**
     * Crea un obejto de la clase <code>Paciente</code>
     * @param DNI <code>String</code> contiene el DNI y/o CARNET DE EXTRANJERIA del paciente
     * @param Nombre <code>String</code> contiene los NOMBRES del paciente
     * @param AptMat <code>String</code> contiene el APELLIDO MATERNO del paciente
     * @param ApPat  <code>String</code> contiene el APELLIDO PATERNO del paciente
     * @param cf <code>CarpetaFamiliar</code> objeto que contendra el numero de carpeta
     * @param hc <code>HistoriaClinica</code> objeto que contendra el numero de historia
     */
    //utilizado en la parte principal del sistema
    public Paciente(String DNI, String Nombre, String AptMat, String ApPat,CarpetaFamiliar cf,HistoriaClinica hc) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.AptMat = AptMat;
        this.ApPat = ApPat;
        this.hc=hc;
        this.cf=cf;
    }
    
    /**
     * Constructor usado para actualizar un Paciente que es Jefe de
     * Carpeta Familiar
     * @param DNI Documento de Identidad del Paciente
     * @param Nombre Nombre del Paciente
     * @param AptMat Apellido Materno del Paciente
     * @param ApPat Apellido Paterno del Paciente
     * @param Fecha Fecha de Nacimiento del Paciente
     * @param Sexo Sexo del Paciente
     * @param direccion Direccion del Paciente
     * @param pa Parentesco del Paciente
     * @param hc Historica Clinica del Paciente
     * @param Referencia id del Paciente
     */
    public Paciente(String DNI, String Nombre, String AptMat, String ApPat, String Fecha, String Sexo, String direccion, Parentesco pa, HistoriaClinica hc, int Referencia) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.AptMat = AptMat;
        this.ApPat = ApPat;
        this.Fecha = Fecha;
        this.Sexo = Sexo;
        this.direccion = direccion;
        this.pa = pa;
        this.hc = hc;
        this.Referencia = Referencia;
    }
    
    /**
     * Constructor usado para actualizar un paciente normal
     * @param DNI Documento de Identidad
     * @param Nombre Nombre
     * @param AptMat Apellido Materno
     * @param ApPat Apellido Paterno
     * @param Fecha Fecha de Nacimiento
     * @param Sexo Sexo
     * @param direccion Direccion
     * @param pa Parentesco
     * @param hc Historia Clinica
     */
    public Paciente(String DNI, String Nombre, String AptMat, String ApPat, String Fecha, String Sexo, String direccion, Parentesco pa, HistoriaClinica hc) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.AptMat = AptMat;
        this.ApPat = ApPat;
        this.Fecha = Fecha;
        this.Sexo = Sexo;
        this.direccion = direccion;
        this.pa = pa;
        this.hc = hc;        
    }
    
    /**
     * Crea un obejto vacio de la clase <code>Paciente</code>
     */
    public Paciente(){
        
    }

    /**
     * Constructor usado para actulizar Paciente
     * @param DNI Documento de Identidad
     * @param Nombre Nombre
     * @param AptMat Apellido Materno
     * @param ApPat Apellido Paterno
     * @param Fecha Fecha de Nacimiento
     * @param direccion Direccion
     * @param Sexo Sexo
     * @param jefe Jefe de Carpeta Familiar
     * @param id id Paciente
     * @param pa Parentesco
     */
    public Paciente(String DNI, String Nombre, String AptMat, String ApPat, String Fecha,String direccion, String Sexo,boolean jefe,int id,Parentesco pa) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.AptMat = AptMat;
        this.ApPat = ApPat;
        this.Fecha = Fecha;
        this.jefeFamilia=jefe;
        this.direccion=direccion;
        this.Sexo = Sexo;
        this.Referencia=id;
        this.pa = pa;
    }
    
    /**
     * Constructor para actualizar Paciente
     * @param DNI Documento de Identidad
     * @param Nombre Nombre
     * @param AptMat Apellido Materno
     * @param ApPat Apellido Paterno
     * @param Fecha Fecha de Nacimiento
     * @param Sexo Sexo
     * @param direccion Direccion
     * @param pa Parentesco
     * @param cf Carpeta Familiar
     */
    public Paciente(String DNI, String Nombre, String AptMat, String ApPat, String Fecha, String Sexo, String direccion, Parentesco pa, CarpetaFamiliar cf) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.AptMat = AptMat;
        this.ApPat = ApPat;
        this.Fecha = Fecha;
        this.Sexo = Sexo;
        this.direccion = direccion;
        this.pa = pa;
        this.cf = cf;
    }

    /**
     * Crea un obejto de la clase <code>Paciente</code>
     * @param DNI <code>String</code> contiene el DNI y/o CARNET DE EXTRANJERIA del paciente
     * @param Nombre <code>String</code> contiene los NOMBRES del paciente
     * @param AptMat <code>String</code> contiene el APELLIDO MATERNO del paciente
     * @param ApPat  <code>String</code> contiene el APELLIDO PATERNO del paciente
     * @param Fecha <code>String</code> contiene la FECHA DE NACIMIENTO del paciente
     * @param direccion <code>String</code> contiene la DIRECCION DOMICILIARIA del paciente
     * @param jefeFamilia <code>Boolean</code> nos indicara si es jefe de familia o no
     * @param cf <code>CarpetaFamiliar</code> objeto que contendra el numero de carpeta
     * @param hc <code>HistoriaClinica</code> objeto que contendra el numero de historia
     */
    public Paciente(String DNI, String Nombre, String AptMat, String ApPat, String Fecha, String direccion, boolean jefeFamilia, HistoriaClinica hc, CarpetaFamiliar cf) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.AptMat = AptMat;
        this.ApPat = ApPat;
        this.Fecha = Fecha;
        this.direccion = direccion;
        this.jefeFamilia = jefeFamilia;
        this.hc = hc;
        this.cf = cf;
    }
    
    /**
     * Obtiene la direccion del domicilio del paciente
     * @return String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Modifica la direccion del domicilio de un paciente
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el DNI del paciente
     * @return String
     */
    public String getDNI() {
        return DNI;
    }

    /**
     * Modifica el DNI del paciente
     * @param DNI 
     */
    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    /**
     * Obtiene el nombre del paciente
     * @return String
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Modifica el nombre del paciente
     * @param Nombre 
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * Obtiene el apellido materno del paciente
     * @return String
     */
    public String getAptMat() {
        return AptMat;
    }

    /**
     * Modifica el apellido materno del paciente
     * @param AptMat 
     */
    public void setAptMat(String AptMat) {
        this.AptMat = AptMat;
    }

    /**
     * Obtiene el apellido paterno del paciente
     * @return String
     */
    public String getApPat() {
        return ApPat;
    }

    /**
     * Modifica el apellido paterno del paciente
     * @param ApPat 
     */
    public void setApPat(String ApPat) {
        this.ApPat = ApPat;
    }

    /**
     * Obtiene la fecha de nacimiento del paciente
     * @return String
     */
    public String getFecha() {
        return Fecha;
    }

    /**
     * Modifica la fecha de naciemiento del paciente
     * @param Fecha 
     */
    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
    
    /**
     * Obtiene el sexo del paciente
     * @return String
     */
    public String getSexo() {
        return Sexo;
    }

    /**
     * Modifica el sexo del paciente
     * @param Sexo 
     */
    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    /**
     * Nos indica si es jefe de familia
     * @return true si es jefe de familia y false si no es jefe de familia
     */
    public boolean isJefeFamilia() {
        return jefeFamilia;
    }

    /**
     * Modifica la condicion de ser o no jefe
     * @param jefeFamilia 
     */
    public void setJefeFamilia(boolean jefeFamilia) {
        this.jefeFamilia = jefeFamilia;
    }

    /**
     * Obtiene el id del Paciente
     * @return int
     */
    public int getReferencia() {
        return Referencia;
    }

    /**
     * Modifica el id del Paciente
     * @param Referencia 
     */
    public void setReferencia(int Referencia) {
        this.Referencia = Referencia;
    }
    
    /**
     * Obtiene el parentesco 
     * @return Parentesco
     */
    public Parentesco getPa() {
        return pa;
    }

    /**
     * Modifica el parentesco
     * @param pa 
     */
    public void setPa(Parentesco pa) {
        this.pa = pa;
    }

    /**
     * Obtiene la historia clinica
     * @return HistoriaClinica
     */
    public HistoriaClinica getHc() {
        return hc;
    }

    /**
     * Modifica la historia clinica
     * @param hc 
     */
    public void setHc(HistoriaClinica hc) {
        this.hc = hc;
    }

    /**
     * Obtiene la carpeta familiar
     * @return CarpetaFamiliar
     */
    public CarpetaFamiliar getCf() {
        return cf;
    }

    /**
     * Modifica la carpeta familiar
     * @param cf 
     */
    public void setCf(CarpetaFamiliar cf) {
        this.cf = cf;
    }
    
    /**
     * Consulta a la base de datos por pacientes
     * segun la query que se envia
     * @param query 
     * @param DeDonde
     * @return Un ArrayList con todos los pacientes que
     * devuelve la query
     * @throws SQLException 
     */
    public ArrayList<Paciente> ConsultarPacientes(String query,int DeDonde) throws SQLException{
        ArrayList<Paciente> pacientes;
        Paciente paciente = null;
        HistoriaClinica historiaClinica;
        CarpetaFamiliar carpetafamiliar;
        Parentesco parentesco;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        rs=st.executeQuery(query);
        pacientes=new ArrayList<Paciente>();
        while(rs.next()){
            historiaClinica=new HistoriaClinica(rs.getString("codHistoria"),rs.getString("histAntigua"));
            carpetafamiliar=new CarpetaFamiliar(rs.getString("codCarpeta"));
            switch(DeDonde)
            {
                case 0:
                    paciente=new Paciente(rs.getString("dni"),rs.getString("Nombres"),rs.getString("ApMaterno"), rs.getString("ApPaterno"),carpetafamiliar,historiaClinica);
                    break;
                case 1:
                    parentesco=new Parentesco(rs.getString("descripcion"));
                    paciente=new Paciente(rs.getString("dni"),rs.getString("Nombres"),rs.getString("ApMaterno"), rs.getString("ApPaterno"),rs.getString("FechNac"),rs.getString("sexo"),rs.getString("direccion"),false,parentesco,carpetafamiliar,historiaClinica);
                    break;
            }
            pacientes.add(paciente);
        }
        return pacientes;
        
    }
        
    /**
     * Se dirige  a la base de datos a consultar si hay pacientes
     * con un determinado nombre y apellidos
     * @param appat es el Apellido paterno del paciente
     * @param apmat es el apellido materno del paciente
     * @param nombre son los nombres del paciente
     * @param DeDonde la interfaz de donde a sido llamado
     * @return devuelve un <code>ArrayList</code> con las posibles 
     * respuestas
     * @throws SQLException 
     */
    public ArrayList<Paciente> ConsultarPacientes(String appat,String apmat,String nombre,int DeDonde) throws SQLException{
        ArrayList<Paciente> pacientes = null;
        Paciente paciente = null;
        HistoriaClinica historiaClinica;
        CarpetaFamiliar carpetafamiliar;
        Parentesco parentesco;
        String query = null;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
         switch(DeDonde)
            {
                case 0:
                    query="SELECT p.dni, p.\"ApPaterno\", p.\"ApMaterno\", p.\"Nombres\",hc.\"codHistoria\", hc.\"codCarpeta\",hc.\"histAntigua\" FROM \"Paciente\" as p inner join \"HistoriaClinica\" hc on hc.id=p.id \n" +
                    "where p.\"ApPaterno\" like '"+appat+"%' and p.\"ApMaterno\" like '"+apmat+"%' and p.\"Nombres\" like '"+nombre+"%';";
                    break;
                case 1:
                    //query="SELECT  p.dni,p.\"ApPaterno\", p.\"ApMaterno\", p.\"Nombres\",p.\"FechNac\",p.\"sexo\",pr.\"descripcion\",hc.\"codCarpeta\",hc.\"codHistoria\" FROM \"HistoriaClinica\" as hc inner join \"Paciente\" as p on hc.dni=p.dni inner join \"Parentesco\" as pr on pr.\"codParentesco\"=p.\"codParentesco\" where p.\"ApPaterno\" like '"+appat+"%' and p.\"ApMaterno\" like '"+apmat+"%' and p.\"Nombres\" like '"+nombre+"%';";
                    query="SELECT  p.dni,p.\"ApPaterno\", p.\"ApMaterno\", p.\"Nombres\",p.\"FechNac\",p.direccion,p.\"sexo\",pr.\"descripcion\",hc.\"codCarpeta\",hc.\"codHistoria\",hc.\"histAntigua\" FROM \"HistoriaClinica\" as hc inner join \"Paciente\" as p on hc.id=p.id inner join \"Parentesco\" as pr on pr.\"codParentesco\"=p.\"codParentesco\" where p.\"ApPaterno\" like '"+appat+"%' and p.\"ApMaterno\" like '"+apmat+"%' and p.\"Nombres\" like '"+nombre+"%'";
                    break;
            }
        rs=st.executeQuery(query);
        pacientes=new ArrayList<Paciente>();
        while(rs.next()){
            carpetafamiliar=new CarpetaFamiliar(rs.getString("codCarpeta"));
            historiaClinica=new HistoriaClinica(rs.getString("codHistoria"),rs.getString("histAntigua"));
            switch(DeDonde)
            {
                case 0:
                    paciente=new Paciente(rs.getString("dni"),rs.getString("Nombres"),rs.getString("ApMaterno"), rs.getString("ApPaterno"),carpetafamiliar,historiaClinica);
                    break;
                case 1:
                    parentesco=new Parentesco(rs.getString("descripcion"));
                    paciente=new Paciente(rs.getString("dni"),rs.getString("Nombres"),rs.getString("ApMaterno"), rs.getString("ApPaterno"),rs.getString("FechNac"),rs.getString("sexo"),rs.getString("direccion"),false,parentesco,carpetafamiliar,historiaClinica);
                    break;
            }
            pacientes.add(paciente);
        }
        return pacientes;
    }
    
    /**
     * Registra los pacientes en la base de datos
     * @param conn
     * @throws SQLException 
     */
    public void registrarPaciente(Connection conn) throws SQLException{
        //FUNCTION "registrarPaciente"(di character, appat character varying, 
        //apmat character varying, nom character varying, fnac character, 
        //sex character, dire character varying, codcarp integer, codparen character)
        
        /** Para obtener los resultados de las consultas SQL de la base de datos */
        ResultSet resultSet = null;
        /** Para enviar comandos SQL a la base de datos */
        Statement statement = null;

        statement = conn.createStatement();
        resultSet = statement.executeQuery("SELECT registrarpaciente('"+getDNI()+"',"
                    + "'"+getApPat()+"','"+getAptMat()+"','"+getNombre()+"',"
                    + "'"+getFecha()+"','"+getSexo()+"','"+getDireccion()+"',"
                    + "'"+getCf().getCarpetaFamiliar()+"','"+getPa().getDenominacion().charAt(0)+"'); ");
        while (resultSet.next()){
            resultSet.getString(1);
        }
    }
    
    /**
     * Registra los datos de un paciente en la base de datos
     * @throws SQLException 
     */
    public void registrarPaciente() throws SQLException{
        String query ;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement(); 
        if(isJefeFamilia()){
            query="select registrarpaciente('"+getDNI()+"','"+getApPat()+"','"+getAptMat()+"','"+getNombre()+"','"+getFecha()+"','"+getSexo()+"','"+getDireccion()+"','"+getCf().getCarpetaFamiliar()+"','"+getPa().getDenominacion()+"')";
        }
        else
        {
            query="select registrarpacientesinjefe('"+getDNI()+"','"+getApPat()+"','"+getAptMat()+"','"+getNombre()+"','"+getFecha()+"','"+getSexo()+"','"+getDireccion()+"','"+getPa().getDenominacion()+"')";
        }
        rs=st.executeQuery(query);
        while(rs.next()){
            rs.getString(1);
        }
    }
    
    /**
     * Actualiza todos los datos del paciente que se haigan modificado
     * @param conn coneccion establecida con la Base de Datos
     * @throws SQLException muestra un mensaje en caso algun error
     */
    public void ModificarPaciente(Connection conn) throws SQLException{
        String query ;
        Statement st;
        ResultSet rs;
        st=conn.createStatement(); 
        if(isJefeFamilia()){
            query="select actualizarpacientetransladojefe('"+getFecha()+"','"+getSexo()+"','"+getDireccion()+"','"+getPa().getDenominacion()+"','"+getHc().getHc()+"','"+getCf().getCarpetaFamiliar()+"')";
        }
        else
        {
            query="select actualizarpacientetranslado('"+getFecha()+"','"+getSexo()+"','"+getDireccion()+"','"+getPa().getDenominacion()+"','"+getHc().getHc()+"')";
        }
        rs=st.executeQuery(query);
        while(rs.next()){
            rs.getString(1);
        }
    }
    
    /**
     * Consulta a la base de datos por le jefe de la carpeta
     * familiar
     * @param codCarpeta
     * @return int
     * @throws SQLException 
     */
    public int isJefe(String codCarpeta) throws SQLException{
        String query = null;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        con=new Conexion();
        conn=con.getConnection();
        st=conn.createStatement();
        query="select count(p.\"codCarpeta\") from \"Paciente\" as p where id in (select id from \"HistoriaClinica\" where \"codCarpeta\"='"+codCarpeta+"') and p.\"codCarpeta\"!=' '";
        rs=st.executeQuery(query);
        while(rs.next())
            return rs.getInt(1);
        return 0;
    }
    
    /**
     * Obtiene la cantidad de pacientes registrados
     * en la base de datos
     * @return int
     * @throws SQLException 
     */
     public int CantidadPacientes() throws SQLException{
        int cantidad = 0;
        String query;
        Connection conn;
        Conexion con;
        Statement st;
        ResultSet rs;
        query="select count(id) from \"Paciente\"";
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
     * Actualizar el Paciente que es Jefe de Carpeta Familiar
     * @param conn Conexion
     * @throws SQLException 
     */
    public void actualizarJefe(Connection conn) throws SQLException{
        //di character, appat character varying, apmat character varying, nom character varying, 
        //fnac character varying, dire character varying, sex character, cpar character, 
        //codhist character varying, idjefe integer
        
        System.out.println("Actualizando Jefe");
        
        CallableStatement sp= conn.prepareCall("{ call actualizarboss(?,?,?,?,?,?,?,?,?,?)}");
        
        sp.setString(1,getDNI());
        System.out.println(getDNI());
        
        sp.setString(2,getApPat());
        System.out.println(getApPat());
        
        sp.setString(3,getAptMat());
        System.out.println(getAptMat());
        
        sp.setString(4,getNombre());
        System.out.println(getNombre());
        
        sp.setString(5,getFecha());
        System.out.println(getFecha());
        
        sp.setString(6,getDireccion());
        System.out.println(getDireccion());
        
        sp.setString(7,getSexo());
        System.out.println(getSexo());
        
        sp.setString(8,getPa().getDenominacion());
        System.out.println(getPa().getDenominacion());
        
        sp.setString(9,getHc().getHc());
        System.out.println(getHc().getHc());
        
        sp.setInt(10,getReferencia());
        System.out.println(getReferencia());        
        
        sp.execute();    
    }//fin actualizarJefe
 
    /**
     * Actualiza a un Paciente Normal
     * @param conn Conexion
     * @throws SQLException 
     */
    public void actualizaPaciente(Connection conn) throws SQLException{
        //appat character varying, apmat character varying, nom character varying, 
        //dire character varying, codhist character varying, fn character varying, 
        //sex character, cpar character, di character
        
        System.out.println("Actualizando Paciente");
        
        CallableStatement sp= conn.prepareCall("{ call actualizarpac(?,?,?,?,?,?,?,?,?)}");
        sp.setString(1,getApPat());
        System.out.println(getApPat());
        
        sp.setString(2,getAptMat());
        System.out.println(getAptMat());
        
        sp.setString(3,getNombre());
        System.out.println(getNombre());
        
        sp.setString(4,getDireccion());       
        System.out.println(getDireccion());
        
        sp.setString(5,getHc().getHc());
        System.out.println(getHc().getHc());
        
        sp.setString(6,getFecha());
        System.out.println(getFecha());
        
        sp.setString(7,getSexo());
        System.out.println(getSexo());
        
        sp.setString(8,getPa().getDenominacion());
        System.out.println(getPa().getDenominacion());
        
        sp.setString(9,getDNI());
        System.out.println(getDNI());
        
        sp.execute();    
    }//fin actualizarPaciente
        
    /**
     * Actualiza el número de Carpeta Familiar del Jefe de la Carpeta Familiar
     * cuando el código de historia no es producto de un traslado
     * @param conn Conexion
     * @param cf Carpeta Familiar nuevo
     * @param historia Historia Clínica nueva
     * @param ref id del Paciente
     * @throws SQLException 
     */
    public void actualizarJefeCarpeta(Connection conn, String cf, String historia, int ref) throws SQLException{
        CallableStatement sp = conn.prepareCall("{ call actualizarjefecarpeta(?,?,?)}");
        System.out.println("--En el sp actualizaJefeCarpeta---");
        sp.setString(1,cf);
        System.out.println("cf: "+cf);
        sp.setString(2,historia);
        System.out.println("historia: "+historia);
        sp.setInt(3,ref);
        System.out.println("ref: "+ref);
        sp.execute();
    }
    
    /**
     * Actualiza el número de Carpeta Familiar del Jefe de la Carpeta Familiar
     * cuando el código de historia es producto de un traslado 
     * @param conn Conexion
     * @param cf Carpeta Familiar nuevo
     * @param ref id del Paciente
     * @throws SQLException 
     */
    public void actualizarJefeCarpetaTras(Connection conn, String cf, int ref) throws SQLException{
        CallableStatement sp = conn.prepareCall("{ call actualizarjefecarpetatras(?,?)}");
        System.out.println("--En el sp actualizaJefeCarpetaTras---");
        sp.setString(1,cf);
        System.out.println("cf: "+cf);
        sp.setInt(2,ref);
        System.out.println("ref: "+ref);
        sp.execute();
    }
    
    /**
     * Actualiza el número de Carpeta Familiar de una Paciente normal
     * cuando el código de historia no es producto de un traslado.
     * @param conn Conexion
     * @param cf Carpeta Familiar
     * @param historia Código de Historia nuevo
     * @param ref id Paciente
     * @throws SQLException 
     */
    public void actualizarNoJefeCarpeta(Connection conn,String cf, String historia, int ref) throws SQLException{
        CallableStatement sp = conn.prepareCall("{ call actualizarnojefecarpeta(?,?,?)}");
        System.out.println("--En el sp actualizaNoJefeCarpeta---");
        sp.setString(1,cf);
        System.out.println("cf: "+cf);
        sp.setString(2,historia);
        System.out.println("historia: "+historia);
        sp.setInt(3,ref);
        System.out.println("ref: "+ref);
        sp.execute();
    }//fin actualizarNoJefeCarpeta
    
    /**
     * Actualiza el número de Carpeta Familiar de una Paciente normal
     * cuando el código de historia es producto de un traslado.
     * @param conn Conexion
     * @param cf Carpeta Familiar nuevo
     * @param ref id del Paciente
     * @throws SQLException 
     */
    public void actualizarNoJefeCarpetaTras(Connection conn,String cf, int ref) throws SQLException{
        CallableStatement sp = conn.prepareCall("{ call actualizarnojefecarpetatras(?,?)}");
        System.out.println("--En el sp actualizaNoJefeCarpetaTras---");
        sp.setString(1,cf);
        System.out.println("cf: "+cf);        
        sp.setInt(2,ref);
        System.out.println("ref: "+ref);
        sp.execute();
    }//fin actualizarNoJefeCarpeta
    
    /**
     * Eliminar un paciente
     * @param conn Conexion
     * @param ref id del paciente
     * @throws SQLException 
     */
    public void eliminarPaciente(Connection conn, int ref) throws SQLException{
        CallableStatement sp = conn.prepareCall("{ call eliminarpaciente(?)}");
        sp.setInt(1,ref);
        sp.execute();
    }
}

