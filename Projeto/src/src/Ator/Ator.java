package src.Ator;

public class Ator implements IAtor {
    // Atributos
    private int x, y;

    // Construtor
    public Ator(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // IAtor
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}