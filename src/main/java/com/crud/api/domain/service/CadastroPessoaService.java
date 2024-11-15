package com.crud.api.domain.service;

import com.crud.api.domain.exception.CadastroException;
import com.crud.api.domain.model.Pessoa;
import com.crud.api.domain.model.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroPessoaService {

    private final PessoaRepository pessoaRepository;

    public Pessoa buscar(Long pessoaID) {
        return pessoaRepository.findById(pessoaID)
                .orElseThrow(() -> new CadastroException("Pessoa não encontrada"));
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {

        boolean emailEmUso = pessoaRepository.findByEmail(pessoa.getEmail())
                .filter(p -> p.getEmail().equals(pessoa.getEmail()))
                .isPresent();

        if (emailEmUso) {
            throw new CadastroException("Já existe um cadastro com este endereço de email!");
        }
        return pessoaRepository.save(pessoa);
    }

    @Transactional
    public void excluir(Long pessoaId) {
        pessoaRepository.deleteById(pessoaId);
    }
}
