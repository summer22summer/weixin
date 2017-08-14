--插入管理员类型数据
insert into admintype(regtime,typename) values(now(),'admin');
insert into admintype(regtime,typename) values(now(),'root');


--插入管理员数据
insert into admin(aname,apwd,telephone,regtime,lastupdatetime,typeid)
	values('a','a','18273474739',now(),null,1);
insert into admin(aname,apwd,telephone,regtime,lastupdatetime,typeid)
	values('b','b','18711183991',now(),null,2);
update admin set apwd='6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2'

	select 
			aid ,aname,apwd,telephone,regtime,lastupdatetime,typeid
		from admin
			where aname='a' and apwd='6f9b0a55df8ac28564cb9f63a10be8af6ab3f7c2'

--插入用户数据（测试
insert into userinfo(nickname,headImgUrl ,sex,country,province,city,
	language ,subscribeTime,subscribe,userRemarks,openId,wait2,wait3)
	values('用户1','http://img.mukewang.com/58febdd20001fb4505400960.jpg',
	'女','中国','湖南','衡阳','zh_CN',now(),1,'测试号','fgegeggewre','','')
	
select
			userid,nickname,headImgUrl,sex,country,province,
			city,language,subscribeTime,subscribe,userRemarks,openId
		from userinfo