package org.example.sistemabiblioteca.servicio;

import org.example.sistemabiblioteca.modelo.Prestamo;

import java.util.List;

public interface PrestamoService {
    Prestamo buscarPorId(Long id);
    List<Prestamo> obtenerTodos();
    Prestamo guardar(Prestamo prestamo);
    void eliminar(Long id);
    Prestamo actualizar(Long id, Prestamo prestamo);
}
