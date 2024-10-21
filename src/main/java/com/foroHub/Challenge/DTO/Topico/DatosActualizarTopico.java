package com.foroHub.Challenge.DTO.Topico;

import com.foroHub.Challenge.model.Estado;

public record DatosActualizarTopico(Long id,
                                    String titulo,
                                    String mensaje,
                                    Estado estado,
                                    Long autorId,
                                    Long cursoId) {
}
