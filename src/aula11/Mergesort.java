package aula11;

public class Mergesort {


        public void mergesort(int[] v){
            if( v != null && v.length > 1 ){
                mergesort(v, 0, v.length);
            }
        }


        /* divide recursivamente o array */
        private void mergesort(int v[], int inicio, int fim){
            if( inicio < fim-1 ) {
                int meio = (inicio + fim)/2;
                mergesort(v, inicio, meio);
                mergesort(v, meio, fim);
                merge(v, inicio, meio, fim);
            }
        }


        /* merge é a junção de dois arrays */
        private void merge(int v[], int inicio, int meio, int fim){
            int i, j;
            /* array auxiliar para receber os elementos a serem ordenados */
            int[] aux = new int[fim-inicio];
            /* copia o trecho do array a ser ordenado */
            for(i = inicio; i < meio; i++){
                aux[i-inicio] = v[i];
            }
            for(j = meio; j < fim; j++){
                aux[(fim-inicio)+meio-j-1] = v[j];
            }
            /* escreve o resultado ordenado no array */
            i = 0; /* será o índice para a 1a metade do array auxiliar */
            j = fim-inicio-1; /* será o índice para a 2a metade do array auxiliar*/
            for (int k = inicio; k < fim; k++){
                if( aux[i] <= aux[j] ){
                    v[k] = aux[i++];
                }
                else{
                    v[k] = aux[j--];
                }
            }
        }


    }

