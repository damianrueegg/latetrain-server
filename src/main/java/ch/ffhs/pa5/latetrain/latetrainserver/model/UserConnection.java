package ch.ffhs.pa5.latetrain.latetrainserver.model;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.EnumSet;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
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

    @ManyToOne
    private User user;

}
