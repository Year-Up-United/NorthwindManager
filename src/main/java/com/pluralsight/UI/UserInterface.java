package com.pluralsight.UI;

import com.pluralsight.Models.Category;
import com.pluralsight.Models.Employee;
import com.pluralsight.data.NorthwindDataManager;

import java.util.List;

public class UserInterface {

    private Employee currentEmployee;
    private Console console;
    private NorthwindDataManager dataManager;

    public UserInterface(NorthwindDataManager dataManager) {
        this.console = new Console();
        this.dataManager = dataManager;
    }


    public void display() {
        System.out.println("Welcome to the Northwind Manager!");
        currentEmployee = loginUser();
        System.out.println("Welcome, " + this.currentEmployee.getFirstName() + "!");


        showHomeMenu();
    }


    private Employee loginUser() {
        String s = console.promptForString("Just hit enter to login as Jayla", true);
        Employee e = new Employee(1, "Jayla", "Jones");
        return e;
    }

    private void showHomeMenu() {
        while (true) {
            String[] menuOptions = {
                    "list product categories",
                    "list all products",
                    "list products by category",
                    "list products by price",
                    "list all suppliers",
                    "list products by supplier",
                    "exit"


            };
            int userChoice = console.promptForOption(menuOptions);
            switch (userChoice) {
                case 1:
                    listCategoriesAll();
                    break;
                case 2:
                    listProductsAll();
                    break;
                case 3:
                    listProductByCategory();
                    break;
                case 4:
                    listProductsByPrice();
                    break;
                case 5:
                    listSuppliersAll();
                    break;
                case 6:
                    listProductsBySupplier();
                    break;
                case 7:
                    System.exit(0);
            }
        }
    }

    private void listProductsBySupplier() {
    }

    private void listSuppliersAll() {
    }

    private void listProductsByPrice() {
    }

    private void listProductByCategory() {
    }

    private void listProductsAll() {
    }

    private void listCategoriesAll() {
        List<Category> categories = dataManager.getCategories();
    }

}