package ir.limondev.springdatamongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Post {
    @Id
    private String id;
    private String userId;
    private String title;
    private String des;
    private LocalDate date;
    private Set<String> labels;
    private String image;
    private Set<UserComment> comments;
    private Set<String> likedUsers;
}
