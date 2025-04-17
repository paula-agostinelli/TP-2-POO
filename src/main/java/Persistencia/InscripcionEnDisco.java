package Persistencia;
import org.example.Concurso;

import org.example.Inscripcion;

import java.nio.file.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class InscripcionEnDisco implements Inscripcion {
    private String registro;

    public InscripcionEnDisco (String registro){

        this.registro=registro;
    }

    @Override
    public void registrar(LocalDate fechaInscripcion, String idParticipante, String idConcurso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String linea = fechaInscripcion.format(formatter) + "," + idParticipante + "," + idConcurso;

        Path path = Paths.get(registro);

        try {
            // Escribe la línea en el archivo (agrega si existe, crea si no)
            Files.write(path, Collections.singletonList(linea), StandardCharsets.UTF_16BE,
                    Files.exists(path, LinkOption.NOFOLLOW_LINKS) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo guardar la inscripción en disco", e);
        }
    }
}

