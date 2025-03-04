package pl.piwowarski;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ItunesProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("${itunes.service.url}")
    String url;

    @Value("${itunes.service.port}")
    int port;

    public String makeShawnMendesRequest(String term, Integer limit) throws JsonProcessingException {
        UriComponentsBuilder builder = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host(url)
                .port(port)
                .path("/search")
                .queryParam("term", "shawnMendes")
                .queryParam("limit", 5);
        String uri = builder.build().toString();
        return makeRequest(uri);
    }

    private String makeRequest(String uri) {
        try {
            ResponseEntity<String> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    String.class
            );
            return response.getBody();
        } catch (RestClientResponseException exception) {
            System.out.println(exception.getStatusText() + " " + exception.getStatusCode().value());
        } catch (ResourceAccessException exception) {
            System.out.println(exception.getMessage());
        } catch (RestClientException exception) {
            System.out.println(exception.getMessage());
        }
        return null;
    }

}
