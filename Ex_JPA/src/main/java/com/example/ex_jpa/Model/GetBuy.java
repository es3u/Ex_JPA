package com.example.ex_jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GetBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    @NotEmpty(message = "Product Name can not be Empty")
    @Column(unique = true , columnDefinition = "varchar(30) not null")
    @Size(min = 4 , max = 30 , message = "Enter Name between 4 to 30")
    private String productName;
    @NotNull(message = "Product price can not be null")
    @Column(columnDefinition = "double not null")
    @Positive(message = "Price must be positive number")
    private Double productPrice;
    @NotEmpty(message = "category ID can not be Empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Size(min = 1 , max = 10 , message = "Enter category ID between 1 to 10")
    private String categoryId;

//    @NotNull
//    @Column(unique = true , columnDefinition = "int not null")
//    private Integer userId;
}
