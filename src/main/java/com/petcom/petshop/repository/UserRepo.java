package com.petcom.petshop.repository;

import com.petcom.petshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
