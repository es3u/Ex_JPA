package com.example.ex_jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MerchantStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Product ID can not be Empty")
    @Column(unique = true , columnDefinition = "int not null")
    @Size(min = 1 , max = 10 )
    private Integer productId;
    @NotEmpty(message = "merchant ID can not be Empty")
    @Column(unique = true , columnDefinition = "int not null")
    @Size(min = 1 , max = 10 )
    private Integer merchantId;
    @NotEmpty(message = "merchant Name can not be Empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Size(min = 1 , max = 10 )
    private String merchantName;
    @NotNull(message = "stock can not be Null")
    @Column(columnDefinition = "int not null")
    @Min(10)
    private Integer stock;
}
