package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.MerchantStock;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Repository.MerchantRepository;
import com.example.ex_jpa.Repository.MerchantStockRepository;
import com.example.ex_jpa.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantStockService {
    private final MerchantStockRepository merchantStockRepository;
    private final MerchantRepository merchantRepository;
    private final ProductRepository productRepository;
    public List findAll() {
        return merchantStockRepository.findAll();
    }

    public Boolean addMerchantStock(MerchantStock merchantStock) {
        if (merchantStock.getProductId().equals(productRepository.findById(merchantStock.getProductId()))){
            if (merchantStock.getMerchantId().equals(merchantRepository.findById(merchantStock.getMerchantId()))) {
                merchantStockRepository.save(merchantStock);
                return true;
            }
        }
        return false;
    }
    public Boolean updateMerchantStock(Integer id ,MerchantStock merchantStock) {
        MerchantStock result = merchantStockRepository.findById(id).get();
        if (result == null){
            return false;
        }
        if (merchantStock.getProductId().equals(productRepository.findById(merchantStock.getProductId()))) {
            if (merchantStock.getMerchantId().equals(merchantRepository.findById(merchantStock.getMerchantId()))) {
                result.setMerchantId(merchantStock.getMerchantId());
                result.setProductId(merchantStock.getProductId());
                result.setStock(merchantStock.getStock());
                result.setMerchantName(merchantStock.getMerchantName());
                merchantStockRepository.save(merchantStock);
                return true;
            }
        }
        return false;
    }

    public Boolean deleteMerchantStock(Integer id) {
        MerchantStock result = merchantStockRepository.findById(id).get();
        if (result == null){
            return false;

        }
        merchantStockRepository.delete(result);
        return true;
    }


    public Boolean addStock(Integer id ,Integer merchantId  ,Integer productId , Integer stock  ) {

        MerchantStock result = merchantStockRepository.findById(id).get();

        if (productId.equals(merchantStockRepository.findById(productId).get().getId()) && merchantId.equals(merchantStockRepository.findById(merchantId).get().getId()) && id.equals(merchantStockRepository.findById(productId).get().getId())) {

            result.setStock(stock + result.getStock());
            return true;
        }

        return false;
        }


    }

