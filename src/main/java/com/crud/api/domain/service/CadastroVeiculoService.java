package com.crud.api.domain.service;

import com.crud.api.domain.exception.CadastroException;
import com.crud.api.domain.model.Pessoa;
import com.crud.api.domain.model.Status;
import com.crud.api.domain.model.Veiculo;
import com.crud.api.domain.model.repository.PessoaRepository;
import com.crud.api.domain.model.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.ssl.PemSslBundleProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CadastroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private  CadastroPessoaService cadastroPessoaService;

    @Transactional
    public Veiculo cadastrar(Veiculo novoVeiculo) {
        if (novoVeiculo.getId() != null) {
            throw new CadastroException("Veiculo a ser cadastrado não deve possuir código!");
        }

        boolean placaEmUso = veiculoRepository.findByPlaca(novoVeiculo.getPlaca())
                .filter(veiculo -> !veiculo.equals(novoVeiculo))
                .isPresent();

        if (placaEmUso){
            throw new CadastroException("Já existe um veiculo cadastrado com esta placa!");
        }

        Pessoa pessoa = cadastroPessoaService.buscar(novoVeiculo.getPessoa().getId());

        novoVeiculo.setPessoa(pessoa);
        novoVeiculo.setStatus(Status.EM_USO);
        novoVeiculo.setDataCadastro(LocalDateTime.now());
        return veiculoRepository.save(novoVeiculo);
    }
}
