package trabalhoso;

/**
 * Classe com a política de Substituição de Páginas com Escopo Global
 */
public class LeastRecentUsed 
{

    /**
     * Escolhe qual quadro será substituído com a página que será carregada na MP, de acordo com a
     * Politica de Substituição LRU.
     *
     * @param quadros vetor de quadros possa ser iterada.
     * @return indice do quadro que irá receber a página que será traga da MS.
     */
    /*public static int encontrarBloco(quadro[] quadros) 
    {
        // TODO identificar/alterar o tipo do parâmetro quadros
        //TODO um método identificaPagina(int bloco) => tabelaPaginas[i], bloco <=> pagina 
        int iMenor = 0;
        int vMenor = identificaPagina(quadros[0]).getUltimaReferencia;
        int candidato;
        
        for (int i = 1; i < quadros.length; i++) 
        {
            candidato = identificaPagina(quadros[i]).getUltimaReferencia;
            if (candidato < vMenor) 
            {
                vMenor = candidato;
                iMenor = i;
            }
        }
        return iMenor;
    }*/

}
