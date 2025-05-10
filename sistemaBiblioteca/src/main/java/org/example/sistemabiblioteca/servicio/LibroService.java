package org.example.sistemabiblioteca.servicio;

import org.example.sistemabiblioteca.modelo.Libro;

import java.util.List;

/**
 * Servicio que gestiona las operaciones relacionadas con los libros.
 * Proporciona métodos para buscar, crear, actualizar y eliminar libros.
 */
public interface LibroService {
    /**
     * Busca un libro por su ISBN.
     * 
     * @param isbn El ISBN del libro a buscar
     * @return El libro encontrado
     * @throws RuntimeException si no se encuentra ningún libro con el ISBN especificado
     */
    Libro buscarPorIsbn(String isbn);

    /**
     * Busca un libro por su ID.
     * 
     * @param id El ID del libro a buscar
     * @return El libro encontrado
     * @throws RuntimeException si no se encuentra ningún libro con el ID especificado
     */
    Libro buscarPorId(Long id);

    /**
     * Obtiene todos los libros disponibles en el sistema.
     * 
     * @return Lista de todos los libros
     */
    List<Libro> obtenerTodos();

    /**
     * Guarda un nuevo libro en el sistema.
     * 
     * @param libro El libro a guardar
     * @return El libro guardado con su ID generado
     */
    Libro guardar(Libro libro);

    /**
     * Elimina un libro por su ID.
     * 
     * @param id El ID del libro a eliminar
     */
    void eliminar(Long id);

    /**
     * Actualiza un libro existente.
     * 
     * @param id El ID del libro a actualizar
     * @param libro El libro con los nuevos datos
     * @return El libro actualizado
     * @throws RuntimeException si no existe un libro con el ID especificado
     */
    Libro actualizar(Long id, Libro libro);
}
