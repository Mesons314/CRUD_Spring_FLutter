package com.flutterApp.crud.Controller;


import com.flutterApp.crud.Entity.UserInfo;
import com.flutterApp.crud.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flutter")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addUser(@RequestBody UserInfo user){
        try {
            user = service.add(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getUser")
    public ResponseEntity<List<UserInfo>> getUsers(){
        try {
            List<UserInfo> user = service.getUser();
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<UserInfo> getUserById(@PathVariable int id){
        try {
            UserInfo user = service.getById(id);
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable int id, @RequestBody UserInfo user){
        try {
            user = service.updateUsers(id,user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id){
        try {
            service.delete(id);
            return ResponseEntity.ok("Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
