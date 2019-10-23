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
    private int relogio;
    
    public GerenciadorMemoria()
    {         
        listaProcessosCriados = new HashMap<>();
        listaProcessosAlocados = new HashMap<>();
        listaProcessosExecutando = new HashMap<>();
        TPE = new HashMap<>();
        ondeEstaMeuProcessoNaMS = new HashMap<>();
        relogio = 0;
    }   
    
    public void criaProcesso(int tamanhoProcesso, String nomeProcesso)
    {
        int localizacaoNaMS=0;
        Processo p = new Processo(tamanhoProcesso,nomeProcesso,relogio);
        
        listaProcessosCriados.put(p.getIdProcesso(),p); //coloca processo no map
        localizacaoNaMS = MS.colocaProcessoMS(p);
        ondeEstaMeuProcessoNaMS.put(p.getIdProcesso(),localizacaoNaMS);
        System.out.printf("\nO ID do processo é %d",p.getIdProcesso()); //debug
        
        admiteProcesso(p);
    }
    
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
    
    private void admiteProcesso(Processo p)
    {   
        int quadro=0; 
        
        if(!(MP.getMPestaCheia()) && (listaProcessosCriados.size()>0))
        {
            System.out.printf("\nMP não está cheia!"); //debug
            System.out.printf("\nPage Fault. Não tem nenhuma página do processo na MP [...] "
                    + "O Processo está sendo admitido (NOVO->PRONTO).\n");
            listaProcessosAlocados.put(p.getIdProcesso(),p); //coloca processo no map
            quadro = MP.colocaProcessoMP(p);   
            p.setEstadoProcesso("PRONTO");
            criaTPE(p, quadro);
        }                     
        else
            System.out.printf("\nMP está cheia!\n"); //fazer função de substituição
    }
    
    private void criaTPE(Processo p, int quadro)
    {
        int[] valoresNaTPE = new int[3];
        
        valoresNaTPE[0] = 1; //bit presença P
        valoresNaTPE[1] = 0; //bit modificação M
        valoresNaTPE[2] = quadro; //numero do quadro
        
        TPE.put(p.getIdProcesso(),valoresNaTPE);       
    }
      
    public void aumentaRelogio()
    {
        relogio++;
    }
    
}
