package com.globo.desafio.soma;

/**
 * Created by Sergio Amim on 04/05/2015.
 */
public class ResultadoVO {

    private int primeiro;

    private int ultimo;

    public ResultadoVO(int primeiro, int ultimo) {
        this.primeiro = primeiro;
        this.ultimo = ultimo;
    }

    public int getPrimeiro() {
        return primeiro;
    }

    public int getUltimo() {
        return ultimo;
    }

}
