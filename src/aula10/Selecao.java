package aula10;

public class Selecao {
    public void selecao(int[] v){
        int menor, aux, j;
        for(int i = 0; i < v.length-1; i++){
            menor = i;
            /* identifica a posição do menor valor no subarray [i..v.length] */
            for(j= i+1; j < v.length; j++){
                if (v[j] < v[menor]){
                    menor = j; /* índice do menor valor */
                }
            }

            /* troca o menor valor com a posição i */
            aux = v[i];
            v[i] = v[menor];
            v[menor] = aux;
        }
    }
}
