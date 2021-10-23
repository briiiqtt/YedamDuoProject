drop table product ;

-------------------------------------------------------------

create table product (  
id varchar2(100)  primary key,
brand varchar2(100) ,
name varchar2(100) ,
originprice number ,
offprice number ,
likeit number ,
filename varchar2(100)
) ;

insert into id_repository2 values(7,'product') ; -- 초기값

-------------------------------------------------------------

insert into product values (1, 'XERO' , 'Deep One Tuck Sweat Pants [grey]' , 39000 , 33000 , 4 , '1.png') ;
insert into product values (2, 'TOFFEE' , '2WAY 스웻 후드 집업 [MELANGE GREY]' , 45000 , 39000 , 5 , '2.jpg') ;
insert into product values (3, 'ROMANTIC MOVE' , '뉴탐페레 첼시 부츠 R17M077 (블랙)' , 198000 , 175000 , 2 , '3.png') ;
insert into product values (4, 'PARTIMENTO' , '[비건 레더] 필드 자켓 블랙 ' , 111000 , 99000 , 3 , '4.jpg') ;
insert into product values (5, 'BBND' , '댄디로퍼 무광 러버솔' , 69000 , 60000 , 4 , '5.jpg') ;
insert into product values (6, 'CONVERSE' , '척 70 클래식 블랙 162058C' , 95000 , 89000 , 4 , '6.png') ;
insert into product values (7, 'LAFUDGESTORE' , '오리지널 M-1965 피쉬테일 파카_Original Khaki' , 138000 , 109000 , 4 , '7.png') ;


select * from product ;
select * from id_repository2 ;

commit ;