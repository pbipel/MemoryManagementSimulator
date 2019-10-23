/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoso;

/**
 *
 * @author Camilla
 */
public class Processo 
{
    private String[] paginas;
    private int tamanhoProcesso;
    private static int ID_PROCESSO_GERAL = 0;
    private int idProcesso;
    
    private int tempoInicial;
    private int tempoFinal;
    
    private String nomeProcesso;   
    private String estadoProcesso; //NOVO - PRONTO - EXECUTANDO - BLOQUEADO - EXIT
    private boolean processoSuspenso; 
    //true e pronto = SUSPENSO - PRONTO, true e bloqueado = SUSPENSO - BLOQUEADO      
    
    public Processo(int tamanhoProcesso, String nomeProcesso, int tempoInicial)
    {
        paginas = new String[tamanhoProcesso]; //cada pagina tem tamanho 1
        this.tamanhoProcesso = tamanhoProcesso;
        ID_PROCESSO_GERAL++;
        idProcesso = ID_PROCESSO_GERAL;
        
        this.tempoInicial = tempoInicial; //fazer função para colocar tempo inicial
        tempoFinal = 0; //fazer função para colocar tempo final
        
        this.nomeProcesso = nomeProcesso;
        estadoProcesso = "NOVO";
        processoSuspenso = false;       
        
        encherProcesso();
    }
    
    //cria valores para cada página do processo que é o nome do processo + índice
    private void encherProcesso()
    {
        for(int i=0;i<tamanhoProcesso;i++) //< ou <= ?
            paginas[i] = nomeProcesso + "paginas[i]";
    }
    
    public void setEstadoProcesso(String estado)
    {
        estadoProcesso = estado;
    }
    
    //rever isso
    public String getPaginas(int i)
    {
        return paginas[i];
    }
    
    public int getIdProcesso()
    {
        return idProcesso;
    }
    
    public String getNomeProcesso()
    {
        return nomeProcesso;
    }
    
    public int getTamanhoProcesso()
    {
        return tamanhoProcesso;
    }
    
    public String getEstadoProcesso()
    {
        return estadoProcesso;
    }
    
    
    //paginas do processo
    //cada págima tem INDICE E CONTEUDO
    //processo tem TAMANHO
}
