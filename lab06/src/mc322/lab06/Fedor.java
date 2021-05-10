package mc322.lab06;

public class Fedor extends Componente {
    // Construtor
    public Fedor(int x, int y, Caverna mapa) {
        super(x, y, 'f', mapa);
        super.setTipo('f');
    }
}
