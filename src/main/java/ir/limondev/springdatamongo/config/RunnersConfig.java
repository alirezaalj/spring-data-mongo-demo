package ir.limondev.springdatamongo.config;

import ir.limondev.springdatamongo.model.*;
import ir.limondev.springdatamongo.repositories.PostRepository;
import ir.limondev.springdatamongo.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
//@Configuration
public class RunnersConfig {

    private final Random random = new Random();

    ApplicationRunner titleRunner(String title, ApplicationRunner rr) {
        return args -> {
            log.info("Runner :{}", title);
            rr.run(args);
        };
    }


    @Bean
    ApplicationRunner mongodbActionStart(UserRepository userRepository, PostRepository postRepository) {
        return titleRunner("mongo start action", args -> {
            userRepository.deleteAll();
            postRepository.deleteAll();
            var userList = Arrays.asList(
                    new User(null, "alireza", "alireza@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("alireza").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    ),
                    new User(null, "erfan", "erfan@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("erfan").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    ),
                    new User(null, "reza", "reza@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("reza").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    ),
                    new User(null, "shishsi", "shishisi@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("shishsi").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    ),
                    new User(null, "limona", "limona@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("limona").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    ),
                    new User(null, "esi", "esi@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("esi").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    ),
                    new User(null, "mamad", "mamad@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("mamad").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    ),
                    new User(null, "kolii", "kolii@mail.com", random.nextInt(), LocalDate.now(),
                            UserInfo.builder().firstName("kolii").lastName("alijani").numbers(getUserNumber()).fallowing(125).fallowers(186).build(),
                            getUserHobbies()
                    )
            );
            userList.forEach(user -> {
                var savedUser=userRepository.save(user);
                log.info("add user : {}", savedUser);
                postRepository.saveAll(generatePost(user,userRepository));
                log.info("add post for user {}",user.getId());
            });
        });
    }

    private List<Post> generatePost(User user,UserRepository userRepository){
        var allUsersId = userRepository.findAll().stream().map(user1 -> user.getId()).collect(Collectors.toSet());
        var labels=getUserHobbies().stream()
                .map(UserHobby::getHobbyName).collect(Collectors.toSet());
        return Arrays.asList(
                Post.builder().title("title").des("desc").date(LocalDate.now()).image("img").labels(labels)
                        .userId(user.getId()).comments(getUserComments()).likedUsers(allUsersId).build(),
                Post.builder().title("title1").des("desc").date(LocalDate.now()).image("img").labels(labels)
                        .userId(user.getId()).comments(getUserComments()).likedUsers(allUsersId).build(),
                Post.builder().title("title2").des("desc").date(LocalDate.now()).image("img").labels(labels)
                        .userId(user.getId()).comments(getUserComments()).likedUsers(allUsersId).build(),
                Post.builder().title("title3").des("desc").date(LocalDate.now()).image("img").labels(labels)
                        .userId(user.getId()).comments(getUserComments()).likedUsers(allUsersId).build()
        );
    }

    private Set<UserComment> getUserComments(){
        return Set.of(UserComment.builder().date(LocalDate.now()).comment("text").userId("userId").id(UUID.randomUUID().toString()).build(),
                UserComment.builder().date(LocalDate.now()).comment("text2").userId("userId").id(UUID.randomUUID().toString()).build(),
                UserComment.builder().date(LocalDate.now()).comment("text3").userId("userId").id(UUID.randomUUID().toString()).build(),
                UserComment.builder().date(LocalDate.now()).comment("text4").userId("userId").id(UUID.randomUUID().toString()).build());
    }

    private Set<UserHobby> getUserHobbies() {
        UserHobby[] userHobbiesa = {UserHobby.builder().hobbyName("reading").rank(20).labels(Set.of("book", "magzin", "other")).build(),
                UserHobby.builder().hobbyName("swim").rank(17).labels(Set.of("pool", "see")).build(),
                UserHobby.builder().hobbyName("computer").rank(25).labels(Set.of("computer", "game", "develop")).build(),
                UserHobby.builder().hobbyName("coding").rank(18).labels(Set.of("java", "linux", "cloud")).build(),
                UserHobby.builder().hobbyName("jugging").rank(12).labels(Set.of("run", "ورزش", "کوه")).build(),
                UserHobby.builder().hobbyName("اینستا").rank(13).labels(Set.of("پست", "ورزش", "چت")).build()
        };
        UserHobby[] userHobbiesb = {UserHobby.builder().hobbyName("ding").rank(20).labels(Set.of("sex", "porn", "girl")).build(),
                UserHobby.builder().hobbyName("fishing").rank(17).labels(Set.of("pool", "see")).build(),
                UserHobby.builder().hobbyName("golf").rank(25).labels(Set.of("computer", "game", "develop")).build(),
                UserHobby.builder().hobbyName("billeard").rank(18).labels(Set.of("java", "linux", "cloud")).build(),
                UserHobby.builder().hobbyName("bolling").rank(12).labels(Set.of("run", "ورزش", "کوه")).build(),
                UserHobby.builder().hobbyName("تلوزیون").rank(13).labels(Set.of("پست", "ورزش", "چت")).build()
        };
        UserHobby[] userHobbiesc = {UserHobby.builder().hobbyName("sleep").rank(20).labels(Set.of("some book", "history", "girl")).build(),
                UserHobby.builder().hobbyName("آشپزی").rank(17).labels(Set.of("pool", "see")).build(),
                UserHobby.builder().hobbyName("درس").rank(25).labels(Set.of("computer", "game", "develop")).build(),
                UserHobby.builder().hobbyName("بیرون رفتن").rank(18).labels(Set.of("java", "linux", "cloud")).build(),
                UserHobby.builder().hobbyName("تلگرام").rank(12).labels(Set.of("run", "ورزش", "کوه")).build(),
                UserHobby.builder().hobbyName("باشگاه").rank(13).labels(Set.of("پست", "ورزش", "چت")).build()
        };
        var a = random.nextInt(userHobbiesa.length);
        var b = random.nextInt(userHobbiesb.length);
        var c = random.nextInt(userHobbiesc.length);
        return Set.of(userHobbiesa[a], userHobbiesb[b], userHobbiesc[c]);
    }


    private Set<String> getUserNumber() {
        return Set.of(String.valueOf(random.nextInt()), String.valueOf(random.nextInt()));
    }

    @Bean
    ApplicationRunner mongodbActionFind(UserRepository userRepository) {
        return titleRunner("mongo find action", args -> {
            var userList = userRepository.findAll();
            var randomUser = userList.get(random.nextInt(userList.size()));
            var findUser = userRepository.findUserByName(randomUser.getName());
            findUser.ifPresent(single -> log.info("find user by name {} -> {}", randomUser.getName(), single));
            userRepository.findUserByHobbyName("jugging").forEach(user -> log.info("user with hobby name {}",user.getUserHobbies()));
            userRepository.findUserByHobbyLabel("java").forEach(user -> log.info("user with hobby label {}",
                    user.getUserHobbies().stream()
                    .map(UserHobby::getLabels)
                    .collect(Collectors.toSet())
            ));
        });
    }
}
