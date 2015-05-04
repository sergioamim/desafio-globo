package com.globo.desafio.robo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by Sergio Amim on 04/05/2015.
 */
public class Application {

    public static void main(String[] args) throws URISyntaxException, IOException {

        Application app = new Application();
        System.out.println(app.run("/entrada.txt"));
    }


    public String run(String fileName) throws URISyntaxException, IOException {
        List<String> comandos = readFile(fileName);

        Mapa mapa = createMapa(comandos);
        Robo robo = createRobo(comandos);
        mapa.setRobo(robo);

        for (String linha : comandos.subList(2, comandos.size())) {
            robo.instrucao(linha);
        }

        return robo.sayLocation();

    }

    private Mapa createMapa(List<String> comandos) {
        String[] primeiraLinha = comandos.get(0).split("\\s+");
        Mapa mapa = new Mapa(Integer.parseInt(primeiraLinha[0]), Integer.parseInt(primeiraLinha[1]));
        return mapa;
    }

    private Robo createRobo(List<String> comandos) {
        String[] segundaLinha = comandos.get(1).split("\\s+");
        Robo robo = new Robo(Integer.parseInt(segundaLinha[0]), Integer.parseInt(segundaLinha[1]), Robo.DirecaoEnum.getDirecao(segundaLinha[2]));
        return robo;
    }

    public List<String> readFile(String fileName) throws URISyntaxException, IOException {
        return Files.readAllLines(Paths.get(this.getClass().getResource(fileName).toURI()), Charset.defaultCharset());
    }
}
