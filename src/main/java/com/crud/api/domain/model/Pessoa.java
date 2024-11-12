package com.crud.api.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @Column(name = "sobrenome")
    private String sobreNome;

    private String idade;
    private String rg;
    private String cpf;

    @Column(name = "datanasc")
    private String dataNascimento;

    private String telefone;
    private String email;

    @Column(name = "estadocivil")
    private String estadoCivil;

    private String escolaridade;
    private String profissao;
}
