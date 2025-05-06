package org.example.sistemabiblioteca.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private Long id;
    private String nombre;
    private String email;
    private String estado; // Podés cambiar esto a enum si lo necesitás luego
}
