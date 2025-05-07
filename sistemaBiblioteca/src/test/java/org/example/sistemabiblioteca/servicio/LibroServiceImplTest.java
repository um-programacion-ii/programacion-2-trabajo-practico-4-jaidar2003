package org.example.sistemabiblioteca.servicio;

import org.example.sistemabiblioteca.modelo.EstadoLibro;
import org.example.sistemabiblioteca.modelo.Libro;
import org.example.sistemabiblioteca.repositorio.LibroRepository;
import org.example.sistemabiblioteca.servicio.impl.LibroServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class LibroServiceImplTest {

    @Mock
    private LibroRepository libroRepository;

    @InjectMocks
    private LibroServiceImpl libroService;

    @Test
    void cuandoBuscarPorIsbnExiste_entoncesRetornaLibro() {
        // Arrange
        String isbn = "123456";
        Libro libro = new Libro(1L, isbn, "Libro Test", "Autor", EstadoLibro.DISPONIBLE);
        when(libroRepository.findByIsbn(isbn)).thenReturn(Optional.of(libro));

        // Act
        Libro resultado = libroService.buscarPorIsbn(isbn);

        // Assert
        assertNotNull(resultado);
        assertEquals(isbn, resultado.getIsbn());
        verify(libroRepository).findByIsbn(isbn);
    }

    @Test
    void cuandoBuscarPorIsbnNoExiste_entoncesLanzaExcepcion() {
        // Arrange
        String isbn = "inexistente";
        when(libroRepository.findByIsbn(isbn)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(RuntimeException.class, () -> libroService.buscarPorIsbn(isbn));
    }

    @Test
    void cuandoGuardar_entoncesRetornaLibroGuardado() {
        // Arrange
        Libro libro = new Libro(null, "abc", "Nuevo", "Autor", EstadoLibro.DISPONIBLE);
        when(libroRepository.save(libro)).thenReturn(new Libro(1L, "abc", "Nuevo", "Autor", EstadoLibro.DISPONIBLE));

        // Act
        Libro guardado = libroService.guardar(libro);

        // Assert
        assertNotNull(guardado);
        assertEquals(1L, guardado.getId());
    }
}
