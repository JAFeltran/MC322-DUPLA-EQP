package mc322.lab06;

public class Wumpus extends Componente {
    // Construtor
    public Wumpus(int x, int y, Caverna mapa) {
        super(x, y, 'W', mapa);
        super.setTipo('W');
    }

    // Cria fedor nas salas adjacentes (exceto pelas diagonais) a posicao do buraco
    public void criarFedor() {
        if (getX() > 0)
            mapa.getSala(getX() - 1, getY()).adicionarComponente(new Fedor(getX() - 1, getY(), mapa));

        if (getX() < 3)
            mapa.getSala(getX() + 1, getY()).adicionarComponente(new Fedor(getX() + 1, getY(), mapa));

        if (getY() < 3)
            mapa.getSala(getX(), getY() + 1).adicionarComponente(new Fedor(getX(), getY() + 1, mapa));

        if (getY() > 0)
            mapa.getSala(getX(), getY() - 1).adicionarComponente(new Fedor(getX(), getY() - 1, mapa));
    }
}
