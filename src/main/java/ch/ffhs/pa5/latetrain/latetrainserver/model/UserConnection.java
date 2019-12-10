package ch.ffhs.pa5.latetrain.latetrainserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.EnumSet;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler"})
public class UserConnection {

    private @Id @GeneratedValue Long id;
    @NotNull @Column(name = "from_station")
    private String from;
    @NotNull @Column(name = "to_station")
    private String to;
    @NotNull
    private LocalTime departureTimeOfDay;

    @NonNull
    private EnumSet<DayOfWeek> occurrence;

    @ManyToOne(fetch = FetchType.EAGER) @JsonIgnore
    private User user;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    public Long getUserId() {
        return user.getId();
    }

}
