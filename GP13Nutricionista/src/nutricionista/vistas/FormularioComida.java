/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package nutricionista.vistas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
public class FormularioComida extends javax.swing.JInternalFrame {
    private ComidaData comidaData;
    private Comida comida;
    private DefaultTableModel modelo;
    private IngredienteData ingredienteData;
    private List<Ingrediente> listaDeIngredientes;
    private List<Ingrediente> ingredientesEnUso = new ArrayList();

    /**
     * Creates new form FormularioComida
     */
    ListaDeComidas listado;
    public FormularioComida(Comida comida, ListaDeComidas listado) {
        initComponents();
        this.listado = listado;
        comidaData = new ComidaData();
        ingredienteData = new IngredienteData();
        this.comida = comida;
        modelo = new DefaultTableModel();
        if (comida != null) {
            seteoCampos(comida);
            ingredientesEnUso = ingredienteData.ingredientesDeUnaComida(comida.getIdComida());
        }
        cabeceradeTabla();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jrbAgregarIngrediente = new javax.swing.JRadioButton();
        jrbQuitarIngrediente = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtIngredientes = new javax.swing.JTable();
        jtfNombreComida = new javax.swing.JTextField();
        jbGuardar = new javax.swing.JButton();
        jtfCaloriasX100grm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfId = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaDetalle = new javax.swing.JTextArea();
        jbAgregar = new javax.swing.JButton();
        jbQuitar = new javax.swing.JButton();
        jcbTipo = new javax.swing.JComboBox<>();
        jbSalir = new javax.swing.JButton();

        titulo.setFont(new java.awt.Font("Dialog", 1, 25)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Formulario Comida");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre de la comida");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Calorias cada 100grm");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo de comida");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Detalle");

