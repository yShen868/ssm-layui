<%--
  Created by IntelliJ IDEA.
  User: 郑悦恺
  Date: 2019/12/3
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="x-admin-sm">
<head>
    <meta charset="UTF-8">
    <title>学生管理后台登录</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/font.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/login.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/xadmin.css">
    <%--<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/jquery-3.4.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/lib/layui/layui.js" charset="utf-8"></script>
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body class="login-bg">

<div class="login layui-anim layui-anim-up">
    <div class="message">管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form">
        <input name="u_name" placeholder="用户名" type="text" lay-verify="required" class="layui-input">
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码" type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20">
    </form>
</div>


<script>
    $(function () {

        function test() {
            // alert("测试");
            console.log(1);
            window.location.href = "/SSM12/list/list";
        }
        layui.use('form', function () {
            var form = layui.form;
            // layer.msg('玩命卖萌中', function(){
            //   //关闭后的操作
            //   });
            //监听提交

            form.on('submit(login)', function (data) {
                var admin = data.field;
                // var user = {user:admin};
                console.log(admin);
                // console.log(user);
                // $.ajax({
                //     url: "/SSM12/user/selectOne",
                //     type:'post',//method请求方式，get或者post
                //     dataType:'json',//预期服务器返回的数据类型
                //     data:{u_name:12312312312},//表格数据序列化 {name: value}
                //     contentType: "application/json; charset=utf-8",
                //     success:function(data) {
                //         console.log(data);
                //         if(data.code == 1){
                //             layer.alert('登录成功！！！',{icon:6});
                //             test();
                //         }else{
                //             layer.alert('账号或者密码错误！！！' + data.msg,{icon:6});
                //         }
                //         // 切换页面
                //     },
                //     error:function(){
                //         layer.alert('失败！！！',{icon:5});
                //     }
                // });

                $.post("/SSM12/user/selectOne", admin, function (data) {
                    if (data.code == 1) {
                        layer.alert('登录成功！！！', {icon: 6});
                        test();
                    } else {
                        layer.alert('账号或者密码错误！！！' + data.msg, {icon: 6});
                    }
                });
                return false;
            });


        });
    })
</script>
</body>
</html>