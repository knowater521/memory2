<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE HTML>
<html>
<head>
	<meta charset="utf-8">
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="stylesheet" type="text/css" href="${basePath }/static/HUI/h-ui/css/H-ui.min.css" />
	<link rel="stylesheet" type="text/css" href="${basePath }/static/HUI/h-ui.admin/css/H-ui.admin.css" />
	<link rel="stylesheet" type="text/css" href="${basePath }/static/HUI/lib/Hui-iconfont/1.0.8/iconfont.css" />
	<link rel="stylesheet" type="text/css" href="${basePath }/static/HUI/h-ui.admin/skin/default/skin.css" id="skin" />
	<link rel="stylesheet" type="text/css" href="${basePath }/static/HUI/h-ui.admin/css/style.css" />
	<title>前台用户列表</title>
</head>
<body>
<nav class="breadcrumb">
	<i class="Hui-iconfont">&#xe67f;</i> ${pathTitle}
	<a class="btn btn-success radius size-MINI r mr-20" id="refreshList" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a>
</nav>
<div class="pd-20">
	<div class="text-c">
		<c:if test="${map.size()>0}">
			<span class="select-box inline">
				<select name="searchdeAttribute" id="searchdeAttribute" class="select">
					<c:forEach items="${map}" var="entry">
						<option value="${entry.key}" >${entry.value}</option>
					</c:forEach>
				</select>
			</span>
			<input type="text" id="searchdetail" class="input-text" style="width:250px" placeholder="请输入" name="">
			<button type="button" class="btn btn-success" id="searchBtn" name=""><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
		</c:if>
	</div>
	<table id="cckj_datatable" class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="7" class="text-c">前台用户列表</th>
			</tr>
			<tr class="text-c">
				<th width="30">序号</th>
				<th width="30">名称</th>
				<th width="30">是否启用</th>
				<th width="30">创建时间</th>
				<th width="120">操作</th>
			</tr>
		</thead>
	</table>
</div>
<%@include file="../../../basics/footer.jsp"%>
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${basePath }/static/HUI/js/myhuijs.js"></script>
<script type="text/javascript" src="${basePath }/static/HUI/lib/datatables/1.10.0/jquery.dataTables.js"></script>
<script type="text/javascript">
    var table;
    inittable();
    //初始页面
    function inittable(){
        table = $('#cckj_datatable').dataTable({
            "info":true,
            "searching":false,
            "lengthChange":true,
            "serverSide":true,
            "pageLength": 10,
            "oLanguage" : {
                "sLengthMenu": "每页显示 _MENU_ 条记录",
                "sZeroRecords": "抱歉， 没有找到",
                "sInfo": "从 _START_ 到 _END_ /共 _TOTAL_ 条数据",
                "sInfoEmpty": "没有数据",
                "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
                "sZeroRecords": "没有检索到数据",
                "sSearch": "名称:",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "前一页",
                    "sNext": "后一页",
                    "sLast": "尾页"
                }
            },
            "ajax":{
                "url":'${basePath }/${url}/listJson',
                "type":"GET",
                "data": function ( d ) {
                    return $.extend( {}, d, {
                        "searchdetail": $('#searchdetail').val(),
                        "searchdeAttribute": $('#searchdeAttribute').val()
                    } );
                }
            },
            "columns":[
                {"data":"id","orderable":false,"className":"td-manage text-c"},
                {"data":"name","orderable":false,"className":"td-manage text-c"},
                {"data":"id",
                    "className":"td-manage text-c","orderable":false,
                    "render":function(data, type, full, meta){
                        var str = "";
                        <shiro:hasPermission name="/${url}/changeUseFlag">
                        if(full.useFlag==1){
                            str+="已启用";
                            str +="<a title='禁用' href='javascript:;' onclick=\"changeUseFlag(this,"+data+",0,'${basePath}/${url}/changeUseFlag?id="+data+"')\" class='btn btn-primary radius size-MINI size-MINI' style='margin-left:10px;'>";
                            str +="<i class='Hui-iconfont'>&#xe605;</i>禁用</a>";
                        }else {
                            str+="已禁用";
                            str +="<a title='启用' href='javascript:;' onclick=\"changeUseFlag(this,"+data+",1,'${basePath}/${url}/changeUseFlag?id="+data+"')\" class='btn btn-primary radius size-MINI size-MINI' style='margin-left:10px;'>";
                            str +="<i class='Hui-iconfont'>&#xe60e;</i>启用</a>";
                        }
                        </shiro:hasPermission>
                        return str;
                    }
                },
				{"data":"createTime",
                    "className":"td-manage text-c","orderable":false,
                    "render":function(data, type, full, meta){
                        return new Date(data).Format("yyyy-MM-dd hh:mm:ss");
                    }
                },
                {"data":"id",
                    "className":"td-manage text-c","orderable":false,
                    "render":function(data, type, full, meta){
                        var str = "";
                        <shiro:hasPermission name="/${url}/distribution">
                        str +="<a title='指定角色' href='javascript:;' onclick=\"object_show('指定角色','${basePath}/${url}/distribution?userId="+data+"',500,500)\" class='btn btn-primary radius size-MINI size-MINI' style='margin-left:10px;'>";
                        str +="<i class='Hui-iconfont'>&#xe6df;</i>指定角色</a>";
                        </shiro:hasPermission>
                        return str;
                    }
                }
            ]
        });
    }
    function changeUseFlag(e,id,flag,url) {

        var str="";
        <shiro:hasPermission name="/${url}/changeUseFlag">
        if (flag==1){
            str+="已启用";
            str +="<a title='禁用' href='javascript:;' onclick=\"changeUseFlag(this,"+id+",0,'${basePath}/${url}/changeUseFlag?id="+id+"')\" class='btn btn-primary radius size-MINI size-MINI' style='margin-left:10px;'>";
            str +="<i class='Hui-iconfont'>&#xe605;</i>禁用</a>";
		}else {
            str+="已禁用";
            str +="<a title='启用' href='javascript:;' onclick=\"changeUseFlag(this,"+id+",1,'${basePath}/${url}/changeUseFlag?id="+id+"')\" class='btn btn-primary radius size-MINI size-MINI' style='margin-left:10px;'>";
            str +="<i class='Hui-iconfont'>&#xe60e;</i>启用</a>";
		}
        </shiro:hasPermission>
        $.ajax( {
            url:url,// 跳转到 action
            type:'post',
            cache:false,
            success:function(data) {
                if(data.resultCode =="200" ){
                    layer.msg(data.data,{icon:1,time:1000});
                    $(e).parents("td").html(str);
                }else{
                    layer.msg(data.resultMsg,{icon:5,time:1500});
                }
            },
            error : function(data) {
                layer.msg(data.resultMsg,{icon:5,time:1500});
            }
        });
    }
</script>
</body>
</html>
