/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Ayuda a manejar algunos modelos de tablas
 * @author Wilson Neira Mija
 */
public class PropiedadesTablas {
    /**
     * Tamanno de la columnas de la tabla
     */
    int tamColum[]={8,200,8,8,8};
    /**
     * Tamanno de la columnas de la tabla
     */
    int tamColum2[]={10,40,40,100,15,200,5,40,10,10,10};
    /**
     * Tamanno de la columnas de la tabla
     */
    int tamColum3[]={30,30,35};
    
    /**
     * Modelo de tabla que se utiliza en la
     * interfaz principal y administrador
     * @param jtPacientes 
     */
    public void TablaPacientes1(JTable jtPacientes){
         jtPacientes.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "APELLIDOS Y NOMBRES", "CARPETA FAMILIAR", "HC NUEVA","HC ANTIGUA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false
            };
             public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
         DefinirTamannoyCentrar(tamColum, jtPacientes);
    }
    
    /**
     * Modelo de tabla que se utiliza
     * al momento de mostrar los datos para los
     * traslados de historia
     * @param jtPacientes JTable al cual se le cambiara el modelo
     */
    public void TablaPacientes(JTable jtPacientes){
         jtPacientes.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "DNI", "APE. PATERNO", "APE. MATERNO", "NOMBRES", "FECHA NAC.","DIRECCION","SEXO", "PARENTESCO", "N° CARPETA", "HC NUEVA","HC ANTIGUA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false,false, false, false, false, false,false,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefinirTamannoyCentrar(tamColum2, jtPacientes);
    }
    
    /**
     * Modelo de la tabla que se utilizara
     * para la actualizacion de cuentas de usuario
     * por parte del administrador
     * @param jtUsuario JTable al cual se le cambia el modelo
     */
    public void TablaUsuario(JTable jtUsuario){
        jtUsuario.setModel(new DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "USUARIO","CONTRASEÑA","NIVEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DefinirTamannoyCentrar(tamColum3,jtUsuario);
    }
    
    /**
     * Define la anchura de cada una de las columnas
     * y centra sus contenidos
     * @param tamColumnas contiene el tamanno de cada columna
     * @param jtPacientes JTable al cual se le definiran los cambios
     */
    public void DefinirTamannoyCentrar(int [] tamColumnas,JTable jtPacientes){
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JTextField.CENTER);
        for(int i = 0; i < jtPacientes.getColumnCount(); i++) {
            //ajustar tamanno para columnas
            jtPacientes.getColumnModel().getColumn(i).setPreferredWidth(tamColumnas[i]);
            //centrar datos de la tabla
            jtPacientes.getColumnModel().getColumn(i).setHeaderRenderer(tcr);
            jtPacientes.getColumnModel().getColumn(i).setCellRenderer(tcr); 
        }    
    }
}
