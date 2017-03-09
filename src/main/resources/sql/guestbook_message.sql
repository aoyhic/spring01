
-- sequence 생성
--시퀀스는 유일한 번호를 만들어내는 객체. 프라이머리키로 사용하기 위해 시퀀스 만들어냄. 
drop SEQUENCE message_id_seq;
create sequence message_id_seq START with 10000;
-- 순번발급기 같은 것.1개씩 늘어나는 역할을 한다. (채번이라고 함)
select message_id_seq.nextval from dual;


-- table 생성
drop table guestbook_message;

create table guestbook_message(
	message_id number PRIMARY key, 
	guest_name varchar2(50 char) not null,
	password 	varchar2(10 char) not null,
	message 	long not null
	);
	
select * from guestbook_message;	



-- ctrl+/ 쓰면 주석나옴
insert into GUESTBOOK_MESSAGE
values
(message_id_seq.nextval, 'xxx', '1234', '계속 늘어난다?');