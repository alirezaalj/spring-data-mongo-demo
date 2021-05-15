package ir.limondev.springdatamongo.repositories;


import ir.limondev.springdatamongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByName(String name);
    Optional<User> findAllByAddDateBetween(LocalDate bef,LocalDate aft);
    Collection<User> findAllByUserInfo_FirstName(String lastName);
    Collection<User> findAllByUserInfo_Numbers(String number);
    @Query("{'userHobbies.hobbyName':?0}")
    Collection<User> findUserByHobbyName(String HobbyName);
    @Query("{'userHobbies.labels':?0}")
    Collection<User> findUserByHobbyLabel(String HobbyLabel);
}
