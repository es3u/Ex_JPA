package com.example.ex_jpa.Controller;

import com.example.ex_jpa.Model.Category;
import com.example.ex_jpa.Service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping("/findAll")
    public ResponseEntity findAll() {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @PostMapping("/addCategory")
    public ResponseEntity addCategory(@RequestBody @Valid Category category , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
       categoryService.addCategory(category);
        return ResponseEntity.ok().body("added successfully");
    }
    @PutMapping("/updateCategory/{id}")
    public ResponseEntity updateCategory(@PathVariable Integer id, @RequestBody @Valid Category category , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        Boolean result = categoryService.updateCategory(id, category);
        if (result) {
            return ResponseEntity.ok().body("updated successfully");
        }
        return ResponseEntity.badRequest().body("update failed");
    }

    @DeleteMapping("/deleteCategory/{id}")
    public ResponseEntity deleteCategory(@PathVariable Integer id ) {
        Boolean result = categoryService.deleteCategory(id);
        if (result) {
            return ResponseEntity.ok().body("deleted successfully");
        }
        return ResponseEntity.badRequest().body("delete failed");
    }

}
