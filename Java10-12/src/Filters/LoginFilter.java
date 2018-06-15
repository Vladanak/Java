package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/welcome")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException
    {
        if (((HttpServletRequest)req).getSession().getAttribute("Name")==null)
        {
            ((HttpServletResponse) resp).sendRedirect("register");
        }
        else {
            chain.doFilter(req, resp);//передача управления следующему фильтру
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
