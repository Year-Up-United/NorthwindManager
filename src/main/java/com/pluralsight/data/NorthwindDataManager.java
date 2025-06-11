package com.pluralsight.data;

import com.pluralsight.Models.Products;
import com.pluralsight.Models.Category;
import com.pluralsight.Models.Products;
import com.pluralsight.Models.Supplier;
import org.apache.commons.dbcp2.BasicDataSource;

import java.net.NoRouteToHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NorthwindDataManager {
    private BasicDataSource dataSource;

    public NorthwindDataManager(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Category> getCategories() {
        ArrayList<Category> result = new ArrayList<Category>();

        String query = """
                SELECT
                CategoryID,
                CategoryName
                FROM
                categories""";

        try (
                Connection c = dataSource.getConnection();
                PreparedStatement s = c.prepareStatement(query);
                ResultSet queryResults = s.executeQuery();
        ) {
            while (queryResults.next()) {
                int categoryId = queryResults.getInt(1);
                String categoryName = queryResults.getString(2);
                Category category = new Category(categoryId, categoryName);
                result.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return result;
    }

    public Category getCategoryByName(String categoryName) {
        String query = """
                SELECT
                CategoryId,
                CategoryName,
                FROM
                categories
                WHERE CategoryName = ?
                """;
        try (
                Connection c = dataSource.getConnection();
                PreparedStatement s = c.prepareStatement(query);
        ) {
            s.setString(1, categoryName);
            try (ResultSet queryResults = s.executeQuery()) {
                if (queryResults.next()) {

                    int categoryId = queryResults.getInt(1);
                    return new Category(categoryId, categoryName);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return null;
    }

        public List<Products> getProducts() {
            ArrayList<Products> result = new ArrayList<Products>();

            String query = """
                    SELECT
                    ProductID,
                    ProductName,
                    SupplierID,
                    CategoryID,
                    UnitPrice
                    FROM products;
                    """;

            try (
                    Connection c = dataSource.getConnection();
                    PreparedStatement s = c.prepareStatement(query);
                    ResultSet queryResults = s.executeQuery();
            ) {
                while (queryResults.next()) {
                    int productId = queryResults.getInt(1);
                    String productName = queryResults.getString(2);
                    int supplierId = queryResults.getInt(3);
                    int categoryId = queryResults.getInt(4);
                    double price = queryResults.getDouble(5);

                    Products product = new Products(productId, productName, categoryId, supplierId, price);

                    result.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }


            return result;
        }

        public List<Products> getProductsByCategory (Category category){
            return null;
        }

        public List<Products> getProductsByPrice ( double minPrice, double maxPrice){
            return null;
        }

        public List<Products> getProductsBySupplier (Supplier supplier){
            return null;
        }

        public List<Supplier> getSuppliers () {
            return null;
        }
    }