        jrbAgregarIngrediente.setText("Agregar ingrediente");
        jrbAgregarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbAgregarIngredienteActionPerformed(evt);
            }
        });

        jrbQuitarIngrediente.setText("Quitar ingrediente");
        jrbQuitarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbQuitarIngredienteActionPerformed(evt);
            }
        });

        jtIngredientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtIngredientes);

        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jtfCaloriasX100grm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfCaloriasX100grmKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("ID");

        jtfId.setEditable(false);

        jtaDetalle.setColumns(20);
        jtaDetalle.setRows(5);
        jScrollPane2.setViewportView(jtaDetalle);

        jbAgregar.setText("Agregar");
        jbAgregar.setEnabled(false);
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbQuitar.setText("Quitar");
        jbQuitar.setEnabled(false);
        jbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuitarActionPerformed(evt);
            }
        });

        jcbTipo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jcbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Desayuno", "Almuerzo", "Merienda", "Cena", "Snack" }));
        jcbTipo.setSelectedIndex(-1);

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
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbGuardar)
                .addGap(136, 136, 136)
                .addComponent(jbSalir)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jrbAgregarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(181, 181, 181))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jrbQuitarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfCaloriasX100grm, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfNombreComida, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfId, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(jbAgregar)
                        .addGap(69, 69, 69)
                        .addComponent(jbQuitar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfId, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfNombreComida, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfCaloriasX100grm, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jcbTipo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbAgregarIngrediente)
                    .addComponent(jrbQuitarIngrediente))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbQuitar)
                    .addComponent(jbAgregar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jbSalir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbAgregarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbAgregarIngredienteActionPerformed
        limpiarTabla();
        jrbQuitarIngrediente.setSelected(false);
        agregarIngredientesTabla();
        jbAgregar.setEnabled(true);
        jbQuitar.setEnabled(false);
    }//GEN-LAST:event_jrbAgregarIngredienteActionPerformed

    private void jrbQuitarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbQuitarIngredienteActionPerformed
        limpiarTabla();
        jrbAgregarIngrediente.setSelected(false);
        quitarIngredientesTabla();
        jbAgregar.setEnabled(false);
        jbQuitar.setEnabled(true);
    }//GEN-LAST:event_jrbQuitarIngredienteActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        if(jtIngredientes.getSelectedRowCount() > 0){
            if (comida != null) {
            int filaElegida = jtIngredientes.getSelectedRow();
            int idIngrediente = Integer.parseInt(jtIngredientes.getValueAt(filaElegida, 0).toString());
            String nombreIngrediente = jtIngredientes.getValueAt(filaElegida, 1).toString();
            Ingrediente ingrediente = new Ingrediente(idIngrediente, nombreIngrediente);
            comidaData.agregarIngredienteAComida(comida.getIdComida(), ingrediente.getIdIngrediente());
            ingredientesEnUso.add(ingrediente);
        } else {
            int filaElegida = jtIngredientes.getSelectedRow();
            int idIngrediente = Integer.parseInt(jtIngredientes.getValueAt(filaElegida, 0).toString());
            String nombreIngrediente = jtIngredientes.getValueAt(filaElegida, 1).toString();
            Ingrediente ingrediente = new Ingrediente(idIngrediente, nombreIngrediente);
            ingredientesEnUso.add(ingrediente);
        }
        limpiarTabla();
        jrbQuitarIngrediente.setSelected(false);
        jrbAgregarIngrediente.setSelected(false);
        jbAgregar.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un ingrediente para agregarlo.");
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuitarActionPerformed
        if (comida != null) {
            int filaElegida = jtIngredientes.getSelectedRow();
            int idIngrediente = Integer.parseInt(jtIngredientes.getValueAt(filaElegida, 0).toString());
            String nombreIngrediente = jtIngredientes.getValueAt(filaElegida, 1).toString();
            Ingrediente ingrediente = new Ingrediente(idIngrediente, nombreIngrediente);
            comidaData.eliminarIngredienteDeComida(comida.getIdComida(), ingrediente.getIdIngrediente());
            ingredientesEnUso.remove(ingrediente);
        } else {
            int filaElegida = jtIngredientes.getSelectedRow();
            int idIngrediente = Integer.parseInt(jtIngredientes.getValueAt(filaElegida, 0).toString());
            String nombreIngrediente = jtIngredientes.getValueAt(filaElegida, 1).toString();
            Ingrediente ingrediente = new Ingrediente(idIngrediente, nombreIngrediente);
            ingredientesEnUso.remove(ingrediente);
        }
        limpiarTabla();
        jrbQuitarIngrediente.setSelected(false);
        jrbAgregarIngrediente.setSelected(false);
        jbQuitar.setEnabled(false);
    }//GEN-LAST:event_jbQuitarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        boolean flagError = false;
        String nombreComida = jtfNombreComida.getText();
        String tipo = (String) jcbTipo.getSelectedItem();
        String detalle = jtaDetalle.getText();
        String calorias = jtfCaloriasX100grm.getText();
        if (nombreComida.isEmpty() || detalle.isEmpty() || calorias.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No pueden haber campos vacios.");
            flagError = true;
            return;
        } else {
            flagError = false;
        }
        String val = "[a-zA-ZáéíóúÁÉÍÓÚ\\s]*";
        if (!nombreComida.matches(val)) {
            JOptionPane.showMessageDialog(this, "El nombre de la comida no puede llevar numeros.");
            flagError = true;
            return;
        }
        if (tipo == null) {
            JOptionPane.showMessageDialog(this, "Se debe elegir un tipo.");
            flagError = true;
            return;
        } else {
            flagError = false;
        }
        double caloriasx100grm = Double.parseDouble(calorias);
        if (caloriasx100grm <= 0) {
            JOptionPane.showMessageDialog(this, "Las calorias no puede ser menor o igual a 0.");
            flagError = true;
            return;
        } else {
            flagError = false;
        }
        if (!flagError) {
            if (comida != null) {
                int id = Integer.parseInt(jtfId.getText());
                Comida comida2 = new Comida(id, nombreComida, caloriasx100grm, tipo, detalle);
                comidaData.modificarComida(comida2.getIdComida(), comida2.getNomComida(), comida2.getTipo(), comida2.getCaloriasPor100Grm(), comida2.getDetalle());
            } else {
                Comida comida2 = new Comida(nombreComida, caloriasx100grm, tipo, detalle);
                comidaData.cargarComida(comida2);
                for (Ingrediente i : ingredientesEnUso) {
                    comidaData.agregarIngredienteAComida(comida2.getIdComida(), i.getIdIngrediente());
                }
            }
            listado.limpiarTabla();
            listado.cargarTabla();
            this.dispose();
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jtfCaloriasX100grmKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfCaloriasX100grmKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c) && c != '\b') {
            evt.consume();
        }
    }//GEN-LAST:event_jtfCaloriasX100grmKeyTyped

    private void seteoCampos(Comida comida) {
        this.jtfId.setText(String.valueOf(comida.getIdComida()));
        this.jtfNombreComida.setText(comida.getNomComida());
        this.jtfCaloriasX100grm.setText(String.valueOf(comida.getCaloriasPor100Grm()));
        this.jcbTipo.setSelectedItem(String.valueOf(comida.getTipo()));
        this.jtaDetalle.setText(String.valueOf(comida.getDetalle()));
    }

    private void limpiarTabla() {
        int indice = modelo.getRowCount() - 1;
        for (int i = indice; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    private void cabeceradeTabla() {
        ArrayList<Object> cabecera = new ArrayList<>();
        cabecera.add("ID");
        cabecera.add("Nombre del Ingrediente");
        for (Object it : cabecera) {
            modelo.addColumn(it);
        }
        jtIngredientes.setModel(modelo);
    }

    private void agregarIngredientesTabla() {
        if (comida != null) {
            listaDeIngredientes = ingredienteData.listaDeIngredientes();
            ingredientesEnUso = comida.getIngredientes();
            for (Ingrediente ingrediente : ingredientesEnUso) {
                listaDeIngredientes.remove(ingrediente);
            }
            for (Ingrediente i : listaDeIngredientes) {
                modelo.addRow(new Object[]{i.getIdIngrediente(), i.getNomIngrediente()});
            }
        } else {
            listaDeIngredientes = ingredienteData.listaDeIngredientes();
            for (Ingrediente ingrediente : ingredientesEnUso) {
                listaDeIngredientes.remove(ingrediente);
            }
            for (Ingrediente i : listaDeIngredientes) {
                modelo.addRow(new Object[]{i.getIdIngrediente(), i.getNomIngrediente()});
            }
        }
    }

    private void quitarIngredientesTabla() {
        if (comida != null) {
            ingredientesEnUso = comida.getIngredientes();
            for (Ingrediente i : ingredientesEnUso) {
                modelo.addRow(new Object[]{i.getIdIngrediente(), i.getNomIngrediente()});
            }
        } else {
            for (Ingrediente i : ingredientesEnUso) {
                modelo.addRow(new Object[]{i.getIdIngrediente(), i.getNomIngrediente()});
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbQuitar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbTipo;
    private javax.swing.JRadioButton jrbAgregarIngrediente;
    private javax.swing.JRadioButton jrbQuitarIngrediente;
    private javax.swing.JTable jtIngredientes;
    private javax.swing.JTextArea jtaDetalle;
    private javax.swing.JTextField jtfCaloriasX100grm;
    private javax.swing.JTextField jtfId;
    private javax.swing.JTextField jtfNombreComida;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
