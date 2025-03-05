package pl.piwowarski.sampleshawnmendes.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.piwowarski.sampleshawnmendes.proxy.SampleServerShawnMendesResponse;

@Component
class ShawnMendesServiceMapper {

    SampleServerShawnMendesResponse mapJsonToItunesResponse(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, SampleServerShawnMendesResponse.class);
    }
}
