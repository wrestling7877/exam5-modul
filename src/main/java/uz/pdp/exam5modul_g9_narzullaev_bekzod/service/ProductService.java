package uz.pdp.exam5modul_g9_narzullaev_bekzod.service;


import com.google.gson.Gson;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.db.Db;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.entity.Category;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.entity.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public static List<Product> getAllProduct(Integer page) {
        int a = (page - 1) * 3;
        List<Product> productList = new ArrayList<>();
        try {
            Connection connection = Db.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement("select p.id," +
                    "       p.name" +
                    "       ,p.image_url" +
                    "       ,p.salary" +
                    "       ,p.description," +
                    "    json_build_object('id', c.id, 'name', c.name) as category " +
                    "from product p" +
                    "         join category c on c.id = p.category_id limit 3 offset'"+a+"' ");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer productId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String imageUrl = resultSet.getString(3);
                Double salary = resultSet.getDouble(4);
                String description = resultSet.getString(5);
                Object categoryObj =  resultSet.getObject(6);

                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);

                Product product = Product.builder()
                        .id(productId)
                        .name(name)
                        .category(category)
                        .imgUrl(imageUrl)
                        .description(description)
                        .salary(salary)
                        .build();

                productList.add(product);


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productList;
    }


//    public static List<Product> getAllProductForAdmin() {
//
//        List<Product> productList = new ArrayList<>();
//        try {
//            Connection connection = Db.getConnection();
//
//
//            PreparedStatement preparedStatement = connection.prepareStatement("select p.id," +
//                    "       p.name" +
//                    "       ,p.image_url" +
//                    "       ,p.salary" +
//                    "       ,p.description," +
//                    "    json_build_object('id', c.id, 'name', c.name) as category " +
//                    "from product p" +
//                    "         join category c on c.id = p.category_id  ");
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                Integer productId = resultSet.getInt(1);
//                String name = resultSet.getString(2);
//                String imageUrl = resultSet.getString(3);
//                Double salary = resultSet.getDouble(4);
//                String description = resultSet.getString(5);
//                Object categoryObj =  resultSet.getObject(6);
//
//                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);
//
//                Product product = Product.builder()
//                        .id(productId)
//                        .name(name)
//                        .category(category)
//                        .imgUrl(imageUrl)
//                        .description(description)
//                        .salary(salary)
//                        .build();
//
//                productList.add(product);
//
//
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        return productList;
//    }


    public static int size() {
        int size = 0;
        try {
            Connection connection = Db.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement("select * from product");


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                size++;
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if ((size % 3) > 0) {
            return size / 3 + 1;
        }
        return size / 3;

    }

    public static void addProduct(Product product) {
        try {
        Connection connection = Db.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name,image_url,description,salary,category_id)values (?,?,?,?,?)");
            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getImgUrl());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setDouble(4,product.getSalary());
            preparedStatement.setInt(5,product.getCategoryId());

            preparedStatement.execute();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(Integer id) {

        try {
            Connection connection = Db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product where id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }

    public static Product getById(Integer id) {
        Product product = new Product();

        try {
            Connection connection = Db.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement("select p.id," +
                    "       p.name" +
                    "       ,p.image_url" +
                    "       ,p.salary" +
                    "       ,p.description," +
                    "    json_build_object('id', c.id, 'name', c.name) as category " +
                    "from product p" +
                    "         join category c on c.id = p.category_id ");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer productId = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String imageUrl = resultSet.getString(3);
                Double salary = resultSet.getDouble(4);
                String description = resultSet.getString(5);
                Object categoryObj =  resultSet.getObject(6);

                Category category = new Gson().fromJson(categoryObj.toString(), Category.class);

                Product product1 = Product.builder()
                        .id(productId)
                        .name(name)
                        .category(category)
                        .imgUrl(imageUrl)
                        .description(description)
                        .salary(salary)
                        .build();
               product = product1;



            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
return product;
    }

    public static void update(Product product) {
        try {
        Connection connection = Db.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("update product set name=?,salary=?,image_url=?,description=?,category_id=? where id=?");
           preparedStatement.setString(1, product.getName());
           preparedStatement.setDouble(2,product.getSalary());
           preparedStatement.setString(3,product.getImgUrl());
           preparedStatement.setString(4,product.getDescription());
           preparedStatement.setInt(5,product.getCategoryId());
           preparedStatement.setInt(6,product.getId());
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
