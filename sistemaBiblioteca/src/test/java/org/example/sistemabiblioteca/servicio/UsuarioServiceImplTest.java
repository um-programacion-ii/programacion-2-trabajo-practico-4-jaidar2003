package org.example.sistemabiblioteca.servicio;

import org.example.sistemabiblioteca.modelo.Usuario;
import org.example.sistemabiblioteca.repositorio.UsuarioRepository;
import org.example.sistemabiblioteca.servicio.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Test
    void guardarUsuario_exitosamente() {
        Usuario usuario = new Usuario(null, "Juan", "juan@mail.com", "ACTIVO");
        when(usuarioRepository.save(usuario)).thenReturn(new Usuario(1L, "Juan", "juan@mail.com", "ACTIVO"));

        Usuario resultado = usuarioService.guardar(usuario);

        assertNotNull(resultado.getId());
        assertEquals("Juan", resultado.getNombre());
    }

    @Test
    void buscarUsuarioPorId_existente() {
        Usuario usuario = new Usuario(1L, "Ana", "ana@mail.com", "ACTIVO");
        when(usuarioRepository.findById(1L)).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.buscarPorId(1L);

        assertEquals("Ana", resultado.getNombre());
    }
}
