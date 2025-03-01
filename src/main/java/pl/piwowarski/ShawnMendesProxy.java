package pl.piwowarski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShawnMendesProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("${shawnmendes.service.url}")
    String url;

    @Value("#{1+2}")
    int suma;

    public String makeSearchRequest(String term, Integer limit) {
        String uri = url + "/search?term=" + term + "&" + "limit=" + limit;
        ResponseEntity<String> exchange = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                String.class
        );
        return exchange.getBody();
    }

}
