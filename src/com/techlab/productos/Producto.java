package com.techlab.productos;


public class Producto {

 // Atributos (la información que define a un producto)
 private static int contadorId = 0; // Para generar IDs automáticamente
 private int id;
 private String nombre;
 private double precio;
 private int cantidadEnStock;

 // Constructor: Un método especial para crear objetos de esta clase
 public Producto(String nombre, double precio, int cantidadEnStock) {
     this.id = ++contadorId; // Incrementa y luego asigna
     this.nombre = nombre;
     this.precio = precio;
     this.cantidadEnStock = cantidadEnStock;
 }

 // Getters (para obtener los valores de los atributos)
 public int getId() {
     return id;
 }

 public String getNombre() {
     return nombre;
 }

 public double getPrecio() {
     return precio;
 }

 public int getCantidadEnStock() {
     return cantidadEnStock;
 }

 // Setters (modifica los valores de los atributos)

 public void setNombre(String nombre) {
     this.nombre = nombre;
 }

 public void setPrecio(double precio) {
     if (precio >= 0) { // Validación simple
         this.precio = precio;
     } else {
         System.out.println("Error: El precio no puede ser negativo.");
     }
 }

 public void setCantidadEnStock(int cantidadEnStock) {
     if (cantidadEnStock >= 0) { // Validación simple
         this.cantidadEnStock = cantidadEnStock;
     } else {
         System.out.println("Error: El stock no puede ser negativo.");
     }
 }

 
 public String toString() {
     return "ID: " + id + ", Nombre: " + nombre + ", Precio: $" + precio + ", Stock: " + cantidadEnStock;
 }
}