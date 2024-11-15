package com.crud.api.controller;

import com.crud.api.domain.exception.CadastroException;
import com.crud.api.domain.model.Veiculo;
import com.crud.api.domain.model.repository.VeiculoRepository;
import com.crud.api.domain.service.CadastroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {


    private VeiculoRepository veiculoRepository;
    private final CadastroVeiculoService cadastroVeiculoService;

    @GetMapping
    public List<Veiculo> listar() {

        return veiculoRepository.findAll();
    }

    @GetMapping("/{veiculoId}")
    public ResponseEntity<Veiculo> pesquisar(@PathVariable Long veiculoId){
        return  veiculoRepository.findById(veiculoId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo cadastrar(@Valid @RequestBody Veiculo veiculo){
        return cadastroVeiculoService.cadastrar(veiculo);
    }

    @ExceptionHandler(CadastroException.class)
    public ResponseEntity<String> capturar (CadastroException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
