package com.bjpn.servlet;

import com.bjpn.bean.ATM;
import com.bjpn.service.ATMService;
import com.bjpn.service.impl.ATMServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        String pwd = request.getParameter("pwd");
        String flag = request.getParameter("flag");
        ATMService empService = new ATMServiceImpl();
        ATM atm = empService.login(code, pwd);
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        if (atm != null) {
            System.out.println(flag);
            if (Boolean.parseBoolean(flag)) {
                Cookie loginCode = new Cookie("loginCode", code);
                loginCode.setMaxAge(60 * 60 * 24 * 10);
                Cookie loginPwd = new Cookie("loginPwd", pwd);
                loginPwd.setMaxAge(60 * 60 * 24 * 10);
                response.addCookie(loginCode);
                response.addCookie(loginPwd);
            } else {
                Cookie loginCode = new Cookie("loginCode",code);
                loginCode.setMaxAge(0);
                Cookie loginPwd = new Cookie("loginPwd",code);
                loginPwd.setMaxAge(0);
                response.addCookie(loginCode);
                response.addCookie(loginPwd);
            }
            request.getSession().setAttribute("atm", atm);
            json.put("message", true);
            out.write(json.toString());
        } else {
            json.put("message", false);
            out.write(json.toString());
        }
        System.out.println(json);
    }
}
