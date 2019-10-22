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
    private int idProcesso;
    
    private int tempoInicial;
    private int tempoFinal;
    
    private String nomeProcesso;   
    private String estadoProcesso; //NOVO - PRONTO - EXECUTANDO - BLOQUEADO - EXIT
    private boolean processoSuspenso; 
    //true e pronto = SUSPENSO - PRONTO, true e bloqueado = SUSPENSO - BLOQUEADO      
    
    public Processo(int tamanhoProcesso, String nomeProcesso)
    {
        paginas = new String[tamanhoProcesso]; //cada pagina tem tamanho 1
        this.tamanhoProcesso = tamanhoProcesso;
        idProcesso = 1; //fazer função para colocar ids incrementando nos processos;
        
        tempoInicial = 0; //fazer função para colocar tempo inicial
        tempoFinal = 0; //fazer função para colocar tempo final
        
        this.nomeProcesso = nomeProcesso;
        estadoProcesso = "NOVO";
        processoSuspenso = false;       
        
        encherProcesso();
    }
    
    //criar valores para cada página do processo que é o nome do processo + índice
    private void encherProcesso()
    {
        for(int i=0;i<tamanhoProcesso;i++) //< ou <= ?
            paginas[i] = nomeProcesso + "paginas[i]";
    }
    
    public void setEstadoProcesso(String estado)
    {
        estadoProcesso = estado;
    }
    
    public String getPaginas(int i)
    {
        return paginas[i];
    }
    
    public int getIdProcesso()
    {
        return idProcesso;
    }
    
    //fazer funções de gets que precisar
    
    //paginas do processo
    //cada págima tem INDICE E CONTEUDO
    //processo tem TAMANHO
}
