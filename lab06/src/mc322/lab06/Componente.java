package mc322.lab06;

public class Componente {
    private int x, y;
    private char tipo;
    Caverna mapa;

    public Componente(int x, int y, char tipo, Caverna mapa) {
        this.x = x;
        this.y = y;
        this.tipo = tipo;
        this.mapa = mapa;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public void setMapa(Caverna mapa) {
        this.mapa = mapa;
    }

    public void setVivo(boolean vivo) {
    }

    public void setOuro(boolean ouro) {
    }

    public void setFlechas(int flechas) {
    }

    public void setFlechaEquipada(boolean flechaEquipada) {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getTipo() {
        return tipo;
    }

    public Caverna getMapa() {
        return mapa;
    }

    public boolean getVivo() {
        return false;
    }

    public boolean getOuro() {
        return false;
    }

    public int getFlechas() {
        return 0;
    }

    public boolean getFlechaEquipada() {
        return false;
    }

    public void equiparFlecha() {
    }

    public void criarBrisa() {
    }

    public void criarFedor() {
    }
}