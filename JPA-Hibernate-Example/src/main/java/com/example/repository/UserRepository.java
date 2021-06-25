package com.example.repository;

import com.example.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Integer>  {

	List<Users> findByName(String name);

	Optional<Users> findById(Integer id);


}
