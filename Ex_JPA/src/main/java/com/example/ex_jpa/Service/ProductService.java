package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Repository.CategoryRepository;
import com.example.ex_jpa.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    public List findAll(){

        return productRepository.findAll();
    }

    public Boolean addProduct(Product product){
        if (product.getCategoryId().equals(categoryRepository.findById(product.getProductId()))){
            productRepository.save(product);
            return true;
        }
        return false;
    }
    public Boolean updateProduct(Integer id , Product product){
        Product oldProduct = productRepository.findById(id).get();
        if(oldProduct == null){
            return false;
        }

        if (product.getCategoryId().equals(categoryRepository.findById(product.getProductId()))){
            oldProduct.setProductName(product.getProductName());
            oldProduct.setProductPrice(product.getProductPrice());
            productRepository.save(oldProduct);
            return true;
        }
        return false;
    }
    public Boolean deleteProduct(Integer id){
        productRepository.deleteById(id);
        return true;
    }
}
