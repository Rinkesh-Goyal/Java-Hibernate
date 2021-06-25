package com.example.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Users;
import com.example.repository.UserRepository;



@RestController
@RequestMapping("/rest/users")
public class UserResource {

	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/all")
	public List<Users> getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/{name}")
    public List<Users> getUser(@PathVariable("name") final String name) {
        return userRepo.findByName(name);

    }

    @GetMapping("/id/{id}")
    public Users getId(@PathVariable("id") final Integer id) {
        return userRepo.findOne(id);
    }

    @GetMapping("/update/{id}/{name}")
    public Users update(@PathVariable("id") final Integer id, @PathVariable("name")
                         final String name) {


        Users users = getId(id);
        users.setName(name);

        return userRepo.save(users);
    }
}
