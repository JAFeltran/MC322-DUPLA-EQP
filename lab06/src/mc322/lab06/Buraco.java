package mc322.lab06;

public class Buraco extends Componente {
    // Construtor
    public Buraco(int x, int y, Caverna mapa) {
        super(x, y, 'B', mapa);
        super.setTipo('B');
    }

    // Cria brisas nas salas adjacentes (exceto pelas diagonais) a posicao do buraco
    public void criarBrisa() {
        if (getX() > 0)
            mapa.getSala(getX() - 1, getY()).adicionarComponente(new Brisa(getX() - 1, getY(), mapa));

        if (getX() < 3)
            mapa.getSala(getX() + 1, getY()).adicionarComponente(new Brisa(getX() + 1, getY(), mapa));

        if (getY() < 3)
            mapa.getSala(getX(), getY() + 1).adicionarComponente(new Brisa(getX(), getY() + 1, mapa));

        if (getY() > 0)
            mapa.getSala(getX(), getY() - 1).adicionarComponente(new Brisa(getX(), getY() - 1, mapa));
    }
}
