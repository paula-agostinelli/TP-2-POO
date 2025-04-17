package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Inscripcion inscripcion = new InscripcionEnDisco("inscripciones.txt");
        EnviadorDeMail enviador = new EnviadorDeMailReal();

        Concurso concurso = new Concurso(inscripcion, enviador);
        concurso.registrarInscripcion(LocalDate.now(), "CONC123", "CONCURSO9");
}}