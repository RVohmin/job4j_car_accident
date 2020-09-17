drop table if exists status;
create table if not exists status
(
    id   serial primary key,
    name varchar(20) not null unique
);
insert into status (name)
values ('Принята');
insert into status (name)
values ('Отклонена');
insert into status (name)
values ('Завершена');
select *
from status;
-- таблица с именами файлов фото происшествий
drop table if exists photo;
create table if not exists photo
(
    id   serial primary key,
    file varchar(200) not null
);
drop table if exists accident;
create table if not exists accident
(
    id        serial primary key,
    name      varchar(100)  not null,
    address   varchar(200)  not null,
    carNumber varchar(20)   not null,
    describe  varchar(2000) not null,
    filename  varchar(200)  not null,
    statusID  int           not null references status (id)
);
select *
from accident;
drop table if exists authorities;
CREATE TABLE if not exists authorities
(
    id        serial primary key,
    authority VARCHAR(50) NOT NULL unique
);
insert into authorities (authority)
values ('ROLE_ADMIN');
insert into authorities (authority)
values ('ROLE_USER');

drop table if exists users;
CREATE TABLE if not exists users
(
    id           serial primary key,
    username     VARCHAR(50)  NOT NULL unique,
    password     VARCHAR(100) NOT NULL,
    enabled      boolean default true,
    authority_id int          not null references authorities (id)
);
insert into users (username, password, authority_id)
values ('root', '$2a$10$3.Qb.xoL7q7ZAmYJJjh9iucsS6W29/MpYQGZ27J5JrCC0Zu7WpMqC',
        (select id from authorities where authority = 'ROLE_ADMIN'));
-- drop table authorities;
-- drop table users;

select *
from users;
