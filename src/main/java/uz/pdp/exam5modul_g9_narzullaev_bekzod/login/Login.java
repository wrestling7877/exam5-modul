package uz.pdp.exam5modul_g9_narzullaev_bekzod.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.entity.User;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.service.UserService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String password = req.getParameter("password");
        String userName = req.getParameter("username");
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        boolean check = UserService.checkUser(user);
        String roleName = UserService.getRoleName();
        if (check) {
            HttpSession session = req.getSession(true);
            session.setAttribute("isCreatedSession", true);
            session.setAttribute("username", userName);
            if (roleName.equals("ADMIN")) {

                resp.sendRedirect("adminPage.jsp");

            } else if (roleName.equals("USER")) {

             resp.sendRedirect("view-Product");

            }


        } else {

            printWriter.println("<center> <p style = \"color:red\"> Username or password incorrect !!!</p> </center>");
            req.getRequestDispatcher("index.jsp").include(req, resp);

        }


    }
}
