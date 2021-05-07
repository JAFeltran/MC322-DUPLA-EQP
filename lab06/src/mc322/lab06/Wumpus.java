package mc322.lab06;

public class Wumpus extends Componente {
    public Wumpus(int x, int y, Caverna mapa) {
        super(x, y, 'W', mapa);
    }

    public void criarFedor() {
        if (getX() > 0)
            mapa.getSala(getX() - 1, getY()).setFedor(new Fedor(getX() - 1, getY(), mapa));

        if (getX() < 3)
            mapa.getSala(getX() + 1, getY()).setFedor(new Fedor(getX() + 1, getY(), mapa));

        if (getY() < 3)
            mapa.getSala(getX(), getY() + 1).setFedor(new Fedor(getX(), getY() + 1, mapa));

        if (getY() > 0)
            mapa.getSala(getX(), getY() - 1).setFedor(new Fedor(getX(), getY() - 1, mapa));
    }
}
