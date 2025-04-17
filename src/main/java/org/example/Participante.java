package org.example;

public class Participante {
    private String idParticipante;
    private int dni;
    private String nombre;
    private int puntos;

    public Participante(int dni, String nombre, String idParticipante) {
        this.dni = dni;
        this.nombre = nombre;
        this.idParticipante=idParticipante;
        this.puntos = 0;
    }

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

    public String getIdParticipante (){
        return this.idParticipante();
    }
}

