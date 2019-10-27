/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoso;

/**
 * Memoria Principal
 * @author Camilla
 */
public class MemoriaPrincipal 
{
    private static final int TAMANHO_MP = 20;
    //tamanho do quadro e das páginas do processo é 1, é o tamanho de um índice
    private int[] quadros; 
    private boolean MPestaCheia;
       
    public MemoriaPrincipal()
    {
        quadros = new int[TAMANHO_MP];  
        MPestaCheia = false;
        encherMP();
    }
    
    /**
    *
    * Coloca valores null na MP
    */
    private void encherMP()
    {
        for(int i=0;i<TAMANHO_MP;i++)
            quadros[i] = -1;           
    }
    
    /**
    *
    * Checa se a MP está cheia de páginas de processos
    */
    private void checaSeMPestaCheia()
    {
        boolean cheia = true;
        
        for(int i=0;i<TAMANHO_MP;i++)       
            if(quadros[i]==-1)           
                cheia = false;                    
        
        if(cheia)
            MPestaCheia = true;            
    }
       
    public boolean getMPestaCheia()
    {
        checaSeMPestaCheia();
        
        return MPestaCheia;
    }
 
    /**
    *
    * Pega uma página do processo e o coloca na MP
    * @param p o processo
    * @param pPagina pagina do processo que vai ser colocada na MP
    * @return j o quadro que o processo foi colocado na MP
    */
    public int colocaProcessoMP(Processo p, int pPagina)
    {
        int j=0;

        for(int i=0;i<TAMANHO_MP;i++)
        {
            if(quadros[i]==-1)
            {
                quadros[i] = p.getPaginas(pPagina);
                j = i;
                break;
            }
        }
        return j;
        
    }
    
    //AQUI - Fazer função para remover o processo da MP
    public void removeProcessoMP(Processo p)
    {
        
    }
    
    /**
    *
    * Exibe as páginas do processo que estão na MP
    */
    public void exibeEstadoMP()
    {
        System.out.printf("\n-- STATUS DA MP - Tamanho: %d -- \n", TAMANHO_MP);
        for(int i=0;i<TAMANHO_MP;i++)
        {
            if(quadros[i]!=-1)
            {
                System.out.printf("\n| ======= |\n");
                System.out.printf("|  %s  |\n", quadros[i]);
                System.out.printf("| ======= |\n");
            }
        }
    }
}
