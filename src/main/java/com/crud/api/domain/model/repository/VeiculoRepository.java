package com.crud.api.domain.model.repository;

import com.crud.api.domain.model.Pessoa;
import com.crud.api.domain.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    Optional<Veiculo> findByModeloContaining(String modelo);
    Optional<Veiculo> findByMarca(String marca);
}
