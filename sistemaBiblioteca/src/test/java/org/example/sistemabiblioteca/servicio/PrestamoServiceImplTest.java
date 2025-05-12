package org.example.sistemabiblioteca.servicio;

import org.example.sistemabiblioteca.modelo.Prestamo;
import org.example.sistemabiblioteca.repositorio.PrestamoRepository;
import org.example.sistemabiblioteca.servicio.impl.PrestamoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PrestamoServiceImplTest {

    @Mock
    private PrestamoRepository prestamoRepository;

    @InjectMocks
    private PrestamoServiceImpl prestamoService;

    @Test
    void guardarPrestamo_exitosamente() {
        Prestamo prestamo = new Prestamo(null, null, null, LocalDate.now(), LocalDate.now().plusDays(7));
        when(prestamoRepository.save(prestamo)).thenReturn(new Prestamo(1L, null, null, LocalDate.now(), LocalDate.now().plusDays(7)));

        Prestamo resultado = prestamoService.guardar(prestamo);

        assertNotNull(resultado.getId());
    }

    @Test
    void buscarPrestamoPorId_existente() {
        Prestamo prestamo = new Prestamo(1L, null, null, LocalDate.now(), LocalDate.now().plusDays(7));
        when(prestamoRepository.findById(1L)).thenReturn(Optional.of(prestamo));

        Prestamo resultado = prestamoService.buscarPorId(1L);

        assertEquals(1L, resultado.getId());
    }
}
