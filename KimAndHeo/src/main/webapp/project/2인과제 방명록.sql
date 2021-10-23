drop table epilogue ;

-------------------------------------------------------------

create table epilogue (
id varchar2(100) ,
name varchar2(100) ,
content varchar2(100)
) ;

insert into id_repository2 values(0,'epilogue') ; -- 초기값

-------------------------------------------------------------

select * from epilogue ;
select * from id_repository2 ;

commit ;