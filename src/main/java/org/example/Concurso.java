package org.example;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Concurso {
    private  String idConcurso;
    private final LocalDate fechaInicio;
    private LocalDate fechaFin;
    private List<Participante> participantes;
    private Map<Participante, LocalDate> inscripciones; //
    private Inscripcion inscripcion;
    private Notificacion notificacion;

    public Concurso(LocalDate fechaInicio, LocalDate fechaFin, Inscripcion inscripcion, String idConcurso, Notificacion notificacion) {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin.");
        }
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
        this.inscripciones = new HashMap<>();
        this.inscripcion= inscripcion;
        this.idConcurso=idConcurso;
        this.notificacion= notificacion;
    }


    public void inscribir(Participante p) {
        LocalDate fechaInscripcion = LocalDate.now();
        if (fechaInscripcion.isBefore(fechaInicio) || fechaInscripcion.isAfter(fechaFin)) {
            throw new IllegalStateException("Inscripción fuera del rango permitido.");
        }

        if (!participantes.contains(p)) {
            this.participantes.add(p);
            this.inscripciones.put(p, LocalDate.now());
            String idP = p.getIdParticipante();
            String fecha= LocalDateTime.now().toString();--

                    this.inscripcion.registrar(LocalDate.parse(fecha),idP,idConcurso);

            if (fechaInscripcion.isEqual(fechaInicio)) {
                p.sumarPuntos(10);
            }
        }
    }

    public LocalDate obtenerFechaIncripcion(Participante p) {
        return this.inscripciones.get(p);
    }

    public boolean inscriptoDiaUno(Participante p) {
        LocalDate fechaInscripcion = obtenerFechaIncripcion(p);
        return fechaInscripcion != null && fechaInscripcion.isEqual(fechaInicio);
    }
}

}
