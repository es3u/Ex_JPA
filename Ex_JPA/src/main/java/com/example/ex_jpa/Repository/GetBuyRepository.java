package com.example.ex_jpa.Repository;

import com.example.ex_jpa.Model.GetBuy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetBuyRepository extends JpaRepository<GetBuy,Integer> {
}
