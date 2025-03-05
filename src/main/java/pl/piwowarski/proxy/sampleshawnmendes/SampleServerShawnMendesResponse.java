package pl.piwowarski.proxy.sampleshawnmendes;

import java.util.List;

public record SampleServerShawnMendesResponse(
        String message,
        List<String> songNames
) {
}
