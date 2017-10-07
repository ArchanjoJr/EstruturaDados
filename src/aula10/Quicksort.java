package aula10;

public class Quicksort {

    public void quicksort(int[] v){
        if( v != null && v.length > 1 ){
            quicksort(v, 0, v.length-1);
        }
    }


    /* escolhe como pivô o elemento que está no meio do array v[inicio..fim] e
    * faz com que os valores à esquerda do pivô sejam menores que o pivô e
    * os valores à direita sejam maiores que o pivô */
    public void quicksort(int v[], int inicio, int fim){
        int pivo, i, j;
        /* escolhe o valor pivô */
        pivo = v[(inicio+fim)/2];
        i = inicio;
        j = fim;
        System.out.print("\nInício:"+inicio+" Pivo:"+pivo + " Fim:"+ fim+"\n");
        imprimir(v);
        /* ao final de cada iteração dois elementos serão trocados de posição */
        while(i <= j){
            /* identifica um valor maior que o pivô à esquerda do pivô */
            while(v[i] < pivo){
                i++;
            }
            /* identifica um valor menor que o pivô à direita do pivô */
            while(v[j] > pivo){
                j--;
            }
            if(i <= j){
                troca(v, i, j); /* troca o menor e maior valor de posição */
                i++;
                j--;
            }
        }
        /* particiona o array e faz nova organização nos elementos */
        if(j > inicio){
            quicksort(v, inicio, j);
        }
        if(i < fim){
            quicksort(v, j+1, fim);
        }
    }


    private void troca(int[] v, int a, int b){
        int aux = v[a];
        v[a] = v[b];
        v[b] = aux;
    }


    public void imprimir(int[] v){
        for(int a:v){
            System.out.print(a + " ");
        }
    }
}
