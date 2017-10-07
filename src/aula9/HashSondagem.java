package aula9;

public class HashSondagem {
    private int m; /* número de elementos da tabela */
    private Registro tabela[]; /* tabela de dispersão */

    public HashSondagem(int m) {
        this.m = m;
        this.tabela = new Registro[m];
    }

    public int hash(int ch) {
        return ch % m;
    }

    public void inserir(int ch) {
        int hc = hash(ch), tentativa;
        /* quantidade de tentativas */
        for( tentativa = 0; tentativa < m; tentativa++ ){
            /* quando a posição está vazia no array */
            if( tabela[hc] == null ){
                tabela[hc] = new Registro(ch);
                tabela[hc].ocorrencia++;
                break;
            }
            /* quando a chave já existe no array */
            else if( tabela[hc].chave == ch ){
                tabela[hc].ocorrencia++;
                break;
            }
            hc = (hc + 1) % m; /* próxima posição na tabela de dispersão */
        }
        if( tentativa >= m ){
            /* falha quando a tabela de dispersão está cheia */
            System.out.println("Falhou: "+ ch);
        }
    }


    /* retorna null se a chave não existir */
    public Registro buscar(int ch){
        int hc = hash(ch);
        while (tabela[hc] != null){
            if (tabela[hc].chave == ch){
                return tabela[hc];
            }
            hc = (hc + 1) % m; /* próxima posição na tabela de dispersão */
        }
        return null;
    }


    public void imprimir(){
        for(int i = 0; i < tabela.length; i++){
            System.out.println( tabela[i] );
        }
    }


}