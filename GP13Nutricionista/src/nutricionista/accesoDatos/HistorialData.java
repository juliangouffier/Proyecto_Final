/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import nutricionista.entidades.HistorialDto;
import nutricionista.entidades.Ingrediente;

/**
 *
 * @author gouff
 */
public class HistorialData {
    private Connection conection = null;

    public HistorialData() {
        conection = Conexion.getConexion();
    }
    
    public List<HistorialDto> buscarHistorialPorPaciente(int pacienteId){
        ArrayList<HistorialDto> historial = new ArrayList();
        String sql = "SELECT * FROM dieta d "
                + "JOIN paciente p on p.id_paciente = d.id_paciente "
                + "WHERE p.id_paciente = ? "
                + "ORDER BY d.id_dieta DESC";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, pacienteId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HistorialDto historialDto = new HistorialDto();
                historialDto.setId(rs.getInt("id_dieta"));
                historialDto.setNombreDieta(rs.getString("nombre"));
                historialDto.setNombrePaciente(rs.getString("nombre_completo"));
                Double pesoInicial = rs.getDouble("peso_inicial");
                Double pesoFinal = rs.getDouble("peso_final");
                Double pesoBuscado = rs.getDouble("peso_buscado");
                if (pesoBuscado != null && pesoFinal != null && pesoInicial != null) {
                    Double porcentajePerdido = (pesoInicial - pesoFinal) / (pesoInicial - pesoBuscado) * 100;
                    historialDto.setAlcanzoPesoBuscado(porcentajePerdido >= 100);
                } else {
                    historialDto.setAlcanzoPesoBuscado(false);
                }
                
                historialDto.setFechaInicio(rs.getDate("fecha_inicio"));
                historialDto.setFechaFin(rs.getDate("fecha_fin"));
                historialDto.setTotalCaloriasDieta(rs.getDouble("total_calorias"));
                historialDto.setPesoInicial(pesoInicial);
                historialDto.setPesoFinal(pesoFinal);
                Date fechaFin = rs.getDate("fecha_fin");
                Date hoy = new Date();
                if (fechaFin != null && fechaFin.after(hoy)) {
                    historialDto.setEstado("Vigente");
                } else {
                    historialDto.setEstado("Finalizada");
                }
                historialDto.setPesoBuscado(pesoBuscado);
                historial.add(historialDto);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo traer el historial");
        }
        return historial;
    }
}
