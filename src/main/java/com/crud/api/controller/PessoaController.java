package com.crud.api.controller;

import com.crud.api.domain.exception.CadastroException;
import com.crud.api.domain.model.Pessoa;
import com.crud.api.domain.model.repository.PessoaRepository;
import com.crud.api.domain.service.CadastroPessoaService;
import jakarta.validation.Valid;
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

    private final CadastroPessoaService cadastroPessoaService;
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
    public Pessoa adicionar(@Valid @RequestBody Pessoa pessoa) {

        return cadastroPessoaService.salvar(pessoa);
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long pessoaId, @Valid @RequestBody Pessoa pessoa) {

        if (!pessoaRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }
        pessoa.setId(pessoaId);
        Pessoa pessoaAtualizada = cadastroPessoaService.salvar(pessoa);
        return ResponseEntity.ok(pessoaAtualizada);
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Void> excluir(@PathVariable Long pessoaId) {

        if (!pessoaRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }
        cadastroPessoaService.excluir(pessoaId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CadastroException.class)
    public ResponseEntity<String> capturar (CadastroException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
