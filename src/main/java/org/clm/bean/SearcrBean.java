package org.clm.bean;

public class SearcrBean {
    private int id;
    private String city = null;
    private String category = null;
    private String keyword = null;

    public SearcrBean() {
    }

    public SearcrBean(String city, String category) {
        this.city = city;
        this.category = category;
    }

    public SearcrBean(String city, String category, String keyword) {
        this.city = city;
        this.category = category;
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
