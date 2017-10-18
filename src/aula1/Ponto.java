package aula1;

public class Ponto {

    int x, y;

    //constructor da classe
    Ponto(int x,int y){
        this.x =x;
        this.y=y;
    }
    /* assinatura: distancia no arguments */
    double distancia(){
    /* o método estático pow retorna x^2 */
        double dx = Math.pow(x,2);
        double dy = Math.pow(y,2);
    /* o método estático sqrt retorna a raiz quadrada */
        return Math.sqrt(dx + dy);
    }


    /* assinatura: distancia Ponto */
    double distancia(Ponto p){
    /* cálculo entre o atributo x deste objeto e o atributo x de p */
        double dx = Math.pow(x - p.x, 2);
        double dy = Math.pow(y - p.y, 2);
        return Math.sqrt(dx + dy);
    }


    void imprimir(){
        System.out.println("(" + x +", "+ y +")");
    }


}