package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer>  {

	List<Users> findByName(String name);

	Users findOne(Integer id);

}
