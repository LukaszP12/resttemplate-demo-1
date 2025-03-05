package pl.piwowarski.sampleshawnmendes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piwowarski.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;
import pl.piwowarski.sampleshawnmendes.proxy.SampleShawnMendesServerProxy;

@Service
public class ShawnMendesService {

    @Autowired
    SampleShawnMendesServerProxy sampleShawnMendesServerClient;

    @Autowired
    ShawnMendesServiceMapper shawnMendesServiceMapper;

    public void testClient() throws JsonProcessingException {
        String getJsonSampleShawnMendesServer = sampleShawnMendesServerClient.makeGetRequest();
        if (getJsonSampleShawnMendesServer != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToItunesResponse(getJsonSampleShawnMendesServer);
            System.out.println(sampleShawnMendesResponse);
        }
        sampleShawnMendesServerClient.makeDeleteRequest(0);
        String getJsonSampleShawnMendesServer2 = sampleShawnMendesServerClient.makeGetRequest();
        if (getJsonSampleShawnMendesServer2 != null) {
            SampleServerShawnMendesResponse sampleServerShawnMendesResponse = shawnMendesServiceMapper.mapJsonToItunesResponse(getJsonSampleShawnMendesServer2);
            System.out.println(sampleServerShawnMendesResponse);
        }

        if (getJsonSampleShawnMendesServer2 != null) {
            SampleServerShawnMendesResponse sampleShawnMendesResponse = shawnMendesServiceMapper.mapJsonToItunesResponse(getJsonSampleShawnMendesServer2);
            System.out.println(sampleShawnMendesResponse);
        }
    }

    private static SampleServerShawnMendesResponse mapJsonToSampleShawnMendesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }

}
