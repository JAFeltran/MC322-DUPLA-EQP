package mc322.lab06;

public class Heroi extends Componente {
    // Atributos
    private boolean ouro;
    private int flechas;
    private boolean flechaEquipada;

    // Construtor
    public Heroi(int x, int y, int flechas, Caverna mapa) {
        super(x, y, 'P', mapa);
        ouro = false;
        this.flechas = flechas;
        flechaEquipada = false;
    }

    // Setters
    public void setOuro(boolean ouro) {
        this.ouro = ouro;
    }

    public void setFlechaEquipada(boolean flechaEquipada) {
        this.flechaEquipada = flechaEquipada;
    }

    // Getters
    public boolean getOuro() {
        return ouro;
    }

    public boolean getFlechaEquipada() {
        return flechaEquipada;
    }

    // Equipa a flecha, que eh disparada automaticamente ao entrar na proxima sala
    public void equiparFlecha() {
        if (flechas > 0) {
            flechaEquipada = true;
            flechas--;
        }
    }
}
