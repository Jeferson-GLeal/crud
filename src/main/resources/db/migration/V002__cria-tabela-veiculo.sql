create table veiculo(
                        id bigint not null auto_increment,
                        pessoa_id bigint not null,
                        marca varchar(20) not null,
                        modelo varchar(20) not null,
                        placa varchar(7) not null,
                        status varchar(20) not null,
                        data_cadastro datetime not null,
                        data_apreensao datetime,

                        primary key (id)
);

alter table veiculo add constraint fk_veiculo_proprietario
    foreign key (pessoa_id) references pessoas (id);

alter table veiculo add constraint uk_veiculo unique (placa)