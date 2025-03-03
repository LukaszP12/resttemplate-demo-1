package pl.piwowarski;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import static pl.piwowarski.ShawnMendesProxy.mapJsonToShawnMendesResponse;

@SpringBootApplication
public class RestTemplateApplication {

    @Autowired
    ShawnMendesProxy shawnMendesClient;

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMendesEndpoint() throws JsonProcessingException {
        String json = shawnMendesClient.makeShawnMendesRequest("shawnmendes", 5);
        if (json != null) {
            ShawnMendesResponse shawnMendesResponse = mapJsonToShawnMendesResponse(json);
            System.out.println(shawnMendesResponse);
        }
    }
}
