/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhoso;
import java.util.Scanner;

/**
 *
 * @author Camilla
 */
public class TrabalhoSO 
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int c=0, tamP;
        String nomeP;
        Scanner input = new Scanner(System.in);      
        GerenciadorMemoria GM = new GerenciadorMemoria();               
        
        while(c!=8)
        {
            GM.statusMemorias();
                    
            System.out.printf("\nOpções:\n");
            System.out.printf("\n1- C - Submeter um processo.");
            System.out.printf("\n2- ");
            System.out.printf("\n3- ");
            System.out.printf("\n4- ");
            System.out.printf("\n5- ");
            System.out.printf("\n6- ");
            System.out.printf("\n7- ");
            System.out.printf("\n8- Sair.\n\n");
            c = input.nextInt();
            
            if(c==8)
                System.exit(0);
            
            if(c==1)
            {
                System.out.printf("\nDigite o nome do processo: ");
                nomeP = input.next();
                
                System.out.printf("Digite o tamanho do processo: ");
                tamP = input.nextInt();
                
                GM.criaProcesso(tamP,nomeP);
                
                System.out.printf("\nO processo foi criado com sucesso.\n");                
            }
            
            else
                System.exit(0);
            
        }
    }
    
}
