# InventarioBazarAPI

API para gestión de ventas y stock del bazar.

## Requisitos previos

Antes de ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17**
- **Maven**
- **Spring Boot**
- **MySQL**
- **Springdoc OpenAPI (para documentación interactiva de la API - http://localhost:8080/swagger-ui.html)**

## Cómo ejecutar el proyecto

1. Clona este repositorio:

   ```bash
   git clone https://github.com/tu_usuario/inventarioBazarAPI.git
   cd inventarioBazarAPI
   ```

2. Compila y ejecuta la aplicación:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

3. La API estará disponible en `http://localhost:8080`.

## Endpoints principales

A continuación, se listan algunos de los endpoints principales:

### Productos

- **GET** `/productos`: Obtiene todos los productos.
- **GET** `/productos/{id}`: Obtiene un producto.
- **GET** `/productos/stock/{cantidad}`: Obtiene los productos segun cantidad.
- **POST** `/productos/crear`: Crea un nuevo producto.
- **PUT** `/productos/editar/{id}`: Actualiza un producto existente.
- **DELETE** `/productos/eliminar/{id}`: Elimina un producto.

### Clientes

- **GET** `/clientes`: Obtiene todos los clientes.
- **GET** `/clientes/{id}`: Obtiene un cliente.
- **POST** `/clientes/crear`: Crea un nuevo cliente.
- **PUT** `/clientes/editar/{id}`: Actualiza un cliente existente.
- **DELETE** `/clientes/eliminar/{id}`: Elimina un cliente.

### Ventas

- **GET** `/ventas`: Obtiene todas los ventas.
- **GET** `/ventas/{id}`: Obtiene una venta.
- **GET** `/ventas/productos/{id}`: Obtiene los productos de una determinada venta.
- **GET** `/ventas/fecha/{fecha_venta}`: Obtiene el total y la cantidad de ventas de un determinado dia.
- **GET** `/ventas/mayor_venta`: Obtiene los datos de la venta con el monto mas alto.
- **POST** `/ventas/crear`: Crea una nueva venta.
- **PUT** `/ventas/editar/{id}`: Actualiza una venta existente.
- **DELETE** `/ventas/eliminar/{id}`: Elimina una venta.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **JPA/Hibernate**
- **MySQL**
- **Maven**
