<%--
  Created by IntelliJ IDEA.
  User: Wu Haotian
  Date: 2019/10/20
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script language="JavaScript" src="js/jquery-1.12.4.js"></script>
    <script language="JavaScript">
        $(function () {
            ${result};
            var flag = false;

            $.post("getProducts", null, function (data) {
                for (var i = 0; i < data.length; i++) {
                    var option = "<option value='" + data[i].id + "'>" + data[i].productname + "</option>";
                    $("#sel").append(option);
                }
            }, "json");

            $("#quantity").blur(function () {
                var zz = /^[1-9]\d*$/;
                var sel = $("#sel").val();
                var qua = $("#quantity").val();
                if (!zz.test(qua)) {
                    alert("数量必须是大于0的整数！");
                    $("#quantity").val("");
                    return;
                }
                $.post("getQuantity", {"productid": sel}, function (data) {
                    var res = data.result;
                    if (qua > res) {
                        $("#sp").html("所选商品库存不足，库存量为" + res + "！");
                        flag = false;
                    } else {
                        $("#sp").html("库存充足");
                        flag = true;
                    }
                }, "json");
            });

            $("#for").submit(function () {
                if (0 == $("#sel").val()) {
                    alert("请选择出库商品！");
                    return false;
                }
                if ("" == $("#quantity").val().trim()) {
                    alert("请填写出库数量！");
                    return false;
                }
                if (false == flag) {
                    alert("库存数量不足！");
                    return false;
                }
                if ("" == $("#handler").val().trim()) {
                    alert("请填写经手人！");
                    return false;
                }
                return true;
            })
        });
    </script>
</head>
<body>
<center>
    <h1>商品出库</h1>
    <form action="addTakeout" method="post" id="for">
        <table>
            <tr>
                <td>出库商品：</td>
                <td>
                    <select name="productid" id="sel">
                        <option value="0">--请选择出库商品--</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>数量：</td>
                <td>
                    <input type="text" name="quantity" id="quantity">
                </td>
                <td>
                    <span id="sp" style="color: red"></span>
                </td>
            </tr>
            <tr>
                <td>经手人：</td>
                <td>
                    <input type="text" name="handler" id="handler">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="提交">&nbsp;&nbsp;
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
