drop table members ;

-------------------------------------------------------------

create table members (
id varchar2(50) primary key,
pw varchar2(50) not null,
name varchar2(50),
email varchar2(50));

select * from members ;

-- admin id
insert into members values ( 'admin' , 'admin' , 'admin' , 'admin@email.com' ) ;

-------------------------------------------------------------

select * from members ;

commit ;