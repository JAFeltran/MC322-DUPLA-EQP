package mc322.lab06;

public class Buraco extends Componente{
    public Buraco(int x, int y)
    {
        super(x, y, 'B');
    }

    public void criarBrisa() {
        mapa.getSala(getX() - 1, getY()).setBrisa(new Brisa(getX() - 1, getY()));

        mapa.getSala(getX() + 1, getY()).setBrisa(new Brisa(getX() + 1, getY()));

        mapa.getSala(getX(), getY() + 1).setBrisa(new Brisa(getX(), getY() + 1));

        mapa.getSala(getX(), getY() - 1).setBrisa(new Brisa(getX(), getY() - 1));
    }
}
