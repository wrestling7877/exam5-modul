package uz.pdp.exam5modul_g9_narzullaev_bekzod.service;

import uz.pdp.examtask.db.Db;
import uz.pdp.examtask.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    public static List<Category> getAllCategory() {
        List<Category>categories = new ArrayList<>();
        try {
        Connection connection = Db.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){

                Category category = Category.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .build();
                categories.add(category);
            }

           connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return categories;
    }
}
