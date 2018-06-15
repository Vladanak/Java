package Servlets;

import DateBaseFiles.DBClass;
import DateBaseFiles.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "MainServlet", urlPatterns = "")
public class MainServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
            response.setContentType("text/html; charset=UTF-8");
            try
            {
                Users thisUser = DBClass.GetUser(request.getParameter("Login"), request.getParameter("Password"));
                if(thisUser!=null)
                {
                    request.getSession().setAttribute("Name", thisUser.UserName);
                    request.getSession().setAttribute("Role", thisUser.Role);
                    request.getSession().setAttribute("Time", new Date().toString());
                    response.sendRedirect("welcome");
                }
                else
                    {
                        response.sendRedirect("register");
                    }
            }
            catch (SQLException e)
            {
                request.setAttribute("errorlog", e);
                request.getRequestDispatcher("error.jsp").forward(request,response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
