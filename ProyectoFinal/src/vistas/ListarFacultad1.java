
package vistas;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectofinal.entidades.Facultad;
import proyectofinal.entidades.impl.FFacultad;

public class ListarFacultad1 extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
  
     public ListarFacultad1(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
       lblTitulo = new JLabel("Listado");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
        
    }
     public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo:");
        modelo.addColumn("Nombre:");
        modelo.addColumn("Descripcion:");
        modelo.addColumn("Codigo_sicoa:");
        ArrayList<Facultad> lista = new ArrayList<>();
        
        try {
            FFacultad ffacultad = new FFacultad();
            
            lista = ffacultad.ObtenerFacultades();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        for(Facultad f:lista){
            
            modelo.addRow(new Object[] {f.getCodigo(), f.getNombre(), f.getDescripcion(), f.getCodigo_sicoa()});
        }
        
    }         
    


}