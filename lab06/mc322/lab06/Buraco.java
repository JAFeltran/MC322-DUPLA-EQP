package mc322.lab06;

public class Buraco extends Componente{
    public Buraco(int x, int y)
    {
        super(x, y, 'B');
    }

    public void criarBrisa()
    {
        /*cria brisa nas salas das posicoes:
            (x-1, y)
            (x+1, y)
            (x, y+1)
            (x, y-1)
        */
    }
}
