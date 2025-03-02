package pl.piwowarski;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class RestTemplateApplication {

    @Autowired
    ShawnMendesProxy shawnMendesClient;

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint() throws JsonProcessingException {
        ShawnMendesResponse response = shawnMendesClient.makeSearchRequest("shawnmendes", 5);
        System.out.println(response);
        Integer integer = response.resultCount();
        List<ShawnMendesResult> results = response.results();
    }
}
