# Sistema de Gestión de Tienda en Java

Este es un proyecto de consola desarrollado en Java que simula un sistema básico de gestión de inventario y pedidos para una tienda. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre productos, así como generar pedidos validando el stock disponible.

Este proyecto fue desarrollado como parte de un requerimiento académico para demostrar el manejo de los conceptos fundamentales de la Programación Orientada a Objetos (POO) y Java.

---

## 🚀 Características Principales

El sistema cuenta con las siguientes funcionalidades accesibles a través de un menú interactivo en la consola:

* **Gestión de Productos:**
    * **Agregar Producto:** Permite registrar nuevos productos con nombre, precio y stock inicial.
    * **Listar Productos:** Muestra un listado de todos los productos en el inventario con su ID, nombre, precio y stock actual.
    * **Buscar y Actualizar Producto:** Busca un producto por su ID o nombre y permite modificar su precio o stock.
    * **Eliminar Producto:** Elimina un producto del inventario previa confirmación.

* **Gestión de Pedidos:**
    * **Crear Pedido:** Permite al usuario seleccionar múltiples productos del inventario y especificar las cantidades deseadas.
    * **Validación de Stock:** El sistema verifica si hay suficiente stock para cada producto solicitado antes de agregarlo al pedido.
    * **Actualización de Inventario:** Al confirmar un pedido, el stock de los productos vendidos se descuenta automáticamente del inventario general.
    * **Listar Pedidos:** Muestra un historial de todos los pedidos realizados, con el detalle de los productos, cantidades y el costo total de cada uno.

* **Manejo de Excepciones:**
    * El sistema maneja entradas inválidas del usuario (por ejemplo, texto en lugar de números).
    * Utiliza una excepción personalizada (`StockInsuficienteException`) para gestionar de forma controlada los casos donde no hay stock suficiente.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java (versión de JRE: JavaSE-21)
* **IDE:** Eclipse IDE
* **Control de Versiones:** Git y GitHub

---

## ⚙️ Cómo Ejecutar el Proyecto

1.  Clonar el repositorio o descargar el código fuente.
2.  Abrir el proyecto en un IDE compatible con Java, como Eclipse o IntelliJ IDEA.
3.  Localizar la clase principal del proyecto en la siguiente ruta:
    `src/com/techlab/app/SistemaGestion.java`
4.  Ejecutar el archivo `SistemaGestion.java` como una Aplicación Java.
5.  Interactuar con el sistema a través del menú que aparecerá en la consola.

---

## 📂 Estructura del Proyecto

El código está organizado en paquetes lógicos para una mejor mantenibilidad, siguiendo las mejores prácticas:

* `com.techlab.app`: Contiene la clase principal que ejecuta el programa.
* `com.techlab.productos`: Contiene la clase `Producto`.
* `com.techlab.pedidos`: Contiene las clases `Pedido` y `LineaPedido`.
* `com.techlab.excepciones`: Contiene la excepción personalizada `StockInsuficienteException`.

---

## 👨‍💻 Autor

* **Tomas-SC** - [Perfil de GitHub](https://github.com/Tomas-SC)
