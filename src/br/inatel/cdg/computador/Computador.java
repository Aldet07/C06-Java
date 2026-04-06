package br.inatel.cdg.computador;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hardwareBasicos;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;
    private int quantidadeHardwares;

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        hardwareBasicos = new HardwareBasico[3];
        quantidadeHardwares = 0;
    }

    public void addHardwareBasico(HardwareBasico hardwareBasico) {
        if (quantidadeHardwares < hardwareBasicos.length) {
            hardwareBasicos[quantidadeHardwares] = hardwareBasico;
            quantidadeHardwares++;
        }
    }

    public void setSistemaOperacional(SistemaOperacional sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public void addMemoriaUSB(MemoriaUSB memoriaUSB) {
        this.memoriaUSB = memoriaUSB;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preco: R$" + (int) preco);

        for (int i = 0; i < quantidadeHardwares; i++) {
            System.out.println(hardwareBasicos[i].getNome() + ": " + (int) hardwareBasicos[i].getCapacidade());
        }

        System.out.println("Sistema Operacional: " + sistemaOperacional.getNome() + " " + sistemaOperacional.getTipo() + " bits");
        System.out.println(memoriaUSB.getNome() + ": " + memoriaUSB.getCapacidade() + "GB");
    }

    public float getPreco() {
        return preco;
    }
}