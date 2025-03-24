package com.flutterApp.crud.Service;

import com.flutterApp.crud.Entity.UserInfo;
import com.flutterApp.crud.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public UserInfo add(UserInfo user) {
       return repo.save(user);
    }

    public List<UserInfo> getUser() {
        return repo.findAll();
    }

    public UserInfo getById(int id) {
        return repo.findById(id).orElse(null);
    }

    public UserInfo updateUsers(int id, UserInfo userDetails) {
        UserInfo existingUser = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userDetails.getFirstName() != null) {
            existingUser.setFirstName(userDetails.getFirstName());
        }
        if (userDetails.getLastName() != null) {
            existingUser.setLastName(userDetails.getLastName());
        }
        if (userDetails.getGender() != null) {
            existingUser.setGender(userDetails.getGender());
        }
        if (userDetails.getDob() != null) {
            existingUser.setDob(userDetails.getDob());
        }
        if (userDetails.getAge() != null) {
            existingUser.setAge(userDetails.getAge());
        }
        if (userDetails.getLocation() != null) {
            existingUser.setLocation(userDetails.getLocation());
        }

        return repo.save(existingUser);
    }


    public void delete(int id) {
        repo.deleteById(id);
    }
}
