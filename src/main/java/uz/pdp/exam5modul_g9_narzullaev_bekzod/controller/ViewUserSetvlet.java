package uz.pdp.exam5modul_g9_narzullaev_bekzod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.entity.User;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/showUser")
public class ViewUserSetvlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }
        int size = UserService.size();
        if (page != 1) {
            req.setAttribute("prev", page - 1);
        } else {
            req.setAttribute("prev", page);
        }

        if ((page * 3) > size) {
            req.setAttribute("page", page);
        } else {
            req.setAttribute("page", page + 1);
        }

        List<User> list= UserService.getAllUser(page);
        req.setAttribute("userSize", size);
        req.setAttribute("userList",list);
        req.getRequestDispatcher("userPage.jsp").forward(req, resp);
    }
}
