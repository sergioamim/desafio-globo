package com.globo.desafio.soma;


/**
 * Created by Sergio Amim on 04/05/2015.
 */
public class SubConjuntoSomaMaxima {

    public static void main(String [] args) {
        Integer[] array = new Integer[] {2, -4, 6, 8, -10, 100, -6, 5};

        ResultadoVO resultado = indiceSubListSomaMaxima(array);

        System.out.print(String.format("SubConjunto com indice inicial %d e final %d", resultado.getPrimeiro(), resultado.getUltimo()));
    }

    protected static ResultadoVO indiceSubListSomaMaxima(Integer[] numeros)  {

        int maior = 0;
        int primeiro = 0;
        int ultimo = 0;

        for (int i = 0 ; i < numeros.length-1; i++) {
            Integer subMaior = numeros[i];
            for (int j = i + 1 ; j < numeros.length ; j++) {
                subMaior += numeros[j];
                    if (maior < subMaior && !(i == 0 && j == (numeros.length-1)) ) {
                    maior = subMaior;
                    primeiro = i;
                    ultimo = j;
                }
            }
        }

        return new ResultadoVO(primeiro, ultimo);

    }


}
