package ir.limondev.springdatamongo.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import ir.limondev.springdatamongo.model.Father;
import ir.limondev.springdatamongo.model.Son;
import ir.limondev.springdatamongo.repositories.FatherRepository;
import ir.limondev.springdatamongo.repositories.SonRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Map;
import java.util.Set;

@Slf4j
@Configuration
public class TestRunnersConfig {

    ApplicationRunner titleRunner(String title, ApplicationRunner rr) {
        return args -> {
            log.info("Runner :{}", title);
            rr.run(args);
        };
    }

//    @Bean
    ApplicationRunner testRunner(FatherRepository fatherRepository, SonRepository sonRepository) {
        return titleRunner("test action", args -> {
            fatherRepository.deleteAll();
            sonRepository.deleteAll();

            var father = fatherRepository.save(new Father(null, "ali","meta data"));
            log.info("save father {}",father);

            var sonOf1 = sonRepository.saveAll(Set.of(new Son(null, "reza", father)
                    , new Son(null, "hasan", father)
                    , new Son(null, "mammd", father)));;
            log.info("save son of father1 {}",sonOf1);



            var father2 = fatherRepository.save(new Father(null, "kian","meta data"));
            log.info("save father {}",father2);
            var sonOf2=sonRepository.saveAll(Set.of(new Son(null, "sara", father2)
                    , new Son(null, "mona", father2)
                    , new Son(null, "fati", father2)));
            log.info("save son of father1 {}",sonOf2);

            sonRepository.findAll().forEach(System.out::println);
            fatherRepository.findById(father.getId())
                    .ifPresent(fined -> {
                        log.info("find father by id {} , {}",fined.getId(),fined.getName());
                        sonRepository.findAllByFatherRf(fined)
                                .forEach(son -> log.info("find son of father {} -> {}",fined.getName(),son));
                    });
        });
    }

//    @Bean
    ApplicationRunner mongoClientTestRunner(){
        return titleRunner("mongo client test",args -> {
            MongoClient mongoClient= MongoClients.create("mongodb://localhost:27017");
//            mongoClient.listDatabaseNames().forEach(name -> log.info("mongoClient find data base {}",name));
            var testDb = mongoClient.getDatabase("testdb");
            var fatherCollection = testDb.getCollection("father");
//            var newFather=new Document(Map.of("name","mamad",
//                    "meta","new Meta data"));
//            fatherCollection.insertOne(newFather);

            fatherCollection.find().forEach(document -> log.info("father : {}",document.get("name")));

        });
    }

//    @Bean
    ApplicationRunner mongoTemplateTestRunner(){
        return titleRunner("mongo template test",args -> {
            var template = new MongoTemplate(MongoClients.create("mongodb://localhost:27017"),"testdb");

        });
    }
}
