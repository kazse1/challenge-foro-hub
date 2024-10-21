package com.foroHub.Challenge.controller;

import com.foroHub.Challenge.DTO.Topico.DatosListadoTopico;
import com.foroHub.Challenge.DTO.Topico.DatosActualizarTopico;
import com.foroHub.Challenge.DTO.Topico.DatosRegistroTopico;
import com.foroHub.Challenge.DTO.Topico.DatosRespuestaTopico;
import com.foroHub.Challenge.model.Curso;
import com.foroHub.Challenge.model.Topico;
import com.foroHub.Challenge.model.Usuario;
import com.foroHub.Challenge.repository.CursoRepository;
import com.foroHub.Challenge.repository.TopicoRepository;
import com.foroHub.Challenge.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private UsuarioRepository usuarioRepositorio;
    @Autowired
    private TopicoRepository topicoRepositorio;
    @Autowired
    private CursoRepository cursoRepositorio;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> crearTopico(@RequestBody DatosRegistroTopico datosRegistroTopico,
                                                            UriComponentsBuilder uri){
        Usuario user = usuarioRepositorio.getReferenceById(datosRegistroTopico.autorId());
        Curso curso = cursoRepositorio.getReferenceById(datosRegistroTopico.cursoId());
        var topic = new Topico(datosRegistroTopico, user, curso);
        Topico topico = topicoRepositorio.save(topic);
        var respuestas = new DatosRespuestaTopico(topico);

        URI url = uri.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(respuestas);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listar (@PageableDefault(size=8) Pageable paginacion){
        return ResponseEntity.ok(topicoRepositorio.findAll(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizar(@RequestBody @Valid DatosActualizarTopico datosActualizar) {
        Usuario autor = usuarioRepositorio.getReferenceById(datosActualizar.autorId());
        Curso curso = cursoRepositorio.getReferenceById(datosActualizar.cursoId());
        Topico topico = topicoRepositorio.getReferenceById(datosActualizar.id());
        topico.actualizarDatos(datosActualizar, autor, curso);
        return ResponseEntity.ok( new DatosRespuestaTopico(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        Topico topico = topicoRepositorio.getReferenceById(id);
        topico.borrarTopico();
        return ResponseEntity.noContent().build();
    }

}
