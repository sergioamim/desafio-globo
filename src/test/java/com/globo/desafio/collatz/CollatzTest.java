package com.globo.desafio.collatz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

/**
 * Created by Sergio Amim on 04/05/2015.
 */
public class CollatzTest {

    @Test
      public void testCollatz() {
        Assert.assertEquals(10, Collatz.contagemCiclos(13));
    }

    @Test
    public void testCollatz1000000() {
        Assert.assertEquals(153, Collatz.contagemCiclos(Collatz.MAX));
    }

    @Test
    public void testCollatzMaiorInteiro() {
        Assert.assertEquals(837799, Collatz.maiorInteiroAbaixoUmMilhao());
    }

    @Test
    public void testCollatzPerformance() {
        long inicio = Calendar.getInstance().getTimeInMillis();
        Assert.assertEquals(153, Collatz.contagemCiclos(Collatz.MAX));
        long fim = Calendar.getInstance().getTimeInMillis();
        Assert.assertTrue((fim-inicio)<5000);
    }


}
