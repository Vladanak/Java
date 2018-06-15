package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "Login", urlPatterns = "/welcome")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("name", request.getSession().getAttribute("Name"));
        request.setAttribute("role", request.getSession().getAttribute("Role"));

        Cookie lastSession = new Cookie("Session", new Date().toString());
        Cookie User = new Cookie("Rolle", request.getSession().getAttribute("Role").toString());
        Cookie Times = new Cookie("Times", "0");

        Cookie [] cookies = request.getCookies();
        for(int i =0; i< cookies.length; i++)
        {
            if(cookies[i].getName().equals("Session"))
                request.setAttribute("last", cookies[i].getValue());
            else if(cookies[i].getName().equals("Rolle"))
                request.setAttribute("rolewas", cookies[i].getValue());
            else if(cookies[i].getName().equals("Times"))
            {
                request.setAttribute("times", cookies[i].getValue());
                Integer s = Integer.parseInt(cookies[i].getValue())+1;
                Times = new Cookie("Times", s.toString());
            }
        }

        response.addCookie(lastSession);
        response.addCookie(User);
        response.addCookie(Times);

        request.getRequestDispatcher("welcome.jsp").forward(request, response);
    }
}
