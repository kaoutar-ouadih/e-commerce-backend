package com.example.e_commerce_backend.Controller;

import com.example.e_commerce_backend.Model.Category;
import com.example.e_commerce_backend.Model.Product;
import com.example.e_commerce_backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = {"http://e-commerce-front-beta.vercel.app"})
@CrossOrigin(origins = {"*"})
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @CrossOrigin(origins = {"http://e-commerce-front-beta.vercel.app"})
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product){
        this.productService.addProduct(product);
        return "Product added successfully";
    }

//    @CrossOrigin(origins = {"http://e-commerce-front-beta.vercel.app"})
    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }

//    @CrossOrigin(origins = {"http://e-commerce-front-beta.vercel.app"})
    @DeleteMapping("delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return this.productService.deleteProduct(id);
    }

//    @CrossOrigin(origins = {"http://e-commerce-front-beta.vercel.app"})
    @PutMapping("update/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product){
        return this.productService.updateProduct(id, product);
    }

//    @CrossOrigin(origins = {"http://e-commerce-front-beta.vercel.app"})
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id){
        return this.productService.getProduct(id);
    }
}
