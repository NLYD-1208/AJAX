<%--
  Created by IntelliJ IDEA.
  User: lbq25
  Date: 2021/3/16
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajxa</title>
    <script type="text/javascript">
        function doSearch() {
            //1.创建异步对象
            var xmlhttp = new XMLHttpRequest();
            //2.绑定事件
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    var data = xmlhttp.responseText;
                    //eval是执行括号中的代码，把json字符串转化为json对象
                    var jsonbj = eval("(" + data + ")");
                    //更新dom对象
                    callback(jsonbj);
                }
            }

            //3.初始化异步对象的请求参数
            var proid = document.getElementById("proid").value;
            xmlhttp.open("get", "jsonServlet?proid=" + proid, true);

            //4.发送请求
            xmlhttp.send();
        }
        //json?jsonbj
        function callback(jsonbj){
            document.getElementById("name").value = jsonbj.name;
            // document.getElementById()  同理
        }

    </script>
</head>
<body>
<table>
    <tr>
        <td>编号：</td>
        <td><input type="text" id="proid">
            <input type="button" value="搜索" onclick="doSearch()">
        </td>
    </tr>
    <tr>
        <td>名称：</td>
        <td><input type="text" id="name"></td>
    </tr>
</table>
</body>
</html>
