package ch.ffhs.pa5.latetrain.latetrainserver.model;

import java.time.LocalDateTime;
import lombok.Data;

import javax.persistence.Entity;
import java.util.List;
import org.springframework.data.annotation.Id;

@Data
public class RouteSearch {
    private String from;
    private String to;
    private LocalDateTime time;
    private boolean isTimeArrival;
}
