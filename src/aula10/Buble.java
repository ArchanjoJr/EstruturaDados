package aula10;

public class Buble {
    public void Buble(int[] v){
        boolean trocado = true;
        /* percorre todo o array n-vezes ou até não haver trocas */
        for(int aux, i, fim = v.length-1; fim > 0 && trocado; fim--){
            trocado = false;
            /* a cada iteração o maior valor vai parar na última posição do subarray [0..fim] */
            for(i = 0; i < fim; i++){
                if( v[i] > v[i+1] ){
                    aux = v[i]; /* troca os pares de valores */
                    v[i] = v[i+1];
                    v[i+1] = aux;
                    trocado = true;
                }
            }
        }
    }
}
