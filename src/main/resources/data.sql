--插入管理员类型数据
insert into admintype(regtime,typename) values(now(),'admin');
insert into admintype(regtime,typename) values(now(),'root');


--插入管理员数据
insert into admin(aname,apwd,telephone,regtime,lastupdatetime,typeid)
	values('a','a','18273474739',now(),null,1);
insert into admin(aname,apwd,telephone,regtime,lastupdatetime,typeid)
	values('b','b','18711183991',now(),null,2);