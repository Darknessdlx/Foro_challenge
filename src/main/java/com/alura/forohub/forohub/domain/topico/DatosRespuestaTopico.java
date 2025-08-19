package com.alura.forohub.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        String nombreCurso,
        String autor,
        LocalDateTime fechaCreacion,
        String status
) {
}
