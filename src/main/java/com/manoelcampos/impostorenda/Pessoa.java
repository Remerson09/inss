package com.manoelcampos.impostorenda;

/**
 * @author Manoel Campos da Silva Filho
 */
public abstract class Pessoa {
    private long id;
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método template que define a estrutura do cálculo de impostos
    public final double calcularImpostos() {
        double ir = calcularIR();
        double outrosImpostos = calcularOutrosImpostos();
        return ir + outrosImpostos;
    }

    // Método abstrato para cálculo do IR (deve ser implementado pelas subclasses)
    protected abstract double calcularIR();

    // Método abstrato para cálculo de outros impostos (deve ser implementado pelas subclasses)
    protected abstract double calcularOutrosImpostos();
}