package com.example.e_commerce_backend.Controller;

import com.example.e_commerce_backend.Model.Category;
import com.example.e_commerce_backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://e-commerce-front-beta.vercel.app"})
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public String addCategory(@RequestBody Category category){
       this.categoryService.addCategory(category);
       return "Category added successfully";
    }

    @GetMapping("/all")
    public List<Category> getAll(){
        return this.categoryService.getAll();
    }

    @DeleteMapping("delete/{id}")
    public String deleteCategory(@PathVariable int id){
        return this.categoryService.deleteCategory(id);
    }

    @PutMapping("update/{id}")
    public String updateCategory(@PathVariable int id, @RequestBody Category category){
        return this.categoryService.updateCategory(id, category);
    }
}
