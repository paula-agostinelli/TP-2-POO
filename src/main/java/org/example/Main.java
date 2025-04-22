package org.example;

import Persistencia.InscripcionEnDisco;
import Persistencia.Mail;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear el sistema con persistencia en archivo y notificación por email
        Inscripcion inscripcionArchivo = new InscripcionEnDisco("inscripciones.txt");
        Notificacion notificador = new Mail("ejemplo@correo.com");

        Concurso concurso = new Concurso(
                LocalDate.of(2025, 4, 1),
                LocalDate.of(2025, 5, 1),
                inscripcionArchivo,
                "C123",
                notificador
        );

        // Crear participante
        Participante p1 = new Participante(12345678, "Juan Pérez", "P001", "juan@example.com");

        // Inscribir participante
        try {
            concurso.inscribirParticipante(p1);
            System.out.println("Participante inscrito correctamente.");
        } catch (Exception e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }

        // Ver lista de inscriptos
        for (Participante p : concurso.getParticipantes()) {
            System.out.println("Participante: " + p.getIdParticipante() + " - Puntos: " + p.getPuntos());
        }
    }
}