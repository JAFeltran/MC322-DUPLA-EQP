package src.Ator;

public interface IAtor extends IAcao, IAtorVisual, IComando{
    // Setters
    public void setX(int x);
    public void setY(int y);

    // Getters
    public int getX();
    public int getY();
}