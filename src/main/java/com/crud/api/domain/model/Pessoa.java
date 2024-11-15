package com.crud.api.domain.model;

import com.crud.api.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pessoas")
public class Pessoa {

    @NotNull(groups = ValidationGroups.PessoaId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 60)
    private String nome;

    @NotBlank
    @Size(max = 60)
    @Column(name = "sobrenome")
    private String sobreNome;

    private String idade;
    private String rg;
    private String cpf;

    @Column(name = "datanasc")
    private String dataNascimento;

    @NotBlank
    @Size(max = 20)
    private String telefone;

    @Email
    private String email;

    @Column(name = "estadocivil")
    private String estadoCivil;

    private String escolaridade;
    private String profissao;
}
