package ch.ffhs.pa5.latetrain.latetrainserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    private String from;
    private LocalDateTime departure;
    private String to;
    private LocalDateTime arrival;
}