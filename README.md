# testproyectum

# 🛠️ CRUD Backend con Spring Boot

Este proyecto es un **backend sencillo en Java Spring Boot** que implementa un CRUD de usuarios y productos, con autenticación mediante **JWT (JSON Web Token)**.

## 🚀 Tecnologías utilizadas 🔥
- **Java 17**
- **Spring Boot 3.3.4**
- **Spring Web** (REST API)
- **Spring Data JPA** (persistencia)
- **H2 Database** (BD en memoria para pruebas)
- **Spring Security + JWT** (autenticación)
- **Maven** (gestor de dependencias)
- **JUnit 5 & Mockito** (pruebas unitarias)

## 🏃‍♂️ Ejecución del Proyecto

### 1️⃣ Clonar el repositorio
```bash
git clone https://github.com/carlos-rojas-dev/prueba-proyectum-backend.git
cd prueba-proyectum-backend

```
#### 2️⃣ Compilar y ejecutar con Maven

```bash
mvn spring-boot:run
```
Por defecto, la aplicación se levantará en:
📍 http://localhost:8080

## 🔑Autenticación con JWT
Antes de usar los endpoints protegidos, debes loguearte y obtener un token.

### Endpoint de login:
#### **POST** /auth/login
```
json 
{
  "username": "Carlos",
  "clave": "1234"
}
```
📤 **Respuesta:**
```
{
    "usuario": {
        "id": 1,
        "nombre": "Carlos Rojas Quintanilla",
        "email": "carlos.rojas.ti@hotmail.com"
    },
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjYXJsb3Mucm9qYXMudGlAaG90bWFpbC5jb20iLCJpYXQiOjE3NTc4ODc5NTgsImV4cCI6MTc1Nzg5MTU1OH0.G2fwKKlqJbzRxiJmHKWTGRTQHQu2zgQVLWBrx_2gGcM"
}
```
Luego, debes enviar el token en el header Authorization:
``` 
Authorization: Bearer TU_TOKEN_AQUI

```  
## 📌 Endpoints principales
### 👤 Usuarios

 -  POST /auth/register → Registrar un nuevo usuario
 - POST /auth/login → Iniciar sesión y obtener token

### 🛒 Productos (protegidos con token)

 -  GET /productos → Listar productos
 -  POST /productos → Crear producto
 -  PUT /productos/{id} → Actualizar producto
 -  DELETE /productos/{id} → Eliminar producto 

## 🧪 Pruebas Automáticas
Puedes ejecutar las pruebas con:

```  bash 
mvn test

```  
Estas pruebas:

- Verifican el **login** y la generación de token.
- Validan la creación y listado de productos.
- Usan **MockMvc** para simular peticiones HTTP.
- Imprimen información en **colores** en la consola para facilitar la depuración.

## 🛠️ Configuración de Base de Datos
Por defecto usa **H2 (en memoria)** para facilitar pruebas y desarrollo.
