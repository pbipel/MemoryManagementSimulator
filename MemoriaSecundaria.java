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
    private static final int TAMANHO_MS = 5;
    Processo[] processos;
    
    public MemoriaSecundaria()
    {
        processos = new Processo[TAMANHO_MS];  
        encherMS();
    }
    
    private void encherMS()
    {
        for(int i=0;i<TAMANHO_MS;i++)
            processos[i] = null;           
    }
    
    public int colocaProcessoMS(Processo p)
    {
        int j=0;
        
        for(int i=0;i<TAMANHO_MS;i++)
        {
            if(processos[i]==null)
            {
                processos[i] = p;
                j = i;
                break;
            }
        }
        return j;                                                        
    }
    
    public void exibeEstadoMS()
    {
        System.out.printf("\n-- STATUS DA MS - Tamanho: %d -- \n", TAMANHO_MS);
        for(int i=0;i<TAMANHO_MS;i++)
        {
            if(processos[i]!=null)
            {
                System.out.printf("\n| =============== |\n");
                System.out.printf("| %s ID: %d tam: %d |\n", 
                        processos[i].getNomeProcesso(), processos[i].getIdProcesso(), 
                        processos[i].getTamanhoProcesso());
                System.out.printf("| =============== |\n");
            }            
        }
    }
 
}
