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

    @GetMapping
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

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId, @RequestBody Pessoa pessoa) {

        if (!pessoaRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(pessoaId);
        Pessoa pessoaAtualizada = pessoaRepository.save(pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Void> excluir(@PathVariable Long pessoaId) {

        if (!pessoaRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }
        pessoaRepository.deleteById(pessoaId);
        return ResponseEntity.noContent().build();
    }
}
