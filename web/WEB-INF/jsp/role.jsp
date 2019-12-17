<%--
  Created by IntelliJ IDEA.
  User: 郑悦恺
  Date: 2019/12/4
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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

<div id='updateDiv' style="display : none">

    <div style="width: 80%; margin: 20px auto">
        <form class="layui-form layui-form-pane" lay-filter="dataFrm2" id="dataFrm2">

            <div class="layui-form-item" style="display: none">
                <label class="layui-form-label">ID</label>
                <div class="layui-input-block">
                    <input type="text" readonly="readonly" name="r_id" autocomplete="off" placeholder="请输入"
                           class="layui-input">
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">职位</label>
                <div class="layui-input-block">
                    <input type="text" name="r_name" autocomplete="off" lay-verify="required" placeholder="请输入"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                    <input type="text" name="desc" autocomplete="off" lay-verify="required" placeholder="请输入"
                           class="layui-input">
                </div>
            </div>

            <%--<div class="layui-form-item">--%>
            <%--<label class="layui-form-label">权限</label>--%>
            <%--<div class="layui-input-block">--%>
            <%--<select id="class_name" name="class_name" lay-search="" lay-verify="required"--%>
            <%--lay-filter="class_name">--%>
            <%--</select>--%>
            <%--</div>--%>
            <%--</div>--%>

            <div class="layui-form-item">
                <label class="layui-form-label">权限</label>
                <div id="checkboxs" class="layui-input-block">
                    <%--<input type="checkbox" name="like[write]" title="写作">--%>
                    <%--<input type="checkbox" name="like[read]" title="阅读" checked="">--%>
                    <%--<input type="checkbox" name="like[game]" title="游戏">--%>
                </div>
            </div>


            <div class="layui-form-item">
                <button class="layui-btn" lay-submit="" lay-filter="doSubmit2">提交</button>
            </div>
        </form>
    </div>


</div>

<table class="layui-hide" id="test" lay-filter="test"></table>
<%--表格--%>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>--%>
        <%--<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>--%>
        <button class="layui-btn layui-btn-sm" lay-event="addStu">添加</button>
        <%--<button class="layui-btn layui-btn-sm" lay-event="addStu">查找</button>--%>
    </div>
</script>

