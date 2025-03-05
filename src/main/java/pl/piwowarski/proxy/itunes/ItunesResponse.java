package pl.piwowarski.proxy.itunes;

import java.util.List;

public record ItunesResponse(Integer resultCount, List<ItunesResult> results) {
}
