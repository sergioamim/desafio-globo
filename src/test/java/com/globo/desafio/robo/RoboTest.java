package com.globo.desafio.robo;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Sergio Amim on 29/04/2015.
 */
public class RoboTest {

    Mapa mapa;

    @Before
    public void setup() {

    }

    @Test
    public void testTurnLeft() {
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        r.turnLeft();
        Assert.assertEquals(Robo.DirecaoEnum.W, r.getDirecao());
    }

    @Test
    public void testTurnLeft2x() {
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        r.turnLeft();
        r.turnLeft();
        Assert.assertEquals(Robo.DirecaoEnum.S, r.getDirecao());
    }

    @Test
    public void testTurnRight2x() {
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        r.turnRight();
        r.turnRight();
        Assert.assertEquals(Robo.DirecaoEnum.S, r.getDirecao());
    }

    @Test
    public void testTurnLeft2x_turnRight() {
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        r.turnLeft();
        r.turnLeft();
        r.turnRight();
        Assert.assertEquals(Robo.DirecaoEnum.W, r.getDirecao());
    }


    @Test
    public void testTurnLeft4x() {
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        r.turnLeft();
        r.turnLeft();
        r.turnLeft();
        r.turnLeft();
        Assert.assertEquals(Robo.DirecaoEnum.N, r.getDirecao());
    }


    @Test
    public void testMoveMapa() {
        Mapa m = new Mapa(10,10);
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        m.setRobo(r);

        r.move();
        r.move();
        r.turnRight();
        r.move();

        Assert.assertEquals("3 7 E", r.sayLocation());

    }


    @Test
    public void testTeleport() {
        Mapa m = new Mapa(10,10);
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        m.setRobo(r);
        r.teleport(1, 8);
        Assert.assertEquals("1 8 N", r.sayLocation());

    }


    @Test
    public void testInstrucao() {
        Mapa m = new Mapa(10, 10);
        Robo r = new Robo(2, 5, Robo.DirecaoEnum.N);
        m.setRobo(r);
        r.instrucao("LLRRMMMRMRMRM");
        Assert.assertEquals("2 7 W", r.sayLocation());

    }

    @Test
    public void testInstrucaoTeleport() {
        Mapa m = new Mapa(10,10);
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        m.setRobo(r);
        r.instrucao("T 5 6");
        Assert.assertEquals("5 6 N", r.sayLocation());
    }

    @Test
    public void testInstrucaoMoverForaMapa() {
        Mapa m = new Mapa(5,5);
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        m.setRobo(r);
        r.instrucao("MMMMMMMMRM");
        Assert.assertEquals("3 5 E", r.sayLocation());
    }

    @Test
    public void testInstrucaoTeleportForaMapa() {
        Mapa m = new Mapa(5,5);
        Robo r = new Robo(2,5, Robo.DirecaoEnum.N);
        m.setRobo(r);
        r.instrucao("MMMMMMMMRM");
        Assert.assertEquals("3 5 E", r.sayLocation());
        r.instrucao("T 8 8");
        Assert.assertEquals("3 5 E", r.sayLocation());
    }

}
