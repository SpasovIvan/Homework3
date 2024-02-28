package com.spasov.homework3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "maxNum", value = "/maxNum")
public class maxNum extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int num1 = Integer.parseInt(req.getParameter("num1"));
        int num2 = Integer.parseInt(req.getParameter("num2"));
        int num3 = Integer.parseInt(req.getParameter("num3"));
        int max = Math.max(num1, Math.max(num2, num3));

        String operation = req.getParameter("operation");


        session.setAttribute("num1", String.valueOf(num1));
        session.setAttribute("num2", String.valueOf(num2));
        session.setAttribute("num3", String.valueOf(num3));
        session.setAttribute("max", String.valueOf(max));
        float res;
        switch (operation) {
            case "max": res = (float) Math.max(num1, Math.max(num2, num3));
                break;
            case "min": res = (float) Math.min(num1, Math.min(num2, num3));
                break;
            case "avg": res = (float) ((num1 + num2 + num3)/3);
                break;
            default: res = 0;
        }
        //res = String.valueOf(res);
        session.setAttribute("res", String.valueOf(res));
        session.setAttribute("operation", operation);
        req.getRequestDispatcher("/quote.jsp").forward(req, resp);
    }


}
