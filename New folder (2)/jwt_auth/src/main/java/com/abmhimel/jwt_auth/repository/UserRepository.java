package com.abmhimel.jwt_auth.repository;

import com.abmhimel.jwt_auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,UUID> {
  Optional<User> findByEmail(String email);
}
