
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilson
 */
public class ConexionSCHCG extends UnicastRemoteObject implements InterfazSCHCG {

    Connection con;
    public ConexionSCHCG() throws RemoteException {

    }
    
    @Override
    public String consultarPorDNI(String query) throws RemoteException {
        String respuesta="";
                try{
            	Statement stmt = con.createStatement ();

            	ResultSet rs = stmt.executeQuery (query);

            	int numCols = rs.getMetaData().getColumnCount ();
                while ( rs.next() ) {
		  for (int i=1; i<=numCols; i++) {
                   respuesta+=(rs.getString(i) + "\t" );
                  }  
                  respuesta+="\n";
                } 
                
                       

            	rs.close();
            	stmt.close();
            	con.close();
                }
                catch(Exception e)
                {e.printStackTrace();
                } 
                return respuesta;
    }
   
    public String EjecutarQuery(String query) throws RemoteException {
                String respuesta="";
                try{
            	Statement stmt = con.createStatement ();

            	ResultSet rs = stmt.executeQuery (query);

            	int numCols = rs.getMetaData().getColumnCount ();
                while ( rs.next() ) {
		  for (int i=1; i<=numCols; i++) {
                   respuesta+=(rs.getString(i) + "\t" );
                  }  
                  respuesta+="\n";
                } 
                
                       

            	rs.close();
            	stmt.close();
            	con.close();
                }
                catch(Exception e)
                {e.printStackTrace();
                } 
                return respuesta;
    }

    
   public void Conectar(String host, String BD, String User, String Password, String dbms) throws RemoteException {
   try{
//        if(dbms.equals("postgresql"))
//	Class.forName("org.postgresql.Driver");
	if(dbms.equals("mysql"))
    	Class.forName  ("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection( "jdbc:"+dbms+"://"+host+"/"+BD+"?user="+User+"&password="+Password);
   }
   catch(Exception e)
   {e.printStackTrace();
   }
    }   
   
}

