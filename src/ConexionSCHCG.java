import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
        String respuesta = "";
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            int numCols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= numCols; i++) {
                    respuesta += (rs.getString(i) + "\t");
                }
                respuesta += "\n";
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    public String EjecutarQuery(String query) throws RemoteException {
        String respuesta = "";
        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            int numCols = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= numCols; i++) {
                    respuesta += (rs.getString(i) + "\t");
                }
                respuesta += "\n";
            }

            rs.close();
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respuesta;
    }

    @Override
    public boolean GenerarBackupMySQL(String path) {
//        int resp;
        Calendar c = Calendar.getInstance();
        String fecha = String.valueOf(c.get(Calendar.DATE));
        fecha = fecha + "-" + String.valueOf(c.get(Calendar.MONTH));
        fecha = fecha + "-" + String.valueOf(c.get(Calendar.YEAR));
        try {
            Runtime runtime = Runtime.getRuntime();
            File backupFile = new File(path + "_" + fecha + ".sql");
            FileWriter fw = new FileWriter(backupFile);
            //C:\xampp\mysql\bin
            Process child = runtime.exec("C:\\xampp\\mysql\\bin\\mysqldump --opt --password= --user=root "
                    + "--databases  bdschcg2 -R");
            InputStreamReader irs = new InputStreamReader(child.getInputStream());
            BufferedReader br = new BufferedReader(irs);

            String line;
            while ((line = br.readLine()) != null) {
                fw.write(line + "\n");
            }
            fw.close();
            irs.close();
            br.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }//GenerarBackupMySQL()

    @Override
    public boolean restoreDB(String path) {
        String executeCmd = "C:/xampp/mysql/bin/mysql -u root bdschcg2 < " + path;
        //System.out.println(executeCmd);

        Process runtimeProcess;

        try {
            runtimeProcess = Runtime.getRuntime().exec(new String[]{"cmd.exe", "/c", executeCmd});
            int processComplete = runtimeProcess.waitFor();
            //System.out.println(processComplete);
            if (processComplete == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }//restoreDB(String path)

    public void Conectar(String host, String BD, String User, String Password, String dbms) throws RemoteException {
        try {
//        if(dbms.equals("postgresql"))
//	Class.forName("org.postgresql.Driver");
            if (dbms.equals("mysql")) {
                Class.forName("com.mysql.jdbc.Driver");
            }
            con = DriverManager.getConnection("jdbc:" + dbms + "://" + host + "/" + BD + "?user=" + User + "&password=" + Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
