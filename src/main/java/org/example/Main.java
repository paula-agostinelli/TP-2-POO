package org.example;

import Persistencia.InscripcionEnDisco;
import Persistencia.Mail;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Inscripcion inscripcionArchivo = new InscripcionEnDisco("inscripciones.txt");
        Notificacion notificador = new Mail("ejemplo@correo.com");

        Concurso concurso = new Concurso(
                LocalDate.of(2025, 4, 1),
                LocalDate.of(2025, 5, 1),
                inscripcionArchivo,
                "C123",
                notificador
        );

        Participante p1 = new Participante(12345678, "Juan Pérez", "P001", "juan@example.com");

        try {
            concurso.inscribir(p1);
            System.out.println("Participante inscrito correctamente.");
        } catch (Exception e) {
            System.out.println("Error al inscribir: " + e.getMessage());
        }

        for (Participante p : concurso.getParticipantes()) {
            System.out.println("Participante: " + p.getIdParticipante() + " - Puntos: " + p.getPuntos());
        }
    }
}
