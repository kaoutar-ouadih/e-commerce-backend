package com.example.e_commerce_backend.Model;

import jakarta.persistence.*;

import java.util.Arrays;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    private String name;
    private String imageUrl;
    private float currentPrice;
    private float oldPrice;
    private float rating;
    private String size;
    private String addedAt;
    private String description;
    private String[] reviews;
    private  String material;
    private  String[] colors;
    private  int sales;
    @ManyToOne
    private Category category;

    public Product(int id, String name, String imageUrl, float currentPrice, float oldPrice, float rating, String size, String addedAt, String description, String[] reviews, String material, String[] colors, int sales, Category category) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.currentPrice = currentPrice;
        this.oldPrice = oldPrice;
        this.rating = rating;
        this.size = size;
        this.addedAt = addedAt;
        this.description = description;
        this.reviews = reviews;
        this.material = material;
        this.colors = colors;
        this.sales = sales;
        this.category = category;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public float getCurrentPrice() {
        return currentPrice;
    }

    public float getOldPrice() {
        return oldPrice;
    }

    public float getRating() {
        return rating;
    }

    public String getSize() {
        return size;
    }

    public String getAddedAt() {
        return addedAt;
    }

    public String getDescription() {
        return description;
    }

    public String[] getReviews() {
        return reviews;
    }

    public String getMaterial() {
        return material;
    }

    public String[] getColors() {
        return colors;
    }

    public int getSales() {
        return sales;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setCurrentPrice(float currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setOldPrice(float oldPrice) {
        this.oldPrice = oldPrice;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setAddedAt(String addedAt) {
        this.addedAt = addedAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReviews(String[] reviews) {
        this.reviews = reviews;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", currentPrice=" + currentPrice +
                ", oldPrice=" + oldPrice +
                ", rating=" + rating +
                ", size='" + size + '\'' +
                ", addedAt='" + addedAt + '\'' +
                ", description='" + description + '\'' +
                ", reviews=" + Arrays.toString(reviews) +
                ", material='" + material + '\'' +
                ", colors=" + Arrays.toString(colors) +
                ", sales=" + sales +
                ", category=" + category +
                '}';
    }
}
