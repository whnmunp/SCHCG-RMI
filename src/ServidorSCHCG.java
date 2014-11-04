
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
public class ServidorSCHCG {
    public static void main(String[] args) {
         try {
      //RMIREGISTRY
      int puertoRMI=Integer.parseInt(JOptionPane.showInputDialog("Ingrese Puerto RMI"));
      Registry registry = LocateRegistry.createRegistry(puertoRMI);

      //Crear Objeto Servidor
      ConexionSCHCG conbd = new ConexionSCHCG();

      //Registrar Objeto Servidor
      registry.rebind("conex", conbd);
      System.out.println("Servidor Corriendo en el Puerto: "+puertoRMI);
    } catch (Exception e) {
      System.out.println(e);
    }
    }

}
