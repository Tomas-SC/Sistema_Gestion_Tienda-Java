package com.techlab.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.techlab.excepciones.StockInsuficienteException;
import com.techlab.pedidos.LineaPedido;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.Producto;

public class SistemaGestion {

    // Almacén de productos
    private static List<Producto> inventario = new ArrayList<>();
    // Lista para guardar los pedidos completados
    private static List<Pedido> listaDePedidos = new ArrayList<>();
    // Scanner para leer la entrada del usuario
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu() {
        int opcion = 0;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Buscar/Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Crear Pedido");
            System.out.println("6. Listar Pedidos"); // Texto actualizado
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        agregarProducto();
                        break;
                    case 2:
                        listarProductos();
                        break;
                    case 3:
                        buscarActualizarProducto();
                        break;
                    case 4:
                        eliminarProducto();
                        break;
                    case 5:
                        crearPedido();
                        break;
                    case 6:
                        listarPedidos(); // Funcionalidad conectada
                        break;
                    case 7:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingrese un número válido para la opción.");
                scanner.nextLine();
                opcion = 0;
            }

        } while (opcion != 7);

        scanner.close();
        System.out.println("Programa finalizado.");
    }

    public static void agregarProducto() {
        System.out.println("\n--- AGREGAR PRODUCTO ---");
        try {
            System.out.print("Nombre del producto: ");
            String nombre = scanner.nextLine();
            System.out.print("Precio del producto: ");
            double precio = scanner.nextDouble();
            System.out.print("Cantidad en stock: ");
            int stock = scanner.nextInt();
            scanner.nextLine();
            if (nombre.trim().isEmpty() || precio < 0 || stock < 0) {
                System.out.println("Error: Datos inválidos. El nombre no puede ser vacío y el precio/stock no pueden ser negativos.");
                return;
            }
            Producto nuevoProducto = new Producto(nombre, precio, stock);
            inventario.add(nuevoProducto);
            System.out.println("Producto '" + nombre + "' agregado con éxito con ID: " + nuevoProducto.getId());
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida para precio o stock. Por favor, ingrese números.");
            scanner.nextLine();
        }
    }

    public static void listarProductos() {
        System.out.println("\n--- LISTA DE PRODUCTOS ---");
        if (inventario.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : inventario) {
                System.out.println(p);
            }
        }
    }

    public static void buscarActualizarProducto() {
        System.out.println("\n--- BUSCAR/ACTUALIZAR PRODUCTO ---");
        if (inventario.isEmpty()) {
            System.out.println("No hay productos registrados para buscar.");
            return;
        }
        System.out.print("¿Buscar por ID (1) o por Nombre (2)?: ");
        int opcionBusqueda;
        try {
            opcionBusqueda = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Opción de búsqueda inválida. Ingrese 1 o 2.");
            scanner.nextLine();
            return;
        }
        Producto productoEncontrado = null;
        if (opcionBusqueda == 1) {
            System.out.print("Ingrese el ID del producto a buscar: ");
            try {
                int idBusqueda = scanner.nextInt();
                scanner.nextLine();
                for (Producto p : inventario) {
                    if (p.getId() == idBusqueda) {
                        productoEncontrado = p;
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("ID inválido. Debe ser un número.");
                scanner.nextLine();
                return;
            }
        } else if (opcionBusqueda == 2) {
            System.out.print("Ingrese el Nombre del producto a buscar: ");
            String nombreBusqueda = scanner.nextLine();
            for (Producto p : inventario) {
                if (p.getNombre().equalsIgnoreCase(nombreBusqueda)) {
                    productoEncontrado = p;
                    break;
                }
            }
        } else {
            System.out.println("Opción de búsqueda no válida.");
            return;
        }
        if (productoEncontrado != null) {
            System.out.println("Producto encontrado:");
            System.out.println(productoEncontrado);
            System.out.print("¿Desea actualizar este producto? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (respuesta.equals("s")) {
                System.out.print("¿Qué desea actualizar? Precio (1) o Stock (2)?: ");
                try {
                    int opcionActualizar = scanner.nextInt();
                    scanner.nextLine();
                    if (opcionActualizar == 1) {
                        System.out.print("Ingrese el nuevo precio: ");
                        double nuevoPrecio = scanner.nextDouble();
                        scanner.nextLine();
                        productoEncontrado.setPrecio(nuevoPrecio);
                        System.out.println("Precio actualizado.");
                    } else if (opcionActualizar == 2) {
                        System.out.print("Ingrese la nueva cantidad en stock: ");
                        int nuevoStock = scanner.nextInt();
                        scanner.nextLine();
                        productoEncontrado.setCantidadEnStock(nuevoStock);
                        System.out.println("Stock actualizado.");
                    } else {
                        System.out.println("Opción de actualización no válida.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida para la actualización.");
                    scanner.nextLine();
                }
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void eliminarProducto() {
        System.out.println("\n--- ELIMINAR PRODUCTO ---");
        if (inventario.isEmpty()) {
            System.out.println("No hay productos registrados para eliminar.");
            return;
        }
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int idEliminar;
        try {
            idEliminar = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("ID inválido. Debe ser un número.");
            scanner.nextLine();
            return;
        }
        Producto productoAEliminar = null;
        int indiceAEliminar = -1;
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getId() == idEliminar) {
                productoAEliminar = inventario.get(i);
                indiceAEliminar = i;
                break;
            }
        }
        if (productoAEliminar != null) {
            System.out.println("Producto encontrado:");
            System.out.println(productoAEliminar);
            System.out.print("¿Está seguro de que desea eliminar este producto? (s/n): ");
            String confirmacion = scanner.nextLine().trim().toLowerCase();
            if (confirmacion.equals("s")) {
                inventario.remove(indiceAEliminar);
                System.out.println("Producto eliminado con éxito.");
            } else {
                System.out.println("Eliminación cancelada.");
            }
        } else {
            System.out.println("Producto con ID " + idEliminar + " no encontrado.");
        }
    }

    public static void crearPedido() {
        System.out.println("\n--- CREAR NUEVO PEDIDO ---");
        if (inventario.isEmpty()) {
            System.out.println("No se pueden crear pedidos porque no hay productos en el inventario.");
            return;
        }
        Pedido nuevoPedido = new Pedido();
        while (true) {
            System.out.println("\n--- PRODUCTOS DISPONIBLES ---");
            listarProductos();
            System.out.println("-------------------------------------");
            System.out.print("Ingrese el ID del producto que desea agregar (o ingrese 0 para finalizar): ");
            int idProducto;
            try {
                idProducto = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido para el ID.");
                scanner.nextLine();
                continue;
            }
            if (idProducto == 0) {
                break;
            }
            Producto productoSeleccionado = null;
            for (Producto p : inventario) {
                if (p.getId() == idProducto) {
                    productoSeleccionado = p;
                    break;
                }
            }
            if (productoSeleccionado == null) {
                System.out.println("Error: Producto con ID " + idProducto + " no encontrado. Intente de nuevo.");
                continue;
            }
            System.out.print("Ingrese la cantidad deseada de '" + productoSeleccionado.getNombre() + "': ");
            int cantidadDeseada;
            try {
                cantidadDeseada = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido para la cantidad.");
                scanner.nextLine();
                continue;
            }
            if (cantidadDeseada <= 0) {
                System.out.println("Error: La cantidad debe ser mayor a cero.");
                continue;
            }
            try {
                if (cantidadDeseada > productoSeleccionado.getCantidadEnStock()) {
                    throw new StockInsuficienteException("Stock insuficiente para " + productoSeleccionado.getNombre() +
                        ". Stock disponible: " + productoSeleccionado.getCantidadEnStock() +
                        ", Cantidad solicitada: " + cantidadDeseada);
                }
                LineaPedido nuevaLinea = new LineaPedido(productoSeleccionado, cantidadDeseada);
                nuevoPedido.agregarLinea(nuevaLinea);
                System.out.println("=> '" + productoSeleccionado.getNombre() + "' (" + cantidadDeseada + " unidades) agregado al pedido.");
            } catch (StockInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        if (nuevoPedido.getLineasPedido().isEmpty()) {
            System.out.println("Pedido cancelado (no se agregaron productos).");
            return;
        }
        System.out.println("\n--- RESUMEN DEL PEDIDO ---");
        System.out.println(nuevoPedido);
        System.out.print("¿Confirma este pedido? (s/n): ");
        String confirmacion = scanner.nextLine().trim().toLowerCase();
        if (confirmacion.equals("s")) {
            for (LineaPedido linea : nuevoPedido.getLineasPedido()) {
                Producto productoEnPedido = linea.getProducto();
                int cantidadComprada = linea.getCantidad();
                productoEnPedido.setCantidadEnStock(productoEnPedido.getCantidadEnStock() - cantidadComprada);
            }
            listaDePedidos.add(nuevoPedido);
            System.out.println("¡Pedido confirmado y procesado con éxito!");
        } else {
            System.out.println("Pedido cancelado por el usuario.");
        }
    }

    public static void listarPedidos() {
        System.out.println("\n--- HISTORIAL DE PEDIDOS ---");
        if (listaDePedidos.isEmpty()) {
            System.out.println("No se ha realizado ningún pedido todavía.");
        } else {
            for (Pedido p : listaDePedidos) {
                System.out.println(p);
            }
        }
    }
}