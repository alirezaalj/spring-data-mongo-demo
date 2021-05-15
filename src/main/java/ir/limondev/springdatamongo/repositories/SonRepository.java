package ir.limondev.springdatamongo.repositories;

import ir.limondev.springdatamongo.model.Father;
import ir.limondev.springdatamongo.model.Son;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

public interface SonRepository extends MongoRepository<Son,String> {
    Collection<Son> findAllByFatherRf(Father fatherId);
    Collection<Son> findAllByName(String name);
}
