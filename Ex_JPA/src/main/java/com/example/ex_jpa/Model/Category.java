package com.example.ex_jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotEmpty(message = "Category Name can not be Empty")
    @Min(value = 3 , message = "Enter the Name between 4 to 30")
    @Column(columnDefinition = "varchar(10) not null")
    private String categoryName;


}
