package ch.ffhs.pa5.latetrain.latetrainserver.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private Long   id;

    @NonNull @NotEmpty
    private String username;

    @NonNull @NotEmpty
    private String password;
    @Transient
    private String passwordConfirm;

    private String role = "MOBILE_USER";

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private Set<UserConnection> connections;
}
