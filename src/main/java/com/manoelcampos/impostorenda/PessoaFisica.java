package com.manoelcampos.impostorenda;

/**
 * @author Manoel Campos da Silva Filho
 */
public class PessoaFisica extends Pessoa {
    private double salarioBruto;
    private int dependentes;
    private double gastosSaude;
    private double gastosEducacao;

    public PessoaFisica(double salarioBruto, int dependentes, double gastosSaude, double gastosEducacao) {
        this.salarioBruto = salarioBruto;
        this.dependentes = dependentes;
        this.gastosSaude = gastosSaude;
        this.gastosEducacao = gastosEducacao;
    }

    @Override
    protected double calcularIR() {
        double deducaoDependentes = dependentes * 189.59; // Dedução por dependente
        double inss = salarioBruto * 0.11; // INSS (11% do salário bruto)
        double irParcial = (salarioBruto - deducaoDependentes - inss) * 0.11; // Alíquota de 11% para IRPF
        double irFinal = irParcial - (gastosSaude + gastosEducacao);
        return Math.max(irFinal, 0); // Garante que o IR não seja negativo
    }

    @Override
    protected double calcularOutrosImpostos() {
        return salarioBruto * 0.11; // INSS (11% do salário bruto)
    }
}