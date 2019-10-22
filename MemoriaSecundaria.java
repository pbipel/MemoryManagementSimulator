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
public class MemoriaSecundaria 
{
    private static final int tamanhoMS = 200;
    Processo[] processos;
    
    public MemoriaSecundaria()
    {
        processos = new Processo[tamanhoMS];  
        encherMS();
    }
    
    private void encherMS()
    {
        for(int i=0;i<tamanhoMS;i++)
            processos[i] = null;           
    }
    
    public void colocaProcessoMS(Processo p)
    {
        for(int i=0;i<tamanhoMS;i++)       
            if(processos[i]==null)          
                processos[i] = p;                   
    }
    
}
