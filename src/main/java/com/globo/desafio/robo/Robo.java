package com.globo.desafio.robo;

import com.sun.javafx.binding.StringFormatter;

/**
 * Created by Sergio Amim on 29/04/2015.
 *
 * Classe repesenta o Robo, que possui seus comportamentos
 */
public class Robo {

    private int x, y;
    private DirecaoEnum direcao;

    private Mapa mapa;

    public Robo(int x, int y, DirecaoEnum direcao) {
        this.x = x;
        this.y = y;
        this.direcao = direcao;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public void turnLeft() {
        this.direcao =  this.direcao.turnLeft();
    }

    public void turnRight() {
        this.direcao = this.direcao.turnRight();
    }


    public void instrucao(String linha) {

        String[] comandos = linha.split("");

        if(comandos[0].equals("T")) {
            teleport(Integer.parseInt(comandos[2]), Integer.parseInt(comandos[4]));
            return;
        }

        for(int i = 0; i<comandos.length;i++) {

            if(comandos[i].equals("L")) {
                turnLeft();
            }

            if(comandos[i].equals("R")) {
                turnRight();
            }

            if(comandos[i].equals("M")) {
                move();
            }
        }

    }



    public void move() {
        if(this.direcao.equals(DirecaoEnum.N)) {
            if(this.y < this.mapa.getY()) {
                this.y++;
            }
        }

        if(this.direcao.equals(DirecaoEnum.E)) {
            if(this.x < this.mapa.getX()) {
                this.x++;
            }
        }

        if(this.direcao.equals(DirecaoEnum.S)) {
            if(this.y>0) {
                this.y--;
            }
        }

        if(this.direcao.equals(DirecaoEnum.W)) {
            if(this.x > 0) {
                this.x--;
            }
        }
    }

    public String sayLocation() {
        return StringFormatter.format("%d %d %s", x, y, direcao).getValue();
    }

    public void teleport(int x, int y) {
        if(this.mapa.getX()>=x && this.mapa.getY()>=y) {
            this.x = x;
            this.y = y;
        }
    }

    public DirecaoEnum getDirecao() {
        return direcao;
    }

    enum DirecaoEnum {
        N(0), E(1), S(2), W(3);

        private int d;

        DirecaoEnum(int d) {
            this.d = d;
        }

        public DirecaoEnum turnLeft() {
            if(d==0) {
                return DirecaoEnum.getDirecao(3);
            } else {
                return DirecaoEnum.getDirecao(d-1);
            }
        }

        public DirecaoEnum turnRight() {

            if(d==3) {
                return DirecaoEnum.getDirecao(0);
            } else {
                return DirecaoEnum.getDirecao(d+1);
            }
        }

        private int getDirecao() {
            return d;
        }

        private static DirecaoEnum getDirecao(int dir) {

            for(DirecaoEnum direcaoEnum: DirecaoEnum.values()) {
                if(direcaoEnum.getDirecao()==dir) {
                    return direcaoEnum;
                }
            }
            throw new IllegalArgumentException("Indice invalido!");
        }

        public static DirecaoEnum getDirecao(String dir) {

            for(DirecaoEnum direcaoEnum: DirecaoEnum.values()) {
                if(direcaoEnum.name().equals(dir)) {
                    return direcaoEnum;
                }
            }
            throw new IllegalArgumentException("Indice invalido!");
        }
    }
}
