package ch.ffhs.pa5.latetrain.latetrainserver;

import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import ch.ffhs.pa5.latetrain.latetrainserver.service.RouteSearchService;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.EnumSet;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LatetrainServerApplication {

    @Autowired
    RouteSearchService rss;

    public static void main(String[] args) {
        SpringApplication.run(LatetrainServerApplication.class, args);
    }

    @PostConstruct
    public void test(){
        UserConnection uc = new UserConnection(0L, "Bern", "Zürich", LocalTime.of(17,32,00), EnumSet.allOf(DayOfWeek.class),null);
        System.out.println("Result: "+rss.getRouteSearchResult(uc));
    }

}
