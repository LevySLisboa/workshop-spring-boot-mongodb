package com.LevySLisboa.workshopmongo.services;

import com.LevySLisboa.workshopmongo.domain.Post;
import com.LevySLisboa.workshopmongo.repository.PostRepository;
import com.LevySLisboa.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices {
    @Autowired
    private PostRepository repository;

    public Post findById(String id) {
        Optional<Post> post = repository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repository.findByTittleContainingIgnoreCase(text);
    }
}
