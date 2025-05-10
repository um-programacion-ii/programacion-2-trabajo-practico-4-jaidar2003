package org.example.sistemabiblioteca.controlador;

import org.example.sistemabiblioteca.modelo.Prestamo;
import org.example.sistemabiblioteca.servicio.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones CRUD para los préstamos de libros.
 * Proporciona endpoints para crear, leer, actualizar y eliminar préstamos.
 */
@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    /**
     * Obtiene todos los préstamos registrados en el sistema.
     * 
     * @return Lista de todos los préstamos
     * @HTTP GET /api/prestamos
     * @responseStatus 200 OK
     */
    @GetMapping
    public List<Prestamo> obtenerTodos() {
        return prestamoService.obtenerTodos();
    }

    /**
     * Obtiene un préstamo específico por su identificador.
     * 
     * @param id El identificador único del préstamo a buscar
     * @return ResponseEntity con el préstamo encontrado
     * @HTTP GET /api/prestamos/{id}
     * @responseStatus 200 OK si se encuentra el préstamo
     * @responseStatus 404 NOT FOUND si no existe el préstamo con el ID especificado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Prestamo> obtenerPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(prestamoService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crea un nuevo préstamo en el sistema.
     * 
     * @param prestamo El objeto Prestamo con los datos a guardar (sin ID)
     * @return ResponseEntity con el préstamo creado, incluyendo su ID generado
     * @HTTP POST /api/prestamos
     * @requestBody Objeto Prestamo sin ID, debe incluir libro, usuario, fechaPrestamo y fechaDevolucion
     * @responseStatus 200 OK con el préstamo creado
     */
    @PostMapping
    public ResponseEntity<Prestamo> crear(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.guardar(prestamo));
    }

    /**
     * Actualiza un préstamo existente en el sistema.
     * 
     * @param id El identificador único del préstamo a actualizar
     * @param prestamo El objeto Prestamo con los nuevos datos (el ID en el cuerpo se ignorará)
     * @return ResponseEntity con el préstamo actualizado
     * @HTTP PUT /api/prestamos/{id}
     * @requestBody Objeto Prestamo con los datos actualizados
     * @responseStatus 200 OK si se actualiza correctamente
     * @responseStatus 404 NOT FOUND si no existe el préstamo con el ID especificado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Prestamo> actualizar(@PathVariable Long id, @RequestBody Prestamo prestamo) {
        try {
            return ResponseEntity.ok(prestamoService.actualizar(id, prestamo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Elimina un préstamo del sistema por su identificador.
     * 
     * @param id El identificador único del préstamo a eliminar
     * @return ResponseEntity sin contenido
     * @HTTP DELETE /api/prestamos/{id}
     * @responseStatus 204 NO CONTENT si se elimina correctamente
     * @responseStatus 404 NOT FOUND si no existe el préstamo con el ID especificado
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            prestamoService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
