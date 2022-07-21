package util;
import java.util.List;

import model.Conteudo;

public interface ExtratorConteudo{
    public List<Conteudo> extraiConteudos(String json);

}