package br.inatel.cdg;

import java.util.Scanner;
import br.inatel.cdg.cliente.Cliente;
import br.inatel.cdg.computador.Computador;
import br.inatel.cdg.computador.HardwareBasico;
import br.inatel.cdg.computador.MemoriaUSB;
import br.inatel.cdg.computador.SistemaOperacional;
import br.inatel.cdg.util.ProcessarPedido;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Cliente cliente = new Cliente("Joao Aldet", "157.655.507-03");

        Computador pc1 = new Computador("Apple", 660);
        pc1.addHardwareBasico(new HardwareBasico("Pentium Core i3", 2200));
        pc1.addHardwareBasico(new HardwareBasico("Memoria RAM", 8));
        pc1.addHardwareBasico(new HardwareBasico("HD", 500));
        pc1.setSistemaOperacional(new SistemaOperacional("macOS Sequoia", 64));
        pc1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        Computador pc2 = new Computador("Samsung", 1894);
        pc2.addHardwareBasico(new HardwareBasico("Pentium Core i5", 3370));
        pc2.addHardwareBasico(new HardwareBasico("Memoria RAM", 16));
        pc2.addHardwareBasico(new HardwareBasico("HD", 1000));
        pc2.setSistemaOperacional(new SistemaOperacional("Windows 8", 64));
        pc2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        Computador pc3 = new Computador("Dell", 6338);
        pc3.addHardwareBasico(new HardwareBasico("Pentium Core i7", 4500));
        pc3.addHardwareBasico(new HardwareBasico("Memoria RAM", 32));
        pc3.addHardwareBasico(new HardwareBasico("HD", 2000));
        pc3.setSistemaOperacional(new SistemaOperacional("Windows 10", 64));
        pc3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

        int opcao;

        do {
            System.out.println("===== PC MANIA =====");
            System.out.println("1 - Promocao 1");
            System.out.println("2 - Promocao 2");
            System.out.println("3 - Promocao 3");
            System.out.println("0 - Finalizar");
            System.out.print("Escolha uma opcao: ");
            opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    cliente.addComputador(pc1);
                    System.out.println("Promocao 1 adicionada com sucesso");
                    break;
                case 2:
                    cliente.addComputador(pc2);
                    System.out.println("Promocao 2 adicionada com sucesso");
                    break;
                case 3:
                    cliente.addComputador(pc3);
                    System.out.println("Promocao 3 adicionada com sucesso");
                    break;
                case 0:
                    System.out.println("Compra encerrada");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        ProcessarPedido.processar(cliente.getComputadores());

        System.out.println();
        cliente.mostraInfo();
        System.out.println("Computadores comprados:");
        cliente.mostraComputadores();
        System.out.println("Total da compra: R$" + (int) cliente.calculaTotalCompra());

        entrada.close();
    }
}