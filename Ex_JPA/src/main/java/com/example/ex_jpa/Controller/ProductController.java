package com.example.ex_jpa.Controller;

import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(productService.findAll());
    }
    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody@Valid Product product , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        Boolean result = productService.addProduct(product);
        if(result){
            return ResponseEntity.ok().body("add product success");
        }
        return ResponseEntity.badRequest().body("add product fail because product category is not exist");
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity updateProduct(@PathVariable@Valid Integer id, @RequestBody@Valid Product product , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        Boolean result = productService.updateProduct(id, product);
        if(result){
            return ResponseEntity.ok().body("update product success");
        }
        return ResponseEntity.badRequest().body("update product fail because product category is not exist");
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable@Valid Integer id){
        Boolean result = productService.deleteProduct(id);
        if(result){
            return ResponseEntity.ok().body("delete product success");
        }
        return ResponseEntity.badRequest().body("delete product fail because product is not exist");
    }
}
