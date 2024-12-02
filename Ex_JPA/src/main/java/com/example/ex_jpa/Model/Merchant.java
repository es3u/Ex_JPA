package com.example.ex_jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer merchantId ;
    @NotEmpty(message = "Name can not be Empty")
    @Column(unique = true , columnDefinition = "varchar(10) not null")
    @Max(10)
    private String merchantName ;
}
