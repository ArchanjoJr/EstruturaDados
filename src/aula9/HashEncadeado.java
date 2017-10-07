package aula9;

public class HashEncadeado {
    private int m; /* número de elementos da tabela */
    private No tabela[]; /* tabela de dispersão */
    public HashEncadeado(int m){
        this.m = m;
        this.tabela = new No[m];
    }


    /* Converte a chave em um valor [0,m-1].
    * O valor retornado será a posição da chave na tabela de dispersão.
    * Essa função é chamada de função de espalhamento, pois ela mapeia um valor (chave) do
    * intervalo [0,R-1] para o intervalo [0,m-1], onde m é menor que R */
    public int hash(int ch){
        return ch % m;
    }


    /* As colisões na tabela de dispersão podem ser resolvidas usando listas encadeadas:
    * todas as chaves que têm um mesmo código hash são armazenadas na lista */
    public void inserir(int ch){
        /* cria um nó */
        No no = new No();
        no.chave = ch;
        no.ocorrencia = 1;
        /* obtém a posição na tabela de dispersão */
        int hc = hash(ch);
        if( tabela[hc] == null ){ /* lista vazia */
            tabela[hc] = no;
        }
        else{
            No aux = tabela[hc];
            /* busca o final da lista ou um valor repetido */
            while( aux.proximo != null && aux.chave != ch ){
                aux = aux.proximo;
            }
            if( aux.chave == ch ){
                aux.ocorrencia++;
            }
            else{
                aux.proximo = no;
            }
        }
    }


    public void imprimir(){
        No aux;
        /* percorre o array */
        for(int i = 0; i < tabela.length; i++){
            System.out.print( i + ": ");
            /* percorre a lista encadeada que está na posição i do array */
            aux = tabela[i];
            while( aux != null ){
                System.out.print( aux + " ");
                aux = aux.proximo;
            }
            System.out.println();
        }
    }


}