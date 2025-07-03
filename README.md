# ☕ Conversor de Moedas com Menu Fixo (Java)



Este projeto consiste em um conversor de moedas interativo que opera diretamente no console, desenvolvido em Java. A aplicação apresenta um menu fixo com 6 opções de conversão entre pares de moedas populares (Dólar Americano, Real Brasileiro, Euro e Peso Argentino).

O principal recurso do projeto é a obtenção das taxas de câmbio em tempo real através da [ExchangeRate-API](https://www.exchangerate-api.com), garantindo que os cálculos sejam sempre baseados em dados precisos e atuais. A aplicação foi otimizada para realizar uma única requisição à API por sessão, tornando-a eficiente.

---

## ✨ Funcionalidades

-   **Menu Fixo e Intuitivo**: Oferece 6 opções de conversão claramente definidas para o usuário.
-   **Taxas de Câmbio em Tempo Real**: Conecta-se a uma API externa para buscar as taxas mais recentes a cada execução.
-   **Eficiência de Rede**: Realiza apenas uma chamada de API no início do programa para carregar todas as taxas necessárias.
-   **Cálculo de Conversão Direta e Inversa**: Capaz de calcular conversões tanto da moeda base (USD) para outras, quanto de outras moedas para a base (ex: BRL -> USD).
-   **Interface de Console**: Interação com o usuário de forma simples e direta através do terminal.
-   **Tratamento de Erros**: Valida as entradas do usuário e trata possíveis falhas de conexão com a API.

---

## 🛠️ Tecnologias Utilizadas

-   **Java 11+**: Linguagem principal do projeto.
-   **Maven**: Para gerenciamento de dependências e do ciclo de vida do projeto.
-   **Gson (Google)**: Biblioteca para interpretar (fazer o "parse") da resposta JSON da API.
-   **Java HTTP Client**: Cliente HTTP nativo do Java 11 para realizar as requisições à API.
-   **ExchangeRate-API**: Fonte de dados para as taxas de câmbio.

---

## 🚀 Como Executar o Projeto

Siga os passos abaixo para executar o projeto em sua máquina local.

### Pré-requisitos

-   [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/) - Versão 11 ou superior.
-   [Apache Maven](https://maven.apache.org/download.cgi) - Gerenciador de dependências.
-   [Git](https://git-scm.com/downloads) - Para clonar o repositório.

### Passos

1.  **Clone o seu repositório:**
    ```bash
    git clone [https://github.com/valdineisiviero/conversor-de-moedas.git](https://github.com/valdineisiviero/conversor-de-moedas.git)
    cd conversor-de-moedas
    ```

2.  **Obtenha uma Chave de API:**
    -   Acesse [https://www.exchangerate-api.com](https://www.exchangerate-api.com) e crie uma conta gratuita para obter sua API Key.

3.  **Configure a Chave de API no Projeto:**
    -   Abra o arquivo: `src/main/java/Principal.java`.
    -   Encontre a linha: `String apiKey = "SUA_API_KEY";`
    -   Substitua `"SUA_API_KEY"` pela chave que você obteve.

4.  **Compile e Execute o Projeto com Maven:**
    -   No terminal, a partir da pasta raiz do projeto, execute o seguinte comando:
    ```bash
    mvn clean install exec:java -Dexec.mainClass="Principal"
    ```

---

## ⚙️ Exemplo de Uso

Após a execução, o console irá interagir com você da seguinte forma:

```text
Buscando taxas de câmbio atualizadas...
Taxas carregadas com sucesso!

Bem-vindo ao Conversor de Moedas!
1. Dólar Americano (USD) para Real Brasileiro (BRL)
2. Real Brasileiro (BRL) para Dólar Americano (USD)
3. Dólar Americano (USD) para Euro (EUR)
4. Euro (EUR) para Dólar Americano (USD)
5. Dólar Americano (USD) para Peso Argentino (ARS)
6. Peso Argentino (ARS) para Dólar Americano (USD)
7. Sair
Escolha uma opção: 2
Digite o valor a ser convertido: 100

===== Resultado da Conversão =====
Valor original: 100.00 BRL
Taxa de câmbio (1 BRL = 0.1833 USD)
Valor convertido: 18.33 USD

--------------------------------------------------

Bem-vindo ao Conversor de Moedas!
...
Escolha uma opção: 7
Obrigado por usar o Conversor de Moedas! Encerrando...
```

---

## 👨‍💻 Autor

Feito com ❤️ por **Valdinei Siviero**.


[![GitHub])](https://github.com/valdineisiviero)

---


