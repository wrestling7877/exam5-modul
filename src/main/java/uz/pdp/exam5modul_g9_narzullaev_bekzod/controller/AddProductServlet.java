package uz.pdp.exam5modul_g9_narzullaev_bekzod.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.entity.Product;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.service.CategoryService;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.service.ProductService;


import java.io.File;
import java.io.IOException;

import static uz.pdp.exam5modul_g9_narzullaev_bekzod.utils.Util.UPLOAD_DIRECTORY;


@WebServlet("/add-product")
@MultipartConfig(maxFileSize = 10_000_000)
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("categoryList", CategoryService.getAllCategory());
        req.getRequestDispatcher("/add-product.jsp").forward(req,resp);

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Long categoryId = Long.valueOf(req.getParameter("categoryId"));
        Double salary = Double.valueOf(req.getParameter("salary"));
        Part imagePart = req.getPart("image");

        Product product = Product.builder()
                .name(name)
                .description(description)
                .salary(salary)
                .imgUrl(uploadAndGetImageUrl(imagePart))
                .categoryId(Math.toIntExact(categoryId))
                .build();


        ProductService.addProduct(product);
        resp.sendRedirect("admin-page");



    }


    private String uploadAndGetImageUrl(Part imagePart) {
        try {

            File uploadDir = new File(UPLOAD_DIRECTORY);
            if (!uploadDir.exists())
                uploadDir.mkdir();
            int index = imagePart.getSubmittedFileName().lastIndexOf('.');
            String extension = imagePart.getSubmittedFileName().substring(index + 1);
            System.out.println("File extension is " + extension);

            String imgName = System.currentTimeMillis() + "." + extension;
            String imgPath = uploadDir.getPath() + "/" + imgName;
            imagePart.write(imgPath);
            return imgName;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
