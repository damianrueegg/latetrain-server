package ch.ffhs.pa5.latetrain.latetrainserver.service;

import ch.ffhs.pa5.latetrain.latetrainserver.model.RouteSearch;
import ch.ffhs.pa5.latetrain.latetrainserver.model.UserConnection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RouteSearchService {

    @Value("${latetrain.external.api.baseurl}")
    private String url;

    @Value("${latetrain.external.api.routeuri}")
    private String uri;

    @Autowired
    RestTemplate restTemplate;

    public String getRouteSearchResult(UserConnection userConnection) {
        String target = url + uri;

        target = UriComponentsBuilder.fromHttpUrl(target)
                                     .queryParam("from", userConnection.getFrom())
                                     .queryParam("to", userConnection.getTo())
                                     .queryParam("time", userConnection.getDepartureTimeOfDay().toString())
                                     .build().toString();
        ResponseEntity<String> forEntity = restTemplate.getForEntity(target, String.class);

        return forEntity.getBody();
    }

}
