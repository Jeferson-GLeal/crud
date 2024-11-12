package com.crud.api.controller;

import com.crud.api.domain.model.Pessoa;
import com.crud.api.domain.model.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaRepository pessoaRepository;

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<Pessoa> pesquisarPorNome(@PathVariable String nome) {
        Optional<Pessoa> pessoa = pessoaRepository.findByNomeContaining(nome);

        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Pessoa> pesquisarPorId(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pessoa adicionar(@RequestBody Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
