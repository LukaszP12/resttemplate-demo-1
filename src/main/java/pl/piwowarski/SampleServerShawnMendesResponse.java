package pl.piwowarski;

import java.util.List;

public record SampleServerShawnMendesResponse(
        String message,
        List<String> songNames
) {
}
