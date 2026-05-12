package ch.projectSE;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;


public class VendureClient {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final String apiUrl;
    private final HttpClient httpClient;

    public VendureClient(String apiUrl) {
        this.apiUrl = apiUrl;
        this.httpClient = HttpClient.newHttpClient();
    }

    public <T> T execute(GraphQLQuery<T> query) throws Exception {

        String body = MAPPER.writeValueAsString(Map.of("query", query.getQuery()));

        HttpRequest request =
                HttpRequest.newBuilder()
                        .uri(URI.create(apiUrl))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(body))
                        .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return query.parseResponse(response.body());
    }
}
