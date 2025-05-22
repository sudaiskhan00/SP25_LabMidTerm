/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sdamidlab;

/**
 *
 * @author lenovo
 */
import javax.swing.*;
import java.awt.event.*;
import java.util.*;


class Product {
    private String name;
    private String details;
    private boolean isAvailable;

    public Product(String name, String details, boolean isAvailable) {
        this.name = name;
        this.details = details;
        this.isAvailable = isAvailable;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}

class ProductModel {
   
    public static List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Dell Inspiron 15, 8GB RAM", true));
        products.add(new Product("Mouse", "Wireless Mouse - Logitech", false));
        products.add(new Product("Keyboard", "Mechanical Keyboard - Redragon", true));
        return products;
    }

   
    public static Product searchProduct(String keyword) {
        for (Product p : getSampleProducts()) {
            if (p.getName().equalsIgnoreCase(keyword.trim())) {
                return p;
            }
        }
        return null;
    }
}


public class SearchProduct {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Product Search");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // View components
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        JTextArea resultArea = new JTextArea();

        searchField.setBounds(50, 30, 200, 30);
        searchButton.setBounds(260, 30, 80, 30);
        resultArea.setBounds(50, 80, 290, 150);

        frame.setLayout(null);
        frame.add(searchField);
        frame.add(searchButton);
        frame.add(resultArea);

    
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String keyword = searchField.getText();
                Product foundProduct = ProductModel.searchProduct(keyword);

                if (foundProduct == null) {
                    resultArea.setText(" Product not available.");
                } else if (foundProduct.isAvailable()) {
                    resultArea.setText(" Product Found:\n"
                            + "- Name: " + foundProduct.getName() + "\n"
                            + "- Details: " + foundProduct.getDetails() + "\n"
                            + "- Status: Available");
                } else {
                    resultArea.setText("️ Product Found:\n"
                            + "- Name: " + foundProduct.getName() + "\n"
                            + "- Details: " + foundProduct.getDetails() + "\n"
                            + "- Status: Not Available");
                }
            }
        });

        frame.setVisible(true);
    }
}
