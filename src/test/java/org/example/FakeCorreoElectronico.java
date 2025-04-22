package org.example;

public class FakeCorreoElectronico implements Notificar {
        String destinatario;
        String asunto;
        String mensaje;

        @Override
        public void enviarMensaje(String destinatario, String asunto, String mensaje) {
            this.destinatario = destinatario;
            this.asunto = asunto;
            this.mensaje = mensaje;
        }

        String obtenerDatosEmail() {
            return destinatario + asunto + mensaje;
        }
    }
