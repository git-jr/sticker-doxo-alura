import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println();
        System.out.println("\u001b[1m\u001b[37m\u001b[44m Lista Filmes \u001b[m");
        System.out.println();

        // API do IMG fora do ar ainda...
        // String url = "https://imdb-api.com/en/API/Top250Movies/k_12345678";

        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";

        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);
        listaDeFilmes = listaDeFilmes.subList(0,10); // Limitando para testes

        adicionaFilmeComNotaBaixa(listaDeFilmes);

        final var listaTextoMemes = Arrays.asList("TOPZERA", "METEU ESSA?!", "DÁ CRTL + AÍ", "SHI...", "VÊ ESSE");

        for (Map<String, String> filme : listaDeFilmes) {

            String ulrImagem = filme.get("image");
            String titulo = filme.get("title");

            InputStream inputStream;
            try {
                var ulrImagemPosterGrande = ulrImagem;
                var remova = ulrImagem.substring( ulrImagem.indexOf("@")+1, ulrImagem.indexOf(".jpg"));
        
                ulrImagemPosterGrande = ulrImagem.replaceAll(remova, "");
                inputStream = new URL(ulrImagemPosterGrande).openStream();
                
            } catch (Exception e) {
                inputStream = new URL(ulrImagem).openStream();
            }
            

            String nomeArquivo = titulo + ".png";

            int numeroAleatorio = new Random().nextInt(listaTextoMemes.size());

            var geradora = new GeradoraDeFirguinhas();
            geradora.criar(inputStream, nomeArquivo,listaTextoMemes.get(numeroAleatorio));

            var title = filme.get("title");
            var rate = filme.get("imDbRating");
            var poster = filme.get("image");

            System.out.print("\u001b[1m\u001b[37m\u001b[44m Titulo: ");
            System.out.println(String.format("\u001b[m\u001b[44m%s", title));

            DecimalFormat df = new DecimalFormat("#");
            var estrelas = Integer.parseInt(df.format(Double.valueOf(rate)));
            var emoji = estrelas <= 5 ? "🍅" : "⭐"; // Joga tomate se for ruim 👀
            var avalicaoEmoji = "";
            for (int i = 0; i < estrelas; i++) {
                avalicaoEmoji += emoji;
            }
            System.out.print("\u001b[m\u001b[1mClassificação:");
            System.out.print(avalicaoEmoji);

            var nota = estrelas <= 5 ? "\u001b[m \u001b[31m(%s)" : "\u001b[m \u001b[33m(%s)";

            System.out.println(String.format(nota, rate));

            System.out.print("\u001b[m\u001b[1mPoster: ");
            System.out.println(String.format("\u001b[m%s", poster));
            System.out.println();

        }

    }

    private static void adicionaFilmeComNotaBaixa(List<Map<String, String>> listaDeFilmes) {
        HashMap<String, String> filmeComNotaBaixa = new HashMap<String, String>();
        filmeComNotaBaixa.put("title", "Morbius");
        filmeComNotaBaixa.put("imDbRating", "5.2");
        filmeComNotaBaixa.put("image",
                "https://m.media-amazon.com/images/M/MV5BYjlhNTA3Y2ItYjhiYi00NTBiLTg5MDMtZDJjMDZjNzVjNjJmXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_.jpg");

        listaDeFilmes.add(filmeComNotaBaixa);
    }

}
