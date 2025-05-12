package org.example.sistemabiblioteca.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.sistemabiblioteca.modelo.Prestamo;
import org.example.sistemabiblioteca.servicio.PrestamoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PrestamoController.class)
class PrestamoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrestamoService prestamoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void obtenerTodos_prestamos() throws Exception {
        Prestamo prestamo = new Prestamo(1L, null, null, LocalDate.now(), LocalDate.now().plusDays(5));
        when(prestamoService.obtenerTodos()).thenReturn(List.of(prestamo));

        mockMvc.perform(get("/api/prestamos"))
                .andExpect(status().isOk());
    }
}
