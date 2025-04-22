package org.example;
import java.time.LocalDate;

public class FakeInscripcion implements Inscripcion {

        String registro;


        @Override
        public void registrar(LocalDate fechaInscripcion, String idConcursante, String idConcurso) {
            this.registro = fechaInscripcion.toString() + ", " + idConcursante + ", " + idConcurso;

        }

        public Boolean startWith(String start) {
            return registro.startsWith(start);
        }


    }

