package src.Controle;

import src.Ator.IHeroi;

public class Controle implements IControle {
    // Atributos
    private int fase, pontuacao;
    private IHeroi heroi;

    // Construtor
    public Controle() {
        fase = 0;
        pontuacao = 0;
    }

    // IControlePropriedades
    public void setHeroi(IHeroi heroi) {
        this.heroi = heroi;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public boolean getVivo() {
        return heroi.getVivo();
    }

    // Batalha
    private void batalha(int x, int y) {
        iCombate inimigo = heroi.getInimigo(x, y);

    }

    // IControle
    public void jogada(int x, int y) {
        heroi.verificaMovimento(x, y);

        // if () {
        //     batalha(x, y);
        // }

    } 
}
