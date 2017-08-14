create database weixin;

select database()

--创建管理员表
create table admin(
   aid int primary key auto_increment,   
   aname varchar(50),
   apwd varchar(50),   
   telephone varchar(15),
   regtime date,
   lastupdatetime date,
   typeid int
);
select * from admin;

--创建管理员类型表
create table admintype(
	typeid int primary key auto_increment, 
   	regtime date,
	typename varchar(20)
);
select * from admintype;
alter table admin
	add constraint fk_typeid foreign key(typeid)
	REFERENCES admintype(typeid)

--创建用户信息表(从微信获取的用户信息
create table userinfo(
	userid int  primary key auto_increment, 
	nickname varchar(100) ,
	headImgUrl varchar(200),
	sex varchar(4),
	country varchar(200),
	province varchar(200),
	city varchar(200),
	language varchar(20),
	subscribeTime date,
	subscribe int,
	userRemarks varchar(200),
	openId varchar(200),
	wait2 varchar(200),
	wait3 varchar(200)
);	


drop table country


create table accesstoken(
	aid int  primary key auto_increment, ss
	 accesstoken varchar(200),
	 lastModifyTime datetime

);
insert into accesstoken(accesstoken,lastModifyTime) values('ooo',now())
select * from accesstoken
drop table accesstoken;
