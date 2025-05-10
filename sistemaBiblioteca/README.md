# 🚀 Trabajo Práctico: Sistema de Gestión de Biblioteca con Spring Framework

![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.4.5-green)
![Java](https://img.shields.io/badge/Java-21-orange)
![Maven](https://img.shields.io/badge/Maven-3.9.0-red)
![JUnit5](https://img.shields.io/badge/JUnit-5.10.1-green)
![Mockito](https://img.shields.io/badge/Mockito-5.8.0-blue)

## ⚠️ Importante: Antes de Comenzar

1. **Lectura Completa**
    - Es **OBLIGATORIO** leer la consigna completa antes de comenzar a trabajar
2. **Configuración del Repositorio**
    - La rama `main` debe estar protegida
    - Todo el desarrollo debe realizarse en ramas feature y Pull Requests

## 🎯 Objetivo General

Desarrollar un sistema de gestión de biblioteca utilizando Spring Framework, aplicando los principios SOLID y una arquitectura en capas.

## ⏰ Tiempo Estimado y Entrega

- Tiempo estimado: 24–30 horas
- Entrega: 14/05/2025 a las 13:00 hs

## 👨‍🎓 Información del Alumno

- **Nombre y Apellido**: Juan Manuel Aidar
- **Legajo**: 62005

## 📋 Requisitos Previos

- Java 21+
- Maven 3.9+
- Conocimientos en POO, SOLID, Spring, REST

## 🧩 Tecnologías y Herramientas

- Spring Boot, Spring Web, Spring Test
- JUnit 5
- Mockito
- Git y GitHub

## 📘 Etapas del Trabajo

### Etapa 1: Modelos

- `Libro`, `Usuario`, `Prestamo`
- Enum: `EstadoLibro`

### Etapa 2: Repositorios y Servicios

- Interfaces `Repository` y `Service`
- Implementaciones en memoria y lógicas de negocio

### Etapa 3: Controladores REST

- `/api/libros`
- `/api/usuarios`
- `/api/prestamos`

### Etapa 4: Testing y Documentación

- Tests unitarios con Mockito
- Tests de integración con MockMvc
- Documentación en README

---

## 📚 Endpoints disponibles

### Libros

- `GET /api/libros`
- `GET /api/libros/{id}`
- `POST /api/libros`
- `PUT /api/libros/{id}`
- `DELETE /api/libros/{id}`

### Usuarios

- `GET /api/usuarios`
- `GET /api/usuarios/{id}`
- `POST /api/usuarios`
- `PUT /api/usuarios/{id}`
- `DELETE /api/usuarios/{id}`

### Préstamos

- `GET /api/prestamos`
- `GET /api/prestamos/{id}`
- `POST /api/prestamos`
- `PUT /api/prestamos/{id}`
- `DELETE /api/prestamos/{id}`

---

## 🧪 Ejemplos de uso con `curl`

### Libros

```bash
curl -X POST http://localhost:8080/api/libros \
  -H "Content-Type: application/json" \
  -d '{"isbn":"123-456","titulo":"Libro de Prueba","autor":"Juanma","estado":"DISPONIBLE"}'

curl http://localhost:8080/api/libros

curl http://localhost:8080/api/libros/1

curl -X PUT http://localhost:8080/api/libros/1 \
  -H "Content-Type: application/json" \
  -d '{"id":1,"isbn":"123-456","titulo":"Libro Editado","autor":"Juanma","estado":"PRESTADO"}'

curl -X DELETE http://localhost:8080/api/libros/1
```

### Usuarios

```bash
curl -X POST http://localhost:8080/api/usuarios \
-H "Content-Type: application/json" \
-d '{"nombre":"Ana","email":"ana@email.com","estado":"ACTIVO"}'

curl http://localhost:8080/api/usuarios

curl http://localhost:8080/api/usuarios/1

curl -X PUT http://localhost:8080/api/usuarios/1 \
-H "Content-Type: application/json" \
-d '{"id":1,"nombre":"Ana María","email":"ana@email.com","estado":"INACTIVO"}'

curl -X DELETE http://localhost:8080/api/usuarios/1
```

### Préstamos

```bash
curl -X POST http://localhost:8080/api/prestamos \
  -H "Content-Type: application/json" \
  -d '{"libro":{"id":1},"usuario":{"id":1},"fechaPrestamo":"2025-05-10","fechaDevolucion":"2025-05-20"}'

curl http://localhost:8080/api/prestamos

curl http://localhost:8080/api/prestamos/1

curl -X PUT http://localhost:8080/api/prestamos/1 \
  -H "Content-Type: application/json" \
  -d '{"id":1,"libro":{"id":1},"usuario":{"id":1},"fechaPrestamo":"2025-05-10","fechaDevolucion":"2025-05-25"}'

curl -X DELETE http://localhost:8080/api/prestamos/1
```
