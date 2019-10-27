/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoso;
import java.util.ArrayList;

/**
 *
 * @author Camilla
 */
public class GerenciadorMemoria
{
    private ArrayList<int[]> TPE;
    private ArrayList<Processo> listaProcessosCriados; //aqui o processo esta na MS
    private ArrayList<Processo> listaProcessosAlocados; //aqui o processo esta na MP
    private MemoriaPrincipal MP = new MemoriaPrincipal();
    private MemoriaSecundaria MS = new MemoriaSecundaria(); 
    
    //ista.indexOf(elemento); //retorna a posição de um elemento da lista
    
    /*TPE = new int[3];
        TPE[0] = 1; //bit P
        TPE[1] = 0; //bit M
        TPE[2] = 1; //numero quadro*/
    
    public GerenciadorMemoria()
    {         
        listaProcessosCriados = new ArrayList<>();
        listaProcessosAlocados = new ArrayList<>();
    }   

    private void colocaProcessoNaLista(Processo p)
    {
        listaProcessosCriados.add(p);
    }
    
    private void removeProcessoDaLista(Processo p)
    {
        listaProcessosCriados.remove(p);
    }
    
    public void criaProcesso(int tamanhoProcesso, String nomeProcesso)
    {
        Processo p = new Processo(tamanhoProcesso,nomeProcesso);
        colocaProcessoNaLista(p);
        MS.colocaProcessoMS(p);
    }
    
}
