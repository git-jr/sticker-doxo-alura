import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFirguinhas {

    /**
     * @param inputStream
     * @param nomeArquivo
     * @param texto
     * @throws Exception
     */
    public void criar(InputStream inputStream, String nomeArquivo, String texto) throws Exception {

        // BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));
        // InputStream inputStream = new
        // URL("https://m.media-amazon.com/images/M/MV5BYjlhNTA3Y2ItYjhiYi00NTBiLTg5MDMtZDJjMDZjNzVjNjJmXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + (altura/5);

        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font("IMPACT", Font.ROMAN_BASELINE, largura/10);

        // Posiciona fonte ao centro e quase no fim da imagem
        FontMetrics medidasFonte = graphics.getFontMetrics(fonte);
        int posicaoTextoX = (largura - medidasFonte.stringWidth(texto)) / 2;
        int posicaoTextoY = novaAltura-(novaAltura/12);

        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        graphics.drawString(texto, posicaoTextoX, posicaoTextoY);





        File file = new File("saida/" + nomeArquivo);
        if (!file.exists()) {
            file.mkdirs();
        }
        ImageIO.write(novaImagem, "png", file);

    }


}
