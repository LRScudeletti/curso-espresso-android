package br.com.lrssoftwares.expressoandroidtests;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CalcularTest {

    @Test
    public void teste_01_testarSoma() {
        Random gerador = new Random();

        double valor1 = gerador.nextDouble();
        double valor2 = gerador.nextDouble();

        assertEquals(new CalcularClass().calcular(valor1, valor2), valor1 + valor2, 0);
    }
}
