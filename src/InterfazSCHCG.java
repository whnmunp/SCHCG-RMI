import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author wilson
 * @author nole
 */
public interface InterfazSCHCG extends Remote {

    public void Conectar(String host, String BD, String User, String Password,
            String dbms) throws RemoteException;

    public String consultarPorDNI(String query,String DNI) throws RemoteException;

    public boolean GenerarBackupMySQL(String path)throws RemoteException;
    
    public boolean restoreDB(String path) throws RemoteException;
}
