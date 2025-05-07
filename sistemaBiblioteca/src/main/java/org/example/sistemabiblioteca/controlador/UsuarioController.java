package org.example.sistemabiblioteca.controlador;

import org.example.sistemabiblioteca.modelo.Usuario;
import org.example.sistemabiblioteca.servicio.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * GET /api/usuarios
     */
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    /**
     * GET /api/usuarios/{id}
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerPorId(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(usuarioService.buscarPorId(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * POST /api/usuarios
     */
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }

    /**
     * PUT /api/usuarios/{id}
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        try {
            return ResponseEntity.ok(usuarioService.actualizar(id, usuario));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * DELETE /api/usuarios/{id}
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
