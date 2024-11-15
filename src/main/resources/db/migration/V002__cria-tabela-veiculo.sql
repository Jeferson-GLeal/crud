create table veiculo(
                        id bigint not null auto_increment,
                        pessoa_id bigint not null,
                        marca varchar(35) not null,
                        modelo varchar(50) not null,
                        versao varchar(50) not null,
                        cor varchar(30) not null,
                        transmissao varchar (20) not null,
                        ano varchar (4) not null,
                        placa varchar(8) not null,
                        status varchar(20) not null,
                        condutor varchar(10) not null,
                        data_cadastro datetime not null,
                        data_atualizacao datetime,

                        primary key (id)
);

alter table veiculo add constraint fk_veiculo_proprietario
    foreign key (pessoa_id) references pessoas (id);

alter table veiculo add constraint uk_veiculo unique (placa)