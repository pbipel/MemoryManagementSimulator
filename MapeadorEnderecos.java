package trabalhoso;

public class MapeadorEnderecos{

    public MapeadorEnderecos() {
    }

    /**
     * Verifica se o endereço está dentro dos limites da IMAGEM do programa.
     *
     * @param endRelativo Endereço requisitado no programa.
     * @param tamImagem Tamanho da imagem do processo em Bytes.
     * @return true Quando o endereço está dentro da Imagem.
     */
    public static boolean dentroLimites(int endRelativo, int tamImagem) {
        return (endRelativo <= tamImagem) && (endRelativo >= 0);
    }

    /**
     * Identifica a página à qual pertence o endereço relativo.
     *
     * @param endRelativo Endereço requisitado no programa.
     * @param tamBloco Tamanho de um bloco no sistema em Bytes.
     * @return Numero da página onde se encontra o endereço relativo.
     */
    public static int identificarPaginaEndereco(int endRelativo, int tamBloco) {
        return endRelativo / tamBloco;
    }

    /**
     * Identifica o offset do endereço na página.
     *
     * @param endRelativo Endereço requisitado no programa.
     * @param tamBloco Tamanho de um bloco no sistema em Bytes.
     * @return Valor do offset dentro da página onde se encontra o endereço relativo.
     */
    public static int identificarOffsetEndereco(int endRelativo, int tamBloco) {
        return endRelativo % tamBloco;
    }

    /**
     * Identifica o endereço real de um endereço relativo na MP .
     *
     * @param numBloco Número do bloco na MP, onde a página do endereço relativo se encontra.
     * @param tamBloco Tamanho de um bloco no sistema em Bytes.
     * @param offset Tamanho de deslocamento dentro do bloco.
     * @return Endereço real associado ao endereço relativo.
     */
    public static int calcularEnderecoReal(int numBloco, int tamBloco, int offset) {
        return numBloco * tamBloco + offset;
    }

}