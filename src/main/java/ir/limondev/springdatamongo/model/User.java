package ir.limondev.springdatamongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("user_col")
public class User {
    @Id
    private String id;
    @Indexed(direction = IndexDirection.ASCENDING)
    private String name;
    @TextIndexed
    private String email;
    private Integer random;
    private LocalDate addDate;
    private UserInfo userInfo;
    private Set<UserHobby> userHobbies;
}
