package ch.ffhs.pa5.latetrain.latetrainserver.model;

import lombok.Data;

import javax.persistence.Entity;
import java.util.List;

@Data
@Entity
public class RouteSearch {
    private long id;
    private List<Route> routes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }
}
