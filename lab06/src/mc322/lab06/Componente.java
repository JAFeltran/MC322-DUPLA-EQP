package mc322.lab06;

public class Componente {
    // Atributos
    private int x, y;
    private char tipo;
    Caverna mapa;

    // Construtor
    public Componente(int x, int y, char tipo, Caverna mapa) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.mapa = mapa;
    }

    // Setters
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setOuro(boolean ouro) {
    }

    public void setFlechaEquipada(boolean flechaEquipada) {
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Caverna getMapa() {
        return mapa;
    }

    public boolean getOuro() {
        return false;
    }

    public boolean getFlechaEquipada() {
        return false;
    }

    // Funcoes para polimorfismo
    public void equiparFlecha() {
    }

    public void criarBrisa() {
    }

    public void criarFedor() {
    }
}