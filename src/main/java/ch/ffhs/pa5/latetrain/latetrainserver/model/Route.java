package ch.ffhs.pa5.latetrain.latetrainserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    private String from;
    private String to;
    private LocalTime departureTimeOfDay;
}