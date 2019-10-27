/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoso;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Camilla
 * Classe processo
 */
public class Processo 
{
    private int[] paginas;
    private int tamanhoProcesso;
    private static int ID_PROCESSO_GERAL = 0;
    private int idProcesso;   
    
    private String nomeProcesso;   
    private String estadoProcesso; 
    //NOVO - PRONTO - EXECUTANDO - BLOQUEADO - SUSPENSO_PRONTO - SUSPENSO_BLOQUEADO  
    
    public Processo(int tamanhoProcesso, String nomeProcesso)
    {
        paginas = new int[tamanhoProcesso]; //cada pagina tem tamanho 1
        this.tamanhoProcesso = tamanhoProcesso;
        ID_PROCESSO_GERAL++;
        idProcesso = ID_PROCESSO_GERAL;      
        
        this.nomeProcesso = nomeProcesso;
        estadoProcesso = "NOVO";               
        
        encherProcesso();
    }
    
    /**
    *
    * 
    * cria valores para cada página do processo que é o nome do processo + índice
    */
    private void encherProcesso()
    {
        for(int i=0;i<tamanhoProcesso;i++)       
            paginas[i] = idProcesso*i + 100;                  
    }

    public void setEstadoProcesso(String estado)
    {
        estadoProcesso = estado;
    }

    public int getPaginas(int i)
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
    
}
