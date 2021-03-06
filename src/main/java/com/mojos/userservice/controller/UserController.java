package com.mojos.userservice.controller;

import com.mojos.userservice.model.UserRequest;
import com.mojos.userservice.model.UserResponse;
import com.mojos.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

   @Autowired
    private UserService userService;

//    public UserController(){
//        userService = UserService.INSTANCE;
//    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> crate(@RequestBody UserRequest userRequest){
        UserResponse userResponse = null;
        try {
            userResponse = userService.crete(userRequest);
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        return ResponseEntity.ok(userResponse);
    }

    @GetMapping("/userId/{id}")
    public ResponseEntity<UserResponse> get(@PathVariable String id){

        Optional<UserResponse> userResponse = userService.get(id);
        if (userResponse.isPresent())
            return ResponseEntity.ok(userResponse.get());
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmailId(@PathVariable String email){
        Optional<UserResponse> userResponse = userService.getUserByEmail(email);
        if (userResponse.isPresent())
            return ResponseEntity.ok(userResponse.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<UserResponse> put(@RequestBody UserRequest userRequest){
        UserResponse userResponse = null;
        try{
            userResponse = userService.update(userRequest);
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        return ResponseEntity.ok(userResponse);
    }
//delete by userid
    @DeleteMapping("/userId/{userId}")
    public ResponseEntity<String> delete(@PathVariable String userId){
        try {
            userService.delete(userId);
        }catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        return ResponseEntity.ok().build();
    }
}