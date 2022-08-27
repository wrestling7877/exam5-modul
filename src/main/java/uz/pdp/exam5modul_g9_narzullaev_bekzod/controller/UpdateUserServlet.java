package uz.pdp.exam5modul_g9_narzullaev_bekzod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.entity.User;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.service.UserService;


import java.io.IOException;

@WebServlet("/update-user")
public class UpdateUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        int id = Integer.parseInt(sid);
        User user = UserService.getUSerById(id);
        req.setAttribute("user", user);
        req.getRequestDispatcher("updateUser.jsp").forward(req, resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id= Integer.parseInt(req.getParameter("id"));
        String username = req.getParameter("username");
        String password= req.getParameter("password");
        String fullName= req.getParameter("fullName");



        User user = User.builder()
                .id(id)
                .username(username)
                .password(password)
                .fullName(fullName)
                .build();


        int update = UserService.update(user);

        if (update!=0) {
            resp.sendRedirect("/showUser");
        }
    }

}
