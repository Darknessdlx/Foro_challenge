package com.alura.forohub.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosRegistroTopico(
        @NotBlank
        @Size(min = 3, max = 100)
        String titulo,
        @NotBlank
        @Size(min = 10, max = 1000)
        String mensaje,
        @NotBlank
        @Size(min = 3, max = 100)
        String nombreCurso
) {
}

