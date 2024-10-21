package com.foroHub.Challenge.repository;

import com.foroHub.Challenge.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
