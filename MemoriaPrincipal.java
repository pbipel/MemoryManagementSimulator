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
public class MemoriaPrincipal 
{
    private static final int TAMANHO_MP = 20;
    //tamanho do quadro e das páginas do processo é 1, é o tamanho de um índice
    private String[] quadros; 
    private boolean MPestaCheia;
       
    public MemoriaPrincipal()
    {
        quadros = new String[TAMANHO_MP];  
        MPestaCheia = false;
        encherMP();
    }
    
    private void encherMP()
    {
        for(int i=0;i<TAMANHO_MP;i++)
            quadros[i] = null;           
    }
    
    private void checaSeMPestaCheia()
    {
        boolean cheia = true;
        
        for(int i=0;i<TAMANHO_MP;i++)       
            if(quadros[i]==null)           
                cheia = false;                    
        
        if(cheia)
            MPestaCheia = true;            
    }
    
    public boolean getMPestaCheia()
    {
        checaSeMPestaCheia();
        
        return MPestaCheia;
    }
 
    public int colocaProcessoMP(Processo p)
    {
        int j=0;
        
        for(int i=0;i<TAMANHO_MP;i++)
        {
            if(quadros[i]==null)
            {
                quadros[i] = p.getPaginas(0);
                j = i;
                break;
            }
        }
        return j;
        
    }
    
    public void exibeEstadoMP()
    {
        System.out.printf("\n-- STATUS DA MP - Tamanho: %d -- \n", TAMANHO_MP);
        for(int i=0;i<TAMANHO_MP;i++)
        {
            if(quadros[i]!=null)
            {
                System.out.printf("\n| ======= |\n");
                System.out.printf("|  %s  |\n", quadros[i]);
                System.out.printf("| ======= |\n");
            }
        }
    }
}
