package Aula;

public class Arvore {
    public No raiz;

    /* retorna a altura de uma árvore binária */
    public int altura(No no){
        if( no == null ){
            return -1; /* árvore vazia */
        }
        else{
            int altEsq = altura(no.esquerdo);
            int altDir = altura(no.direito);
            return altEsq < altDir ? altDir + 1 : altEsq + 1;
        }
    }


    /* libera a árvore que se encontra abaixo do no */
    public No limpar(No no){
        if( no != null ){
            no.esquerdo = limpar(no.esquerdo); /* limpa o lado esquerdo */
            no.direito = limpar(no.direito); /* limpa o lado direito */
        }
        return null;
    }


    public boolean buscar(No no, int nro){
        if( no == null ){
            return false; /* não encontrou */
        }
        else{
            return
                    nro == no.conteudo ||
                            buscar(no.esquerdo, nro) ||
                            buscar(no.direito, nro);
        }
    }


    /* Insere o nro mantendo os valores ordenados.
    * A inserção será em uma subárvore do no */
    public No inserir(No no, int nro){
        if( no == null ){ /* árvore vazia */
            no = new No();
            no.conteudo = nro;
        }
        else if( nro < no.conteudo ){ /* percorre a subárvore esquerda */
            no.esquerdo = inserir(no.esquerdo, nro);
        }
        else{ /* percorre a subárvore direita */
            no.direito = inserir(no.direito, nro);
        }
        return no;
    }


    /* Remove o nó que possui o nro mantendo os valores ordenados.
    * A busca será em uma subárvore do no */
    public No remover(No no, int nro){
        if( no == null ){
            return null; /* não existe o nó */
        }
        else if( nro < no.conteudo ){ /* o nro está em um filho à esquerda */
            no.esquerdo = remover(no.esquerdo, nro);
        }
        else if( nro > no.conteudo ){ /* o nro está em um filho à direita */
            no.direito = remover(no.direito, nro);
        }
        else{ /* o nro procurado está no nó */
        /* nó sem filhos */
            if( no.esquerdo == null && no.direito == null ){
                return null;
            }
            else if( no.esquerdo == null ){ /* nó só tem filho à direita */
                no = no.direito;
            }
            else if( no.direito == null ){ /* nó só tem filho à esquerda */
                no = no.esquerdo;
            }
            else{ /* nó tem os dois filhos */
                No aux = no.esquerdo;
                while( aux.direito != null ){
                    aux = aux.direito;
                }
                no.conteudo = aux.conteudo; /* troca os conteúdos */
                aux.conteudo = nro;
                no.esquerdo = remover(no.esquerdo, nro);
            }
        }
        return no;
    }


    /* varredura infixa ou em ordem ou simétrica */
    public void imprimirEsqRaizDir(No no){
        if( no != null ){
            imprimirEsqRaizDir(no.esquerdo);
            System.out.print(no.conteudo + " ");
            imprimirEsqRaizDir(no.direito);
        }
    }


    /* varredura prefixa ou pré-ordem */
    public void imprimirRaizEsqDir(No no){
        if( no != null ){
            System.out.print(no.conteudo + " ");
            imprimirRaizEsqDir(no.esquerdo);
            imprimirRaizEsqDir(no.direito);
        }
    }


    /* varredura posfixa ou pós-ordem */
    public void imprimirEsqDirRaiz(No no){
        if( no != null ){
            imprimirEsqDirRaiz(no.esquerdo);
            imprimirEsqDirRaiz(no.direito);
            System.out.print(no.conteudo + " ");
        }
    }


}

