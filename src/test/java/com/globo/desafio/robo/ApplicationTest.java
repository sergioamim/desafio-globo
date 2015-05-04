package com.globo.desafio.robo;

import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by Sergio Amim on 29/04/2015.
 */
public class ApplicationTest {

    @Test
    public void testApp() throws URISyntaxException, IOException {
        Application app = new Application();
        String saida = app.run("/entrada_teste.txt");

        Assert.assertEquals("2 1 W", saida);
    }
}
