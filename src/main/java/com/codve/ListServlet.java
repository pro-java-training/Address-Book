package com.codve;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

@WebServlet(
        name = "listServlet",
        urlPatterns = "/list"
)
public class ListServlet extends HttpServlet {
    private static final SortedSet<Contact> contacts =
            new TreeSet<>();
    static {
        contacts.add(new Contact("Issac", "Newton",
                "555-994", "London",
                MonthDay.of(Month.JANUARY, 1)
        ));
        contacts.add(new Contact("Albert", "Einstein",
                "555-995", "New York",
                null
        ));
        contacts.add(new Contact("Charles", "Darwin",
                "555-996", "Italy",
                MonthDay.of(Month.MARCH, 3)
        ));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        if (request.getParameter("empty") != null) {
            request.setAttribute("contacts", Collections.<Contact>emptySet());
        } else {
            request.setAttribute("contacts", contacts);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp")
                .forward(request, response);
    }

}
