package trabalhoso;

/**
 * Classe com a política de Substituição de Páginas com Escopo Global
 */
public class Relogio1Bit 
{

    private int ponteiro;

    public Relogio1Bit() 
    {
        this.ponteiro = 0;
    }
    /**
     * Escolhe qual quadro será substituído com a página que será carregada na MP, de acordo com a
     * Politica de Substituição do Relógio de 1 Bit.
     *
     * @param quadros vetor de quadros possa ser iterada.
     * @return indice do quadro que irá receber a página que será traga da MS.
     */
    /*public int encontrarBloco(quadro[] quadros) 
    {
        // TODO identificar/alterar o tipo do parâmetro quadros
        // TODO um método identificaPagina(int bloco) => tabelaPaginas[i], bloco <=> pagina 
        int qtdQuadros = quadros.length;
        int resposta;
        
        while (true) 
        {
            if (!(identificaPagina(quadros[ponteiro]).getU)) 
            {
                resposta = ponteiro;
                ponteiro = ++ponteiro % qtdQuadros;
                return resposta;
            }
            identificaPagina(quadros[ponteiro]).setU(false);
            ponteiro = ++ponteiro % qtdQuadros;
        }
    }*/

}
