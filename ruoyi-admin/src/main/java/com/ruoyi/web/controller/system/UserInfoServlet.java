package com.ruoyi.web.controller.system;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.system.domain.Oldman;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

@WebServlet(name = "UserInfoServlet", urlPatterns = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        /*设置响应头允许ajax跨域访问*/
        response.setHeader("Access-Control-Allow-Origin", "*");

        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        //获取微信小程序传递的参数值并打印
//        String transInfo = request.getParameter("transInfo");
//        System.out.println("接收到小程序端传递的数据:" + transInfo);
        //Oldman oldman = new Oldman();
        //String userName=oldman.setName("张三");


        String userName="zhangsan";
        String json = JSONObject.toJSONString(userName);
        response.getWriter().write(json);


//        像小程序端传递数据
        Writer out = response.getWriter();
        out.write("汰，这是后台给小程序端的数据");
        out.flush();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
