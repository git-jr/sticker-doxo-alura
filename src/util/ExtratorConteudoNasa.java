package util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.Conteudo;

public class ExtratorConteudoNasa implements ExtratorConteudo {
    public List<Conteudo> extraiConteudos(String json) {
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        // listaDeAtributos = listaDeAtributos.subList(0,3); // Limitando para testes

        List<Conteudo> conteudos = new ArrayList<>();

        for (Map<String, String> atributos : listaDeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);
        }

        return conteudos;

    }

}
