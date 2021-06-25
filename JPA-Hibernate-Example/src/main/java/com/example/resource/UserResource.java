package com.example.resource;

import com.example.model.Users;
import com.example.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/rest/users")
public class UserResource {

    @Autowired
	private UserRepository userRepository;

	@GetMapping("/all")
	public List<Users> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{name}")
    public List<Users> getUser(@PathVariable("name") final String name) {
        return userRepository.findByName(name);

    }

    @GetMapping("/id/{id}")
    public Users getId(@PathVariable("id") final Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/update/{id}/{name}")
    public Users update(@PathVariable("id") final Integer id, @PathVariable("name")
                         final String name) {
	    
        Users users = getId(id);
        users.setName(name);

        return userRepository.save(users);
    }
}
