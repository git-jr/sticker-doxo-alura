import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import enums.APIEnum;
import model.Conteudo;
import util.ClienteHttp;
import util.ExtratorConteudo;
import util.ExtratorConteudoNasa;
import util.GeradoraDeFirguinhas;

public class App {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        System.out.println();
        System.out.println("\u001b[1m\u001b[37m\u001b[44m Lista Filmes \u001b[m");
        System.out.println();

        // API do IMBD instável...
        // String url = APIEnum.NASA.url();

        // String url = APIEnum.IMDB.url();
        // ExtratorConteudo extrator = new ExtratorConteudoIMDB();

        String url = APIEnum.NASA.url();
        ExtratorConteudo extrator = new ExtratorConteudoNasa();

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        var geradora = new GeradoraDeFirguinhas();

        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var listaTextoMemes = Arrays.asList("TOPZERA", "METEU ESSA?!", "DÁ CRTL + AÍ", "SHI...", "VÊ ESSE");

        for (Conteudo conteudo : conteudos) {
            int numeroAleatorio = new Random().nextInt(listaTextoMemes.size());

            InputStream inputStream = new URL(conteudo.ulrImagem()).openStream();
            String nomeArquivo = conteudo.titulo() + ".png";

            geradora.criar(inputStream, nomeArquivo, listaTextoMemes.get(numeroAleatorio));

            System.out.print("\u001b[1m\u001b[37m\u001b[44m Titulo: ");
            System.out.println(String.format("\u001b[m\u001b[44m%s\u001b[m", conteudo.titulo()));
            System.out.println();

        }

    }

}
