package pl.piwowarski.itunes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.piwowarski.itunes.proxy.ItunesResponse;

@Component
class ItunesMapper {

    ItunesResponse mapJsonToItunesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ItunesResponse.class);
    }
}
