package org.example.sistemabiblioteca.controlador;

import org.example.sistemabiblioteca.modelo.Usuario;
import org.example.sistemabiblioteca.servicio.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones CRUD para los usuarios del sistema.
 * Proporciona endpoints para crear, leer, actualizar y eliminar usuarios.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Obtiene todos los usuarios registrados en el sistema.
     * 
     * @return Lista de todos los usuarios
     * @HTTP GET /api/usuarios
     * @responseStatus 200 OK
     */
    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    /**
     * Obtiene un usuario específico por su identificador.
     * 
     * @param id El identificador único del usuario a buscar
     * @return ResponseEntity con el usuario encontrado
     * @HTTP GET /api/usuarios/{id}
     * @responseStatus 200 OK si se encuentra el usuario
     * @responseStatus 404 NOT FOUND si no existe el usuario con el ID especificado
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
     * Crea un nuevo usuario en el sistema.
     * 
     * @param usuario El objeto Usuario con los datos a guardar (sin ID)
     * @return ResponseEntity con el usuario creado, incluyendo su ID generado
     * @HTTP POST /api/usuarios
     * @requestBody Objeto Usuario sin ID
     * @responseStatus 200 OK con el usuario creado
     */
    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.guardar(usuario));
    }

    /**
     * Actualiza un usuario existente en el sistema.
     * 
     * @param id El identificador único del usuario a actualizar
     * @param usuario El objeto Usuario con los nuevos datos (el ID en el cuerpo se ignorará)
     * @return ResponseEntity con el usuario actualizado
     * @HTTP PUT /api/usuarios/{id}
     * @requestBody Objeto Usuario con los datos actualizados
     * @responseStatus 200 OK si se actualiza correctamente
     * @responseStatus 404 NOT FOUND si no existe el usuario con el ID especificado
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
     * Elimina un usuario del sistema por su identificador.
     * 
     * @param id El identificador único del usuario a eliminar
     * @return ResponseEntity sin contenido
     * @HTTP DELETE /api/usuarios/{id}
     * @responseStatus 204 NO CONTENT si se elimina correctamente
     * @responseStatus 404 NOT FOUND si no existe el usuario con el ID especificado
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
