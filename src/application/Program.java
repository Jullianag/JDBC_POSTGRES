package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import entities.Product;

public class Program {

    public static void main(String[] args) throws SQLException {

        Connection conn = DB.getConnection();

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select * from tb_product");

        // percorre linha a linha
        while (rs.next()) {

            Product p = instatiateProduct(rs);

            System.out.println(p);
        }
    }

    private static Product instatiateProduct(ResultSet rs) throws SQLException {

        Product p = new Product();
        p.setId(rs.getLong("id"));
        p.setDescription(rs.getString("description"));
        p.setName(rs.getString("name"));
        p.setImageUri(rs.getString("image_uri"));
        p.setPrice(rs.getDouble("price"));

        return p;
    }
}