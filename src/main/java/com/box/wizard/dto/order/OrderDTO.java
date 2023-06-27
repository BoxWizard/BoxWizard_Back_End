package com.box.wizard.dto.order;

public class OrderDTO {
    private String userID;

    private String boxGrade;

    private String boxPrice;

    private String productName;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getBoxGrade() {
        return boxGrade;
    }

    public void setBoxGrade(String boxGrade) {
        this.boxGrade = boxGrade;
    }

    public String getBoxPrice() {
        return boxPrice;
    }

    public void setBoxPrice(String boxPrice) {
        this.boxPrice = boxPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
