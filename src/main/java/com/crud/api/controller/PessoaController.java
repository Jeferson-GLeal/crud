package com.crud.api.controller;

import com.crud.api.domain.model.Pessoa;
import com.crud.api.domain.model.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    @GetMapping("/pessoas")
    public List<Pessoa> listar() {

        return pessoaRepository.findAll();
    }
}
