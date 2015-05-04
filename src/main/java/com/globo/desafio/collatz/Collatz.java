package com.globo.desafio.collatz;

/**
 * Created by Sergio Amim on 04/05/2015.
 */
public class Collatz {

    public static int MAX = 1000000;

    public static void main(String[] args) {

        System.out.println("Inteiro de 1 Milhao: "+contagemCiclos(MAX)+ " ciclos");

        System.out.println("Inteiro de 999999: "+contagemCiclos(999999) + " ciclos");

        int maiorInteiro = maiorInteiroAbaixoUmMilhao();
        System.out.println("Maior inteiro "+maiorInteiro+ ": " + contagemCiclos(maiorInteiro) + " ciclos");

    }


    public static int maiorInteiroAbaixoUmMilhao() {
        int maiorInteiro = 0;
        int maiorSequencia = 0;
        for(int i = MAX-1; i>1; i--) {
            int temp = contagemCiclos(i);
            if(maiorSequencia<temp) {
                maiorSequencia= temp;
                maiorInteiro = i;
            }
        }
        return maiorInteiro;
    }

    public static int contagemCiclos(long n){

        int i = 1;
        while (n > 1){
            if ((n % 2) == 0){
                n /= 2;
            } else{
                n = (n*3)+1;
            }
            i++;
        }
        return i;
    }
}
