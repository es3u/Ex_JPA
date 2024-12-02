package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.Merchant;
import com.example.ex_jpa.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MerchantSevice {
    private final MerchantRepository merchantRepository;

    public List findAll(){
        return merchantRepository.findAll();
    }
    public void addMerchant(Merchant merchant){
        merchantRepository.save(merchant);
    }
    public Boolean updateMerchant(Integer id ,Merchant merchant){
        Merchant oldMerchant = merchantRepository.findById(id).get();
        if (oldMerchant != null){
            oldMerchant.setMerchantName(merchant.getMerchantName());
            merchantRepository.save(oldMerchant);
            return true;
        }
        return false;
    }
    public Boolean deleteMerchant(Integer id){
        Merchant merchant = merchantRepository.findById(id).get();
        if (merchant != null){
            merchantRepository.delete(merchant);
            return true;
        }
        return false;
    }


}
