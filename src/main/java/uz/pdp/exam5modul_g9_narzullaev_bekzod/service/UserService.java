package uz.pdp.exam5modul_g9_narzullaev_bekzod.service;

import uz.pdp.exam5modul_g9_narzullaev_bekzod.db.Db;
import uz.pdp.exam5modul_g9_narzullaev_bekzod.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {


    public static int add(User user) {
        int status=0;
        Connection connection = Db.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("insert into users(username,password,fullname,role) values(?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFullName());
            ps.setString(4,"USER");
            status= ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static int delete(int id){
        int status=0;
        Connection connection=Db.getConnection();
        try {
            PreparedStatement ps=connection.prepareStatement("delete from users where id="+id);
            status=ps.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static List<User> getAllUser(Integer page){
        int a = (page - 1) * 3;
        List<User> list=new ArrayList<>();

        Connection connection=Db.getConnection();

        try {
            PreparedStatement ps=connection.prepareStatement("select * from users limit 3 offset'"+a+"'");
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                User user=new User();
                user.setId(rs.getInt(1));
                user.setRole(rs.getString(2));
                user.setUsername(rs.getString(3));
                user.setPassword(rs.getString(4));
                user.setFullName(rs.getString(5));
                list.add(user);
                connection.close();


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
