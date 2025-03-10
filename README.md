# Pizzería API

Este es un proyecto desarrollado en **Spring Boot** que gestiona una pizzería, permitiendo la administración de pedidos, productos y clientes. Se utiliza **Spring Data JPA** para la persistencia de datos en **MySQL** y una configuración de seguridad basada utilizando **Spring Security**.

## Tecnologías utilizadas
- **Java 21**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **Spring Security**

## Instalación y configuración
1. Clona el repositorio:
   ```sh
   git clone https://github.com/andres-colonia-al/pizzeria.git
   ```
2. Configura la base de datos en `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pizzeria
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=create-drop
   ```
3. Ejecuta el proyecto con:
   ```sh
   mvn spring-boot:run
   ```

## Endpoints principales

### **Pizzas** (`PizzaController`)
- **Obtener todas las pizzas**
  ```http
  GET /api/pizzas
  ```
- **Obtener todas las pizzas paginadas**
  ```http
  GET /api/pizzas/pag?page={page}&elements={elements}
  ```
- **Obtener todas las pizzas paginadas y ordenadas**
  ```http
  GET /api/pizzas/pag-sort?page={page}&elements={elements}&sortBy={sortBy}&sortDirection={sortDirection}
  ```
- **Obtener una pizza por ID**
  ```http
  GET /api/pizzas/{idPizza}
  ```
- **Obtener pizzas disponibles**
  ```http
  GET /api/pizzas/available
  ```
- **Obtener una pizza disponible por nombre**
  ```http
  GET /api/pizzas/name/{name}
  ```
- **Obtener pizzas que contengan un ingrediente**
  ```http
  GET /api/pizzas/with/{description}
  ```
- **Obtener pizzas más baratas que un precio dado**
  ```http
  GET /api/pizzas/cheapper/{price}
  ```
- **Obtener pizzas que NO contengan un ingrediente**
  ```http
  GET /api/pizzas/without/{description}
  ```
- **Crear una nueva pizza**
  ```http
  POST /api/pizzas
  ```
- **Actualizar una pizza**
  ```http
  PUT /api/pizzas
  ```
- **Eliminar una pizza**
  ```http
  DELETE /api/pizzas/{idPizza}
  ```
- **Actualizar precio de una pizza**
  ```http
  PUT /api/pizzas/price
  ```

### **Pedidos** (`OrderController`)
- **Obtener todos los pedidos**
  ```http
  GET /api/orders
  ```
- **Obtener pedidos de hoy**
  ```http
  GET /api/orders/today
  ```
- **Obtener pedidos fuera del restaurante**
  ```http
  GET /api/orders/outside
  ```
- **Obtener pedidos de un cliente por ID**
  ```http
  GET /api/orders/customer/{id}
  ```
- **Obtener resumen de un pedido**
  ```http
  GET /api/orders/summary/{id}
  ```

### **Clientes** (`CustomerController`)
- **Obtener un cliente por número de teléfono**
  ```http
  GET /api/customers/phone/{phone}
  ```

## Futuras mejoras
- Implementación de seguridad con Spring Security
- Creación de documentación con Swagger
- Desarrollo de pruebas unitarias con JUnit y Mockito

## Autor
**Andrés Felipe Colonia Aldana**
