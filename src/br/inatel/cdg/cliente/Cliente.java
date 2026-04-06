package br.inatel.cdg.cliente;

import br.inatel.cdg.computador.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int quantidade;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        computadores = new Computador[10];
        quantidade = 0;
    }

    public void addComputador(Computador computador) {
        if (quantidade < computadores.length) {
            computadores[quantidade] = computador;
            quantidade++;
        }
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < quantidade; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }

    public void mostraInfo() {
        System.out.println("Nome do cliente: " + nome);
        System.out.println("CPF do cliente: " + cpf);
    }

    public void mostraComputadores() {
        for (int i = 0; i < quantidade; i++) {
            System.out.println();
            System.out.println("PC " + (i + 1) + ":");
            computadores[i].mostraPCConfigs();
        }
    }

    public Computador[] getComputadores() {
        return computadores;
    }
}