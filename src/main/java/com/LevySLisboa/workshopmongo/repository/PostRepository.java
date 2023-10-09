package com.LevySLisboa.workshopmongo.repository;

import com.LevySLisboa.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    @Query("{ tittle: { $regex: ?0, $options: 'i' } }")
    List<Post> searchTittle(String text);
    List<Post> findByTittleContainingIgnoreCase(String text);

}
