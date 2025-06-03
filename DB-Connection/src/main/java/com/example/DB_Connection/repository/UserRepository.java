package com.example.DB_Connection.repository;

import com.example.DB_Connection.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
