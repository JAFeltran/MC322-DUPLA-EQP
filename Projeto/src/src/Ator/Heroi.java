package src.Ator;

public class Heroi extends Ator {
    // Atributos
    private int vida, ataque, defesa, visao;
    private Item inventario[];
    private IMapa mapa;

    // Construtor
    public Heroi(int x, int y, IMapa mapa) {
        // vida, ataque, defesa = valor inicial
        visao = 0;
        inventario = new Item[5];
        this.mapa = mapa;
        super(x, y);
    }
}