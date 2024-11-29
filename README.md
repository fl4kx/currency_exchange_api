# 통화 환전 API

등록된 사용자와 통화 정보를 바탕으로 환전 신청과 조회, 취소 및 삭제가 가능한 API 입니다.

JPA 를 활용해 테이블의 연관 관계를 지정하고 중간 테이블을 생성해 환전 신청 정보를 관리할 수 있도록 구현했습니다.


## API 명세서

https://documenter.getpostman.com/view/39403184/2sAYBXCBMh

## ERD

![exchangeERD](https://github.com/user-attachments/assets/539ac3e3-1745-48c8-a651-4147e05e2110)

## SQL

create table user
(
	created_at datetime(6) null,
	id bigint auto_increment
		primary key,
	modified_at datetime(6) null,
	email varchar(255) null,
	name varchar(255) null
);

create table currency
(
	exchange_rate decimal(38,2) null,
	created_at datetime(6) null,
	id bigint auto_increment primary key,
	modified_at datetime(6) null,
	user_id bigint null,
	currency_name varchar(255) null,
	symbol varchar(255) null,
	foreign key (user_id) references user (id)
);

create table user_currency
(
	after_exchange decimal(38,2) null,
	before_exchange decimal(38,2) null,
	created_at datetime(6) null,
	currency_id bigint null,
	id bigint auto_increment primary key,
	modified_at datetime(6) null,
	user_id bigint null,
	status varchar(255) null,
	foreign key (currency_id) references currency (id),
	foreign key (user_id) references user (id)
);
