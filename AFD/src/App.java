// Autor do código: Gustavo Costa (2024)
// Universidade Federal de Lavras


import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        
        //Instanciação do scanner.
        Scanner sc = new Scanner(System.in);

        System.out.println("---------BEM VINDO AO AFD!------------");
        
        System.out.print("DIGITE OS ESTADOS DA MÁQUINA: ");
        String estados = sc.nextLine();

        System.out.print("DIGITE O ALFABETO DA MÁQUINA (SEPARE CARACTERE POR CARACTERE COM ESPAÇO): ");
        String alfabeto = sc.nextLine();

        System.out.print("DIGITE O ESTADO INICIAL DA MÁQUINA: ");
        String estadoInicial = sc.nextLine();

        System.out.print("DIGITE OS ESTADOS FINAIS: ");
        String estadosFinais = sc.nextLine();        

        //Chamada do construtor da classe para instanciar uma máquina AFD.
        Automato afd = new Automato(estados, alfabeto, estadoInicial, estadosFinais);

        //Perguntar ao usuário, após todas essas informações, as funções de transição.
        afd.receberFuncoesTransicao(sc);

        //Reconhecimento.
        System.out.println("Digite a palavra a ser reconhecida: ");
        String palavra = sc.nextLine();
        while(true){
            
            System.out.println(afd.verificacao(palavra));
            System.out.println("Digite a palavra a ser reconhecida: ");
            palavra = sc.nextLine();

            if(palavra.equals("exit")){
                break;
            }
        }

        sc.close();
    }
}
