package util;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import exception.RequisicaoException;

public class ClienteHttp {
    public String buscaDados(String url) {
        try {
            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();

        } catch (IOException | InterruptedException error) {
            throw new RequisicaoException(error);
        }

    }
}
