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
    
}