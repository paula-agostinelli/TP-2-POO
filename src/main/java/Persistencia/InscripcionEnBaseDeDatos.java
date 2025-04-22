package Persistencia;

import org.example.Inscripcion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InscripcionEnBaseDeDatos  implements Inscripcion {


    @Override
    public void registrar(LocalDate fechaInscripcion, String idParticipante, String idConcurso) {
        Connection conn = ConnectionManager.getConnection();
        String sql = "INSERT INTO inscripciones (fecha_inscripcion, id_participante, id_concurso) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setDate(1, java.sql.Date.valueOf(fechaInscripcion));
            stmt.setString(2, idParticipante);
            stmt.setString(3, idConcurso);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}