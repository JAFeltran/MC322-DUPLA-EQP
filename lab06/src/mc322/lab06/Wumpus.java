package mc322.lab06;

public class Wumpus extends Componente {
    public Wumpus(int x, int y) {
        super(x, y, 'W');
    }

    public void criarFedor() {
        mapa.getSala(getX() - 1, getY()).setFedor(new Fedor(getX() - 1, getY()));

        mapa.getSala(getX() + 1, getY()).setFedor(new Fedor(getX() + 1, getY()));

        mapa.getSala(getX(), getY() + 1).setFedor(new Fedor(getX(), getY() + 1));

        mapa.getSala(getX(), getY() - 1).setFedor(new Fedor(getX(), getY() - 1));
    }
}
