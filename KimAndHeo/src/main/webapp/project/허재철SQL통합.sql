drop table members ;
drop table cart ;
drop table product ;
drop table epilogue ;
drop table id_repository2 ;

--------------------------테이블삭제-----------------------

-- 회원 테이블
create table members (
id varchar2(50) primary key,
pw varchar2(50) not null,
name varchar2(50),
email varchar2(50));

-- 장바구니 테이블
create table cart (
id varchar2(100) ,
name varchar2(100) ,
price number ,
psize varchar2(100) ,
count number ,
deliveryfee number ,
img varchar2(100)
) ;

-- 제품정보 테이블
create table product (  
id varchar2(100) ,
brand varchar2(100) ,
name varchar2(100) ,
originprice number ,
offprice number ,
likeit number ,
filename varchar2(100)
) ;

-- 이용후기 테이블
create table epilogue (
id varchar2(100) ,
name varchar2(100) ,
content varchar2(100)
) ;

-- id 테이블
create table id_repository2 (
value   number ,
name    varchar2(100)
) ;

--------------------------테이블생성-----------------------

-- 어드민 계정 생성
insert into members values ( 'admin' , 'admin' , 'admin' , 'admin@email.com' ) ;

-- 제품 정보 생성
insert into product values (1, 'XERO' , 'Deep One Tuck Sweat Pants [grey]' , 39000 , 33000 , 4 , '1.png') ;
insert into product values (2, 'TOFFEE' , '2WAY 스웻 후드 집업 [MELANGE GREY]' , 45000 , 39000 , 5 , '2.jpg') ;
insert into product values (3, 'ROMANTIC MOVE' , '뉴탐페레 첼시 부츠 R17M077 (블랙)' , 198000 , 175000 , 2 , '3.png') ;
insert into product values (4, 'PARTIMENTO' , '[비건 레더] 필드 자켓 블랙 ' , 111000 , 99000 , 3 , '4.jpg') ;
insert into product values (5, 'BBND' , '댄디로퍼 무광 러버솔' , 69000 , 60000 , 4 , '5.jpg') ;
insert into product values (6, 'CONVERSE' , '척 70 클래식 블랙 162058C' , 95000 , 89000 , 4 , '6.png') ;
insert into product values (7, 'LAFUDGESTORE' , '오리지널 M-1965 피쉬테일 파카_Original Khaki' , 138000 , 109000 , 4 , '7.png') ;

-- id 초기값 생성
insert into id_repository2 values(0,'cart') ; -- 초기값
insert into id_repository2 values(7,'product') ; -- 초기값
insert into id_repository2 values(0,'epilogue') ; -- 초기값

--------------------------기초 데이터 생성-----------------------

select * from members ;
select * from cart ;
select * from product ;
select * from epilogue ;
select * from id_repository2 ;

commit ;
