package org.example.sistemabiblioteca.controlador;

import org.example.sistemabiblioteca.modelo.Prestamo;
import org.example.sistemabiblioteca.servicio.PrestamoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    /**
     * GET /api/prestamos
     */
    @GetMapping
    public List<Prestamo> obtenerTodos() {
        return prestamoService.obtenerTodos();
    }

    /**
     * GET /api/prestamos/{id}
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
     * POST /api/prestamos
     */
    @PostMapping
    public ResponseEntity<Prestamo> crear(@RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoService.guardar(prestamo));
    }

    /**
     * PUT /api/prestamos/{id}
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
     * DELETE /api/prestamos/{id}
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
