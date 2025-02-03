package com.manoelcampos.impostorenda;

public class Main {
    public static void main(String[] args) {
        Pessoa pf = new PessoaFisica(10000, 2, 500, 300);
        System.out.println("Impostos da Pessoa Física: R$ " + pf.calcularImpostos());

        Pessoa pj = new PessoaJuridica(50000, 2500);
        System.out.println("Impostos da Pessoa Jurídica: R$ " + pj.calcularImpostos());
    }
}