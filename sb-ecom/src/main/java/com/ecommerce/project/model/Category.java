package com.ecommerce.project.model;

public class Category {

    private Long CategoryID;
    private String CategoryName;

    public Category(Long categoryID, String categoryName) {
        CategoryID = categoryID;
        CategoryName = categoryName;
    }

    public Long getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Long categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }


}
