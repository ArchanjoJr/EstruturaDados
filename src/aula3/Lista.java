package aula3;

public class Lista {

    No inicio;

    Lista(){
    /* a lista está vazia */
        inicio = null;
    }


    void inserir(int nro) {
        /* criar um nó */
        No no = new No();
        no.conteudo = nro;
        no.proximo = null; /* este será o último nó da lista */
        /* checa se a lista está vazia */
        if (inicio == null) {
            inicio = no;
        } else {
            /* percorrer a lista até encontrar o último nó */
            No ultimo = inicio;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            /* alterar o próximo do último para o endereço do no */
            ultimo.proximo = no;
        }
    }


    void imprimir(){
        /* checa se a lista está vazia */
        if( inicio == null ){
            System.out.println("Lista vazia");
        }
        else{
            System.out.println(); /* quebra de linha na tela */
            /* percorrer a lista até encontrar o último nó */
            No ultimo = inicio;
            while( ultimo != null ){
                System.out.print( ultimo.conteudo +" ");
                ultimo = ultimo.proximo;
            }
        }
    }


    /*irá retornar o nó que possui o nro ou null caso contrário*/
    No buscar(int nro){
        No atual = inicio;
        /* percorre até encontrar o nro ou o fim da lista */
        while( atual != null && atual.conteudo != nro ){
            atual = atual.proximo;
        }
        return atual;
    }


    /* irá retornar o nó que possui o nro ou null caso contrário.
    * A busca será por recursividade */
    No buscar(int nro, No no){
        if( no == null ) return null;
        else if( no.conteudo == nro ) return no;
        else return buscar(nro, no.proximo);
    }


    void remover(int nro){
        No anterior = null; /* ponteiro para o elemento anterior*/
        No atual = inicio; /* ponteiro para o elemento atual*/
        /* procura o nó que possui o nro */
        while( atual != null && atual.conteudo != nro){
            anterior = atual;
            atual = atual.proximo;
        }
        if( anterior == null && atual != null ){
            /* o nro está no 1o nó */
            inicio = atual.proximo;
        }
        /* atual será null quando o nro não existir */
        else if( atual != null ){
            /* remove do meio ou final da sequência */
            anterior.proximo = atual.proximo;
        }
    }


}
