package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.GetBuy;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Repository.GetBuyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBuyService {

    private final GetBuyRepository getBuyRepository;

    public List findall(){
        return getBuyRepository.findAll();
    }

    public void addGetBuy( Product getBuy){

//        getBuyRepository.save(getBuy)
    }
}
