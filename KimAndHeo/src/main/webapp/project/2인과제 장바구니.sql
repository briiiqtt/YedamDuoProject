drop table cart ;
drop table id_repository2 ;

-------------------------------------------------------------

create table cart (
id varchar2(100) ,
name varchar2(100) ,
price number ,
psize varchar2(100) ,
count number ,
deliveryfee number ,
img varchar2(100)
) ;

create table id_repository2 (
value   number ,
name    varchar2(100)
) ;

insert into id_repository2 values(0,'cart') ; -- 초기값

-------------------------------------------------------------

select * from cart ;
select * from id_repository2 ;

commit ;