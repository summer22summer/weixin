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