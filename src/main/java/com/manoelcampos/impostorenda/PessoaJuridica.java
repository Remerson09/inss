package com.manoelcampos.impostorenda;

/**
 * @author Manoel Campos da Silva Filho
 */
public class PessoaJuridica extends Pessoa {
    private double lucro;
    private double icms;

    public PessoaJuridica(double lucro, double icms) {
        this.lucro = lucro;
        this.icms = icms;
    }

    @Override
    protected double calcularIR() {
        double irParcial = lucro * 0.15; // Alíquota de 15% para IRPJ
        double limiteCobranca = 20000;
        double irExcedente = Math.max(irParcial - limiteCobranca, 0);
        double irFinal = irParcial + (irExcedente * 0.10); // Alíquota adicional de 10%
        return irFinal;
    }

    @Override
    protected double calcularOutrosImpostos() {
        double csll = lucro * 0.09; // CSLL (9% do lucro)
        return csll + icms; // ICMS já é passado como valor fixo
    }
}