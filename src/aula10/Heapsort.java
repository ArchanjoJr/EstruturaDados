package aula10;

public class Heapsort {
    public void heapsort(int[]v){
        for (int a:v) {
            System.out.print(a + " ");
        }
        criaHeap(v); /* ao final desse passo o pai será maior que os filhos em toda a árvore */
        System.out.print("\nArray heap:\n");
        for( int a:v ){
            System.out.print( a +" " );
        }
        for(int i = v.length - 1, n=v.length; i > 0; i--) {
            troca(v, i, 0); /* troca o elemento i (em ordem decrescente) com o raiz */
            System.out.print("\nIteração i="+i+":\n");
            for( int a:v ){
                System.out.print( a +" " );
            }
            /* Percorre a árvore de cima para baixo.
            * Ao final do 1a iteração o maior valor estará na última posição,
            * ao final da 2a iteração o 2o maior valor estará na penúltima posição e
            * assim sucessivamente */
            heap(v, 0, --n); /* note que o intervalo 0..n diminui a cada iteração */
        }
    }


    /* percorre a 1a metade do array */
    private void criaHeap(int[] v){
        for(int i = v.length/2-1; i >= 0; i--){
            heap(v, i, v.length);
        }
    }


    /* rearranja os elementos */
    private void heap(int[] v, int pai, int n){
        int fe = 2 * pai + 1, fd = fe + 1;
        int maior = fe; /* índice do maior valor entre os filhos esquerdo e direito */
        if( fe < n ){
            if( fd < n && v[fe] < v[fd] ){ /* para ordenar no outro sentido basta substituir v[fe] > v[fd] */
                maior = fd; /* obtém o maior valor entre os filhos esquerdo e direito */
            }
            if( v[maior] > v[pai] ){ /* para ordenar no outro sentido basta substituir v[fe] < v[pai] */
                troca(v, maior, pai); /* o maior valor entre os filhos sobe para o pai */
                heap(v, maior, n);
            }
        }
    }


    private void troca(int[] v, int a, int b){
        int aux = v[a];
        v[a] = v[b];
        v[b] = aux;
    }


}

