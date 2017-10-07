package aula9;

public class Registro {
    public int chave,ocorrencia;

    public Registro(int chave){
        this.chave=chave;
    }

    @Override
    public String toString(){
        return chave+" "+ocorrencia;
    }
}
