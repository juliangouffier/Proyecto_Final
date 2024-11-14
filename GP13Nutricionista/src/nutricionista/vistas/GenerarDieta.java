/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package nutricionista.vistas;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import nutricionista.accesoDatos.ComidaData;
import nutricionista.accesoDatos.DietaData;
import nutricionista.accesoDatos.MenuData;
import nutricionista.accesoDatos.RenglonData;
import nutricionista.entidades.Comida;
import nutricionista.entidades.Dieta;
import nutricionista.entidades.Menu;
import nutricionista.entidades.Paciente;
import nutricionista.entidades.Renglon;

/**
 *
 * @author gouff
 */
public class GenerarDieta extends javax.swing.JFrame {

    /**
     * Creates new form GenerarDieta
     */
    DietaData dietaData;
    Paciente paciente;
    ComidaData comidaData;
    RenglonData renglonData;
    MenuData menuData;
    
    public GenerarDieta(Paciente paciente) {
        initComponents();
        this.paciente = paciente;
        dietaData = new DietaData();
        comidaData = new ComidaData();
        renglonData = new RenglonData();
        menuData = new MenuData();
        iniciarTablas();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        lunes = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        martes = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        miercoles = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        jueves = new javax.swing.JTable();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jScrollPane13 = new javax.swing.JScrollPane();
        viernes = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        sabado = new javax.swing.JTable();
        jScrollPane14 = new javax.swing.JScrollPane();
        domingo = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pesoInicial = new javax.swing.JTextField();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Auto Generar Dieta");

        jButton2.setText("Guardar Dieta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayout(new java.awt.GridLayout(1, 0));

        lunes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        lunes.setEditingColumn(0);
        lunes.setEditingRow(0);
        lunes.getTableHeader().setReorderingAllowed(false);
        jScrollPane10.setViewportView(lunes);
        lunes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLayeredPane2.add(jScrollPane10);

        martes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane8.setViewportView(martes);
        martes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLayeredPane2.add(jScrollPane8);

        miercoles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        miercoles.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(miercoles);
        miercoles.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLayeredPane2.add(jScrollPane9);

        jueves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jueves.getTableHeader().setReorderingAllowed(false);
        jScrollPane11.setViewportView(jueves);
        jueves.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLayeredPane2.add(jScrollPane11);

        jLayeredPane3.setLayout(new java.awt.GridLayout(1, 0));

        viernes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        viernes.getTableHeader().setReorderingAllowed(false);
        jScrollPane13.setViewportView(viernes);
        viernes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLayeredPane3.add(jScrollPane13);

        sabado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        sabado.getTableHeader().setReorderingAllowed(false);
        jScrollPane12.setViewportView(sabado);
        sabado.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLayeredPane3.add(jScrollPane12);

        domingo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        domingo.getTableHeader().setReorderingAllowed(false);
        jScrollPane14.setViewportView(domingo);
        domingo.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        jLayeredPane3.add(jScrollPane14);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 220, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 235, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jLayeredPane3.add(jPanel1);

        jButton3.setText("Salir");

        jLayeredPane4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("LUNES");
        jLayeredPane4.add(jLabel7);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MARTES");
        jLayeredPane4.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MIERCOLES");
        jLayeredPane4.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("JUEVES");
        jLayeredPane4.add(jLabel3);

        jLayeredPane6.setLayout(new java.awt.GridLayout(1, 0));

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("VIERNES");
        jLayeredPane6.add(jLabel14);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("SABADO");
        jLayeredPane6.add(jLabel15);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("DOMINGO");
        jLayeredPane6.add(jLabel13);

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("            ");
        jLayeredPane6.add(jLabel16);

        jLayeredPane7.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 211);
        jLayeredPane7.add(nombre, gridBagConstraints);

        jLabel5.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 124;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 162, 0, 0);
        jLayeredPane7.add(jLabel5, gridBagConstraints);

        jLabel8.setText("Fecha Inicio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 103;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 162, 0, 0);
        jLayeredPane7.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 6, 6, 211);
        jLayeredPane7.add(pesoInicial, gridBagConstraints);

