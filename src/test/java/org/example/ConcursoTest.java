package org.example;



import Persistencia.InscripcionEnDisco;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
class ConcursoTest {

    @Test
    public void seInscribeOk() {
        Participante p = new Participante(42708536, "Paula Agostinelli","15_p","ejemplo@gmail.com");
        Concurso c = new Concurso(LocalDate.now().plusDays(2), LocalDate.now().plusDays(7),"MIT");
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            c.inscribir(p);  // Se espera que se lance una excepción si la fecha de inscripción está fuera del rango
        });

        // Verificamos que el mensaje de la excepción sea el esperado
        assertTrue(exception.getMessage().contains("Inscripción fuera del rango permitido."));
    }


    @Test
    public void seIncribeDia1() {
        Participante p = new Participante(42708536, "Paula Agostinelli","16_P");
        Inscripcion inscripcion = new InscripcionEnDisco();
        Concurso c = new Concurso(LocalDate.now(), LocalDate.now().plusDays(7),"MIT");
        c.inscribir(p);
        assertTrue(c.inscriptoDiaUno(p));

    }


    @Test
    public void inscripcionFueraDeTermino() {
        Participante p = new Participante(42708536, "Paula Agostinelli","17_P");
        Concurso c = new Concurso(LocalDate.now().plusDays(1), LocalDate.now().plusDays(2), new Inscripcion(p) {
            @Override
            public void registrar(LocalDate fechaInscripcion, String idParticipante, String idConcurso) {

            }
        });

        Exception exception = assertThrows(IllegalStateException.class, () -> c.inscribir(p));

        assertTrue(exception.getMessage().contains("Inscripción fuera del rango permitido."));
    }

}

