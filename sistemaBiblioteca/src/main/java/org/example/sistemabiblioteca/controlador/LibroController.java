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
     * GET /api/libros
     * Devuelve la lista completa de libros
     */
    @GetMapping
    public List<Libro> obtenerTodos() {
        return libroService.obtenerTodos();
    }

    /**
     * GET /api/libros/{id}
     * Devuelve un libro por su ID
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
     * POST /api/libros
     * Crea un nuevo libro
     */
    @PostMapping
    public ResponseEntity<Libro> crear(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroService.guardar(libro));
    }

    /**
     * PUT /api/libros/{id}
     * Actualiza un libro existente por su ID
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
     * DELETE /api/libros/{id}
     * Elimina un libro por su ID
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
