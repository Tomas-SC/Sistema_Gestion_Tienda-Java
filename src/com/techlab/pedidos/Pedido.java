package com.techlab.pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    // Atributos:
    private static int contadorId = 0; // Contador para generar los IDS de pedido únicos
    private int id;
    // este pedido tiene una lista de líneas de pedido
    private List<LineaPedido> lineasPedido;
    private double costoTotal;

    //Constructor:
    // Cuando se crea un nuevo pedido, se inicializa con un ID nuevo y una lista vacía.
    public Pedido() {
        this.id = ++contadorId;
        this.lineasPedido = new ArrayList<>(); // Inicio la lista
        this.costoTotal = 0.0;
    }

    //Métodos: (para guiarme)
    
    /**
     * Agrega una nueva línea (un producto y su cantidad) al pedido
     * y actualiza el costo total.
     * @param linea La LineaPedido a agregar.
     */
    public void agregarLinea(LineaPedido linea) {
        this.lineasPedido.add(linea);
        this.costoTotal += linea.getSubtotal(); // Sumamos el subtotal de la nueva línea al total
    }

    //Getters:
    public int getId() {
        return id;
    }

    public List<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }

    public double getCostoTotal() {
        return costoTotal;
    }
    
    // --- Método toString ---
    // Para mostrar la información completa del pedido es
    @Override
    public String toString() {
        // StringBuilder ,eficiente para construir strings largos
        StringBuilder sb = new StringBuilder();
        sb.append("--- Pedido ID: ").append(id).append(" ---\n");
        sb.append("Detalles del Pedido:\n");
        for (LineaPedido linea : lineasPedido) {
            sb.append("- ").append(linea).append("\n");
        }
        sb.append("-----------------------------\n");
        sb.append("Costo Total: $").append(String.format("%.2f", costoTotal)).append("\n");
        sb.append("-----------------------------\n");
        return sb.toString();
    }
}
