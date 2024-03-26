// Autor: Gustavo Costa (2024)
// Universidade Federal de Lavras

import java.util.HashSet; //Importação de conjuntos para: Estados da máquina, simbolos.
import java.util.Set;
import java.util.Map; //Estrutura de dados para mapear as funções de transição.
import java.util.HashMap;
import java.util.Scanner;

public class Automato {
    
    //Atributos da classe.
    private Set<String> estados;
    private Set<String> alfabeto;
    private final String estadoInicial;
    private Set<String> estadosFinais;
    private Map< Chave <String, String>, String> funcoesTransicao;

    //Construtor da máquina AFD.
    public Automato(String entradaEstados, String entradaAlfabeto, String estadoI, String estadosFinais){
        
        this.estados = new HashSet<>();
        this.alfabeto = new HashSet<>();
        this.estadosFinais = new HashSet<>();
        this.funcoesTransicao = new HashMap<>();

        this.estados = adicionarEstado(entradaEstados);
        this.alfabeto = adicionarAlfabeto(entradaAlfabeto);
        estadoInicial = estadoI;
        this.estadosFinais = adicionarFinais(estadosFinais);
    }

    //Gets da classe.
    public String getEstadoInicial(){
        return estadoInicial;
    }

    public Set<String> getEstados(){
        return this.estados;
    }

    public Set<String> getEstadosFinais(){
        return this.estadosFinais;
    }

    public Set<String> getAlfabeto(){
        return this.alfabeto;
    }

    public Map<Chave<String,String>,String> getFuncoesTransicao(){
        return this.funcoesTransicao;
    }

    //Métodos de inserção (privados) nos conjuntos de acordo com a entrada do usuário.
    private Set<String> adicionarEstado(String entradaEstados){

        //Conjunto auxiliar.
        Set<String> aux = new HashSet<>();

        //Dividir a String digitada pelo usuário.
        String[] estadosSeparados = entradaEstados.split(" ");

        //for each para adicioná-las ao conjunto de estados.
        for(String estado: estadosSeparados){
            aux.add(estado);
        }

        return aux;
    }

    private Set<String> adicionarAlfabeto(String entradaAlfabeto){

        Set<String> aux = new HashSet<>();

        //Realizar o mesmo procedimento dos estados.
        String[] simbolosSeparados = entradaAlfabeto.split(" ");

        for(String simbolo: simbolosSeparados){
            aux.add(simbolo);
        }

        return aux;
    }
   
    private Set<String> adicionarFinais(String estadosF){

        Set<String> aux = new HashSet<>();

        //Realizar o mesmo procedimento dos estados.
        String[] estadosFinais = estadosF.split(" ");

        for(String estadoFinal: estadosFinais){
            aux.add(estadoFinal);
        }

        return aux;
    }

    public void receberFuncoesTransicao(Scanner aux){

        for(String estado : estados){
            for(String simbolo : alfabeto){
                
                System.out.println();
                System.out.println("OBSERVAÇÃO: CASO NÃO HAJA TRANSIÇÃO, DIGITE 'none'");
                System.out.print("DIGITE O ESTADO DESTINO DE ("+estado+") recebe ("+simbolo+") ----> (?): ");
                
                String estadoDestino = aux.nextLine();

                //Criação da tupla (EstadoAtual, simboloRecebido).
                Chave<String, String> chave = new Chave<>(estado, simbolo);
                
                //Inserção no map a chave e o valor.
                if(estadoDestino.equals("none")){
                    
                    this.funcoesTransicao.put(chave, "");   
                }
                else{

                    this.funcoesTransicao.put(chave, estadoDestino);
                }
                
            }
        }
    }

    //Método que realiza a verificação de aceitação ou não.
    public String verificacao(String palavra){

        // Estado atual.
        String estadoAtual = estadoInicial;
    
        char[] chars = palavra.toCharArray();
        for(char c: chars){
            
            // Lógica para tirar do Map o possível próximo estado.
            String proximoEstado = funcoesTransicao.get(new Chave<>(estadoAtual, String.valueOf(c)));
    
            // Se o próximo estado for "none", não há transição definida, então não reconhece a palavra.
            if ("none".equals(proximoEstado)) {
                return "NÃO RECONHECE!";
            }
    
            // Atualização do estado atual.
            estadoAtual = proximoEstado;
        }
    
        // Verifica se o estado atual é um estado final.
        if (estadosFinais.contains(estadoAtual)){
            return "RECONHECE!";
        } else {
            return "NÃO RECONHECE!";
        }
    }
    
}
