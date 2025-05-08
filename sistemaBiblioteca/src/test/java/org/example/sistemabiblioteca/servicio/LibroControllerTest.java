package org.example.sistemabiblioteca.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sistemabiblioteca.modelo.EstadoLibro;
import org.example.sistemabiblioteca.modelo.Libro;
import org.example.sistemabiblioteca.servicio.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LibroController.class)
class LibroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibroService libroService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void obtenerTodos_deberiaRetornarListaDeLibros() throws Exception {
        Libro libro = new Libro(1L, "123", "Test", "Autor", EstadoLibro.DISPONIBLE);
        when(libroService.obtenerTodos()).thenReturn(List.of(libro));

        mockMvc.perform(get("/api/libros"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].titulo").value("Test"));
    }

    @Test
    void crearLibro_deberiaRetornarLibroGuardado() throws Exception {
        Libro libro = new Libro(null, "456", "Nuevo", "Autor", EstadoLibro.DISPONIBLE);
        Libro guardado = new Libro(2L, "456", "Nuevo", "Autor", EstadoLibro.DISPONIBLE);

        when(libroService.guardar(libro)).thenReturn(guardado);

        mockMvc.perform(post("/api/libros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(libro)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(2))
                .andExpect(jsonPath("$.isbn").value("456"));
    }
}
