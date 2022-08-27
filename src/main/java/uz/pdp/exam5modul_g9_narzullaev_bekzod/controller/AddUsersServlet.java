package uz.pdp.exam5modul_g9_narzullaev_bekzod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.examtask.entity.User;
import uz.pdp.examtask.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/save-user")
public class AddUsersServlet {
    public class Save extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html");
            PrintWriter out=resp.getWriter();
            String username=req.getParameter("username");
            String password=req.getParameter("password");
            String fullname=req.getParameter("fullname");
            String role=req.getParameter("role");

            User user=new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFullName(fullname);
            user.setRole(role);
            int status= UserService.add(user);
            if(status>0){

//                out.print("<p><b>Record saved successfly!</b></p>");
                req.getRequestDispatcher("userPage.jsp").include(req,resp);

            }else {
                out.println("Sorry! unable to saved record");
            }
            out.close();

        }
    }

}




