package ir.limondev.springdatamongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserHobby {
    private int id;
    private String hobbyName;
    private int rank;
    private Set<String> labels;
}
