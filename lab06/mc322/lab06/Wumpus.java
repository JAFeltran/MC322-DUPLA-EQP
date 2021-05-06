package mc322.lab06;

public class Wumpus extends Componente{
    public Wumpus(int x, int y)
    {
        super(x, y, 'W');
    }

    public void criarFedor()
    {
        /*cria fedor nas salas das posicoes:
            (x-1, y)
            (x+1, y)
            (x, y+1)
            (x, y-1)
        */
    }
}
