package com.example.ex_jpa.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UserID ;
    @NotEmpty(message = "UserName can not be Empty")
    @Column(unique = true, columnDefinition = "varchar(20) not null ")
    @Min(3)
    @Max(20)
    private String UserName ;
    @NotEmpty(message = "Password can not be Empty")
    @Column(columnDefinition = "varchar(20) not null")
    @Min(1)
    @Max(20)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$" ,
            message = "Password must be at least 8 characters long, include uppercase and lowercase letters, a digit, and a special character.")
    private String Password ;
    @NotEmpty(message = "Email can not be Empty")
    @Column(columnDefinition = "varchar(50) not null")
    @Email
    private String email ;

    @NotEmpty(message = "Role can not be Empty")
    @Column(columnDefinition = "varchar(8) not null")
    @Check(constraints = "role = 'Admin' OR role = 'Customer'")
    @Pattern(regexp = "^(Admin|Customer)$" , message = "must be Enter between admin and Customer")
    private String Role ;

    @NotNull(message = "balance can not be null")
    @Column(columnDefinition = "double not null")
    @Positive(message = "must be positive number")
    private double balance ;

}
