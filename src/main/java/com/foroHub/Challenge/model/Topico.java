package com.foroHub.Challenge.model;

import com.foroHub.Challenge.DTO.Topico.DatosActualizarTopico;
import com.foroHub.Challenge.DTO.Topico.DatosRegistroTopico;
import com.foroHub.Challenge.DTO.Topico.DatosRespuestaTopico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Estado status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "topico_id", referencedColumnName = "id")
    private List<Respuesta> respuestas = new ArrayList<>();


    public Topico(DatosRegistroTopico datosRespuestaTopico, Usuario autor, Curso curso){
        this.titulo = datosRespuestaTopico.titulo();
        this.mensaje = datosRespuestaTopico.mensaje();
        this.autor = autor;
        this.curso = curso;
    }

    public void borrarTopico() {
        this.status = Estado.SOLUCIONADO;
    }


    public void actualizarDatos(DatosActualizarTopico datosActualizar, Usuario autor, Curso curso) {
            this.titulo = datosActualizar.titulo();
            this.mensaje = datosActualizar.mensaje();
            this.status = datosActualizar.estado();
            this.curso = curso;

    }

}
