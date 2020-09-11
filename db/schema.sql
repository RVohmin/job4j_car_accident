drop table if exists accident ;
create table if not exists accident  (
    id serial primary key,
    name varchar(100) not null,
    address varchar(200) not null,
    carNumber int not null unique,
    describe varchar(2000) not null,
    photo text default null,
    status varchar(10) not null
);
select * from accident;