package com.spasov.homework3;

import com.spasov.homework3.model.Quote;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "QuoteServlet", value = "/quote-servlet")
public class QuoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        Quote quote = (Quote) session.getAttribute("quote");
        if (quote == null) {
            quote = new Quote();
            quote.setQuote("Bad programmers worry about the code. Good programmers\n" +
                    "worry about data structures and their relationships");
        }
        session.setAttribute("quote", quote);
        req.getRequestDispatcher("/quote.jsp").forward(req, resp);
    }
}
