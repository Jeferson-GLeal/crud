create table pessoas(
                        id           bigint      not null auto_increment,
                        nome         varchar(60) not null,
                        sobrenome    varchar(60) not null,
                        idade        varchar(2)  not null,
                        rg           varchar(12)  not null,
                        cpf          varchar(14) not null,
                        datanasc     varchar(10)  not null,
                        telefone     varchar(15) not null,
                        email        varchar(35),
                        estadocivil  varchar(20) not null,
                        escolaridade varchar(50) not null,
                        profissao    varchar(50) not null,

                        primary key (id)

);
    alter table pessoas
    add constraint uk_pessoas unique (cpf);