package uz.pdp.exam5modul_g9_narzullaev_bekzod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.service.ProductService;


import java.io.IOException;

@WebServlet("/delete-product")
public class DeleteProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       Integer id = Integer.valueOf(req.getParameter("id"));

        ProductService.delete(id);
        req.getRequestDispatcher("admin-page").forward(req, resp);


    }
}
