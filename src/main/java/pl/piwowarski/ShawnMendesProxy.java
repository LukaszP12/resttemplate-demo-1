package pl.piwowarski;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class ShawnMendesProxy {

    @Autowired
    RestTemplate restTemplate;

    @Value("${shawnmendes.service.url}")
    String url;

//    @Value("#{1+2}")
//    int suma;

    public String makeShawnMendesRequest(String term, Integer limit) throws JsonProcessingException {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.queryParam("term", "shawnMendes");
        builder.queryParam("limit", 5);
        UriComponents append = builder.build();
//        String uri = url + "/search?term=" + term + "&limit=" + limit;
        String uri = url + "/search" + append;
        return makeRequest(uri);
    }

    public static ShawnMendesResponse mapJsonToShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ShawnMendesResponse.class);
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
