package ir.limondev.springdatamongo.repositories;

import ir.limondev.springdatamongo.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post,String> {
}
