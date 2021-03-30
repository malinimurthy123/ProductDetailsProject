package bean;


import java.io.Serializable;

public class LoginBean implements Serializable {


    private static String productName;
    private String productID;
    private String size;
    private String colour;

    public static void setProductName(String productName) {
        LoginBean.productName = productName;
    }

    public String getProductID() {
        return productID;
    }

    public static String getProductName() {
        return productName;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }


}