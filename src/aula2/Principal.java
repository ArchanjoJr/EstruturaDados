package aula2;

public class Principal {


    public static void main(){
        System.out.print(fatorial(5));
    }

    public static long fatorial(int nro){
        if(nro <= 1){
            return 1;
        }else{
            return nro*fatorial(nro-1);
        }
    }
}