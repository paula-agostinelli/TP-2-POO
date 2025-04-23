package org.example;

public class Participante {
    private String idParticipante;
    private int dni;
    private String nombre;
    private int puntos;
    private String email;

    public Participante(int dni, String nombre, String idParticipante, String email) {
        this.dni = dni;
        this.nombre = nombre;
        this.idParticipante = idParticipante;
        this.puntos = 0;
        this.email = email;
    }

    public void sumarPuntos(int cantidad) {
        this.puntos += cantidad;
    }

    public int obtenerPuntos() {
        return this.puntos;
    }

    public String obtenerId() {
        return this.idParticipante;
    }

    public String obtenerEmail() {
        return this.email;
    }

    public String getIdParticipante() {
        return idParticipante;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getEmail() {
        return email;
    }
}




