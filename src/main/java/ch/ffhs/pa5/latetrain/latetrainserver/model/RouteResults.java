package ch.ffhs.pa5.latetrain.latetrainserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RouteResults {

    private int count;
    private List<Route> connections;

}
