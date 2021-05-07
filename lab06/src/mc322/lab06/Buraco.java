package mc322.lab06;

public class Buraco extends Componente {
    public Buraco(int x, int y, Caverna mapa) {
        super(x, y, 'B', mapa);
    }

    public void criarBrisa() {
        mapa.getSala(getX() - 1, getY()).setBrisa(new Brisa(getX() - 1, getY(), mapa));

        mapa.getSala(getX() + 1, getY()).setBrisa(new Brisa(getX() + 1, getY(), mapa));

        mapa.getSala(getX(), getY() + 1).setBrisa(new Brisa(getX(), getY() + 1, mapa));

        mapa.getSala(getX(), getY() - 1).setBrisa(new Brisa(getX(), getY() - 1, mapa));
    }
}
