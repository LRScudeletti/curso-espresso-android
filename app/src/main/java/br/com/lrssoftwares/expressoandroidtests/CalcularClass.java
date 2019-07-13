package br.com.lrssoftwares.expressoandroidtests;

public class CalcularClass {
    private double valor1;
    private double valor2;

    public double getValor1() {
        return valor1;
    }

    public void setValor1(double valor1) {
        this.valor1 = valor1;
    }

    public double getValor2() {
        return valor2;
    }

    public void setValor2(double valor2) {
        this.valor2 = valor2;
    }

    private double calcular(double valor1, double valor2) {
        return valor1 + valor2;
    }
}
