package pl.piwowarski;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import pl.piwowarski.itunes.service.ItunesService;
import pl.piwowarski.sampleshawnmendes.service.ShawnMendesService;

@SpringBootApplication
public class RestTemplateApplication {

    @Autowired
    ItunesService itunesService;

    @Autowired
    ShawnMendesService shawnMendesClient;

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
        itunesService.fetchShawnMendesSongs();
        shawnMendesClient.testClient();
    }

}