<%--操作--%>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


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
            , url: '/SSM12/role/selectAll'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: false
            , title: '教师数据表'
            // , cellMinWidth: 160 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            , cols: [[
                {field: 'r_id', align: 'center', title: 'r_id', fixed: 'left', unresize: true, sort: true}
                , {field: 'r_name', align: 'center', title: '职位',}
                , {field: 'desc', align: 'center', title: '备注'}
                , {fixed: 'right', title: '操作', align: 'center', toolbar: '#barDemo', width: 150}
            ]]
            // , page: true
        });
        // //动态添加下拉框
        // $.ajax({
        //     url: 'student_select',
        //     dataType: 'json',
        //     // type:'post',
        //     success: function (data) {
        //         // console.log("获取成功");
        //         // console.log(data);
        //         $("#class_name").append(new Option("请选择班级", ""));
        //         $.each(data, function (index, item) {
        //             // console.log(item);
        //             //option  第一个参数是页面显示的值，第二个参数是传递到后台的值
        //             $('#class_name').append(new Option(item.name, item.id));//往下拉菜单里添加元素
        //             //设置value（这个值就可以是在更新的时候后台传递到前台的值）为2的值为默认选中
        //             // $('#selectId').val(2);
        //         })
        //         // form.render(); //更新全部表单内容
        //         form.render('select'); //刷新表单select选择框渲染
        //     }
        // });


        //动态加载
        $.ajax({
            url: '/SSM12/list/select',
            dataType: 'json',
            // type:'post',
            success: function (data) {
                console.log("获取成功");
                console.log(data);
                // $("#class_name").append(new Option("请选择班级", ""));
                $.each(data, function (index, item) {
                    // console.log(item);
                    //option  第一个参数是页面显示的值，第二个参数是传递到后台的值
                    // $('#class_name').append(new Option(item.name, item.id));//往下拉菜单里添加元素
                    //设置value（这个值就可以是在更新的时候后台传递到前台的值）为2的值为默认选中
                    // $('#selectId').val(2);

                    $('#checkboxs').append('<input  type="checkbox" value="' + item.id + '" id="check" name="' + item.id + '" title="' + item.name + '">');

                });
                form.render()//刷新表单select选择框渲染
            }
        });
        //头工具栏事件
        table.on('toolbar(test)', function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'getCheckData':
                    var data = checkStatus.data;
                    layer.alert(JSON.stringify(data));
                    break;
                case 'getCheckLength':
                    var data = checkStatus.data;
                    layer.msg('选中了：' + data.length + ' 个');
                    break;
                case 'isAll':
                    layer.msg(checkStatus.isAll ? '全选' : '未全选');
                    break;
                case 'addStu':
                    console.log("add");
                    openAddUser();
                    break;
                //自定义头工具栏右侧图标 - 提示
                case 'LAYTABLE_TIPS':
                    layer.alert('这是工具栏右侧自定义的一个图标按钮');
                    break;
            }
        });
        var mainIndex;

        //打开添加页面
        function openAddUser() {
            mainIndex = layer.open({
                type: 1,
                title: '添加职位',
                content: $("#updateDiv"),
                area: ['600px', '300px'],
                success: function (index) {
                    //清空表单数据
                    $("#dataFrm2")[0].reset();

                    $("input#check").each(function (i) {
                        $(this).attr('checked', false);
                    });


                    // $("#class_name").each(function () {
                    //     // this代表的是<option></option>，对option再进行遍历
                    //     $(this).children("option").each(function () {
                    //         $(this).attr("selected", false);
                    //         layui.form.render("select");
                    //     });
                    // });
                    // $("#department_name").each(function () {
                    //     // this代表的是<option></option>，对option再进行遍历
                    //     $(this).children("option").each(function () {
                    //         $(this).attr("selected", false);
                    //         layui.form.render("select");
                    //     });
                    // });
                    // layui.form.render("select");

                    // url="user/addUser.action";
                }
            });
        }

        // //edit
        // table.on('edit(test)', function (obj) { //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
        //     console.log(obj.value); //得到修改后的值
        //     console.log(obj.field); //当前编辑的字段名
        //     var value = obj.value;
        //     // console.log(obj.data); //所在行的所有相关数据
        //     console.log(obj.data.s_id); //所在行的所有相关数据
        //     var id = obj.data.s_id;
        //     $.post("update_name", {
        //         s_name: value, s_id: id
        //     }, function (resout) {
        //         console.log(resout);
        //     })
        // });

        // //查询
        // form.on('submit(doSearch)', function (data) {
        //     // layer.msg(JSON.stringify(data.field));//表格数据序列化
        //     var formData = data.field;
        //     // console.log(formData);
        //     // console.log(formData.url);
        //     var name = formData.username,
        //         url = formData.url,
        //
        //         icon = formData.icon,
        //         parent_id = formData.parent_id;
        //     //数据表格重载
        //     table.reload('tableReload', {
        //         page: {
        //             curr: 1 //重新从第 1 页开始
        //         }
        //         , where: {//这里传参  向后台
        //             name: name
        //         }
        //         , url: 'teacher_search'//后台做模糊搜索接口路径
        //         , method: 'post'
        //     });
        //     return false;//false：阻止表单跳转  true：表单跳转
        // });

        //监听行工具事件
        table.on('tool(test)', function (obj) {
            var data = obj.data;
            if (obj.event === 'del') {
                layer.confirm('真的删除么' + data.r_id, function (index) {
                    $.post("/SSM12/role/delete", {r_id: data.r_id}
                        , function (result) {
                            if (result.code == 0) {
                                layer.msg(result.msg);
                                obj.del();
                            } else {
                                layer.msg(result.msg);
                            }
                        }
                    );
                    layer.close(index);
                });
            } else if (obj.event === 'edit') {
                openUpdateUser(data);
            }
        });
        // var department_name;
        // var class_name;
        function openUpdateUser(data) {
            mainIndex = layer.open({
                type: 1,
                title: '修改信息',
                content: $("#updateDiv"),
                area: ['600px', '300px'],
                success: function (index) {

                    $("input#check").each(function (i) {
                        $(this).attr('checked', false);
                    });


                    form.val("dataFrm2", data);
                    console.log(data);
                    $.post("/SSM12/role/find", data, function (data) {
                        console.log(data);
                        $("input#check").each(function (i) {
                            var val = $(this).val();
                            var ss = $(this);
                            $(data).each(function (t, m) {
                                console.log(m + "-------------" + val);
                                console.log(m == val);
                                if (m == val) {
                                    ss.attr('checked', true);
                                }
                            })
                        });
                        form.render();
                    });


                    layui.form.render();


                }
            });
        }


        //更新/或添加
        form.on("submit(doSubmit2)", function (obj) {
            //序列化表单数据
            // console.log();
            // var params = $("#dataFrm2").serialize();
            // console.log(params);
            console.log(obj.field);
            var value = obj.field;
            var ids = [];
            $("input:checked").each(function (i) {
                ids.push($(this).val());
            });
            if (ids.length == 0) {
                ids.push(0)
            }
            var goto = {
                r_id: value.r_id,
                r_name: value.r_name,
                desc: value.desc,
                ids: ids
            }
            console.log(goto);
            if (goto.r_id == null || goto.r_id === "") {
                goto.r_id = -1;
                $.post("../role/insert", goto, function (result) {
                    layer.msg("更新成功", {
                        icon: 1,
                        time: 3000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        tableIns.reload();
                    });
                })
            } else {
                $.post("../role/update", goto, function (result) {
                    layer.msg(result, {
                        icon: 1,
                        time: 3000 //2秒关闭（如果不配置，默认是3秒）
                    }, function () {
                        tableIns.reload();
                    });
                    //关闭弹出层
                    // layer.close(mainIndex);
                    //刷新数据 表格
                })
            }

        });

    });
</script>

</body>
</html>