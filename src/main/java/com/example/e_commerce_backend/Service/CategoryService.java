package com.example.e_commerce_backend.Service;

import com.example.e_commerce_backend.Model.Category;
import com.example.e_commerce_backend.Repository.CategoryRepo;
import org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService{
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public void addCategory(Category category){
        this.categoryRepo.save(category);
    }

    public List<Category> getAll() {
        return this.categoryRepo.findAll();
    }

    public String deleteCategory(int id) {
        if(this.categoryRepo.existsById(id)){
            this.categoryRepo.deleteById(id);
            return "Category deleted successfully";
        }
        else{
            return"Category does not exist";
        }

    }

    public String updateCategory(int id, Category category) {
      Optional<Category> foundCategory =  this.categoryRepo.findById(id);
      if(!foundCategory.isPresent()){
          return "Category does not exist";
      }
      else{
          Category updatedCategory = foundCategory.get();
          updatedCategory.setName(category.getName());
          this.categoryRepo.save(updatedCategory);
          return "Category updated successfully";
      }
    }
}
