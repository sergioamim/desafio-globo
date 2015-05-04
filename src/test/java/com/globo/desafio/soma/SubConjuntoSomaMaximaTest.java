package com.globo.desafio.soma;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Sergio Amim on 04/05/2015.
 */
public class SubConjuntoSomaMaximaTest {

    @Test
    public void testConjuntoBasico() {
        Integer[] array = new Integer[] {2, -4, 6, 8, -10, 100, -6, 5};
        ResultadoVO resultado = SubConjuntoSomaMaxima.indiceSubListSomaMaxima(array);

        Assert.assertEquals(2, resultado.getPrimeiro());
        Assert.assertEquals(5, resultado.getUltimo());
    }
}
