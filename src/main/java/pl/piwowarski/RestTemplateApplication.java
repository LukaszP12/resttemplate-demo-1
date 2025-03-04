package pl.piwowarski;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestTemplateApplication {

    @Autowired
    ItunesProxy shawnMendesClient;

    @Autowired
    SampleShawnMendesServerProxy sampleShawnMendesServerProxy;

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void run() throws JsonProcessingException {
//        String json = shawnMendesClient.makeShawnMendesRequest("shawnmendes", 5);
//        if (json != null) {
//            ShawnMendesResponse shawnMendesResponse = mapJsonToShawnMendesResponse(json);
//            System.out.println(shawnMendesResponse);
//        }

//        String postJsonSampleShawnMendesServer = sampleShawnMendesServerProxy.makePostRequest();
        String getJsonSampleShawnMendesServer = sampleShawnMendesServerProxy.makeGetRequest();
        if (getJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleServerShawnMendesResponse = mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer);
            System.out.println(sampleServerShawnMendesResponse);
        }

        sampleShawnMendesServerProxy.makeDeleteRequest(1);
        String getJsonSampleShawnMendesServer2 = sampleShawnMendesServerProxy.makeGetRequest();
//        if (postJsonSampleShawnMendesServer != null) {
//            SampleServerShawnMendesResponse sampleServerShawnMendesResponse = mapJsonToSampleShawnMendesResponse(postJsonSampleShawnMendesServer);
//            System.out.println(sampleServerShawnMendesResponse);
//        }

        if (getJsonSampleShawnMendesServer2 != null) {
            SampleServerShawnMendesResponse sampleServerShawnMendesResponse = mapJsonToSampleShawnMendesResponse(getJsonSampleShawnMendesServer2);
            System.out.println(sampleServerShawnMendesResponse);
        }
    }

    private static ShawnMendesResponse mapJsonToShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ShawnMendesResponse.class);
    }

    private static SampleServerShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }
}
