package com.flutterApp.crud.Repo;

import com.flutterApp.crud.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<UserInfo,Integer> {
    void deleteByIdIn(List<Integer> id);
}
