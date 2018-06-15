package Servlets;

import DateBaseFiles.DBClass;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Register", urlPatterns = "/register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
            try
            {
                DBClass.RegisterUser(request.getParameter("LoginField"), request.getParameter("PasswordField"), request.getParameter("Role"));
                response.sendRedirect("");
            }
            catch (SQLException e)
            {
                request.setAttribute("errorlog", e);
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
