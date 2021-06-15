package src.Controle;

import src.Ator.IHeroi;

public interface IControle {
    public void setHeroi(IHeroi heroi);
    public int getPontuacao();
    public boolean getVivo();
    public void jogada(int x, int y);
}
