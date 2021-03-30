<%--
  Created by IntelliJ IDEA.
  User: lbq25
  Date: 2021/3/16
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAX</title>
    <script type="text/javascript">
        function search() {
            //发送ajax请求，传参，返回数据
            //1.创建异步对象
            var xmlHttp = new XMLHttpRequest();
            //2.绑定事件
            xmlHttp.onreadystatechange = function () {
                alert(xmlHttp.readyState == 4 && xmlHttp.status == 200)
                {
                    // alert(xmlHttp.responseText)
                    //更新页面，==更新dom对象
                    document.getElementById("name").value = xmlHttp.responseText;
                }
            }
            //3.初始异步对象
            var proid = document.getElementById("proid").value;
            xmlHttp.open("get", "querysomething", "true");
            //4.发送请求
            xmlHttp.send();
        }
    </script>
</head>
<body>
<p> ajax
<p/>
<table>
    <tr>
        <td>编号：</td>
        <td><input type="text" id="proid">
            <input type="button" value="搜索" onclick="search()">
        </td>
    </tr>
    <tr>
        <td>名称：</td>
        <td><input type="text" id="name"></td>
    </tr>
</table>
</body>
</html>
