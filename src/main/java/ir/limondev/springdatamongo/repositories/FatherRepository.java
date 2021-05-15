package ir.limondev.springdatamongo.repositories;

import ir.limondev.springdatamongo.model.Father;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FatherRepository extends MongoRepository<Father,String> {
}
