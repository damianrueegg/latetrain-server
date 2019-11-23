package ch.ffhs.pa5.latetrain.latetrainserver.model.client;

import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

public class RouteRestClient {

    private static final String RESOURCE_PATH;

    static {
        RESOURCE_PATH = "/rest/routes";
    }

    private Logger LOG = (Logger) LoggerFactory.getLogger(RouteRestClient.class);
    private String REQUEST_URI;
    private RestTemplate restTemplate;
    public RouteRestClient(RestTemplate restTemplate, String host, int port) {
        this.restTemplate = restTemplate;
        this.REQUEST_URI = host + ":" + port + RESOURCE_PATH;
    }
}
