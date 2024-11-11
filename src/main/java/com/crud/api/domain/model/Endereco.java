package com.crud.api.domain.model;

import lombok.Data;

@Data
public class Endereco {

    String tipo;
    String nome;
    String numero;
    String bairro;
    String cidade;
    String Estado;
    String cep;
    String UF;
    String pontoRef;
}
