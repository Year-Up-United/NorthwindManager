package com.pluralsight.data;

import com.pluralsight.Models.Category;
import com.pluralsight.Models.Products;
import com.pluralsight.Models.Supplier;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class NorthwindDataManager {

    private BasicDataSource dataSource;

    public NorthwindDataManager(BasicDataSource dataSource){
        this.dataSource = dataSource;

    }
    public List<Category> getCategories(){
        return null;
}
    public Category getCategoryByName(String categoryName){
        return null;
    }
    public List<Products> getProducts(){
        return null;
    }
    public List<Products> getProductByCategory(Category category){
        return null;
    }
    public List<Products> getProductByPrice(double minPrice, double maxPrice){
        return null;
    }
    public List<Products> getSuppliers(){
        return null;
    }
    public List<Products> getProductsBySupplier(Supplier supplier){
        return null;
    }
        }