package com.example.ProductDetails;


public class Product {
    private String ProductID;
    private String ProductName;
    private String Colour;
    private int Size ;

    public String getColour() {
        return Colour;
    }

    public String getProductName() {
        return ProductName;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int size) {
        Size = size;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setColour(String colour) {
        Colour = colour;
    }


    public Product() {
        super();
    }

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String productID) {
        ProductID = productID;
    }

    public Product(String ProductID, String ProductName, int Size, String Colour) {
        super();
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.Size = Size;
        this.Colour = Colour;
    }


    @Override
    public String toString() {
        return "Product [id=" + ProductID + ", name=" + ProductName + ", Size=" + Size + ", Colour=" + Colour + "]";
    }
}