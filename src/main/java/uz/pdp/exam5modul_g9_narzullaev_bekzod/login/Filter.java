package uz.pdp.exam5modul_g9_narzullaev_bekzod.login;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@WebFilter("/*")
public class Filter implements jakarta.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        jakarta.servlet.Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {




        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();


        HttpSession session = request.getSession();
        Boolean isCreatedSession = (Boolean) session.getAttribute("isCreatedSession");


        if (Objects.nonNull(isCreatedSession) || isPublicPage(path)){
            chain.doFilter(req,resp);
        }
        else {
            response.sendRedirect("index.jsp");
        }


    }


    private boolean isPublicPage (String path){

        List<String>publicPages = Arrays.asList("/index.jsp","/homePage.jsp","/login");

        return publicPages.contains(path);
    }

    @Override
    public void destroy() {
        jakarta.servlet.Filter.super.destroy();
    }
}
