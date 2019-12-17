<%--
  Created by IntelliJ IDEA.
  User: 郑悦恺
  Date: 2019/12/16
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
    <script src="<%=request.getContextPath()%>/resources/jquery-3.4.1.js" charset="utf-8"></script>
</head>
<body>


<div class="layui-card-body ">
    <form class="layui-form layui-col-space5" method="post">
        <div class="layui-inline layui-show-xs-block">
            <input class="layui-input" autocomplete="off" placeholder="开始日" readonly name="start" id="start"
                   lay-key="1">
        </div>
        <div class="layui-inline layui-show-xs-block">
            <input class="layui-input" autocomplete="off" placeholder="截止日" readonly name="end" id="end" lay-key="2">
        </div>
        <div class="layui-inline layui-show-xs-block">
            <input type="text" name="name" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-inline layui-show-xs-block">
            <%--lay-submit=""  lay-filter="sreach"   --%>
            <button class="layui-btn" id="doSearch" lay-submit="" lay-filter="doSearch"><i class="layui-icon"></i>
            </button>
        </div>
    </form>
</div>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script src="<%=request.getContextPath()%>/resources/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use(['jquery', 'layer', 'form', 'table', 'laydate'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var laydate = layui.laydate;


        //绑定时间选择器
        laydate.render({
            elem: '#start'
        });
        laydate.render({
            elem: '#end'
        });


        var tableIns = table.render({
            elem: '#test'
            , id: 'tableReload'//重载数据表格
            , url: '/SSM12/manualsign/select'
            , title: '签到表'
            , cols: [[
                {field: 'm_id', align: 'center', title: 'ID', fixed: 'left', unresize: true, sort: true}
                , {
                    field: 'come_time', align: 'center', title: '签到时间',
                    templet: "<div>{{layui.util.toDateString(d.come_time, 'yyyy年MM月dd日 HH:mm:ss')}}</div>"
                }

                , {field: 'user_id', align: 'center', title: '员工ID'}
                , {field: 'm_desc', align: 'center', title: '备注'}
            ]]
            , page: true
        });
        //查询
        form.on('submit(doSearch)', function (data) {
            var formData = data.field;
            console.log(formData);

            //数据表格重载
            table.reload('tableReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: formData
                , url: '/SSM12/manualsign/select'//后台做模糊搜索接口路径
                , method: 'post'
            });
            return false;//false：阻止表单跳转  true：表单跳转
        });
    });
</script>

</body>


<script>


</script>


</html>
