package com.crud.api.domain.model.repository;

import com.crud.api.domain.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    //List<Pessoa> findByNomeContaining(String nome);
    Optional<Pessoa> findByNomeContaining(String nome);
}
