


import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Cliente para interagir com a API de taxas de câmbio.
 */
public class ApiCliente {

    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    /**
     * Busca as taxas de câmbio mais recentes para uma determinada moeda base.
     * @param apiKey Sua chave da API.
     * @param moedaBase A moeda base para a qual buscar as taxas (ex: "USD", "BRL").
     * @return Um objeto TaxasDeCambioResponse contendo as taxas.
     * @throws IOException Se ocorrer um erro de rede ou a API retornar um status de erro.
     * @throws InterruptedException Se a requisição for interrompida.
     */
    public TaxasDeCambioResponse getTaxas(String apiKey, String moedaBase) throws IOException, InterruptedException {
        // Constrói a URL final para a requisição
        String endereco = API_URL + apiKey + "/latest/" + moedaBase;

        // Cria o cliente HTTP e a requisição
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        // Envia a requisição e obtém a resposta
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Verifica se a requisição foi bem-sucedida (código 200)
        if (response.statusCode() != 200) {
            throw new IOException("Erro ao buscar taxas de câmbio. Código de status: " + response.statusCode());
        }

        // Usa a biblioteca Gson para converter a string JSON em nosso objeto Java
        return new Gson().fromJson(response.body(), TaxasDeCambioResponse.class);
    }

}














