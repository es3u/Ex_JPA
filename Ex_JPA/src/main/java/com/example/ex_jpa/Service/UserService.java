package com.example.ex_jpa.Service;

import com.example.ex_jpa.Model.GetBuy;
import com.example.ex_jpa.Model.Product;
import com.example.ex_jpa.Model.User;
import com.example.ex_jpa.Repository.GetBuyRepository;
import com.example.ex_jpa.Repository.MerchantStockRepository;
import com.example.ex_jpa.Repository.ProductRepository;
import com.example.ex_jpa.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final MerchantStockRepository merchantStockRepository;
    private final ProductRepository productRepository;
    private final GetBuyService getBuyService;
    private final GetBuyRepository getBuyRepository;


    public List findAll(){

        return userRepository.findAll();
    }
    public void save(User user){
        userRepository.save(user);
    }

    public Boolean updateUser(Integer id ,User user){
        User oldUser = userRepository.findById(id).get();

        if (oldUser != null){
            oldUser.setUserName(user.getUserName());
            oldUser.setPassword(user.getPassword());
            oldUser.setEmail(user.getEmail());
            oldUser.setBalance(user.getBalance());
            oldUser.setRole(user.getRole());
            userRepository.save(oldUser);

            return true;
        }
        return false;

    }



    public Boolean deleteUser(Integer id){
        userRepository.deleteById(id);
        return true;
    }


    public int buy(Integer id , Integer merchentId , Integer productId){
        User user = userRepository.findById(id).get();
        Product product = productRepository.findById(productId).get();
//        GetBuy getBuy = productRepository.findById(productId).get();
        if (user == null){
            return 0;
        }



        if (merchentId.equals(merchantStockRepository.findById(productId).get().getMerchantId()) && productId.equals(merchantStockRepository.findById(productId).get().getProductId()
        )){
           user.setBalance(user.getBalance() - productRepository.findById(productId).get().getProductPrice() );
           userRepository.save(user);

           merchantStockRepository.findById(merchentId).get().setStock(merchantStockRepository.findById(productId).get().getStock() - 1);




           return 1;

        }

        return 2;
    }








}
