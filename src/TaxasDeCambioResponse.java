
import java.util.Map;

// Usamos um 'record' para representar de forma concisa os dados que nos interessam da API.
// Ele mapeia diretamente a estrutura do JSON de resposta.
public record TaxasDeCambioResponse(Map<String, Double> conversion_rates) {
}







