package com.example.DB_Connection.repository;

import com.example.DB_Connection.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Do not need to implement because the Spring JPA will automatically generate a query to DB
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    public boolean existsUsersByUsername(String username);  // Do not need to implement because the Spring JPA will automatically generate a query to DB
}
