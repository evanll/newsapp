package newsapi;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Top headlines endpoint
 */
public class TopHeadlinesEndpoint extends ArticlesEndpoint {

    public TopHeadlinesEndpoint() {
        super();
        this.setRootUrl("https://newsapi.org/v2/top-headlines?");
    }

    @Override
    WebTarget buildWebTarget(ApiRequest apiRequest, Client client) {
        WebTarget webTarget = client.target(this.getRootUrl());

        if (apiRequest.getQ() != null) {
            webTarget = webTarget.queryParam("q", apiRequest.getQ());
        }

        if (apiRequest.getSources() != null) {
            webTarget = webTarget.queryParam("sources", apiRequest.getSources());
        }

        if (apiRequest.getLang() != null) {
            webTarget = webTarget.queryParam("language", apiRequest.getLang());
        }

        if (apiRequest.getCountry() != null) {
            webTarget = webTarget.queryParam("country", apiRequest.getCountry());
        }

        if (apiRequest.getCategory() != null) {
            webTarget = webTarget.queryParam("category", apiRequest.getCategory());
        }

        return webTarget;
    }
}
