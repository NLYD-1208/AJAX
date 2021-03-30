package com.AJAX.controller;

import com.AJAX.dao.AJAXDao;
import com.AJAX.entity.name;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.naming.Name;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class jsonServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //默认值为 {}:表示json 格式的数据
        String json = "{}";

        //获得参数 id
        String strProid = request.getParameter("proid");

        //判断，如果proid 有值，则查询
        if (strProid != null && strProid.trim().length()>0){
            AJAXDao dao = new AJAXDao();
            name n = dao.queryallbyid(Integer.valueOf(strProid));
            //转化为json
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(n);

        }

        //将获得的数据，通过网络传给ajax中的异步对象，响应结果数据
        //指服务器段（servlet）返回给浏览器的时json 的数据
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }
}
