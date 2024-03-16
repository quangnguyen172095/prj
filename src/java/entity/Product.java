/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author DELL
 */
public class Product {
    private int productId;
    private String productName;
    private int modelYear;
    private double listPrice;
    private String brandName, categoryName;

    public Product() {
    }

    public Product(int productId, String productName, int modelYear, double listPrice, String brandName, String categoryName) {
        this.productId = productId;
        this.productName = productName;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
        this.brandName = brandName;
        this.categoryName = categoryName;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", modelYear=" + modelYear + ", listPrice=" + listPrice + ", brandName=" + brandName + ", categoryName=" + categoryName + '}';
    }
    
}
