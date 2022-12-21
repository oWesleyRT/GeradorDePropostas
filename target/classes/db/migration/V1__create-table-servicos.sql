create table servicos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    valorintegral double not null,
    valorcomdesconto double not null,

    primary key(id)

);