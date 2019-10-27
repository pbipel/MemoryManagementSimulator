/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoso;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

/**
 *
 * Gerenciador de Memória, tem instância da MP e MS, e basicamente admistra os processos
 * @author Camilla
 */
public class GerenciadorMemoria
{
    private Map<Integer,Processo> listaProcessosCriados; //aqui o processo esta na MS
    private Map<Integer,Processo> listaProcessosAlocados; //aqui o processo esta na MP 
    private Map<Integer,Processo> listaProcessosExecutando;
    private Map<Integer,int[]> TPE;
    private Map<Integer,Integer> ondeEstaMeuProcessoNaMS;
    private MemoriaPrincipal MP = new MemoriaPrincipal();
    private MemoriaSecundaria MS = new MemoriaSecundaria(); 
    
    public GerenciadorMemoria()
    {         
        listaProcessosCriados = new HashMap<>();
        listaProcessosAlocados = new HashMap<>();
        listaProcessosExecutando = new HashMap<>();
        TPE = new HashMap<>();
        ondeEstaMeuProcessoNaMS = new HashMap<>();
    }   
    
    /**
    *
    * Cria o processo e o coloca na lista de criados, na MS
    * Depois, chama método que admite o processo na fila de pronto, na MP
    * @param tamanhoProcesso tamanho do processo que vai ser criado
    * @param nomeProcesso nome do processo que vai ser criado
    */
    public void criaProcesso(int tamanhoProcesso, String nomeProcesso)
    {
        int localizacaoNaMS=0;
        Processo p = new Processo(tamanhoProcesso,nomeProcesso);
        
        listaProcessosCriados.put(p.getIdProcesso(),p); //coloca processo no map
        localizacaoNaMS = MS.colocaProcessoMS(p);
        ondeEstaMeuProcessoNaMS.put(p.getIdProcesso(),localizacaoNaMS);
        System.out.printf("\nO ID do processo é %d",p.getIdProcesso()); //debug
        
        admiteProcesso(p);
    }
    
    /**
    *
    * Exibe estados na tela das memórias e da tabela de páginas
    */
    public void statusMemorias()
    {
        MS.exibeEstadoMS();
        MP.exibeEstadoMP();
        
        System.out.printf("\n-- Tabela de Paginas -P-M-#quadro --");
        for(Integer nome: TPE.keySet())
        {
            String chave = nome.toString();
            String valor = Arrays.toString(TPE.get(nome));
            System.out.printf("\n| ====================== |\n");
            System.out.printf("| Id Processo: %s, TPE: %s |\n", chave, valor);
            System.out.printf("| ======================== |\n");
        }            
    }
    
    /**
    *
    * Coloca o processo criado na fila de prontos
    * @param p processo
    */
    private void admiteProcesso(Processo p)
    {   
        int quadro=0, paginasNaMP=0, ultPagina=0;
        boolean pPronto=false, pIteracao=true;
        
        for(int i=0;i<p.getTamanhoProcesso();i++)
        {
            if(!(MP.getMPestaCheia()) && (listaProcessosCriados.size()>0) && (pIteracao))
            {
                System.out.printf("\nMP não está cheia!");
                System.out.printf("\nPage Fault. Não tem nenhuma página do processo na MP [...] "
                    + "O Processo está sendo admitido (NOVO->PRONTO).\n");
                listaProcessosAlocados.put(p.getIdProcesso(),p); //coloca processo no map
                quadro = MP.colocaProcessoMP(p,i);                  
                criaTPE(p,quadro,i); 
                pPronto = true;
                System.out.printf("\nFoi trazida uma página do processo para a MP.\n");
                pIteracao=false;
            }
            else if((!pIteracao) && !(MP.getMPestaCheia()) && (paginasNaMP<3))
            {
                System.out.printf("\nMP não está cheia! Pode trazer mais páginas para a MP.");
                quadro = MP.colocaProcessoMP(p,i);
                //criaTPE(p,quadro,i); fazer função de modificar a tpe então
                System.out.printf("\nFoi trazida uma página do processo para a MP.\n");
                paginasNaMP++;
            }
            else
                System.out.printf("\nMP está cheia!\n"); //fazer função de substituição
        }
        if(pPronto)
        {            
            p.setEstadoProcesso("PRONTO");
            System.out.printf("\nO Processo foi admitido (NOVO->PRONTO).\n");
        }
            
    }
    
    /**
     * Cria tabela de páginas de cada processo
     * @param p processo
     * @param quadro numero do quadro
     * 
     */
    private void criaTPE(Processo p, int quadro, int pagina)
    {
        int[] valoresNaTPE = new int[6];
        
        valoresNaTPE[0] = 1; //bit presença P
        valoresNaTPE[1] = 0; //bit modificação M
        valoresNaTPE[2] = quadro; //numero do quadro
        valoresNaTPE[3] = pagina; //pagina que esta na TPE
        valoresNaTPE[4] = 1; //bit U da política do relógio
        valoresNaTPE[5] = 0; //bit usado da política LRU
        
        TPE.put(p.getIdProcesso(),valoresNaTPE);       
    }
    
}
