package com.techlab.pedidos;

import com.techlab.productos.Producto;

public class LineaPedido {

    private Producto producto; //producto específico de esta línea de pedido
    private int cantidad;     // unidades de ese producto

    //Constructor:
    // Se usa para crear una nueva línea de pedido
    public LineaPedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters:
    // Métodos para obtener los valores de los atributos
    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    // El Métodos de Cálculo:
    // Calcula el subtotal para esta línea (precio del producto * cantidad)
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
    
    //  Método toString:
    //  Muestra la información de la linea pedido
    @Override
    public String toString() {
        return "Producto: " + producto.getNombre() + 
               ", Cantidad: " + cantidad + 
               ", Subtotal: $" + getSubtotal();
    }
}
