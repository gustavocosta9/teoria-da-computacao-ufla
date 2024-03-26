import java.util.Objects;

public class Chave<String1, String2> {
    
    //atributos da classe.
    private String1 estadoAtual;
    private String2 simbolo;

    //Construtor da classe.
    public Chave(String1 estadoAtual, String2 simbolo){
        
        this.estadoAtual = estadoAtual;
        this.simbolo = simbolo;
    }

    //gets da classe.
    public String1 getEstadoAtual(){
        return estadoAtual;
    }

    public String2 getSimboloAtual(){
        return simbolo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chave<?, ?> chave = (Chave<?, ?>) o;
        return Objects.equals(estadoAtual, chave.estadoAtual) && Objects.equals(simbolo, chave.simbolo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadoAtual, simbolo);
    }
}
