package com.LevySLisboa.workshopmongo.services;

import com.LevySLisboa.workshopmongo.domain.User;
import com.LevySLisboa.workshopmongo.dto.UserDTO;
import com.LevySLisboa.workshopmongo.repository.UserRepository;
import com.LevySLisboa.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado"));
    }
    public User insert(User obj){
        return repository.insert(obj);
    }

    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(),objDTO.getName(), objDTO.getEmail());
    }
}
