package com.example.ex_jpa.Controller;

import com.example.ex_jpa.Model.MerchantStock;
import com.example.ex_jpa.Service.MerchantStockService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/merchantStock")
@RequiredArgsConstructor
public class MerchantStockController {

    private final MerchantStockService merchantStockService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(merchantStockService.findAll());
    }

    @PostMapping("/addMerchantStockController")
    public ResponseEntity addMerchantStockController(@RequestBody@Valid MerchantStock merchantStock , Errors errors){
        Boolean result = merchantStockService.addMerchantStock(merchantStock);
        if(result){
            return ResponseEntity.ok().body("add merchant stock success");
        }
        return ResponseEntity.badRequest().body("add merchant stock failed");
    }

    @PutMapping("/updateMerchantStockController/{id}")
    public ResponseEntity updateMerchantStockController(@PathVariable Integer id, @RequestBody@Valid MerchantStock merchantStock, Errors errors){
        Boolean result = merchantStockService.updateMerchantStock(id, merchantStock);
        if(result){
            return ResponseEntity.ok().body("update merchant stock success");
        }
        return ResponseEntity.badRequest().body("update merchant stock failed");
    }

    public ResponseEntity deleteMerchantStockController(@PathVariable Integer id){
        Boolean result = merchantStockService.deleteMerchantStock(id);
        if(result){
            return ResponseEntity.ok().body("delete merchant stock success");
        }
        return ResponseEntity.badRequest().body("delete merchant stock failed");
    }

    public ResponseEntity addStock(@PathVariable Integer id , @PathVariable Integer merchantId , @PathVariable Integer productId, @PathVariable Integer stock){
        Boolean result = merchantStockService.addStock(id, merchantId, productId, stock);
        if(result){
            return ResponseEntity.ok().body("add stock success");
        }
        return ResponseEntity.badRequest().body("add stock failed");
    }




}
