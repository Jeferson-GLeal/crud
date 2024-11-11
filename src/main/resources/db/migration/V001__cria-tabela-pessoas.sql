create table pessoas(
                        id           bigint      not null auto_increment,
                        nome         varchar(60) not null,
                        sobrenome    varchar(60) not null,
                        idade        varchar(2)  not null,
                        rg           varchar(9)  not null,
                        cpf          varchar(11) not null,
                        datanasc     varchar(8)  not null,
                        telefone     varchar(11) not null,
                        estadocivil  varchar(15) not null,
                        escolaridade varchar(50) not null,
                        profissao    varchar(30) not null,

                        primary key (id)

);
    alter table pessoas
    add constraint uk_pessoas unique (cpf);