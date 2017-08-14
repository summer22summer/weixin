<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.text.*,java.util.*"%>
<%@ include file="head.jsp" %>

<script type="text/javascript">
	$(function(){
		$('#manTypeTable').edatagrid({
			url:'showUser.action',   //查询时加载的URL
			pagination:true,   //显示分页
			pageSize:10,       //默认分页的条数
			fitColumns:true,   //自适应列
			fit:true,   	   //自动补全
			title:"用户管理",
			idField:"openid",		//标识，会记录我们选中的一行的ID，不一定是ID，通常是主键
			rownumbers:"true",	 //显示行号
			nowrap:"true",		//不换行显示
			sortName:"uid",		//排序的列 这个参数会传到后台的servlet上，所以要有后台对应的接收
			sortOrder:"desc",   //排序方式
			singleSelect:true,
			//以上的四种增删改查操作，只要失败，都会回调这个onError
			onError:function(a,b){
				$.messager.alert("错误","操作失败");
			}, 
			columns:[[{
				field:'uid',
				title:'用户编号',
				width:15,
				align:'center',
				hidden:'true'
			},{
				field:'nickname',
				title:'昵称',
				width:50,
				align:'center'
			},{
				field:'headimgurl',
				title:'头像',
				align:'center',
				width:50,
				formatter:function(value,row){
				     var str = "";
				     if(value!="" || value!=null){
				     str = "<img style=\"height: 50px;width: 50px;\" src=\""+value+"\"/>";
				     return str;
				     }
				}
			},{
				field:'sex',
				title:'性别',
				width:10,
				align:'center',
				formatter:function(value,row){
				     if(value==1){
						return "男";
				     }else if(value==2){
						return "女";
				     }else{
				    	 return"未知";
				     }
				}
			},{
				field:'country',
				title:'国家',
				width:20,
				align:'center'
			},{
				field:'province',
				title:'省份',
				width:20,
				align:'center'
			},{
				field:'city',
				title:'城市',
				width:20,
				align:'center'
			},{
				field:'subscribetime',
				title:'关注时间',
				width:50,
				align:'center',
				formatter:function(value,row){
					var time=new Date(parseInt(value) * 1000).toLocaleString().replace(/年|月/g, "-").replace(/日/g, " ")
					return time; 
				}
			}]]
		});		
	});
</script>
<title>用户管理</title>
</head>
<body>

	<table id="manTypeTable"></table>

</body>
</html>