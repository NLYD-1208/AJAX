package com.AJAX.controller;

import com.AJAX.dao.AJAXDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.security.Provider;

public class AJAXServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strProid = req.getParameter("proid");
        System.out.println("strProid" + strProid);
        String name = "null";
        //输入不为空 ， 不为空字符串
        if (strProid != null && "".equals(strProid.trim())) {
            //创建dao包对象，调用方法
            AJAXDao dao = new AJAXDao();
            name = dao.querybyid(Integer.valueOf(strProid));
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println();
        pw.flush();
        pw.close();
    }
}
