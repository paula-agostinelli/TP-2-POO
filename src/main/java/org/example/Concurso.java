package org.example;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Concurso {
    static final String ERROR_FECHAS_CONCURSO = "La fecha de finalización no puede ser anterior a la fecha de inicio del concurso.";
    static final String ERROR_NOMBRE_CONCURSO = "El nombre proporcionado no es válido. Ingrese un nombre correcto.";
    static final String ERROR_PARTICIPANTE_YA_INSCRIPTO = "El participante ya fue inscripto.";
    static final String ERROR_FECHA_INSCRIPCION = "La inscripción al concurso ya cerró";
    static final String ERROR_ID_CONCURSO = "No es correcto el ID para identificar al concurso";


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
           inscripcion.registrar(LocalDate.parse(fechaInscripcion), p.obtenerId(), idConcurso);

           notificacion.enviar(p.getEmail(), "Te inscribiste al concurso " + idConcurso + " con éxito.");

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

