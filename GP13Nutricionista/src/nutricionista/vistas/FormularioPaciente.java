/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package nutricionista.vistas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import nutricionista.accesoDatos.DietaData;
import nutricionista.accesoDatos.PacienteData;
import nutricionista.entidades.Dieta;
import nutricionista.entidades.Paciente;

/**
 *
 * @author Hernan
 */
public class FormularioPaciente extends javax.swing.JInternalFrame {
    
    List<Paciente> pacientes = new ArrayList();
    PacienteData pacienteData;
    DietaData dietaData;
    String[] columnas = {"Número de Paciente", "Nombre Completo", "Edad", "Altura", "Peso Actual", "Peso Buscado"};
    /**
     * Creates new form NewJInternalFrame
     */
    public FormularioPaciente() {
        initComponents();
        pacienteData = new PacienteData();
        List<Paciente> pacientesList = pacienteData.listarPacientes();
        pacientes = pacientesList;
        tablaPacientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        dietaData = new DietaData();
        String[] columnas = {"Número de Paciente", "Nombre Completo", "Edad", "Altura", "Peso Actual", "Peso Buscado"};
    
        // Crear el modelo de la tabla con los nombres de las columnas
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Recorrer la lista de pacientes y agregar cada uno al modelo de la tabla
        for (Paciente paciente : pacientesList) {
            Object[] fila = {
                paciente.getIdPaciente(),
                paciente.getNombreCompleto(),
                paciente.getEdad(),
                paciente.getAltura(),
                paciente.getPesoActual(),
                paciente.getPesoBuscado()
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo a la tabla
        tablaPacientes.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPacientes = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        titulo.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Pacientes");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Ingrese nombre paciente");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton5.setText("Salir");

        tablaPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPacientes);

        jButton2.setText("Crear Paciente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Modificar Paciente");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Crear Dieta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Ver Dieta");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nombreText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                        .addGap(10, 10, 10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       List<Paciente> pacientesList = pacienteData.buscarPacientesPorNombre("%"+nombreText.getText()+"%");
        
    
        // Crear el modelo de la tabla con los nombres de las columnas
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Recorrer la lista de pacientes y agregar cada uno al modelo de la tabla
        for (Paciente paciente : pacientesList) {
            Object[] fila = {
                paciente.getIdPaciente(),
                paciente.getNombreCompleto(),
                paciente.getEdad(),
                paciente.getAltura(),
                paciente.getPesoActual(),
                paciente.getPesoBuscado()
            };
            modelo.addRow(fila);
        }

        // Asignar el modelo a la tabla
        tablaPacientes.setModel(modelo);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        CrearPaciente jframe = new CrearPaciente(this);
        jframe.setSize(523, 463);
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filaSeleccionada = tablaPacientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            Paciente paciente = new Paciente(
            (int) tablaPacientes.getValueAt(filaSeleccionada, 0),    
            (String) tablaPacientes.getValueAt(filaSeleccionada, 1),
            (int) tablaPacientes.getValueAt(filaSeleccionada, 2),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 3),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 4),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 5));
            
            ModificarPaciente jframe = new ModificarPaciente(paciente,this);
            jframe.setSize(500, 550);
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
            jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada, seleccione un paciente para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int filaSeleccionada = tablaPacientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            Paciente paciente = new Paciente(
            (int) tablaPacientes.getValueAt(filaSeleccionada, 0),    
            (String) tablaPacientes.getValueAt(filaSeleccionada, 1),
            (int) tablaPacientes.getValueAt(filaSeleccionada, 2),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 3),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 4),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 5));
            
            GenerarDieta jframe = new GenerarDieta(paciente);
            jframe.setSize(1200, 887);
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
            jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada, seleccione un paciente para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int filaSeleccionada = tablaPacientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            
            // valido que posea una dieta 
            Dieta dieta = dietaData.pacientePoseeDieta((int) tablaPacientes.getValueAt(filaSeleccionada, 0));
            if(dieta != null){
                VerDieta jframe = new VerDieta(dieta);
                jframe.setSize(1200, 957);
                jframe.setLocationRelativeTo(null);
                jframe.setVisible(true);
                jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else {
                JOptionPane.showMessageDialog(null, "El paciente seleccionado no posee una dieta activa.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            System.out.println("DIETA " + dieta);
            /*Paciente paciente = new Paciente(
            (int) tablaPacientes.getValueAt(filaSeleccionada, 0),    
            (String) tablaPacientes.getValueAt(filaSeleccionada, 1),
            (int) tablaPacientes.getValueAt(filaSeleccionada, 2),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 3),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 4),
            (double) tablaPacientes.getValueAt(filaSeleccionada, 5));*/
            
            
        } else {
            JOptionPane.showMessageDialog(null, "No hay ninguna fila seleccionada, seleccione un paciente para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    public void agregarPacienteATabla(Paciente paciente){
        pacientes.add(paciente);
        DefaultTableModel modelo = (DefaultTableModel) tablaPacientes.getModel();
        
        Object[] fila = {
                paciente.getIdPaciente(),
                paciente.getNombreCompleto(),
                paciente.getEdad(),
                paciente.getAltura(),
                paciente.getPesoActual(),
                paciente.getPesoBuscado()
            };
        modelo.addRow(fila);
    }
    
    public void actualizarListado(Paciente paciente){
        List<Paciente> pacientesList = pacienteData.listarPacientes();
        pacientes = pacientesList;
        DefaultTableModel model = (DefaultTableModel) tablaPacientes.getModel();
        model.setRowCount(0);  
        
        for (Paciente paciente1 : pacientes) {
            Object[] fila = {
                paciente1.getIdPaciente(),
                paciente1.getNombreCompleto(),
                paciente1.getEdad(),
                paciente1.getAltura(),
                paciente1.getPesoActual(),
                paciente1.getPesoBuscado()
            };
            model.addRow(fila);
        }
        tablaPacientes.setModel(model);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nombreText;
    private javax.swing.JTable tablaPacientes;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
