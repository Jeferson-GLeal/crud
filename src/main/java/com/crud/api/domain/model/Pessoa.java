package com.crud.api.domain.model;

import com.crud.api.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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
    @Size(min = 5, max = 60)
    private String nome;

    @Size(min = 5, max = 60)
    @Column(name = "sobrenome")
    private String sobreNome;

    @Size(min = 1, max = 2)
    private String idade;

    @Pattern(regexp = "[0-9]{9}")
    private String rg;

    @Pattern(regexp = "[0-9]{11}")
    private String cpf;

    @Pattern(regexp = "[0-9]{8}")
    @Column(name = "datanasc")
    private String dataNascimento;

    @Pattern(regexp = "[0-9]{11}")
    private String telefone;

    @Email
    private String email;

    @Column(name = "estadocivil")
    private String estadoCivil;

    @Size(min = 5, max = 60)
    private String escolaridade;

    @Size(min = 5, max = 60)
    private String profissao;
}