        fechaFin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 211);
        jLayeredPane7.add(fechaFin, gridBagConstraints);

        jLabel9.setText("Fecha FIn");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 115;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 162, 0, 0);
        jLayeredPane7.add(jLabel9, gridBagConstraints);

        fechaInicio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 112;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 6, 0, 211);
        jLayeredPane7.add(fechaInicio, gridBagConstraints);

        jLabel17.setText("Peso Inicial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 105;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 162, 0, 0);
        jLayeredPane7.add(jLabel17, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DIETA");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLayeredPane8.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLayeredPane8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jButton2)
                .addGap(74, 74, 74)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 279, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addComponent(jLayeredPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane4)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane6)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane8)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLayeredPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JTable[] tablasDias = {lunes, martes, miercoles, jueves, viernes, sabado, domingo};

        int diasSeleccionados = 0;
        int showMsg1 = 0;
        for (JTable tabla : tablasDias) {
            int filasSeleccionadas = tabla.getSelectedRowCount();
            if (filasSeleccionadas == 5) {
                diasSeleccionados++; 
            } else if(filasSeleccionadas == 0){
                showMsg1 = showMsg1 != 0 ? showMsg1 : 0;
            } else if(filasSeleccionadas > 5 || filasSeleccionadas < 5){
                showMsg1 = showMsg1 +1;
            }
        }

        if (diasSeleccionados >= 3 && !(showMsg1 >=1)) {
            crearDieta(tablasDias, this.paciente, nombre.getText(), fechaInicio.getDate(), fechaFin.getDate(), pesoInicial.getText());
            System.out.println("Dieta guardada correctamente.");
            JOptionPane.showMessageDialog(this,
                "Se genero la dieta correctamente.",
                "Creacion Finalizada",
                JOptionPane.PLAIN_MESSAGE);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this,
                "Debe seleccionar al menos 5 comidas en al menos 3 días diferentes.",
                "Selección insuficiente",
                JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void iniciarTablas() {
    List<Renglon> renglones = renglonData.traerRenglones();
    String[] columnas = {"ID", "Nombre", "Cantidad Grm", "Tipo", "subTotalCalorias"};

    DefaultTableModel modeloLunes = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel modeloMartes = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel modeloMiercoles = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel modeloJueves = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel modeloViernes = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel modeloSabado = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    DefaultTableModel modeloDomingo = new DefaultTableModel(columnas, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };

    for (Renglon renglon : renglones) {
        Object[] dataRow = {
            renglon.getNumRenglon(),
            renglon.getComida().getNomComida(),
            renglon.getCantGrm(),
            renglon.getComida().getTipo(),
            renglon.getSubTotalCalorias()
        };

        modeloLunes.addRow(dataRow);
        modeloMartes.addRow(dataRow);
        modeloMiercoles.addRow(dataRow);
        modeloJueves.addRow(dataRow);
        modeloViernes.addRow(dataRow);
        modeloSabado.addRow(dataRow);
        modeloDomingo.addRow(dataRow);
    }

    lunes.setName("lunes");
    lunes.setModel(modeloLunes);
    martes.setModel(modeloMartes);
    martes.setName("martes");
    miercoles.setModel(modeloMiercoles);
    miercoles.setName("miercoles");
    jueves.setModel(modeloJueves);
    jueves.setName("jueves");
    viernes.setModel(modeloViernes);
    viernes.setName("jueves");
    sabado.setModel(modeloSabado);
    sabado.setName("jueves");
    domingo.setModel(modeloDomingo);
    domingo.setName("jueves");

    eliminarColumnas(lunes);
    eliminarColumnas(martes);
    eliminarColumnas(miercoles);
    eliminarColumnas(jueves);
    eliminarColumnas(viernes);
    eliminarColumnas(sabado);
    eliminarColumnas(domingo);
}

private void eliminarColumnas(JTable tabla) {
    if (tabla.getColumnCount() > 4) {
        tabla.getColumnModel().getColumn(0).setMinWidth(0); 
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        tabla.getColumnModel().getColumn(0).setResizable(false);
    }
    if (tabla.getColumnCount() > 0) {
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        tabla.getColumnModel().getColumn(0).setResizable(false);
    }
}


    private void crearDieta(JTable[] tablasDias, Paciente paciente, String nombre, Date fechaInicio, Date fechaFin, String pesoInicial){
        List<Integer> menues = new ArrayList<>();
        Double totalCaloriasMenues = 0.00;
        for (JTable tabla : tablasDias) {
            List<Integer> renglones = new ArrayList<>();
            int filasSeleccionadas = tabla.getSelectedRowCount(); 
            if (filasSeleccionadas == 5) {
                Menu menu = new Menu();
                menu.setDia(tabla.getName().toUpperCase());
                Double totalCalorias = 0.00;
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    if (tabla.isRowSelected(i)) {
                        Object valor = tabla.getValueAt(i, 4);  
                        Object idRenglon = tabla.getValueAt(i, 0); 
                        renglones.add((Integer) idRenglon);
                        totalCalorias += (Double) valor;  
                    }
                }
                totalCaloriasMenues = totalCaloriasMenues + totalCalorias;
                menu.setCaloriasDelMenu(totalCalorias);
                menu = menuData.cargarMenu(menu);
                renglonData.cargarMenuTieneRenglon(renglones, menu.getIdMenu());
                menues.add(menu.getIdMenu());
            }
        }
        Dieta dieta = new Dieta();
        dieta.setNombre(nombre);
        dieta.setFechaInicio(fechaInicio);
        dieta.setFechaFin(fechaFin);
        dieta.setPaciente(paciente);
        dieta.setPesoInicial(Double.valueOf(pesoInicial));
        dieta.setTotalCalorias(totalCaloriasMenues);
        dieta = dietaData.cargarDieta(dieta);
        dietaData.cargarDietaTieneMenues(menues, dieta.getIdDieta());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable domingo;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jueves;
    private javax.swing.JTable lunes;
    private javax.swing.JTable martes;
    private javax.swing.JTable miercoles;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField pesoInicial;
    private javax.swing.JTable sabado;
    private javax.swing.JTable viernes;
    // End of variables declaration//GEN-END:variables
}
