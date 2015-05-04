package com.globo.desafio.robo;

/**
 * Created by Sergio Amim on 29/04/2015.
 */
public class Mapa {

    private int x;

    private int y;

    private Robo robo;

    public void setRobo(Robo robo) {
        this.robo = robo;
        robo.setMapa(this);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Mapa(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
