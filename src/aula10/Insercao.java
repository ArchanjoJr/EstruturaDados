package aula10;

public class Insercao {
    public void insercao(int[] v){
        int aux, j;
        /* o loop se repete i-1 vezes */
        for (int i = 1; i < v.length; i++) {
            aux = v[i];
            /* pode chegar a percorrer tod o subarray v[0..i-1] */
            for (j = i-1; j >= 0 && v[j] > aux; j--){
                v[j+1] = v[j];
            }
            v[j+1] = aux;
        }
    }
}
