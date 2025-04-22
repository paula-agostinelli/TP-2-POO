package org.example;

import java.time.LocalDate;

public interface Inscripcion {
    void registrar(LocalDate fechaInscripcion, String idParticipante, String idConcurso);
}
