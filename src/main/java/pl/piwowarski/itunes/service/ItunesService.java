package pl.piwowarski.itunes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.piwowarski.itunes.proxy.ItunesProxy;
import pl.piwowarski.itunes.proxy.ItunesResponse;

@Service
public class ItunesService {

    @Autowired
    ItunesProxy itunesClient;

    public void fetchShawnMendesSongs() throws JsonProcessingException {
        String json = itunesClient.makeGetRequest("shawnmendes", 3);
        if (json != null) {
            ItunesResponse itunesResponse = mapJsonToItunesResponse(json);
            System.out.println(itunesResponse);
        }
    }

    private static ItunesResponse mapJsonToItunesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ItunesResponse.class);
    }

}
