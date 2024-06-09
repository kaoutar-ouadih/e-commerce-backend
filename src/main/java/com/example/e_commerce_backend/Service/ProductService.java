package com.example.e_commerce_backend.Service;

import com.example.e_commerce_backend.Model.Category;
import com.example.e_commerce_backend.Model.Product;
import com.example.e_commerce_backend.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepo productRepo;
    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public void addProduct(Product product) {
        System.out.println(product);
        this.productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    public String deleteProduct(int id) {
        if(this.productRepo.existsById(id)){
            this.productRepo.deleteById(id);
            return "Product deleted successfully";
        }
        else{
            return"Product does not exist";
        }

    }

    public String updateProduct(int id, Product product) {
        Optional<Product> foundCategory =  this.productRepo.findById(id);
        if(!foundCategory.isPresent()){
            return "Product does not exist";
        }
        else{
            Product updatedProduct = foundCategory.get();
            updatedProduct.setName(product.getName());
            updatedProduct.setCategory(product.getCategory());
            updatedProduct.setColors(product.getColors());
            updatedProduct.setAddedAt(product.getAddedAt());
            updatedProduct.setCurrentPrice(product.getCurrentPrice());
            updatedProduct.setOldPrice(product.getOldPrice());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setImageUrl(product.getImageUrl());
            updatedProduct.setMaterial(product.getMaterial());
            updatedProduct.setRating(product.getRating());
            updatedProduct.setReviews(product.getReviews());
            updatedProduct.setSize(product.getSize());
            updatedProduct.setSales(product.getSales());
            this.productRepo.save(updatedProduct);
            return "Product updated successfully";
        }
    }

    public Product getProduct(int id) {
       Optional<Product> productFound = this.productRepo.findById(id);
        if(productFound.isPresent()){
            return productFound.get();
        }
        else{
            return productFound.get();
        }
    }
}
