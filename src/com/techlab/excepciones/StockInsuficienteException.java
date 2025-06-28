package com.techlab.excepciones;

public class StockInsuficienteException extends Exception {

    /**
     * Constructor que recibe un mensaje de error personalizado.
     * @param mensaje El mensaje que describe por qué ocurrió el error.
     */
    public StockInsuficienteException(String mensaje) {
        // Llama al constructor de la clase padre (Exception) para guardar el mensaje.
        super(mensaje);
    }
}