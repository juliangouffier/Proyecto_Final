/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package nutricionista.vistas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import nutricionista.accesoDatos.ComidaData;
import nutricionista.accesoDatos.IngredienteData;
import nutricionista.entidades.Comida;
import nutricionista.entidades.Ingrediente;

/**
 *
 * @author Hernan
 */
public class ListaDeComidas extends javax.swing.JInternalFrame {

    private List<Comida> listaComidas;
    private ComidaData comidaData;
    private IngredienteData ingredienteData;
    private Comida comida = null;
    private Comida comida2 = null;
    private DefaultTableModel modelo;
    private Connection conection = null;

    /**
     * Creates new form NewJInternalFrame
     */
    public ListaDeComidas() {
        initComponents();
        modelo = new DefaultTableModel();
        comidaData = new ComidaData();
        ingredienteData = new IngredienteData();
        listaComidas = comidaData.listaDeComidas();
        cabeceradeTabla();
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ListaDeIngredientes = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtComidas = new javax.swing.JTable();
        jbAgregar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();

        ListaDeIngredientes.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        ListaDeIngredientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ListaDeIngredientes.setText("Lista de Comidas");

        jtComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtComidas);

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbAgregar)
                .addGap(18, 18, 18)
                .addComponent(jbModificar)
                .addGap(18, 18, 18)
                .addComponent(jbEliminar)
                .addGap(242, 242, 242)
                .addComponent(jbSalir)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListaDeIngredientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ListaDeIngredientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSalir)
                    .addComponent(jbModificar)
                    .addComponent(jbAgregar)
                    .addComponent(jbEliminar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        FormularioComida formularioComida = new FormularioComida(comida);
        menuPrincipal.jDesktopPane1.add(formularioComida);
        formularioComida.moveToFront();
        formularioComida.setVisible(true);
        formularioComida.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        int filaElegida = jtComidas.getSelectedRow();
        if (filaElegida != -1) {
            comida2 = null;
            int id = Integer.parseInt(jtComidas.getValueAt(filaElegida, 0).toString());
            String nombre = jtComidas.getValueAt(filaElegida, 1).toString();
            String tipo = jtComidas.getValueAt(filaElegida, 2).toString();
            Double calorias = Double.parseDouble(jtComidas.getValueAt(filaElegida, 3).toString());
            String detalle = jtComidas.getValueAt(filaElegida, 4).toString();
            List<Ingrediente> ingredientes = ingredienteData.ingredientesDeUnaComida(id);
            comida2 = new Comida (id,nombre,calorias,tipo,detalle,ingredientes);
            FormularioComida formularioComida = new FormularioComida(comida2);
            menuPrincipal.jDesktopPane1.add(formularioComida);
            formularioComida.moveToFront();
            formularioComida.setVisible(true);
            formularioComida.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada, seleccione un paciente para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
//        int filaElegida = jtIngredientes.getSelectedRow();
//        if (filaElegida != -1) {
//            int idIngrediente = Integer.parseInt(jtIngredientes.getValueAt(filaElegida, 0).toString());
//            String nombreIngrediente = jtIngredientes.getValueAt(filaElegida, 1).toString();
//            ingrediente = new Ingrediente(idIngrediente, nombreIngrediente);
//            ingredienteData.eliminarIngrediente(ingrediente);
//            ingrediente = null;
//        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void cabeceradeTabla() {
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("ID");
        cabecera.add("Nombre");
        cabecera.add("Tipo");
        cabecera.add("CaloriasX100grm");
        cabecera.add("Detalle");
        cabecera.add("Ingredientes");
        for (Object it : cabecera) {
            modelo.addColumn(it);
        }
        jtComidas.setModel(modelo);
    }

    private void cargarTabla() {
        for (Comida c : listaComidas) {
            modelo.addRow(new Object[]{c.getIdComida(), c.getNomComida(), c.getTipo(), c.getCaloriasPor100Grm(), c.getDetalle(), c.getIngredientes()});
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ListaDeIngredientes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JTable jtComidas;
    // End of variables declaration//GEN-END:variables
}
