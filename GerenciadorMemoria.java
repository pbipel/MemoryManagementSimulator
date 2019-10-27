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
    private Map<Integer,Processo> listaProcessosBloqueados;
    private Map<Integer,Processo> listaProcessosSuspensoB;
    private Map<Integer,Processo> listaProcessosSuspensoP;
    
    private Map<Integer,int[]> TPE;
    private Map<Integer,Integer> ondeEstaMeuProcessoNaMS;
    
    private MemoriaPrincipal MP;
    private MemoriaSecundaria MS; 
    
    public GerenciadorMemoria()
    {         
        listaProcessosCriados = new HashMap<>();
        listaProcessosAlocados = new HashMap<>();
        listaProcessosExecutando = new HashMap<>();
        listaProcessosBloqueados = new HashMap<>();
        listaProcessosSuspensoB = new HashMap<>();
        listaProcessosSuspensoP = new HashMap<>();
        
        TPE = new HashMap<>();
        ondeEstaMeuProcessoNaMS = new HashMap<>();
        
        MP = new MemoriaPrincipal();
        MS = new MemoriaSecundaria();
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
    * Coloca o processo criado na fila de prontos, só trás 1 página do processo
    * @param p processo
    */
    private void admiteProcesso(Processo p)
    {   
        int quadro=0;

        if(!(MP.getMPestaCheia()) && (listaProcessosCriados.size()>0))
        {
            System.out.printf("\nMP não está cheia!");
            System.out.printf("\nPage Fault. Não tem nenhuma página do processo na MP [...] "
                + "O Processo está sendo admitido (NOVO->PRONTO).\n");
            listaProcessosAlocados.put(p.getIdProcesso(),p); //coloca processo no map
            quadro = MP.colocaProcessoMP(p,0);                  
            criaTPE(p,quadro,0); 
            System.out.printf("\nFoi trazida uma página do processo para a MP.\n");
            p.setEstadoProcesso("PRONTO");
            System.out.printf("\nO Processo foi admitido (NOVO->PRONTO).\n");
        }
        else
        {
            System.out.printf("\nMP está cheia!\n");
            //AQUI: chamar função suspendeProcesso
            //e escolher o processo que vai ser removido
        }
                   
    }
    
    /**
     * Coloca processo na lista de processos sendo executados no momento
     * Pode executar vários processos
     * @param p Processo
     */
    public void executaProcesso(Processo p)
    {
        if(p.getEstadoProcesso().equals("PRONTO"))
        {
            listaProcessosAlocados.remove(p.getIdProcesso());
            listaProcessosExecutando.put(p.getIdProcesso(),p);
            p.setEstadoProcesso("EXECUTANDO");
        }
    }
    
    public void terminaProcesso(Processo p)
    {
        //AQUI: também atualizar a TPE nos ifs, o bit presença e o bit modificação
        if(p.getEstadoProcesso().equals("PRONTO"))
        {
            listaProcessosAlocados.remove(p.getIdProcesso());
            MP.removeProcessoMP(p);
            p.setEstadoProcesso("EXIT");
            
        }           
        else if(p.getEstadoProcesso().equals("EXECUTANDO"))
        {
            listaProcessosExecutando.remove(p.getIdProcesso());
            MP.removeProcessoMP(p);
            p.setEstadoProcesso("EXIT");
        }
            
    }
    
    //AQUI - precisa da leitura/escrita
    public void BloqueiaProcesso(Processo p)
    {
        if(p.getEstadoProcesso().equals("EXECUTANDO"))
        {
            listaProcessosExecutando.remove(p.getIdProcesso());
            listaProcessosBloqueados.put(p.getIdProcesso(),p);
            p.setEstadoProcesso("BLOQUEADO");
        }
    }
    
    private void suspendeProcesso(Processo p)
    {
        //AQUI - Atualizar TPE - precisa fazer um método de atualizar a tpe
        //e em todos os ifs atualizar o bit de presença e modificação
        if(p.getEstadoProcesso().equals("PRONTO"))
        {
            listaProcessosAlocados.remove(p.getIdProcesso());
            listaProcessosSuspensoP.put(p.getIdProcesso(),p);
            MP.removeProcessoMP(p);
            p.setEstadoProcesso("SUSPENSO_BPRONTO");
        }
        else if(p.getEstadoProcesso().equals("EXECUTANDO"))
        {
            listaProcessosExecutando.remove(p.getIdProcesso());
            listaProcessosSuspensoP.put(p.getIdProcesso(),p);
            MP.removeProcessoMP(p);
            p.setEstadoProcesso("SUSPENSO_PRONTO");
        }
        else if(p.getEstadoProcesso().equals("BLOQUEADO"))
        { 
            listaProcessosBloqueados.remove(p.getIdProcesso());
            listaProcessosSuspensoB.put(p.getIdProcesso(),p);
            MP.removeProcessoMP(p);
            p.setEstadoProcesso("SUSPENSO_BLOQUEADO");
        }
        
    }
    
    private void atualizaTPE()
    {
        
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
    
    public static void main(String[] args) 
    {      
        GerenciadorMemoria GM = new GerenciadorMemoria();    
        
        GM.statusMemorias();
        
        GM.criaProcesso(10,"P1");
        GM.criaProcesso(20,"P2");
        GM.criaProcesso(30,"P3");
        
        GM.statusMemorias();
    }
}
