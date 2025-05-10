package org.example.sistemabiblioteca.controlador;

import org.example.sistemabiblioteca.modelo.Libro;
import org.example.sistemabiblioteca.servicio.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Obtiene todos los libros disponibles en el sistema.
     * 
     * @return Lista de todos los libros
     * @HTTP GET /api/libros
     * @responseStatus 200 OK
     */
    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    /**
     * Obtiene un libro específico por su identificador.
     * 
     * @param id El identificador único del libro a buscar
     * @return ResponseEntity con el libro encontrado
     * @HTTP GET /api/libros/{id}
     * @responseStatus 200 OK si se encuentra el libro
     * @responseStatus 404 NOT FOUND si no existe el libro con el ID especificado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(libroService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo libro en el sistema.
     * 
     * @param libro El objeto Libro con los datos a guardar (sin ID)
     * @return ResponseEntity con el libro creado, incluyendo su ID generado
     * @HTTP POST /api/libros
     * @requestBody Objeto Libro sin ID
     * @responseStatus 200 OK con el libro creado
     */
    @PostMapping
    public ResponseEntity<Libro> crear(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.guardar(libro));
    }

    /**
     * Actualiza un libro existente en el sistema.
     * 
     * @param id El identificador único del libro a actualizar
     * @param libro El objeto Libro con los nuevos datos (el ID en el cuerpo se ignorará)
     * @return ResponseEntity con el libro actualizado
     * @HTTP PUT /api/libros/{id}
     * @requestBody Objeto Libro con los datos actualizados
     * @responseStatus 200 OK si se actualiza correctamente
     * @responseStatus 404 NOT FOUND si no existe el libro con el ID especificado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(@PathVariable Long id, @RequestBody Libro libro) {
        try {
            return ResponseEntity.ok(libroService.actualizar(id, libro));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un libro del sistema por su identificador.
     * 
     * @param id El identificador único del libro a eliminar
     * @return ResponseEntity sin contenido
     * @HTTP DELETE /api/libros/{id}
     * @responseStatus 204 NO CONTENT si se elimina correctamente
     * @responseStatus 404 NOT FOUND si no existe el libro con el ID especificado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            libroService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
