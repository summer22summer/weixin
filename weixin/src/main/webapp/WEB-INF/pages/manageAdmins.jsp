<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>

<script type="text/javascript">
	$(function(){
		$('#manTypeTable').edatagrid({
			url:'findAdmins.action',   //查询时加载的URL
			pagination:true,   //显示分页
			pageSize:10,       //默认分页的条数
			fitColumns:true,   //自适应列
			fit:true,   	   //自动补全
			title:"角色管理",
			idField:"aid",		//标识，会记录我们选中的一行的ID，不一定是ID，通常是主键
			rownumbers:"true",	 //显示行号
			nowrap:"true",		//不换行显示
			sortName:"aid",		//排序的列 这个参数会传到后台的servlet上，所以要有后台对应的接收
			sortOrder:"desc",   //排序方式
			singleSelect:true,
			//以上的四种增删改查操作，只要失败，都会回调这个onError
			onError:function(a,b){
				$.messager.alert("错误","操作失败");
			},
			columns:[[{
				field:'aid',
				title:'管理员编号',
				width:100,
				align:'center',
				hidden:'true'
			},{
				field:'aname',
				title:'管理员名称',
				width:100,
				align:'center'
			},{
				field:'apwd',
				title:'账户密码',
				width:100,
				align:'center'
			}]]
		});		
	});
</script>
<title>角色管理</title>
</head>
<body>

	<table id="manTypeTable"></table>

</body>
</html>