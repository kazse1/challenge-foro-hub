package com.foroHub.Challenge.DTO.Topico;

import com.foroHub.Challenge.model.Topico;

public record DatosListadoTopico(Long Id,
                                 String titulo,
                                 String mensaje,
                                 String curso) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getCurso().getNombre());

    }

}
