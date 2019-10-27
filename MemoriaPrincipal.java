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
    private static final int tamanhoMP = 20;
    //tamanho do quadro e das páginas do processo é 1, é o tamanho de um índice
    private String[] quadros; 
    private boolean MPestaCheia;
       
    public MemoriaPrincipal()
    {
        quadros = new String[tamanhoMP];  
        MPestaCheia = false;
        encherMP();
    }
    
    private void encherMP()
    {
        for(int i=0;i<tamanhoMP;i++)
            quadros[i] = null;           
    }
    
    private void checaSeMPestaCheia()
    {
        boolean cheia = true;
        
        for(int i=0;i<tamanhoMP;i++)       
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
 
    public void colocaProcessoMP(Processo p)
    {
        for(int i=0;i<tamanhoMP;i++)
        {
            if(quadros[i]==null)
            {
                quadros[i] = p.getPaginas(i);
            }
        }
    }
}
