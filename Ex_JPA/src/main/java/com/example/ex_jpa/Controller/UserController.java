package com.example.ex_jpa.Controller;

import com.example.ex_jpa.Model.User;
import com.example.ex_jpa.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    public ResponseEntity addUser(@RequestBody@Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        userService.save(user);
        return ResponseEntity.ok().body("added successfully");
    }

    public ResponseEntity updateUser(@PathVariable Integer id , @RequestBody@Valid User user , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        }
        Boolean isUpdate = userService.updateUser(id,user);
        if(isUpdate){
            return ResponseEntity.ok().body("updated successfully");
        }
        return ResponseEntity.badRequest().body("update failed");
    }

    public ResponseEntity deleteUser(@PathVariable Integer id ){
        Boolean isDelete = userService.deleteUser(id);
        if(isDelete){
            return ResponseEntity.ok().body("deleted successfully");

        }

        return ResponseEntity.badRequest().body("delete failed");
    }

}
