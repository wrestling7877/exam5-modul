package uz.pdp.exam5modul_g9_narzullaev_bekzod.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.examtask.entity.Product;
import uz.pdp.examtask.service.ProductService;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/admin-page")
public class Admin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String pageStr = req.getParameter("page");
        int page = 1;
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
        }


        List<Product>productList = ProductService.getAllProduct(page);
        int size = ProductService.size();
        req.setAttribute("productList", productList);
        req.setAttribute("productSize", size);


        if (page != 1) {
            req.setAttribute("prev", page - 1);
        } else {
            req.setAttribute("prev", page);
        }

        if ((page ) > size) {
            req.setAttribute("page", page);
        } else {
            req.setAttribute("page", page + 1);
        }

        List<Integer>pageList = Collections.singletonList(page);
        req.setAttribute("pageList", pageList);
        req.getRequestDispatcher("update-delete-product.jsp").forward(req, resp);
        }


    }

