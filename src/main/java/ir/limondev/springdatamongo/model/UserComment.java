package ir.limondev.springdatamongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserComment {
    private String id;
    private String comment;
    private String userId;
    private LocalDate date;
    private Set<UserComment> rplay;
}
