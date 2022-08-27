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


@WebServlet("/update-product")
@MultipartConfig(maxFileSize = 10_000_000)
public class UpdateProduct extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));

        Product product = ProductService.getById(id);
        req.setAttribute("product",product);
        req.setAttribute("categoryList", CategoryService.getAllCategory());

        req.getRequestDispatcher("update-product.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Long categoryId = Long.valueOf(req.getParameter("categoryId"));
        Double salary = Double.valueOf(req.getParameter("salary"));
        String url = req.getParameter("url");

        Part imagePart = req.getPart("image");
        boolean empty = imagePart.getSubmittedFileName().isEmpty();
        Product product = Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .salary(salary)
                .categoryId(Math.toIntExact(categoryId))
                .build();

        if (!empty){
            product.setImgUrl(uploadAndGetImageUrl(imagePart));
        }
        else {
            product.setImgUrl(url);
        }
        ProductService.update(product);

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
    }}
