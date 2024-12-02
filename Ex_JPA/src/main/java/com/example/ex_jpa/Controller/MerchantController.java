package com.example.ex_jpa.Controller;

import com.example.ex_jpa.Model.Merchant;
import com.example.ex_jpa.Service.MerchantSevice;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Merchant")
@RequiredArgsConstructor
public class MerchantController {
    private final MerchantSevice merchantSevice;

    @GetMapping("/findAll")
    public List findAll() {
        return merchantSevice.findAll();
    }

    @PostMapping("/addMerchant")
    public ResponseEntity addMerchant(@RequestBody@Valid Merchant merchant , Errors errors) {

        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());
        }
        merchantSevice.addMerchant(merchant);
        return ResponseEntity.ok().body("add merchant success");
    }

    @PutMapping("/updateMerchant/{id}")
    public ResponseEntity updateMerchant(@PathVariable Integer id ,@RequestBody@Valid Merchant merchant , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getFieldError().getDefaultMessage());

        }
        Boolean isupdate = merchantSevice.updateMerchant(id,merchant);
        if (isupdate) {
            return ResponseEntity.ok().body("update merchant success");
        }
        return ResponseEntity.ok().body("update merchant failed");
    }

    @DeleteMapping("/deleteMerchant/{id}")
    public ResponseEntity deleteMerchant(@PathVariable Integer id) {
        Boolean isdelete = merchantSevice.deleteMerchant(id);
        if (isdelete) {
            return ResponseEntity.ok().body("delete merchant success");
        }
        return ResponseEntity.ok().body("delete merchant failed");
    }
}
